/**  
 * @Title: ManagerHandler.java  
 * @Package top.gn.controller
 * @author BoyHu  
 * @date 1 Apr 2018  
 * @version V1.0  
 */  
package top.gn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
 * @ClassName: ManagerHandler  
 * @Description: 处理管理员相关操作的 请求 . 登录后天 , 注册等 
 * @author BoyHu
 * @date 1 Apr 2018  
 *    
 */
@RequestMapping("/boy_hu513")
@Controller
public class ManagerHandler {

	
	@GetMapping("/edit")
	public String show() {
		System.out.println("edit");
		return "redirect:../editor/editor.jsp"; 
	}
	
	
	
}
