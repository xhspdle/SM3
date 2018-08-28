package sm3.ldk.controller.dev;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sm3.ldk.dao.CartDao;
import sm3.ldk.vo.CartVo;

@WebServlet("/dev/cartOrder/cart.do")
public class CartController extends HttpServlet{
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
		}
	}
	protected void insert(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String suser_num=request.getParameter("user_num");
		String ssize_num=request.getParameter("size_num");
		String sorder_cnt=request.getParameter("order_cnt");
		String sitem_price=request.getParameter("item_price");
		int user_num=0;
		int size_num=0;
		int order_cnt=0;
		int item_price=0;
		if(suser_num!=null && !suser_num.equals("")) {
			user_num=Integer.parseInt(suser_num);
		}
		if(ssize_num!=null && !ssize_num.equals("")) {
			size_num=Integer.parseInt(ssize_num);
		}
		if(sorder_cnt!=null && !sorder_cnt.equals("")){
			order_cnt=Integer.parseInt(sorder_cnt);
		}
		if(sitem_price!=null && !sitem_price.equals("")) {
			item_price=Integer.parseInt(sitem_price);
		}
		int n=CartDao.getInstance().insert(new CartVo(0, user_num,
				size_num, order_cnt, item_price));
		if(n>0) {
			request.setAttribute("msg", "장바구니 담기 성공!!");
		}else {
			request.setAttribute("msg", "장바구니 담기 실패..");
		}
		request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
	}
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CartVo> list=CartDao.getInstance().list();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("CART_list.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "목록 불러오기 실패");
			request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
		}
	}
	protected void delete(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String suser_num=request.getParameter("user_num");
		int user_num=0;
		if(suser_num!=null && !suser_num.equals("")) {
			user_num=Integer.parseInt(suser_num);
		}	
		int n=CartDao.getInstance().delete(user_num);
		if(n>0) {
			request.setAttribute("msg", "장바구니 비우기 성공!!");
		}else {
			request.setAttribute("msg", "장바구니 비우기 실패..");
		}
		request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
	}
	protected void select(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String scart_num=request.getParameter("cart_num");
		int cart_num=0;
		if(scart_num!=null && !scart_num.equals("")) {
			cart_num=Integer.parseInt(scart_num);
		}	
		CartVo vo=CartDao.getInstance().select(cart_num);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("CART_insert.jsp?do1=update").forward(request, response);
		}else {
			request.setAttribute("msg", "선택실패");
			request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
		}
	}
	protected void update(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String scart_num=request.getParameter("cart_num");
		String suser_num=request.getParameter("user_num");
		String ssize_num=request.getParameter("size_num");
		String sorder_cnt=request.getParameter("order_cnt");
		String sitem_price=request.getParameter("item_price");
		int cart_num=0;
		int user_num=0;
		int size_num=0;
		int order_cnt=0;
		int item_price=0;
		if(scart_num!=null && !scart_num.equals("")) {
			cart_num=Integer.parseInt(scart_num);
		}
		if(suser_num!=null && !suser_num.equals("")) {
			user_num=Integer.parseInt(suser_num);
		}
		if(ssize_num!=null && !ssize_num.equals("")) {
			size_num=Integer.parseInt(ssize_num);
		}
		if(sorder_cnt!=null && !sorder_cnt.equals("")){
			order_cnt=Integer.parseInt(sorder_cnt);
		}
		if(sitem_price!=null && !sitem_price.equals("")) {
			item_price=Integer.parseInt(sitem_price);
		}
		int n=CartDao.getInstance().update(new CartVo(cart_num, user_num,
				size_num, order_cnt, item_price));
		if(n>0) {
			request.setAttribute("msg", "장바구니 수정 성공!!");
		}else {
			request.setAttribute("msg", "장바구니 수정 실패..");
		}
		request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
	}
}
