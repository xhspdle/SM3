package sm3.ldk.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sm3.ldk.dao.ItemCateDao;
import sm3.ldk.vo.ItemCateVo;

@WebServlet("/admin/itemCate.do")
public class ItemCateController extends HttpServlet{
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
		}else if(cmd!=null && cmd.equals("update")) {
			update(request,response);
		}else if(cmd!=null && cmd.equals("select")) {
			select(request,response);
		}else if(cmd!=null && cmd.equals("goInsert")) {
			goInsert(request,response);
		}
	}
	protected void insert(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String cate_name=request.getParameter("cate_name");
		int n=ItemCateDao.getInstance().insert(cate_name);
		if(n>0) {
			request.setAttribute("msg", "ī�װ��� �߰� ����!!");
		}else {
			request.setAttribute("msg", "ī�װ��� �߰� ����..");
		}
		request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
	}
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ItemCateVo> list=ItemCateDao.getInstance().list();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("../admin.jsp?page1=ITEMCATE_list.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "��� �ҷ����� ����");
			request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
		}
	}
	protected void delete(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String scate_num=request.getParameter("cate_num");
		int cate_num=0;
		if(scate_num!=null && !scate_num.equals("")) {
			cate_num=Integer.parseInt(scate_num);
		}
		int n=ItemCateDao.getInstance().delete(cate_num);
		if(n>0) {
			request.setAttribute("msg", "ī�װ��� ���� ����!!");
		}else {
			request.setAttribute("msg", "ī�װ��� ���� ����..");
		}
		request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
	}
	protected void select(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String scate_num=request.getParameter("cate_num");
		int cate_num=0;
		if(scate_num!=null && !scate_num.equals("")) {
			cate_num=Integer.parseInt(scate_num);
		}
		ItemCateVo vo=ItemCateDao.getInstance().select(cate_num);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("../admin.jsp?page1=ITEMCATE_insert.jsp?do1=update").forward(request, response);
		}else {
			request.setAttribute("msg", "���ý���");
			request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
		}
	}
	protected void update(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String scate_num=request.getParameter("cate_num");
		int cate_num=0;
		if(scate_num!=null && !scate_num.equals("")) {
			cate_num=Integer.parseInt(scate_num);
		}
		String cate_name=request.getParameter("cate_name");
		int n=ItemCateDao.getInstance().update(new ItemCateVo(cate_num, cate_name));
		if(n>0) {
			request.setAttribute("msg", "ī�װ��� ���� ����!!");
		}else {
			request.setAttribute("msg", "ī�װ��� ���� ����..");
		}
		request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
	}
	protected void goInsert(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String do1=request.getParameter("do1");
		request.getRequestDispatcher("../admin.jsp?page1=ITEMCATE_insert.jsp?do1=" + do1).forward(request, response);
		//����! page1=���� �ѱ� �Ķ���Ϳ� &�� �Ķ���� ���̴°� �ƴ϶�, ?�� �Ķ���� �ٿ�����...(page1�� ��ũ�ּҷ� �����Ŷ�)
	}
}