/**  
 * @Title: ArticleHandler.java  
 * @Package top.gn.controller 
 * @author BoyHu  
 * @date 1 Apr 2018  
 * @version V1.0  
 */  
package top.gn.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.gn.entity.Article;
import top.gn.entity.BlogData;
import top.gn.page.Page;
import top.gn.service.ArticleService;
import top.gn.service.ChildTypeService;
import top.gn.service.ParentTypeService;



/**  
 * @ClassName: ArticleHandler  
 * @Description: 处理 操作文章展示的相关 请求 , 
 * @author BoyHu
 * @date 1 Apr 2018
 */
@RequestMapping("/article")
@Controller
public class ArticleHandler {

	/*
	 * 做为 Article的请求处理Handler , 
	 * 		该类当中需要有一个 ArticleService 的服务
	 * 		父分类  parentTypeServiceImpl 的服务
	 * 		子分类 childTypeServiceImpl 的服务
	 */
	private ArticleService articleServiceImpl;
	private ChildTypeService childTypeServiceImpl;
	private ParentTypeService parentTypeServiceImpl;
	
	public ArticleHandler() {}
	
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
	 * 
	 * @Title: exhibitionArticlePage  
	 * @Description: 分页查找第一页文章文章 
	 * @param map 用于将查询结果放到requestScope当中
	 * @return
	 * @throws
	 */
	@GetMapping(value = "/article-list")
	public String exhibitionArticlePage(Map<String, Object> map) {
		BlogData blogData = new BlogData();
		
		blogData.setPage(this.articleServiceImpl.getArticlePage(1));
		
		blogData.setChildTypesList(this.childTypeServiceImpl.getChildTypeAll());
		
		blogData.setArticleBrowse(this.articleServiceImpl.getArticleByBrowse());
		map.put("blogData", blogData);
		return "/blog-index";
	}
	
	/**
	 * 
	 * @Title: exhibitionArticlePageAjax  
	 * @Description: 查找其余页文章 , 由于使用了 ajax 所以需要在方法上添加@ResponseBody 注解
	 * 	用于将return 的内容 响应给浏览器
	 * @param pageNo 查询的页数  , 最低从第二页开始
	 * @return 查询到的page 对象
	 * @throws
	 */
	@ResponseBody
	@GetMapping(value = "/article-list-ajax")
	public Page<Article> exhibitionArticlePageAjax(@RequestParam(value="pageNo") int pageNo) {
		Page<Article> page = this.articleServiceImpl.getArticlePage(pageNo);		
		return page;
	}
	
	/**
	 * 
	 * @Title: exhibitionArticleById  
	 * @Description: 根据id查找文章 
	 * @param id --文章id
	 * @param map -- 用于将查询的文章对象 , 放入request
	 * @return
	 * @throws
	 */
	@GetMapping("/article-show/{id}")
	public String exhibitionArticleById(@PathVariable(value="id") int id , Map<String, Object> map) {
		BlogData blogData = new BlogData();
		blogData.setArticle(this.articleServiceImpl.getArticleById(id));
		blogData.setChildTypesList(this.childTypeServiceImpl.getChildTypeAll());		
		blogData.setArticleBrowse(this.articleServiceImpl.getArticleByBrowse());				
		map.put("blogData", blogData);
		return "/text-content";
	}
	
	/**
	 * 
	 * @Title: exhibitionArticleDefaultType  
	 * @Description: 按照默认的分类(技术) 查找对应的文章
	 * @throws
	 */
	@GetMapping("/article-type")
	public String exhibitionArticleDefaultType(Map<String, Object> map) {
		BlogData blogData = new BlogData();
		blogData.setArticlesList(this.articleServiceImpl.getArticleByParentType("技术"));
		blogData.setChildTypesList(this.childTypeServiceImpl.getChildTypeAll());
		blogData.setParentTypesList(this.parentTypeServiceImpl.getParentTypeAll());
		map.put("blogData", blogData);
		return "/blog_type";
	}

	
	
	
	/**
	 * 
	 * @Title: exhibitionArticleByChildType  
	 * @Description: 按照子分类(二级分类 or 也可以叫做<标签>)查找文章
	 * @return
	 * @throws
	 */
	@GetMapping("/article-type/2/{childType}")
	public String exhibitionArticleByChildType(@PathVariable("childType") String childType , Map<String, Object> map) {
		BlogData blogData = new BlogData();
		blogData.setArticlesList(this.articleServiceImpl.getArticleByChildType(childType));
		blogData.setChildTypesList(this.childTypeServiceImpl.getChildTypeAll());
		blogData.setParentTypesList(this.parentTypeServiceImpl.getParentTypeAll());
		map.put("blogData", blogData);
		return "/blog_type";
	}
	
	/**
	 * 
	 * @Title: exhibitionArticleByChildType  
	 * @Description: 按照子分类(二级分类 or 也可以叫做<标签>)查找文章
	 * @return
	 * @throws
	 */
	@GetMapping("/article-type/1/{parentType}")
	public String exhibitionArticleByParentType(@PathVariable("parentType") String parentType , Map<String, Object> map) {
		BlogData blogData = new BlogData();
		blogData.setArticlesList(this.articleServiceImpl.getArticleByParentType(parentType));
		blogData.setChildTypesList(this.childTypeServiceImpl.getChildTypeAll());
		blogData.setParentTypesList(this.parentTypeServiceImpl.getParentTypeAll());
		map.put("blogData", blogData);
		return "/blog_type";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
