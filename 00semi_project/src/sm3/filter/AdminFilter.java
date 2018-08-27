package sm3.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminFilter implements Filter{
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		boolean adminLogin=false;
		HttpServletRequest request=(HttpServletRequest)req;
		HttpSession session=request.getSession();
		if(session!=null) {
			String admin_id=(String)session.getAttribute("admin_id");
			if(admin_id!=null) {
				adminLogin=true;
			}
		}
		if(adminLogin) {
			chain.doFilter(request, resp);
		}else {
			HttpServletResponse response=(HttpServletResponse)resp;
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {}
}
