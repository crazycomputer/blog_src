/**  
 * @Title: ArticleService.java  
 * @Package top.gn.service 
 * @author BoyHu  
 * @date 5 Apr 2018  
 * @version V1.0  
 */  
package top.gn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import top.gn.entity.Article;
import top.gn.page.Page;

/**  
 * @ClassName: ArticleService  
 * @Description: Article业务逻辑层 , 处理Article业务方法
 * @author BoyHu
 * @date 5 Apr 2018  
 *    
 */
public interface ArticleService {

	/**
	 * 
	 * @Title: getArticlePage  
	 * @Description: 按照分页查询  文章
	 * @param page : 封装分页信息
	 * @return 返回结果集 , 若没有查询到 , 返回 list.size = 0
	 * @throws 
	 */
	Page<Article> getArticlePage(int pageNo); 
	
	/*-----------获取--------*/
	/**
	 * 
	 * @Title: getAll  
	 * @Description: 查询所有的文章  
	 * @return List<Article> 返回查询到的结果集 , 若没有对应的记录 , 返回的list.size = 0
	 * @throws
	 */
	List<Article> getArticleAll();
	
	/**
	 * 
	 * @Title: getArticleByChildType  
	 * @Description: 根据子分类查找文章  
	 * @param type 分类的名称
	 * @return  返回查询到的结果集 , 若没有对应的记录 , 返回的list.size = 0
	 * @throws
	 */
	List<Article> getArticleByChildType(String childType);

	/**
	 * 
	 * @Title: getArticleByParentType  
	 * @Description: 根据副分类查找文章
	 * @param parentType 副分类
	 * @return 返回查询到的结果集 , 若没有对应的记录 , 返回的list.size = 0
	 * @throws
	 */
	List<Article> getArticleByParentType(String parentType);
	
	/**
	 * 
	 * @Title: getArticleByBrowse  
	 * @Description: 提供按照浏览量进行查新的 服务  
	 * @return 放回查询的结果集
	 * @throws 
	 */
	List<Article> getArticleByBrowse();
	
	/**
	 * 
	 * @Title: getArticleById  
	 * @Description: 根据 id 查询 指定文章记录 , 用于点击每一个标题 , 进入文章展示页面  
	 * @param id
	 * @return 返回查询到的结果集 , 若没有对应的记录 , 返回的list.size = 0
	 * @throws
	 */
	Article getArticleById(Integer id) ;
	
	/**
	 * 
	 * @Title: getArticleCount  
	 * @Description: 查询  article当中的总记录数
	 * @param sql
	 * @return 返回查询到的结果集 , 若没有对应的记录 , 返回的list.size = 0
	 * @throws
	 */
	long getArticleCount();
	
	/*------添加------*/
	/**
	 * 
	 * @Title: addArticle
	 * @Description: 添加一篇文章  
	 * @param article
	 * @return 添加成功返回true , 失败 false
	 * @throws
	 */
	long addArticle(Article article);

	/**
	 * 文章封面的文件上传方法
	 * @param request
	 * @param pototitle
	 * @return 返回的是文件的新名称+后缀
	 */
	String upload(HttpServletRequest request, MultipartFile pototitle);

	/**
	 * 用于将最新的数据 , 保存到数据库当中  ,可以使用其实现自动保存 , 和 点击提交后的后一次更新
	 * @param aritcle
	 * @param bgPath
	 * @return
	 */
	int articleSubmit(Article aritcle, String bgPath);

	
	/**
	 * 用于安照用户查询文章 , 
	 * @param managerobj 用户的对象
	 * @return
	 */
	List<Article> getArticleByAuthor(Object managerobj);

	/**
	 * 获取文章进行编辑 和 表单的回显
	 * @param id
	 * @return
	 */
	Article getArticleEditor(int id);
	
}
