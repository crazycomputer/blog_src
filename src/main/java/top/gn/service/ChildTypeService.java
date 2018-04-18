/**  
 * @Title: ChildTypeService.java  
 * @Package top.gn.service 
 * @author BoyHu  
 * @date 6 Apr 2018  
 * @version V1.0  
 */  
package top.gn.service;

import java.util.List;

import top.gn.entity.BlogChildType;

/**  
 * @ClassName: ChildTypeService  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author BoyHu
 * @date 6 Apr 2018  
 *    
 */
public interface ChildTypeService {

	List<BlogChildType> getChildTypeAll();

	List<BlogChildType> getChildTypeByParentName(String parentName);
	
	
	
}
