/**  
 * @Title: ArticlerDAO.java  
 * @Package top.gn.dao 
 * @author BoyHu  
 * @date 1 Apr 2018  
 * @version V1.0  
 */  
package top.gn.dao;

import java.sql.SQLException;
import java.util.List;

import top.gn.entity.Article;
import top.gn.page.Page;

/**  
 * @ClassName: ArticlerDAO  
 * @Description: 文章操作的 dao接口
 * @author BoyHu
 * @date 1 Apr 2018  
 *    
 */
public interface ArticlerDAO {

	
	/*-----------获取--------*/
	/**
	 * 
	 * @Title: getAll  
	 * @Description: 查询所有的文章  
	 * @return List<Article> 返回查询到的结果集 , 若没有对应的记录 , 返回的list.size = 0
	 * @throws
	 */
	List<Article> getArticleAll() throws SQLException;
	
	/**
	 * 
	 * @Title: getArticlePage  
	 * @Description: 查询文章 , 分页查询  
	 * @param page  分页的条件
	 * @return 返回page对象 , 已经保存了查询结果的page对象
	 * @throws
	 */
	Page<Article> getArticlePage(Page<Article> page)  throws SQLException;
	
	/**
	 * 
	 * @Title: getArticleByChildType  
	 * @Description: 根据子分类查找文章  
	 * @param type 分类的名称
	 * @return  返回查询到的结果集 , 若没有对应的记录 , 返回的list.size = 0
	 * @throws
	 */
	List<Article> getArticleByChildType(String childType)  throws SQLException;

	/**
	 * 
	 * @Title: getArticleByParentType  
	 * @Description: 根据副分类查找文章
	 * @param parentType 副分类
	 * @return 返回查询到的结果集 , 若没有对应的记录 , 返回的list.size = 0
	 * @throws
	 */
	List<Article> getArticleByParentType(String parentType)  throws SQLException;
	
	/**
	 * 
	 * @Title: getArticleByBrowse  
	 * @Description: 根据浏览量 , 进行文章的查询
	 * @param browse -- 浏览量的条件
	 * @return 放回查询的集合
	 * @throws SQLException
	 * @throws
	 */
	List<Article> getArticleByBrowse(int browse)  throws SQLException;

	
	/**
	 * 
	 * @Title: getArticleById  
	 * @Description: 根据 id 查询 指定文章记录 , 用于点击每一个标题 , 进入文章展示页面  
	 * @param id
	 * @return
	 * @throws
	 */
	Article getArticleById(Integer id) throws SQLException ;
	
	
	/**
	 * 
	 * @Title: getArticleCount  
	 * @Description: 查询  article当中的总记录数
	 * @param sql
	 * @return
	 * @throws
	 */
	long getArticleCount() throws SQLException ;
	
	/*------添加------*/
	/**
	 * 
	 * @Title: addArticle
	 * @Description: 添加一篇文章  
	 * @param article
	 * @return 添加成功返回true , 失败 false
	 * @throws
	 */
	long addArticle(Article article) throws SQLException;
	
	/*------修改 ------*/
	
	int updateEditorArticle();
	
	

	
}
