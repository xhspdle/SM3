package sm3.jya.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import sm3.jya.dao.EventNoticeDao;
import sm3.jya.dao.OrderListViewDao;
import sm3.jya.vo.EventNoticeVo;
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
		}else if(cmd!=null && cmd.equals("listUser")) {
			listUser(request,response);
		}else if(cmd!=null && cmd.equals("month")) {
			month(request,response);
		}
	}
	
	protected void listUser(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String suser_num=request.getParameter("user_num");
		int user_num=0;
		if(suser_num!=null && !suser_num.equals("")) {
			user_num=Integer.parseInt(suser_num);
		}
		ArrayList<OrderListViewVo> list=OrderListViewDao.getInstance().listUser(user_num);
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("mypage_pay_list.jsp").forward(request, response);
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
			request.getRequestDispatcher("mypage_pay_list.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "선택실패");
			request.getRequestDispatcher("msg.jsp").forward(request, response);
		}
	}
	protected void list(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		String suser_num=request.getParameter("user_num");
		int user_num=0;
		if(suser_num!=null && !suser_num.equals("")) {
			user_num=Integer.parseInt(suser_num);
		}
		String spageNum=request.getParameter("pageNum");
		int pageNum=1; //기본값
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*10+1; //페이지의 첫번째 글
		int endRow=startRow+9; //마지막 글
		OrderListViewDao dao = OrderListViewDao.getInstance();
		ArrayList<OrderListViewVo> list1=dao.list(user_num,startRow, endRow);
		//System.out.println("list:"+list1); //toString메소드 호출하는..
		
		
			int pageCount=(int)Math.ceil(dao.getCount(user_num)/10.0); //전체페이지수, 로그인한 사용자의 주문목록수만 나오게 하기.
			
			int startPage=((pageNum-1)/10*10)+1; //첫번째 페이지 번호
			
			int endPage=startPage+9; //끝페이지
			if(endPage>pageCount) {
				endPage=pageCount;
			}
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("list", list1);
			request.getRequestDispatcher("mypage_pay_list.jsp").forward(request, response);
		}
	protected void month(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		HttpSession session = request.getSession();
		int user_num = (int)session.getAttribute("user_num"); 
		int sDate = Integer.parseInt(request.getParameter("sDate"));
		ArrayList<OrderListViewVo> list = OrderListViewDao.getInstance().list();
		ArrayList<OrderListViewVo> list2 = OrderListViewDao.getInstance().orderMonth(user_num, sDate);
		if(sDate == 0) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("orderlist.do?cmd=list&user_num="+user_num+"").forward(request, response);
		}else{
			request.setAttribute("list", list2);
			request.getRequestDispatcher("mypage_pay_list.jsp").forward(request, response);
		}
		
		}
	}
	
		
	


  