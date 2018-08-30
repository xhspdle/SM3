package sm3.jya.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		}
	}
	
//	protected void list(HttpServletRequest request, 
//			HttpServletResponse response) throws ServletException, IOException {
//		ArrayList<OrderListViewVo> list=OrderListViewDao.getInstance().list();
//		if(list!=null) {
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("mypage_pay_list.jsp").forward(request, response);
//		}else {
//			request.setAttribute("msg", "목록 불러오기 실패");
//			request.getRequestDispatcher("msg.jsp").forward(request, response);
//		}
//	}
	protected void listUser(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
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
		String search=request.getParameter("search");
		String keyword = request.getParameter("keyword");
		if(keyword==null || keyword.equals("")) {
			search="";
			keyword="";
		}
		String spageNum=request.getParameter("pageNum");
		int pageNum=1; //기본값
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*10+1; //페이지의 첫번째 글
		int endRow=startRow+9; //마지막 글
		OrderListViewDao dao = OrderListViewDao.getInstance();
		ArrayList<OrderListViewVo> list1=dao.list(startRow, endRow, search, keyword);
		//System.out.println("list:"+list1); //toString메소드 호출하는..
		if(list1!=null) {
			int pageCount=(int)Math.ceil(dao.getCount(search,keyword)/9.0); //전체페이지수
			int startPage=((pageNum-1)/10*10)+1; //첫번째 페이지 번호
			int endPage=startPage+9; //끝페이지
			if(endPage>pageCount) {
				endPage=pageCount;
			}
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("search", search);
			request.setAttribute("keyword", keyword);
			request.setAttribute("list", list1);
			request.getRequestDispatcher("mypage_pay_list.jsp").forward(request, response);
			request.setAttribute("msg", "목록보기 성공");
		}else {
			request.setAttribute("list", list1);
			request.getRequestDispatcher("mypage_pay_list.jsp").forward(request, response);
		}
	}
}
  