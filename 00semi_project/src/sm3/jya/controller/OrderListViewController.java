package sm3.jya.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sm3.jya.dao.OrderListViewDao;
import sm3.jya.vo.OrderListViewVo;


@WebServlet("/orderlist.do")
public class OrderListViewController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd!=null && cmd.equals("list")) {
			list(request,response);
		}else if(cmd!=null && cmd.equals("select")) {
			select(request,response);
		}
	}
	
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<OrderListViewVo> list=OrderListViewDao.getInstance().list();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("Orderlist.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "목록 불러오기 실패");
			request.getRequestDispatcher("msg.jsp").forward(request, response);
		}
	}
	protected void select(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String sorder_num=request.getParameter("order_num");
		int order_num=0;
		if(sorder_num!=null && !sorder_num.equals("")) {
			order_num=Integer.parseInt(sorder_num);
		}	
		ArrayList<OrderListViewVo> vo=OrderListViewDao.getInstance().select(order_num);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("PURCHASE_LIST_insert.jsp?do1=update").forward(request, response);
		}else {
			request.setAttribute("msg", "선택실패");
			request.getRequestDispatcher("msg.jsp").forward(request, response);
		}
	}
}
