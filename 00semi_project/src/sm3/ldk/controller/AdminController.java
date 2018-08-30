package sm3.ldk.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sm3.ldk.dao.AdminDao;
import sm3.ldk.vo.AdminVo;

@WebServlet("/admin/admin.do")
public class AdminController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd!=null && cmd.equals("insert")) {
			insert(request,response);
		}else if(cmd!=null && cmd.equals("list")) {
			list(request,response);
		}else if(cmd!=null && cmd.equals("delete")) {
			delete(request,response);
		}else if(cmd!=null && cmd.equals("select")) {
			select(request,response);
		}else if(cmd!=null && cmd.equals("update")) {
			update(request,response);
		}else if(cmd!=null && cmd.equals("goInsert")) {
			goInsert(request,response);
		}
	}
	protected void insert(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String admin_id=request.getParameter("admin_id");
		String admin_pwd=request.getParameter("admin_pwd");
		int n=AdminDao.getInstance().insert(new AdminVo(0, admin_id, admin_pwd));
		if(n>0) {
			request.setAttribute("success", "성공!");
			request.setAttribute("msg", "관리자 등록 성공!!");
		}else {
			request.setAttribute("msg", "관리자 등록 실패..");
		}
		request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
	}
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AdminVo> list=AdminDao.getInstance().list();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("../admin.jsp?page1=ADMIN_list.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "목록 불러오기 실패..");
			request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
		}
	}
	protected void delete(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String sadmin_num=request.getParameter("admin_num");
		int admin_num=0;
		if(sadmin_num!=null && !sadmin_num.equals("")) {
			admin_num=Integer.parseInt(sadmin_num);
		}
		int n=AdminDao.getInstance().delete(admin_num);
		if(n>0) {
			request.setAttribute("success", "성공!");
			request.setAttribute("msg", "관리자 삭제 성공!!");
		}else {
			request.setAttribute("msg", "관리자 삭제 실패..");
		}
		request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
	}
	protected void select(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String sadmin_num=request.getParameter("admin_num");
		int admin_num=0;
		if(sadmin_num!=null && !sadmin_num.equals("")) {
			admin_num=Integer.parseInt(sadmin_num);
		}
		AdminVo vo=AdminDao.getInstance().select(admin_num);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("../admin.jsp?page1=ADMIN_insert.jsp?do1=update").forward(request, response);
			//주의! page1=으로 넘긴 파라미터에 &로 파라미터 붙이는게 아니라, ?로 파라미터 붙여야함...(page1이 링크주소로 붙을거라서)
		}else {
			request.setAttribute("msg", "선택 실패..");
			request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
		}
	}
	protected void update(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String sadmin_num=request.getParameter("admin_num");
		int admin_num=0;
		if(sadmin_num!=null && !sadmin_num.equals("")) {
			admin_num=Integer.parseInt(sadmin_num);
		}
		String admin_id=request.getParameter("admin_id");
		String admin_pwd=request.getParameter("admin_pwd");
		int n=AdminDao.getInstance().update(new AdminVo(admin_num, admin_id, admin_pwd));
		if(n>0) {
			request.setAttribute("success", "성공!");
			request.setAttribute("msg", "관리자 수정 성공!!");
		}else {
			request.setAttribute("msg", "관리자 수정 실패..");
		}
		request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
	}
	protected void goInsert(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String do1=request.getParameter("do1");
		request.getRequestDispatcher("../admin.jsp?page1=ADMIN_insert.jsp?do1=" + do1).forward(request, response);
		//주의! page1=으로 넘긴 파라미터에 &로 파라미터 붙이는게 아니라, ?로 파라미터 붙여야함...(page1이 링크주소로 붙을거라서)
	}
}
