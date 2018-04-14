/**  
 * @Title: TestManagerDAOImpl.java  
 * @Package top.gn.dao.impl 
 * @author BoyHu  
 * @date 9 Apr 2018  
 * @version V1.0  
 */  
package top.gn.test;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.gn.dao.ManagerDAO;
import top.gn.dao.impl.ArticleDAOImpl;
import top.gn.dao.impl.ManagerDAOImpl;
import top.gn.entity.Manager;

/**  
 * @ClassName: TestManagerDAOImpl  
 * @Description: 用于测试 : top.gn.dao.impl.ManagerDAOImpl 类当中的方法 
 * @author BoyHu
 * @date 9 Apr 2018  
 *    
 */
public class TestManagerDAOImpl {

	ApplicationContext ac;
	ManagerDAO managerDAOImpl ; 
	{
		this.ac = new ClassPathXmlApplicationContext("springConfig.xml");
		managerDAOImpl = this.ac.getBean(ManagerDAOImpl.class);
	}
	
	@Test
	public void testGetAll() throws SQLException {
		for (Manager manager : managerDAOImpl.getAll()) {
			System.out.println(manager);
		}
	}
	
	@Test
	public void testGetById() throws SQLException {
		System.out.println(managerDAOImpl.getManagerById(2));
	}
	
	@Test
	public void testGetByNickName() throws SQLException {
		Manager manager = new Manager();
		manager.setNickname("小m");
		System.out.println(managerDAOImpl.getManagerByAccountOrNickname(manager));
	}
	
	@Test
	public void testGetBykey() throws SQLException {
//		Manager manager = new Manager();
//		manager.setAccount("10000");
		System.out.println(managerDAOImpl.getManagerByKey("10000"));
	}
	
	/*---------删除------------*/
	@Test
	public void testDelete() throws SQLException {
		System.out.println("删除了(行数): "+ managerDAOImpl.removeById(7));
	}
	
	/*-------更新 ---------*/
	@Test
	public void testNewHash() throws SQLException {
		Manager user =  managerDAOImpl.getManagerByKey("123456");
		if(user == null) {
			System.out.println("找不到账户信息! ");
			return ;
		}
		System.out.println("更新了密码:"+ managerDAOImpl.setNewHash(user, "aaaaaa"));
	}
	
	/*-------添加 ---------*/
	@Test
	public void testAddManager() throws SQLException {
		int result = managerDAOImpl.addManager(new Manager("zhanghao", "123456" ,"小七"));
		System.out.println(result);
	}
	
	 
	

}
