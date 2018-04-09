/**  
 * @Title: GenericDAO.java  
 * @Package top.gn.dao 
 * @author BoyHu  
 * @date 4 Apr 2018  
 * @version V1.0  
 */  
package top.gn.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

/**  
 * @ClassName: GenericDAO  
 * @Description: DAO最顶层接口
 * @author BoyHu
 * @date 4 Apr 2018  
 *    
 */
public interface GenericDAO<T> {

	/**
	 * 
	 * @Title: update  
	 * @Description: 更新操作
	 * @param sql  要执行的sql
	 * @param params 参数
	 * @return 返回影响的行数
	 * @throws
	 */
	int doUpdate(String sql , Object...params) throws SQLException;
	
	
	/**
	 * @Title: doInsert  
	 * @Description: 插入一条数据后 , 返回当前自增的id  
	 * @param sql 需要执行的sql
	 * @param params 占位符
	 * @return 返回 插入数据自增的id
	 * @throws
	 */
	long doInsert(String sql , Object ...params);
	
	/**
	 * 
	 * @Title: getFieldValue  
	 * @Description: 返回某一个字段的值  
	 * @param clazz 该字段类型的  class对象
	 * @param sql 需要执行的sql 
	 * @param params 参数
	 * @return 返回该字段的值
	 * @throws
	 */
	<E> E doGetFieldValue(Class<E> clazz , String sql , Object...params)  throws SQLException;
	
	
	/**
	 * @Title: get  
	 * @Description: 查询 指定的一个记录
	 * @param sql 需要执行的sql 
	 * @param params 参数 , 填补占位符
	 * @return  返回该字段的值
	 * @throws
	 */
	T doGet(String sql ,RowMapper<T> rowMapper , Object ...params)  throws SQLException;
	
	/**
	 * 
	 * @Title: getAll  
	 * @Description: 查询多个 指定的记录
	 * @param sql 需要执行的sql 
	 * @param obj  参数 , 填补占位符
	 * @return 结果集
	 * @throws SQLException
	 */
	List<T> doGetAll(String sql , RowMapper<T> rowMapper, Object ...obj) throws SQLException;
	
	
	
}
