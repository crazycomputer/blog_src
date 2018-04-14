package top.gn.service.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.gn.dao.ManagerDAO;
import top.gn.entity.Manager;
import top.gn.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	
	private ManagerDAO managerDAOImpl;
	
	public ManagerServiceImpl() {	}
	
	@Autowired
	public void setManagerDAOImpl(ManagerDAO managerDAOImpl) {
		this.managerDAOImpl = managerDAOImpl;
	}
	
	@Override
	public String login(HttpSession session , String account , String hash) {
		
		if(account == null || hash == null) {
			return "用户密码不能为空";
		}else { //除去两边空格
			account = account.trim();
			hash = hash.trim();
		}
		
		Manager manager = null;
		try {
			manager = this.managerDAOImpl.getManagerByKey(account);
		} catch (SQLException e) {
			System.err.println("error-blog: ManagerServiceImpl.login(String account)");
			e.printStackTrace();
		}
		
		//判断是否查询到 用户
		if(manager == null) {
			return "没有这个用户";
		}
		//验证用户名和密码
		if( account.equals(manager.getAccount()) && hash.equals(manager.getHash()) ) {
			manager.setHash("");
			session.setAttribute("now-author", manager);
			return "登录成功";
		}else {
			return "用户名密码错误";
		}
	}
	
	
	
	
}
