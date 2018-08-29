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
			request.setAttribute("success", "����!");
			request.setAttribute("msg", "������ ��� ����!!");
		}else {
			request.setAttribute("msg", "������ ��� ����..");
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
			request.setAttribute("msg", "��� �ҷ����� ����..");
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
			request.setAttribute("success", "����!");
			request.setAttribute("msg", "������ ���� ����!!");
		}else {
			request.setAttribute("msg", "������ ���� ����..");
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
			//����! page1=���� �ѱ� �Ķ���Ϳ� &�� �Ķ���� ���̴°� �ƴ϶�, ?�� �Ķ���� �ٿ�����...(page1�� ��ũ�ּҷ� �����Ŷ�)
		}else {
			request.setAttribute("msg", "���� ����..");
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
			request.setAttribute("success", "����!");
			request.setAttribute("msg", "������ ���� ����!!");
		}else {
			request.setAttribute("msg", "������ ���� ����..");
		}
		request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
	}
	protected void goInsert(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String do1=request.getParameter("do1");
		request.getRequestDispatcher("../admin.jsp?page1=ADMIN_insert.jsp?do1=" + do1).forward(request, response);
		//����! page1=���� �ѱ� �Ķ���Ϳ� &�� �Ķ���� ���̴°� �ƴ϶�, ?�� �Ķ���� �ٿ�����...(page1�� ��ũ�ּҷ� �����Ŷ�)
	}
}
