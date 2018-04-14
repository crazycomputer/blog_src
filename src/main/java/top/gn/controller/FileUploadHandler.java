package top.gn.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import top.gn.entity.Article;
@RequestMapping("/upload")
@Controller
public class FileUploadHandler {
	
	
	

	
	@ModelAttribute
	public void attribute(Map<String, Object> map) {
		
		//map.put(key, value)
		
		
	}
	
	@PostMapping("/fileupload/{id-1}")
	public String upload(Map<String, Object> map , HttpServletRequest request , @PathVariable("id-1") Integer id , 
				Article article , @RequestParam(value="pototitle" , required = false) MultipartFile pototitle) throws IllegalStateException, IOException {
		
		System.out.println(article);
		
		
		System.out.println("id-1: "+id);
		System.out.println("id:"+pototitle.getName());
		System.out.println("type:"+ pototitle.getContentType());
		if(!pototitle.isEmpty()) {
			String path = request.getSession().getServletContext().getRealPath("poto");;
			
			String potoName = pototitle.getOriginalFilename();
			
			String newFileName = UUID.randomUUID() + potoName;
			
			File newFile = new File(path , newFileName);
			System.out.println("newFile.getParentFile().exists():"+ newFile.getParentFile().exists());
			
			System.out.println(newFile.getParentFile().exists());
			if(!newFile.getParentFile().exists()) {
				newFile.getParentFile().mkdirs();
			}
			
			File upFile = new File(path + File.separator + newFileName);
			System.out.println(path);
			pototitle.transferTo(upFile);
			System.out.println(potoName);
			map.put("filePath","poto" + File.separator + newFileName);
			return "file";
		}else {
			return "WEB-INF/error.jsp";
		}
		
	}
	
	
	
	
}
