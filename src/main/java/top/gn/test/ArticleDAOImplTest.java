/**  
 * @Title: ArticleDAOImplTest.java  
 * @Package top.gn.test 
 * @author BoyHu  
 * @date 4 Apr 2018  
 * @version V1.0  
 */  
package top.gn.test;


import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.gn.dao.impl.ArticleDAOImpl;
import top.gn.dao.impl.ArticleInfoDAOImpl;
import top.gn.entity.Article;
import top.gn.page.Page;

/**  
 * @ClassName: ArticleDAOImplTest  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author BoyHu
 * @date 4 Apr 2018  
 *    
 */
public class ArticleDAOImplTest {
	
	ApplicationContext ac;
	ArticleDAOImpl articleDAOImpl ; 
	ArticleInfoDAOImpl articleInfoDAOImpl;
	{
		this.ac = new ClassPathXmlApplicationContext("springConfig.xml");
		articleDAOImpl = this.ac.getBean(ArticleDAOImpl.class);
		articleInfoDAOImpl = this.ac.getBean(ArticleInfoDAOImpl.class);
	}

	
	@Test
	public void testGetArticleAll() throws SQLException {
		System.out.println(articleDAOImpl.getArticleAll());
	}
	
	@Test
	public void testGetArticlePage() throws SQLException {
		Page<Article> page = new Page<Article>(3, -2, articleDAOImpl.getArticleCount());
		page = articleDAOImpl.getArticlePage(page);
		
		for(Article a : page.getList()) {
			System.out.println(a);
		}
	}
	
	@Test
	public void testGetArticleByChildType() throws SQLException {
		List<Article> list = articleDAOImpl.getArticleByChildType("技术");
		for (Article article : list) {
			System.out.println(article);
		}
	}
	@Test
	public void testGetArticleByParentType() throws SQLException {
		List<Article> list = articleDAOImpl.getArticleByParentType("技术");
		for (Article article : list) {
			System.out.println(article);
		}
	}
	
	@Test
	public void testAddArticle() throws SQLException {
		Article article = new Article();
		article.setAuthor("小李");
		article.setTitle("测试标题");
		article.setSubtitleHTML("<a href='#'>链接</a>");
		article.setSubtitleMd("[发的士大夫](http://www.baidu.com)");
		article.setType("python");
		article.setParentType("技术");
		article.setContentHTML("冲突了听HTMl");
		article.setContentMd("```content MD  test  ```");
		
		//long id = articleDAOImpl.addArticle(article);
		//System.out.println(id);
	}
	
	@Test
	public void testGetArticleById() throws SQLException {
		System.out.println(articleDAOImpl.getArticleById(15));
	}
	
	@Test
	public void testGetArticleCount() throws SQLException {
		System.out.println(articleDAOImpl.getArticleCount());
	}
	@Test
	public void testArticleInfoDAOImpl() throws SQLException {
		System.out.println(articleInfoDAOImpl.addArticleInfo(15));
	}
	

}
