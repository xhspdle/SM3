package sm3.ldk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sm3.ldk.dao.AdminDao;
import sm3.ldk.vo.AdminVo;

@WebServlet("/adminLogin.do")
public class AdminLoginController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd!=null && cmd.equals("login")) {
			login(request,response);
		}else if(cmd!=null && cmd.equals("logout")) {
			logout(request,response);
		}
	}
	protected void login(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String admin_id=request.getParameter("admin_id");
		String admin_pwd=request.getParameter("admin_pwd");
		AdminVo vo=AdminDao.getInstance().login(new AdminVo(0, admin_id, admin_pwd));
		if(vo!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("admin_num", vo.getAdmin_num());//넘버도 저장하도록 수정
			session.setAttribute("admin_id", vo.getAdmin_id());
			response.sendRedirect(request.getContextPath() + "/admin.jsp");
		}else {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}
	protected void logout(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/admin.jsp");
	}
}
