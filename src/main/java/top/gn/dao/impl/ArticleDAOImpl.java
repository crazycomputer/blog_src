/**  
 * @Title: ArticleDAOImpl.java  
 * @Package top.gn.dao.impl 
 * @author BoyHu  
 * @date 1 Apr 2018  
 * @version V1.0  
 */  
package top.gn.dao.impl;

import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import top.gn.dao.ArticlerDAO;
import top.gn.entity.Article;
import top.gn.page.Page;

/**  
 * @ClassName: ArticleDAOImpl  
 * @Description: 这个类是ArticleDAO的实现类 , 为ArticleDAO接口当中的方法 ,提供了具体实现
 * @author BoyHu
 * @date 1 Apr 2018
 *    
 */
@Repository
public class ArticleDAOImpl extends GenericDAOImpl<Article> implements ArticlerDAO {

	public ArticleDAOImpl() {
		System.out.println("ArticleDAOImpl....");
	}
	
	
	RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
	
	/*
	 * <p>Title: getAll</p>  
	 * <p>Description: 查询所有的文章  </p>  
	 * @return  
	 * @see top.gn.dao.ArticlerDAO#getAll()  
	 */
	@Override
	public List<Article> getArticleAll() throws SQLException {
		String sql = " SELECT article.id,author,title, subtitle_html AS subtitleHTML , create_date AS createDate , type , parent_type AS parentType , article_info.browse , article_info.`like` FROM article,article_info WHERE article.id=article_info.article_id ORDER BY id DESC  LIMIT 2,3 ";
		return doGetAll(sql,rowMapper);
	}

	@Override
	public Page<Article> getArticlePage(Page<Article> page) throws SQLException {
		String sql = " SELECT article.id,author,title, subtitle_html AS subtitleHTML , create_date AS createDate , type , parent_type AS parentType , article_info.browse , article_info.`like` FROM article,article_info WHERE article.id=article_info.article_id ORDER BY id DESC  LIMIT ?,? "; 
		int a = (page.getPageNo()-1)*page.getPageSize();  //计算每一页的起始 数据的下标  (当前页 - 1) * 每页显示的数量
		page.setList(doGetAll(sql, rowMapper, a , page.getPageSize()));
		return page;
	}

	@Override
	public List<Article> getArticleByChildType(String childType) throws SQLException {
		String sql = " SELECT article.id,author,title, subtitle_html AS subtitleHTML , create_date AS createDate , type , parent_type AS parentType , article_info.browse , article_info.`like` FROM article,article_info WHERE type = ? AND article.id=article_info.article_id ORDER BY id DESC ";
		return doGetAll(sql , rowMapper , childType);
	}

	@Override
	public List<Article> getArticleByParentType(String parentType) throws SQLException {
		String sql = " SELECT article.id,author,title, subtitle_html AS subtitleHTML , create_date AS createDate , type , parent_type AS parentType , article_info.browse , article_info.`like` FROM article,article_info WHERE parent_type = ?  AND article.id=article_info.article_id ORDER BY id DESC  ";
		return doGetAll(sql , rowMapper , parentType);
	}


	@Override
	public Article getArticleById(Integer id) throws SQLException {
		String sql = " SELECT article.id,author,title, subtitle_html AS subtitleHTML , content_html AS contentHTML , create_date AS createDate , type , parent_type AS parentType , article_info.browse , article_info.`like` FROM article,article_info WHERE article.id = ? AND article.id=article_info.article_id ";
		return doGet(sql, rowMapper, id);
	}

	@Override
	public long getArticleCount() throws SQLException  {
		String sql = " SELECT COUNT(1) FROM article ";
		return doGetFieldValue(Long.class, sql);
	}

	@Override
	public List<Article> getArticleByBrowse(int browse) throws SQLException {
		String sql = "SELECT article.id,title FROM article,article_info WHERE article.id=article_info.article_id AND article_info.browse > ? ";
		return doGetAll(sql, rowMapper, browse);
	}


	/*-------- 添  加 ---------*/
	@Override
	public long addArticle(Article article) throws SQLException {
		String sql = " INSERT article(author,title,subtitle_md ,subtitle_html , create_date , parent_type , type , content_html , content_md ) value(?,?,?,?,CURDATE(),?,?,?,?) ";
		return doInsert(sql, article.getAuthor() , article.getTitle() , article.getSubtitleMd() , article.getSubtitleHTML() , article.getParentType() , article.getType()
				,article.getContentHTML() , article.getContentMd());
	}
	
	/*--------- 删除  ----------*/
	
	

	


	
	
}

