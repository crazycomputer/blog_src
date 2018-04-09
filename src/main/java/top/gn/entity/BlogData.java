/**  
 * @Title: BlogData.java  
 * @Package top.gn.entity 
 * @author BoyHu  
 * @date 8 Apr 2018  
 * @version V1.0  
 */  
package top.gn.entity;

import java.util.List;

import top.gn.page.Page;

/**  
 * @ClassName: BlogData  
 * @Description: 该类用于存放 请求相关的数据信息
 * @author BoyHu
 * @date 8 Apr 2018  
 *    
 */
public class BlogData {

	private List<Article> articlesList;
	
	private List<Article> articleBrowse;
	
	private List<BlogChildType> childTypesList;
	
	private List<BlogParentType> parentTypesList;
	
	private List<Manager> managersList;
	
	private Page<Article> page;
	
	private Article article;

	public List<Article> getArticlesList() {
		return articlesList;
	}
	
	

	public Page<Article> getPage() {
		return page;
	}

	public void setPage(Page<Article> page) {
		this.page = page;
	}
	
	


	public Article getArticle() {
		return article;
	}



	public void setArticle(Article article) {
		this.article = article;
	}



	public List<Article> getArticleBrowse() {
		return articleBrowse;
	}
	public void setArticleBrowse(List<Article> articleBrowse) {
		this.articleBrowse = articleBrowse;
	}
	public void setArticlesList(List<Article> articlesList) {
		this.articlesList = articlesList;
	}

	public List<BlogChildType> getChildTypesList() {
		return childTypesList;
	}

	public void setChildTypesList(List<BlogChildType> childTypesList) {
		this.childTypesList = childTypesList;
	}

	public List<BlogParentType> getParentTypesList() {
		return parentTypesList;
	}

	public void setParentTypesList(List<BlogParentType> parentTypesList) {
		this.parentTypesList = parentTypesList;
	}

	public List<Manager> getManagersList() {
		return managersList;
	}

	public void setManagersList(List<Manager> managers) {
		this.managersList = managers;
	}
	
	
	
	
}
