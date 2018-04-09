/**  
 * @Title: BlogType.java  
 * @Package top.gn.entity   
 * @author BoyHu  
 * @date 1 Apr 2018  
 * @version V1.0  
 */  
package top.gn.entity;

import org.springframework.stereotype.Component;

/**  
 * @ClassName: BlogType  
 * @Description: 一级分类
 * @author BoyHu  
 * @date 1 Apr 2018  
 *    
 */
@Component
public class BlogParentType {
	
	private Integer id;
	
	private String name;
	
	public BlogParentType() {
	}

	
	public BlogParentType(Integer id, String name) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return "BlogType [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
