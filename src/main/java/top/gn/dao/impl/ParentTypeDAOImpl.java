/**  
 * @Title: ParentTypeDAOImpl.java  
 * @Package top.gn.dao.impl 
 * @author BoyHu  
 * @date 6 Apr 2018  
 * @version V1.0  
 */  
package top.gn.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import top.gn.dao.ParentTypeDAO;
import top.gn.entity.BlogParentType;

/**  
 * @ClassName: ParentTypeDAOImpl  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author BoyHu
 * @date 6 Apr 2018  
 *    
 */
@Repository
public class ParentTypeDAOImpl extends GenericDAOImpl<BlogParentType> implements ParentTypeDAO {

	
	
	
	public ParentTypeDAOImpl() {System.out.println("ParentTypeDAOImpl...");}

	RowMapper<BlogParentType> rowMapper = new BeanPropertyRowMapper<BlogParentType>(BlogParentType.class);
	
	@Override
	public List<BlogParentType> getAll() throws SQLException {
		String sql = " SELECT id , name FROM blog_parent_type ";
		return doGetAll(sql, rowMapper);
	}

}
