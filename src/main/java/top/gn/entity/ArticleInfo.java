/**  
 * @Title: ArticleInfo.java  
 * @Package top.gn.entity 
 * @author BoyHu  
 * @date 9 Apr 2018  
 * @version V1.0  
 */  
package top.gn.entity;

import org.springframework.stereotype.Component;

/**  
 * @ClassName: ArticleInfo  
 * @Description: 文章的其他信息
 * @author BoyHu
 * @date 9 Apr 2018
 */
@Component
public class ArticleInfo {
	
	private int id;
	
	private int articleId;
	
	private int browse;
	
	private int like;
	
	private String bgPath;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public int getBrowse() {
		return browse;
	}

	public void setBrowse(int browse) {
		this.browse = browse;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public String getBgPath() {
		return bgPath;
	}

	public void setBgPath(String bgPath) {
		this.bgPath = bgPath;
	}
	
	
	
	
}
