/**  
 * @Title: ManagerDAOImpl.java  
 * @Package top.gn.dao.impl 
 * @author BoyHu  
 * @date 4 Apr 2018  
 * @version V1.0  
 */  
package top.gn.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import top.gn.dao.ManagerDAO;
import top.gn.entity.Manager;

/**  
 * @ClassName: ManagerDAOImpl  
 * @Description: 用户管理dao
 * @author BoyHu
 * @date 4 Apr 2018
 */
@Repository
public class ManagerDAOImpl extends GenericDAOImpl<Manager> implements ManagerDAO {

	RowMapper<Manager> rowMapper = new BeanPropertyRowMapper<Manager>(Manager.class);
	
	/**  
	 * 创建一个新的实例 ManagerDAOImpl.  
	 */
	public ManagerDAOImpl() {
		System.out.println("ManagerDAOImpl.....");
	}

	/*----------获取  start--------------*/
	@Override
	public List<Manager> getAll() throws SQLException {
		String sql = " SELECT id,account,`hash`,`level`,nickname FROM manager ";
		return doGetAll(sql, rowMapper);
	}

	@Override
	public Manager getManagerById(Integer id)  throws SQLException  {
		String sql = " SELECT id,account,`hash`,`level`,nickname FROM manager WHERE id = ?  ";
		return doGet(sql, rowMapper, id);
	}

	@Override
	public Manager getManagerByKey(String account) throws SQLException  {
		String sql = " SELECT id,account,`hash`,`level`,nickname FROM manager WHERE account = ? ";
		return doGet(sql, rowMapper, account);
	}

	@Override
	public Manager getManagerByAccountOrNickname(Manager manager) throws SQLException  {
		String sql = " SELECT id,account,`hash`,`level`,nickname FROM manager WHERE nickname = ? ";
		return doGet(sql, rowMapper, manager.getNickname());
	}
	/*----------获取  end--------------*/

	
	
	/*---------- 修改  S  --------------*/
	@Override
	public int setNewHash(Manager manager, String newHash) throws SQLException  {
		String sql = " UPDATE manager SET hash = ? WHERE account = ? AND hash = ? ";
		return doUpdate(sql, newHash , manager.getAccount() , manager.getHash()) ;
	}
	/*---------- 修改  E  --------------*/
	
	/*---------- 删除  S -------------*/
	@Override
	public int removeById(Integer id) throws SQLException  {
		String sql = " DELETE FROM manager WHERE id = ? ";
		return doUpdate(sql, id);
	}
	/*---------- 删除 E -------------*/
	
	/*----------添加 S --------------*/
	@Override
	public int addManager(Manager manager) throws SQLException {
		String sql = " INSERT INTO manager(account , `hash` , nickname) value(?,?,?) ";
		return doUpdate(sql, manager.getAccount() , manager.getHash() , manager.getNickname());
	}
	/*----------添加 E --------------*/
	
	
}
