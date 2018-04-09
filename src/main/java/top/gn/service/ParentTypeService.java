/**  
 * @Title: ParentTypeService.java  
 * @Package top.gn.service 
 * @author BoyHu  
 * @date 6 Apr 2018  
 * @version V1.0  
 */  
package top.gn.service;

import java.util.List;

import top.gn.entity.BlogParentType;

/**  
 * @ClassName: ParentTypeService  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author BoyHu
 * @date 6 Apr 2018  
 *    
 */
public interface ParentTypeService {

	List<BlogParentType> getParentTypeAll();
	
	
}
