package sm3.ldk.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sm3.jsh.dao.PointDao;
import sm3.jsh.vo.PointVo;
import sm3.ldk.dao.OrderDao;
import sm3.ldk.vo.OrderVo;

@WebServlet("/order.do")
public class OrderController extends HttpServlet{
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
		}
	}
	
	protected void insert(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String suser_num=request.getParameter("user_num");
		String spur_num=request.getParameter("pur_num");
		String sorder_total=request.getParameter("order_total");
		String sorder_point=request.getParameter("order_point"); //적립금 사용액
		String sorder_pay=request.getParameter("order_pay"); //결제금액  
		int user_num=0;
		int pur_num=0;
		int order_total=0;
		int order_point=0;
		int order_pay=0;
		if(suser_num!=null && !suser_num.equals("")) {
			user_num=Integer.parseInt(suser_num);
		}
		if(spur_num!=null && !spur_num.equals("")) {
			pur_num=Integer.parseInt(spur_num);
		}
		if(sorder_total!=null && !sorder_total.equals("")) {
			order_total=Integer.parseInt(sorder_total);
		}
		if(sorder_point!=null && !sorder_point.equals("")) {
			order_point=Integer.parseInt(sorder_point);
		}
		if(sorder_pay!=null && !sorder_total.equals("")) {
			order_pay=Integer.parseInt(sorder_pay);
		}
		String order_recipient=request.getParameter("order_recipient");
		String order_post_addr=request.getParameter("order_post_addr");
		String order_basic_addr=request.getParameter("order_basic_addr");
		String order_detail_addr=request.getParameter("order_detail_addr");
		String[] sorder_phone=request.getParameterValues("order_phone");
		String order_phone= sorder_phone[0] + "-" + sorder_phone[1] + "-" + sorder_phone[2];
		int order_status=1;
		int order_num=OrderDao.getInstance().getMaxNum();
		int n=OrderDao.getInstance().insert(new OrderVo(0, user_num, 
				pur_num, order_total, order_point, order_pay, order_recipient,
				order_post_addr, order_basic_addr, order_detail_addr, order_phone, 
				null, order_status));
		if(n>0) {
			request.setAttribute("success", "성공!");
			request.setAttribute("msg", "주문 성공!!");
			//적립금 넣어주기
			Date order_date=OrderDao.getInstance().select(order_num).getOrder_date();
			//int n = PointDao.getInstance().insert(new PointVo(order_num, user_num, order_date, point, null));
			
		}else {
			request.setAttribute("msg", "주문 실패..");
		}
		request.getRequestDispatcher("msg.jsp").forward(request, response);		
	}
	
	
	
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<OrderVo> list=OrderDao.getInstance().list();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin.jsp?page1=ORDER_list.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "주문 목록 불러오기 실패..");
			request.getRequestDispatcher("admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
		}
	}
	protected void delete(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Object admin_num=session.getAttribute("admin_num");
		String sorder_num=request.getParameter("order_num");
		int order_num=0;
		if(sorder_num!=null && !sorder_num.equals("")) {
			order_num=Integer.parseInt(sorder_num);
		}
		int n=OrderDao.getInstance().delete(order_num);
		if(admin_num!=null) {
			if(n>0) {
				request.setAttribute("success", "성공!");
				request.setAttribute("msg", "주문 삭제 성공!!");
			}else {
				request.setAttribute("msg", "주문 삭제 실패..");
			}
			request.getRequestDispatcher("admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
		}else {
			if(n>0) {
				request.setAttribute("success", "성공!");
				request.setAttribute("msg", "주문 삭제 성공!!");
			}else {
				request.setAttribute("msg", "주문 삭제 실패..");
			}
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
		OrderVo vo=OrderDao.getInstance().select(order_num);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("admin.jsp?page1=ORDER_insert.jsp?do1=update").forward(request, response);
		}else {
			request.setAttribute("msg", "주문 선택 실패..");
			request.getRequestDispatcher("admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
		}
	}
	protected void update(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String sorder_num=request.getParameter("order_num");
		String suser_num=request.getParameter("user_num");
		String spur_num=request.getParameter("pur_num");
		String sorder_total=request.getParameter("order_total");
		String sorder_point=request.getParameter("order_point");
		String sorder_pay=request.getParameter("order_pay");
		int order_num=0;
		int user_num=0;
		int pur_num=0;
		int order_total=0;
		int order_point=0;
		int order_pay=0;
		if(sorder_num!=null && !sorder_num.equals("")) {
			order_num=Integer.parseInt(sorder_num);
		}
		if(suser_num!=null && !suser_num.equals("")) {
			user_num=Integer.parseInt(suser_num);
		}
		if(spur_num!=null && !spur_num.equals("")) {
			pur_num=Integer.parseInt(spur_num);
		}
		if(sorder_total!=null && !sorder_total.equals("")) {
			order_total=Integer.parseInt(sorder_total);
		}
		if(sorder_point!=null && !sorder_point.equals("")) {
			order_point=Integer.parseInt(sorder_point);
		}
		if(sorder_pay!=null && !sorder_total.equals("")) {
			order_pay=Integer.parseInt(sorder_pay);
		}
		String order_recipient=request.getParameter("order_recipient");
		String order_post_addr=request.getParameter("order_post_addr");
		String order_basic_addr=request.getParameter("order_basic_addr");
		String order_detail_addr=request.getParameter("order_detail_addr");
		String order_phone=request.getParameter("order_phone");
		String sorder_status=request.getParameter("order_status");
		int order_status=0;
		if(sorder_status!=null && !sorder_status.equals("")) {
			order_status=Integer.parseInt(sorder_status);
		}
		int n=OrderDao.getInstance().update(new OrderVo(order_num, user_num, pur_num,
				order_total, order_point, order_pay, order_recipient,
				order_post_addr, order_basic_addr, order_detail_addr,
				order_phone, null, order_status));
		if(n>0) {
			request.setAttribute("success", "성공!");
			request.setAttribute("msg", "주문 수정 성공!!");
		}else {
			request.setAttribute("msg", "주문 수정 실패..");
		}
		request.getRequestDispatcher("admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
	}
}
