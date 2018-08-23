package sm3.jsh.controller;

import java.io.Console;
import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.glass.ui.Application;

import sm3.dbcp.DBConnection;
import sm3.jsh.dao.UserDao;
import sm3.jsh.vo.UserVo;

@WebServlet("/userControll.do")
public class UserController extends HttpServlet {
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if (cmd != null || cmd.equals("insert")) {
			insert(request, response);
		}
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao dao = UserDao.getInstance();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String[] phoneArray = request.getParameterValues("phone[]");
		String[] addr = request.getParameterValues("addr[]");
		String[] emailArray = request.getParameterValues("email[]");
		int pwdHint = Integer.parseInt(request.getParameter("pwdHint"));
		String hintOk = request.getParameter("hintOk");
		String postAddr = addr[0];
		String basicAddr = addr[1];
		String detailAddr = addr[2];
		String phone = phoneArray[0] + "-" + phoneArray[1] + "-" + phoneArray[2];
		String email = emailArray[0] + "@" + emailArray[1];
		System.out.println(phone);
		System.out.println(hintOk);
		int n = dao.insert(new UserVo(0, id, pwd, name, email, phone, postAddr, basicAddr, detailAddr, null, pwdHint, hintOk));
		if (n > 0) {
			request.setAttribute("msg", "성공쓰");
		} else {
			request.setAttribute("msg", "실패쓰");
		}
		request.getRequestDispatcher("test.jsp").forward(request, response);

	}

}
