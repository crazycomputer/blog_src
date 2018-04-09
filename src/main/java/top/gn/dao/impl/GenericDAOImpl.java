/**  
 * @Title: GenericDAOImpl.java  
 * @Package top.gn.dao.impl 
 * @author BoyHu  
 * @date 4 Apr 2018  
 * @version V1.0  
 */  
package top.gn.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;



import top.gn.dao.GenericDAO;

/**  
 * @ClassName: GenericDAOImpl  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author BoyHu
 * @date 4 Apr 2018  
 *    
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {

	private JdbcTemplate jdbcTemplate;

    public GenericDAOImpl() {
    	System.out.println("GenericDAOImpl...."); 
    }
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int doUpdate(String sql, Object... params) throws SQLException {
		return this.jdbcTemplate.update(sql, params);
	}
	
	@Override
	public long doInsert(String sql , Object...params) {
		
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        PreparedStatementCreator preparedStatementCreator = con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if(params != null) {
            	for(int i = 0; i< params.length; i++) {
            		ps.setObject(i+1, params[i]);
            	}
            }
            return ps;
        };

        jdbcTemplate.update(preparedStatementCreator, keyHolder);
		return keyHolder.getKey().longValue();
	}
	

	@Override
	public <E> E doGetFieldValue(Class<E> clazz, String sql, Object... params) throws SQLException {
		return this.jdbcTemplate.queryForObject(sql, clazz);
	}

	@Override
	public T doGet(String sql,RowMapper<T> rowMapper, Object... params) throws SQLException {
		try {
			return this.jdbcTemplate.queryForObject(sql, rowMapper, params);
		} catch (DataAccessException e) {
			System.err.println(e.getCause() +" error: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<T> doGetAll(String sql,RowMapper<T> rowMapper, Object... params) throws SQLException {
		return this.jdbcTemplate.query(sql, rowMapper,params);
	}

	
	
}
