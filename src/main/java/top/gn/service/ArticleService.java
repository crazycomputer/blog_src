/**  
 * @Title: ArticleService.java  
 * @Package top.gn.service 
 * @author BoyHu  
 * @date 5 Apr 2018  
 * @version V1.0  
 */  
package top.gn.service;

import java.sql.SQLException;
import java.util.List;

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
	
}