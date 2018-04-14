/**  
 * @Title: ArticleHandler.java  
 * @Package top.gn.controller 
 * @author BoyHu  
 * @date 1 Apr 2018  
 * @version V1.0  
 */  
package top.gn.controller.hou;


import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import top.gn.entity.Article;
import top.gn.entity.BlogData;
import top.gn.page.Page;
import top.gn.service.ArticleService;
import top.gn.service.ChildTypeService;
import top.gn.service.ParentTypeService;



/**  
 * @ClassName: ArticleHandler  
 * @Description: 处理 操作文章管理的相关 请求 , 发布文章 , 编辑 , 删除文章
 * @author BoyHu
 * @date 1 Apr 2018    manager-article/fileupload/123
 */
@RequestMapping("/manager-article")
@Controller
public class ArticleManagerHandler {
	
	/*
	 

	 
	 */

	/*
	 * 做为 Article的请求处理Handler , 
	 * 		该类当中需要有一个 ArticleService 的服务
	 * 		父分类  parentTypeServiceImpl 的服务
	 * 		子分类 childTypeServiceImpl 的服务
	 */
	private ArticleService articleServiceImpl;
	private ChildTypeService childTypeServiceImpl;
	private ParentTypeService parentTypeServiceImpl;
	
	public ArticleManagerHandler() {}
	
	/**
	 * 
	 * @Title: setArticleService  
	 * @Description: 使用spring @Autowired 自动注入  依赖的bean
	 * @param articleService
	 * @throws
	 */
	@Autowired
	public void setArticleServiceImpl(ArticleService articleServiceImpl) {
		this.articleServiceImpl = articleServiceImpl;
	}
	
	@Autowired
	public void setChildTypeServiceImpl(ChildTypeService childTypeServiceImpl) {
		this.childTypeServiceImpl = childTypeServiceImpl;
	}
	
	@Autowired
	public void setParentTypeServiceImpl(ParentTypeService parentTypeServiceImpl) {
		this.parentTypeServiceImpl = parentTypeServiceImpl;
	}
	 
	
	/**
	 * 显示文章发布的表单页面
	 * @param map
	 * @return
	 */
	@GetMapping("/show-form")
	public String showForm(Map<String, Object> map) {
		map.put("article", new Article());
		BlogData blogData = new BlogData();
		blogData.setChildTypesList(this.childTypeServiceImpl.getChildTypeAll());
		blogData.setParentTypesList(this.parentTypeServiceImpl.getParentTypeAll());
		map.put("blogData", blogData);
		System.out.println("run....");
		return "/editor/addArticle";
	}
	
	//, @RequestParam(value="pototitle" , required = false) MultipartFile pototitle
	@ResponseBody
	@PostMapping("/add-article")
	public long addOneArticle(Article article) {
		System.out.println(article);
		long id = this.articleServiceImpl.addArticle(article);
		return id;
	}
	
	/**
	 * 提交时进行最终的更新
	 * @param article
	 * @param request
	 * @param pototitle
	 * @return
	 */
	@PostMapping("/update-commit-article")
	public String articleFormSubmit(Article article ,HttpServletRequest request, MultipartFile pototitle ) {
		String bgPath = this.articleServiceImpl.upload(request, pototitle);
		//将文章的type设置为发布类型 , 默认为1 草稿类型
		article.setArticleType(2);
		this.articleServiceImpl.articleSubmit(article , bgPath);
		return "redirect:../article/article-list";
	}
	
	
	
	
	
	
	
	
	
	
	
}
