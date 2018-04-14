/**  
 * @Title: ArticleService.java  
 * @Package top.gn.service 
 * @author BoyHu  
 * @date 4 Apr 2018  
 * @version V1.0  
 */  
package top.gn.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import top.gn.dao.ArticleInfoDAO;
import top.gn.dao.ArticlerDAO;
import top.gn.entity.Article;
import top.gn.entity.Manager;
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
	
	private ArticleInfoDAO articleInfoDAOImpl;
	
	public ArticleServiceImpl() {
		System.out.println("ArticleServiceImpl......");
	}
	
	@Autowired
	public void setArticleInfoDAOImpl(ArticleInfoDAO articleInfoDAOImpl) {
		this.articleInfoDAOImpl = articleInfoDAOImpl;
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
	public Article getArticleEditor(int id) {
		try {
			return this.articleDAOImpl.getArticleEditorMd(id);
		} catch (SQLException e) {
			System.err.println("ArticleServiceImpl.getArticleEditor() --- error");
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
	public List<Article> getArticleByAuthor(Object managerobj){
		Manager manger = null;
		try {
			manger = (Manager)managerobj;
			return this.articleDAOImpl.getArticleByArthor(manger);
		} catch (SQLException e) {
			System.err.println(this+" Method:getArticleByAuthor error");
			e.printStackTrace(); 
		} catch (Exception e1) {
			System.err.println(this+" Method:getArticleByAuthor error");
			e1.printStackTrace();
		}
		return null;
	}
	
	

	/*------------ 添加 -------------*/
	
	@Override
	public long addArticle(Article article) {
		
		try {
			long id =  this.articleDAOImpl.addArticle(article);
					   this.articleInfoDAOImpl.addArticleInfo((int)id);
			return id;
		} catch (SQLException e) {
			System.err.println(this.getClass()+" #addArticle(Article article)");
			e.printStackTrace();
		}
		
		return -1L;
	}
	
	@Override
	public int articleSubmit(Article article , String bgPath) {
		try {
			return this.articleDAOImpl.articleSubmit(article, bgPath);
		} catch (SQLException e) {
			System.err.println("ArticleServiceImpl.articleSubmit(Article article , String bgPath)");
			e.printStackTrace();
		}
		return -1;
	}
	
	
	
	@Override
	public String upload(HttpServletRequest request , MultipartFile pototitle) {
		
		if(pototitle != null && !pototitle.isEmpty()) {
			System.out.println("id:"+pototitle.getName());
			System.out.println("type:"+ pototitle.getContentType());
			String path = request.getServletContext().getRealPath("poto");
			
			String potoName = pototitle.getOriginalFilename();
			
			String newFileName = UUID.randomUUID() + potoName;
			
			File newFile = new File(path , newFileName);
			
			System.out.println(newFile.getParentFile().exists());
			if(!newFile.getParentFile().exists()) {
				newFile.getParentFile().mkdirs();
			}
			
			File upFile = new File(path + File.separator + "type_mg" + File.separator + newFileName);
			System.out.println(path);
			try {
				pototitle.transferTo(upFile);
			} catch (IllegalStateException | IOException e) {
				System.out.println("ArticleServiceImpl.upload()");
				e.printStackTrace();
			}
			
			System.out.println(potoName);
			return newFileName;
		}
		return null;
	}
	
	
	public void deletePoto(String bgPath , HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("poto");
		File bgPathFile = new File(path + File.separator + "type_mg" + File.separator + bgPath);
		if(bgPathFile.exists()) {
			bgPathFile.delete();
			System.out.println("删除旧图片: " + bgPath);
		}else {
			System.out.println("没有找到旧文件");
		}
		
	}
	
	
	
	
}
