package sm3.jsh.controller;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sun.glass.ui.Application;

import sm3.dbcp.DBConnection;
import sm3.jsh.dao.UserDao;
import sm3.jsh.vo.UserVo;

@WebServlet("/userControll.do")
public class UserController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd");
		
		if (cmd == null || cmd.equals("")) {
			list(request, response);
		}
		
		
		if (cmd.equals("insert")) {
			insert(request, response);
		}else if (cmd.equals("list")) {
			list(request, response);
		}else if (cmd.equals("update")) {
			update(request, response);
		}else if (cmd.equals("getInfo")) {
			getInfo(request, response);
		}else if (cmd.equals("delete")) {
			delete(request, response);
		}else if(cmd.equals("idSearch")) {
			idSearch(request, response);
		}else if(cmd.equals("login")) {
			login(request, response);
		}else if(cmd.equals("logout")) {
			logout(request, response);
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao dao = UserDao.getInstance();
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String originPwd = request.getParameter("originPwd");
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
		
		if(pwd.equals("")) {
			pwd = originPwd;
		}
		System.out.println(pwd);
		int n = dao.update(new UserVo(num, id, pwd, name, email, phone, postAddr, basicAddr, detailAddr, null, pwdHint, hintOk));
		if (n > 0) {
			request.setAttribute("msg", "수정성공쓰");
		} else {
			request.setAttribute("msg", "수정실패쓰");
		}
		request.getRequestDispatcher("test.jsp").forward(request, response);

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
		System.out.println(hintOk);
		int n = dao.insert(
				new UserVo(0, id, pwd, name, email, phone, postAddr, basicAddr, detailAddr, null, pwdHint, hintOk));
		if (n > 0) {
			request.setAttribute("msg", "추가성공쓰");
		} else {
			request.setAttribute("msg", "추가실패쓰");
		}
		request.getRequestDispatcher("test.jsp").forward(request, response);

	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mpageNum = request.getParameter("pageNum");
		int pageNum = 1;
		if (mpageNum != null) {
			pageNum = Integer.parseInt(mpageNum);
		}
		String search = request.getParameter("search");
		String keyword = request.getParameter("keyword");

		
		if (keyword == null || keyword.equals("")) {
			search = "";
			keyword = "";
		}

		int endRow = 15 * pageNum;
		int startRow = endRow - 14;

		UserDao dao = UserDao.getInstance();
		ArrayList<UserVo> list = dao.list(startRow, endRow, search, keyword);
		System.out.println(list);
		if (list != null) {
			int pageCount = (int)(Math.ceil(dao.getCount(search, keyword) / 15.0));
			System.out.println(pageCount);
			int startPage = ((pageNum - 1) / 3 * 3) + 1;
			int endPage = startPage + 2;
			if (pageCount < endPage) {
				endPage = pageCount;
			}
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("search", search);
			request.setAttribute("keyword", keyword);
			request.setAttribute("list", list);
			request.getRequestDispatcher("listTest.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "리스트소환실패");
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
	}
	
	protected void getInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_num = Integer.parseInt(request.getParameter("user_num"));
		UserDao dao = UserDao.getInstance();
		UserVo vo = dao.getinfo(user_num);
		if(vo != null){
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("user_update.jsp").forward(request, response);
		}
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_num = Integer.parseInt(request.getParameter("user_num"));
		UserDao dao = UserDao.getInstance();
		int n = dao.delete(user_num);
		if(n>0){
			request.getRequestDispatcher("userControll.do?cmd=list").forward(request, response);
		}
	}
	
	protected void idSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		UserDao dao = UserDao.getInstance();
		ArrayList<String> idList = dao.idSearch();
		boolean check = true; 
		if(idList !=null) {
			for (int i = 0; i <idList.size(); i++) {
				String ids = idList.get(i);
				if(ids.equals(id)) {
					check = false;
					break;
				}
			}
		}
		if(check){
			request.setAttribute("check", check);
			request.setAttribute("idMsg", "사용가능한 아이디 입니다.");
			
		}else {
			request.setAttribute("check", check);
			request.setAttribute("idMsg", "사용불가능한 아이디 입니다.");
		}
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}
	
	
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		String remember = request.getParameter("remember");
		ArrayList<UserVo> list = UserDao.getInstance().allView();
		HttpSession session = request.getSession();
		boolean n = false;
		int user_num = 0;
		for(UserVo vo: list) {
			if(user_id.equals(vo.getUser_id()) && user_pwd.equals(vo.getUser_pwd())){
				user_num = vo.getUser_num();
				n= true;
			}
		}
		if(n) {
			session.setAttribute("user_id", user_id);
			session.setAttribute("user_pwd", user_pwd);
			session.setAttribute("user_num", user_num);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else {
			request.setAttribute("login_msg", "아이디 비밀번호를 다시 확인해 주세요");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		//쿠키처리
		if (remember== null) {
			Cookie cook = new Cookie("user_id", user_id);
			cook.setMaxAge(0);//종료
			response.addCookie(cook);
			Cookie cook2 = new Cookie("user_pwd", user_pwd);
			cook2.setMaxAge(0);
			response.addCookie(cook2);
		}else{
			Cookie cook = new Cookie("user_id", user_id);
			cook.setMaxAge(60 * 60 * 24 * 30);//한달
			response.addCookie(cook);
			Cookie cook2 = new Cookie("user_pwd", user_pwd);
			cook2.setMaxAge(60 * 60 * 24 * 30);
			response.addCookie(cook2);
		}
		
	}
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	
	
	
}