package top.gn.controller.hou;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.gn.service.ManagerService;

/**
 * 该handler为处理用户相关请求的handler
 * @author Hu Ji mi
 * 2018-4-13
 */
@RequestMapping("/author")
@Controller
public class ManagerHandler {

	private ManagerService managerServiceImpl;
	
	@Autowired
	public void setManagerServiceImpl(ManagerService managerServiceImpl) {
		this.managerServiceImpl = managerServiceImpl;
	}
	
	@ResponseBody
	@PostMapping( value = "/laici-go",produces="text/html;charset=UTF-8")
	public String signIn(HttpSession session , @RequestParam(value = "account") String account , @RequestParam(value="hash") String hash) {
		String result = null;
		result = this.managerServiceImpl.login(session , account, hash);
		System.out.println(result);
		System.out.println(account+", "+hash);
		return result;
	}

	/**
	 * 显示后台主页
	 * @return
	 */
	@GetMapping("/author-data")
	public String showManagerPage() {
		return "/editor/back-index";
	}
	
	@GetMapping("/exit")
	public String exitLogin(HttpSession session) {
		session.setAttribute("now-author", null);  //退出登录
		return "forward:/article/article-list";
	}

	@GetMapping("/ccc/513")
	public String showLoginPage() {
		return "/editor/sign-in";
	}
	
	
	
}
