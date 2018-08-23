package sm3.jsh.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String pwdOk = request.getParameter("pwdOk");
		String phone = request.getParameter("phone[]");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
		String pwdHint = request.getParameter("pwdHint");
		String hintOk = request.getParameter("hinkOk");
		
		
	}

}
