package sm3.ldk.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sm3.ldk.dao.InItemDao;
import sm3.ldk.vo.InItemVo;

@WebServlet("/admin/inItem.do")
public class InItemController extends HttpServlet{
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
		String ssize_num=request.getParameter("size_num");
		String sadmin_num=request.getParameter("admin_num");
		String sin_cnt=request.getParameter("in_cnt");
		String sin_cost=request.getParameter("in_cost");
		int size_num=0;
		int admin_num=0;
		int in_cnt=0;
		int in_cost=0;
		if(ssize_num!=null && !ssize_num.equals("")) {
			size_num=Integer.parseInt(ssize_num);
		}
		if(sadmin_num!=null && !sadmin_num.equals("")) {
			admin_num=Integer.parseInt(sadmin_num);
		}
		if(sin_cnt!=null && !sin_cnt.equals("")){
			in_cnt=Integer.parseInt(sin_cnt);
		}
		if(sin_cost!=null && !sin_cost.equals("")) {
			in_cost=Integer.parseInt(sin_cost);
		}
		int n=InItemDao.getInstance().insert(new InItemVo(0,
				size_num, admin_num, in_cnt, in_cost, null));
		if(n>0) {
			request.setAttribute("msg", "상품 입고 및 재고 반영 성공!!");
		}else {
			request.setAttribute("msg", "상품 입고 및 재고 반영 실패..");
		}
		request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
	}
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<InItemVo> list=InItemDao.getInstance().list();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("../admin.jsp?page1=IN_ITEM_list.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "목록 불러오기 실패");
			request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
		}
	}
	protected void delete(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String sin_num=request.getParameter("in_num");
		int in_num=0;
		if(sin_num!=null && !sin_num.equals("")) {
			in_num=Integer.parseInt(sin_num);
		}	
		int n=InItemDao.getInstance().delete(in_num);
		if(n>0) {
			request.setAttribute("msg", "입고 삭제 및 재고 반영 성공!!");
		}else {
			request.setAttribute("msg", "입고 삭제 및 재고 반영 실패..");
		}
		request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
	}
	protected void select(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String sin_num=request.getParameter("in_num");
		int in_num=0;
		if(sin_num!=null && !sin_num.equals("")) {
			in_num=Integer.parseInt(sin_num);
		}	
		InItemVo vo=InItemDao.getInstance().select(in_num);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("../admin.jsp?page1=IN_ITEM_insert.jsp?do1=update").forward(request, response);
		}else {
			request.setAttribute("msg", "선택실패");
			request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
		}
	}
	protected void update(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String sin_num=request.getParameter("in_num");
		String ssize_num=request.getParameter("size_num");
		String sadmin_num=request.getParameter("admin_num");
		String sin_cnt=request.getParameter("in_cnt");
		String sin_cost=request.getParameter("in_cost");
		int in_num=0;
		int size_num=0;
		int admin_num=0;
		int in_cnt=0;
		int in_cost=0;
		if(sin_num!=null && !sin_num.equals("")) {
			in_num=Integer.parseInt(sin_num);
		}
		if(ssize_num!=null && !ssize_num.equals("")) {
			size_num=Integer.parseInt(ssize_num);
		}
		if(sadmin_num!=null && !sadmin_num.equals("")) {
			admin_num=Integer.parseInt(sadmin_num);
		}
		if(sin_cnt!=null && !sin_cnt.equals("")){
			in_cnt=Integer.parseInt(sin_cnt);
		}
		if(sin_cost!=null && !sin_cost.equals("")) {
			in_cost=Integer.parseInt(sin_cost);
		}
		int n=InItemDao.getInstance().update(new InItemVo(in_num,
				size_num, admin_num, in_cnt, in_cost, null));
		if(n>0) {
			request.setAttribute("msg", "입고 수정 및 재고 반영 성공!!");
		}else {
			request.setAttribute("msg", "입고 수정 및 재고 반영 실패..");
		}
		request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
	}
	protected void goInsert(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String do1=request.getParameter("do1");
		request.getRequestDispatcher("../admin.jsp?page1=IN_ITEM_insert.jsp?do1=" + do1).forward(request, response);
		//주의! page1=으로 넘긴 파라미터에 &로 파라미터 붙이는게 아니라, ?로 파라미터 붙여야함...(page1이 링크주소로 붙을거라서)
	}
}
