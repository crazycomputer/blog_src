/**  
 * @Title: ManagerDAO.java  
 * @Package top.gn.dao  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author BoyHu  
 * @date 1 Apr 2018  
 * @version V1.0  
 */  
package top.gn.dao;

import java.sql.SQLException;
import java.util.List;

import top.gn.entity.Manager;

/**  
 * @ClassName: ManagerDAO  
 * @Description: 用户 DAO
 * @author BoyHu  
 * @date 1 Apr 2018
 */
public interface ManagerDAO {

	/*---------获取---------*/
	/**
	 * 
	 * @Title: getAll  
	 * @Description: 查询所有的注册人员  
	 * @return
	 * List<Manager>
	 * @throws
	 */
	public List<Manager> getAll() throws SQLException;
	
	/**
	 * 
	 * @Title: getManager  
	 * @Description: 根据id 查询单个用户  
	 * @param id
	 * @return 返回查询到的  Manager对象 ， 若没有查询到则为null；
	 * Manager
	 * @throws
	 */
	public Manager getManagerById(Integer id) throws SQLException ;
	
	/**
	 * 
	 * @Title: getManagerByKey  
	 * @Description: 根据账号密码查询到Manager对象  
	 * @param manager
	 * @return 返回查询到的  Manager对象 ， 若没有查询到则为null；
	 * @throws
	 */
	public Manager getManagerByKey(Manager manager) throws SQLException ;
	
	/**
	 * 
	 * @Title: getManagerByAccountOrNickname  
	 * @Description: 获取Manager对象 , 根据account或nickname 进行模糊查询  
	 * @return 返回查询到的  Manager对象 ， 若没有查询到则为null；
	 * @throws
	 */
	public Manager getManagerByAccountOrNickname(Manager manager) throws SQLException ;
	
	/*-------修改--------*/
	/**
	 * 
	 * @Title: setNewHash  
	 * @Description: 根据账号和旧密码设置新密码  
	 * @param manager
	 * @return
	 * @throws
	 */
	public int setNewHash(Manager manager , String newHash) throws SQLException ;
	
	/*-------删除------*/
	/**
	 * 
	 * @Title: reomveById  
	 * @Description: 根据id删除一个用户
	 * @param id
	 * @return
	 * @throws
	 */
	public int removeById(Integer id) throws SQLException ;
	
	/* 添加一个管理员   */
	/**
	 * 
	 * @Title: addManager  
	 * @Description: 添加一个管理源
	 * @param manager
	 * @return
	 * @throws SQLException
	 * @throws
	 */
	public int addManager(Manager manager) throws SQLException ;  
	
	
	
}
