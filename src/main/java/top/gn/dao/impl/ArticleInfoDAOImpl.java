/**  
 * @Title: ArticleInfoDAOImpl.java  
 * @Package top.gn.dao 
 * @author BoyHu  
 * @date 9 Apr 2018  
 * @version V1.0  
 */  
package top.gn.dao.impl;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import top.gn.dao.ArticleInfoDAO;
import top.gn.entity.ArticleInfo;

/**  
 * @ClassName: ArticleInfoDAOImpl  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author BoyHu
 * @date 9 Apr 2018  
 *    
 */
@Repository
public class ArticleInfoDAOImpl extends GenericDAOImpl<ArticleInfo> implements ArticleInfoDAO {

	
	RowMapper<ArticleInfo> rowMapper = new BeanPropertyRowMapper<ArticleInfo>(ArticleInfo.class);
	
	@Override
	public int addArticleInfo(int articleId) throws SQLException {
		String sql = " INSERT INTO article_info(article_id) VALUE(?)  ";
		return doUpdate(sql, articleId);
	}

	@Override
	public int deleteArticleInfoByArticleId(int articleId) throws SQLException {
		String sql = " DELETE FROM article_info WHERE article_id = ? ";
		return doUpdate(sql, articleId);
	}

	@Override
	public int updateBrowseArticleInfo(int articleId) throws SQLException {
		String sql = " UPDATE article_info SET browse = browse + 1 WHERE article_id = ? ";
		return doUpdate(sql, articleId);
	}

	@Override
	public int updateLikeArticleInfo(int articleId) throws SQLException {
		String sql = " UPDATE article_info SET `like` = `like` + 1 WHERE article_id = ? ";
		return doUpdate(sql, articleId);
	}

}
