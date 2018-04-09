/**  
 * @Title: ArticleService.java  
 * @Package top.gn.service 
 * @author BoyHu  
 * @date 4 Apr 2018  
 * @version V1.0  
 */  
package top.gn.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.gn.dao.ArticlerDAO;
import top.gn.dao.impl.ArticleDAOImpl;
import top.gn.entity.Article;
import top.gn.page.Page;
import top.gn.service.ArticleService;

/**  
 * @ClassName: ArticleService  
 * @Description: 处理ArticleDAO的业务逻辑
 * @author BoyHu
 * @date 4 Apr 2018  
 *    
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	private ArticlerDAO articleDAOImpl;
	
	public ArticleServiceImpl() {
		System.out.println("ArticleServiceImpl......");
	}
	
	@Autowired
	public void setArticleDAOImpl(ArticlerDAO articleDAOImpl) {
		this.articleDAOImpl = articleDAOImpl;
	}

	@Override
	public Page<Article> getArticlePage(int pageNo) {
		
		Page<Article> page = new Page<Article>(5 , pageNo , this.getArticleCount());
		try {
			//封装了查询结果的page
			page = this.articleDAOImpl.getArticlePage(page);
		} catch (SQLException e) {
			System.err.println("ArticleServiceImpl#getArticlePage");
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public List<Article> getArticleAll() {
		return null;
	}

	@Override
	public List<Article> getArticleByChildType(String childType) {
		try {
			return this.articleDAOImpl.getArticleByChildType(childType);
		} catch (SQLException e) {
			System.err.println("错误: ArticleServiceImpl#getArticleByChildType()");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Article> getArticleByParentType(String parentType) {
		try {
			return this.articleDAOImpl.getArticleByParentType(parentType);
		} catch (SQLException e) {
			System.err.println("错误: ArticleServiceImpl#getArticleByParentType()");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Article> getArticleByBrowse() {
		try {
			return this.articleDAOImpl.getArticleByBrowse(50);
		} catch (SQLException e) {
			System.err.println("错误: ArticleServiceImpl#getArticleByBrowse()");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Article getArticleById(Integer id) {
		try {
			return this.articleDAOImpl.getArticleById(id);
		} catch (SQLException e) {
			System.err.println("ArticleServiceImpl.getArticleById() --- error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public long getArticleCount() {
		try {
			return this.articleDAOImpl.getArticleCount();
		} catch (SQLException e) {
			System.err.println(this+" Method:getArticleCount() error");
			e.printStackTrace();
		}
		
		return 0L;
	}

	@Override
	public long addArticle(Article article) {
		return 0;
	}

	
	
	
	
	
	
}
