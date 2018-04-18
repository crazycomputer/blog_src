/**  
 * @Title: ChildTypeDAOImpl.java  
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

import top.gn.dao.ChildTypeDAO;
import top.gn.entity.BlogChildType;

/**  
 * @ClassName: ChildTypeDAOImpl  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author BoyHu
 * @date 6 Apr 2018  
 *    
 */
@Repository
public class ChildTypeDAOImpl extends GenericDAOImpl<BlogChildType> implements ChildTypeDAO {
	
	public ChildTypeDAOImpl() {System.out.println("ChildTypeDAOImpl...");}

	RowMapper<BlogChildType> rowMapper = new BeanPropertyRowMapper<BlogChildType>(BlogChildType.class);
	
	@Override
	public List<BlogChildType> getAll() throws SQLException {
		String sql = " SELECT id , name , parent_type as parentType FROM blog_child_type ";
		return doGetAll(sql, rowMapper);
	}

	@Override
	public List<BlogChildType> getChildTypeByParentName(String parentName) throws SQLException {
		String sql = " SELECT id , name , parent_type as parentType FROM blog_child_type WHERE parent_type = ? ";
		return doGetAll(sql, rowMapper, parentName);
	}

}
