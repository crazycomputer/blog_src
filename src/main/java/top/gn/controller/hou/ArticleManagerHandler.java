/**  
 * @Title: ArticleHandler.java  
 * @Package top.gn.controller 
 * @author BoyHu  
 * @date 1 Apr 2018  
 * @version V1.0  
 */  
package top.gn.controller.hou;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import top.gn.entity.Article;
import top.gn.entity.BlogData;
import top.gn.service.ArticleService;
import top.gn.service.ChildTypeService;
import top.gn.service.ParentTypeService;
import top.gn.service.impl.ArticleServiceImpl;



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
	 
	
	@ModelAttribute
	public void attributeShowForm(@RequestParam(value = "_i" , 
							required = false) Integer _i , Map<String, Object> map ,
							@RequestParam(value = "flag" , required = false , defaultValue = "null") String flag ) {
		if(_i == null) {
			_i = 0;
		}
		
		
		if( !("null".equals(flag)) ) {
			map.put("article",this.articleServiceImpl.getArticleEditor(_i));
			System.out.println("attributeShowForm..run > 为编辑准备数据");
		}
	}
	
	/*------获取显示  -------------*/
	/**
	 * 显示文章发布的表单页面
	 * @param map
	 * @return
	 */
	@GetMapping("/show-form")
	public String showForm(Map<String, Object> map , Article article) {
		map.put("article", article);
		System.out.println(article);
		BlogData blogData = new BlogData();
		blogData.setChildTypesList(this.childTypeServiceImpl.getChildTypeAll());
		blogData.setParentTypesList(this.parentTypeServiceImpl.getParentTypeAll());
		map.put("blogData", blogData);
		System.out.println("run....");
		return "/editor/addArticle";
	}
	

	/**
	 * 处理后台文章管理的查询文章请求  , 展示于后台文章管理页面 , 会自动的判断超级管理员和普通管理员
	 * @param session
	 * @param map
	 * @return
	 */
	@GetMapping("/article-tab")
	public String showArticleManagerPage(HttpSession session , Map<String, Object> map){
		
		Object managerobj = session.getAttribute("now-author");
		if(managerobj == null) {
			return "forward:/author/ccc/513";
		}
		
		BlogData blogData = new BlogData();
		//将查询结果放入blogData对象
		blogData.setArticlesList(this.articleServiceImpl.getArticleByAuthor(managerobj));
		map.put("blogData",blogData);
		return "/editor/article-manager";
	}
	

	@GetMapping("/type-tab")
	public String showTypeManagerPage(){
		return "/editor/type-manager";
	}
	
	@GetMapping("/draft")
	public String showDraftManagerPage(HttpSession session){
		System.out.println("showDraftManagerPage");
		return "/editor/draft-manager";
	}
	
	/*---------- 更新 添加 ----------*/
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
		
		//1 若文章本身有图片 , 又想上传一个新的图片 , 此时 需要删除原有图片
			// 需要满足的条件 : 1 article.getBgPath() 不为   "" 2 bgPath != null 需要删除原有图片
		if(!( "".equals(article.getBgPath()) ) && bgPath != null) {
			ArticleServiceImpl artiImpl = (ArticleServiceImpl)this.articleServiceImpl;
			//删除文件
			artiImpl.deletePoto(article.getBgPath() , request);
			
		}else if("".equals(article.getBgPath()) && bgPath != null) {
			//2 若文章本身没有图片 , 上传了一个图片 , 直接使用bgPath即可
			// 需要满足的条件 : 1 article.getBgPath() 为   ""  2 bgPath != null 不需要删除任何图片
			
		}else if(bgPath == null &&  !( "".equals(article.getBgPath()) ) ) {
			//3 若文章本身有图片 , 修改时没有上传图片 ,使用原有的图片
			// 需要满足的条件 : 1 article.getBgPath() 不为   "" 2 bgPath == null 直接使用 article.getBgPath()
			/*
			 * 用于二次编辑文章修改操作 , 
			 *  1   若没上传图片bgPath的值为null
			 *	2 article当中若有回显图片的名称  , getBgPath() 不为 "" 串 
			 */
			bgPath = article.getBgPath();
			System.out.println("bgPath: "+bgPath);
		}
		
		
		
		
		//将文章的type设置为发布类型 , 默认为1 草稿类型
		article.setArticleType(2);
		this.articleServiceImpl.articleSubmit(article , bgPath);
		return "redirect:../article/article-list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
