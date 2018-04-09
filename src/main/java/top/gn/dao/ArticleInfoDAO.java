/**  
 * @Title: ArticleInfoDAO.java  
 * @Package top.gn.dao 
 * @author BoyHu  
 * @date 9 Apr 2018  
 * @version V1.0  
 */  
package top.gn.dao;

import java.sql.SQLException;

import top.gn.entity.ArticleInfo;

/**  
 * @ClassName: ArticleInfoDAO  
 * @Description: 
 * @author BoyHu
 * @date 9 Apr 2018  
 *    
 */
public interface ArticleInfoDAO {

	/**
	 * @Title: addArticleInfo  
	 * @Description: 添加对应的   文章信息
	 * @return
	 * @throws SQLException
	 */
	int addArticleInfo(ArticleInfo articleInfo) throws SQLException;

	/**
	 * @Title: deleteArticleInfo  
	 * @Description: 删除一条文章对应的其他信息  
	 * @param 根据文章的id进行删除
	 * @return 
	 * @throws
	 */
	int deleteArticleInfoByArticleId(int articleId) throws SQLException ;
	
	/**
	 * 
	 * @Title: updateBrowseArticleInfo  
	 * @Description: 更新浏览人数
	 * @param articleId 文章id
	 * @return 返回影响的行数
	 * @throws SQLException
	 */
	int updateBrowseArticleInfo(int articleId) throws SQLException ;
	
	/**
	 * 
	 * @Title: updateLikeArticleInfo  
	 * @Description: 更新点赞人数
	 * @param articleId 文章id
	 * @return 返回影响的行数
	 * @throws SQLException
	 */
	int updateLikeArticleInfo(int articleId) throws SQLException ;
}
