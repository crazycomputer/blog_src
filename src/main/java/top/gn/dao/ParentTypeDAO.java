/**  
 * @Title: ParentTypeDAO.java  
 * @Package top.gn.dao 
 * @author BoyHu  
 * @date 6 Apr 2018  
 * @version V1.0  
 */  
package top.gn.dao;

import java.sql.SQLException;
import java.util.List;

import top.gn.entity.BlogParentType;

/**  
 * @ClassName: ParentTypeDAO  
 * @Description: 该类为  文章一级分类DAO
 * @author BoyHu
 * @date 6 Apr 2018  
 *    
 */
public interface ParentTypeDAO {

	List<BlogParentType> getAll() throws SQLException;
	
	
	
}
