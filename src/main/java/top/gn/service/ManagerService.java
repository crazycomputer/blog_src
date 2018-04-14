package top.gn.service;

import javax.servlet.http.HttpSession;

public interface ManagerService {

	/**
	 * 用于用户登录使用的login方法
	 * @param account 用户名
	 * @return
	 */
	String login(HttpSession session , String account , String hash);

	
	
	
}
