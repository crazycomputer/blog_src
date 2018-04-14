/**  
 * @Title: Article.java  
 * @Package top.gn.entity  
 * @Description: 文章的JavaBean  
 * @author xiaomi  
 * @date 1 Apr 2018  
 * @version V1.0  
 */  
package top.gn.entity;

import java.util.Date;

import org.springframework.stereotype.Component;
 
/** 
 * @ClassName: Article  
 * @Description: 文章的JavaBean  
 * @author BoyHu  
 * @date 1 Apr 2018 
 */ 
@Component
public class Article {

	private Integer id;
	
	private String author;
	
	private String title;
	//简介 md语法
	private String subtitleMd;
	//简介 html
	private String subtitleHTML;
	// 所属 二级分类
	private String type;
	// 所属一级分类
	private String parentType;
	
	
	private String contentHTML;
	
	private String contentMd;
	
	private Date createDate;
	
	private int articleType;
	
	private int browse;
	
	private int like;
	
	private String bgPath;
	

	public Article() {}
	
	

	public Article(Integer id, String author, String title, String subtitleMd, String subtitleHTML, String type,
			String contentHTML, String contentMd, int articleType) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.subtitleMd = subtitleMd;
		this.subtitleHTML = subtitleHTML;
		this.type = type;
		this.contentHTML = contentHTML;
		this.contentMd = contentMd;
		this.articleType = articleType;
	}




	public Article(Integer id, String author, String title, String subtitleMd, String subtitleHTML, String type,
			String parentType, String contentHTML, String contentMd, int articleType, int browse,
			int like) {
		super();
		this.author = author;
		this.title = title;
		this.subtitleMd = subtitleMd;
		this.subtitleHTML = subtitleHTML;
		this.type = type;
		this.parentType = parentType;
		this.contentHTML = contentHTML;
		this.contentMd = contentMd;
		this.articleType = articleType;
		this.browse = browse;
		this.like = like;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitleMd() {
		return subtitleMd;
	}

	public void setSubtitleMd(String subtitleMd) {
		this.subtitleMd = subtitleMd;
	}

	public String getSubtitleHTML() {
		return subtitleHTML;
	}

	public void setSubtitleHTML(String subtitleHTML) {
		this.subtitleHTML = subtitleHTML;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	public void setParentType(String parentType) {
		this.parentType = parentType;
	}
	
	public String getParentType() {
		return parentType;
	}

	public String getContentHTML() {
		return contentHTML;
	}

	public void setContentHTML(String contentHTML) {
		this.contentHTML = contentHTML;
	}

	public String getContentMd() {
		return contentMd;
	}

	public void setContentMd(String contentMd) {
		this.contentMd = contentMd;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getArticleType() {
		return articleType;
	}

	public void setArticleType(int articleType) {
		this.articleType = articleType;
	}

	

	public String getBgPath() {
		return bgPath;
	}



	public void setBgPath(String bgPath) {
		this.bgPath = bgPath;
	}



	@Override
	public String toString() {
		return "Article [id=" + id + ", author=" + author + ", title=" + title + ", subtitleMd=" + subtitleMd
				+ ", subtitleHTML=" + subtitleHTML + ", type=" + type + ", parentType=" + parentType + ", contentHTML="
				+ contentHTML + ", contentMd=" + contentMd + ", createDate=" + createDate + ", articleType="
				+ articleType + ", browse=" + browse + ", like=" + like + "]";
	}


	
	
	
	
	
	
	
	
}
