/**  
 * @Title: ChildTypeDAO.java  
 * @Package top.gn.dao 
 * @author BoyHu  
 * @date 6 Apr 2018  
 * @version V1.0  
 */  
package top.gn.dao;

import java.sql.SQLException;
import java.util.List;

import top.gn.entity.BlogChildType;

/**  
 * @ClassName: ChildTypeDAO  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author BoyHu
 * @date 6 Apr 2018  
 *    
 */
public interface ChildTypeDAO {

	List<BlogChildType> getAll() throws SQLException;
	
	
}
