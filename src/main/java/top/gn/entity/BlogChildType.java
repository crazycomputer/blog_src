/**  
 * @Title: BlogChildType.java  
 * @Package top.gn.entity  
 * @Description: 二级分类JavaBean
 * @author BoyHu  
 * @date 1 Apr 2018  
 * @version V1.0  
 */  
package top.gn.entity;

import org.springframework.stereotype.Component;

/**  
 * @ClassName: BlogChildType  
 * @Description: 二级分类 JavaBean
 * @author BoyHu
 * @date 1 Apr 2018  
 */ 
@Component
public class BlogChildType {
	
	
	private Integer id;
	
	private String name;
	
	private String parentType;

	public BlogChildType() {
	}

	public BlogChildType(String name) {
		this.name = name;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentType() {
		return parentType;
	}

	public void setParentType(String parentType) {
		this.parentType = parentType;
	}

	@Override
	public String toString() {
		return "BlogChildType [id=" + id + ", name=" + name + ", parentType=" + parentType + "]";
	}
	
	
	
}
