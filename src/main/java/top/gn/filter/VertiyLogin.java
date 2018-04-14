package top.gn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.gn.entity.Manager;

/**
 * Servlet Filter implementation class VertiyLogin
 */
@WebFilter("/VertiyLogin")
public class VertiyLogin extends HttpFilter implements Filter {
       

	private static final long serialVersionUID = 1L;

	private String keywords = null;
	
    public VertiyLogin() {
        super();
    }

	public void destroy() {}


	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String servletPath = request.getServletPath();
		
		if(servletPath == null) {
			chain.doFilter(request, response);
			return;			
		}	
		if(!(this.keywords.contains(servletPath))) {
			chain.doFilter(request, response);
			return;
		}
		
		System.out.println(servletPath);
		
		Manager manager = null;
		try {
			manager = (Manager)request.getSession().getAttribute("now-author");
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		if(manager == null) {  //未登录
			response.sendRedirect(request.getContextPath()+"/author/ccc/513");
		}else {  // 已登录
			chain.doFilter(request, response);
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
		this.keywords = fConfig.getInitParameter("keyworkd");
		System.out.println(keywords);
	}

}
