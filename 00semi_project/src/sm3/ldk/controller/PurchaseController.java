package sm3.ldk.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sm3.ldk.dao.PurchaseDao;
import sm3.ldk.dao.PurchaseListDao;
import sm3.ldk.dao.PurchaseViewDao;
import sm3.ldk.vo.PurchaseListVo;
import sm3.ldk.vo.PurchaseViewVo;


@WebServlet("/purchase.do")
public class PurchaseController extends HttpServlet{
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
		//size_num, order_cnt, item_price 여러개가 넘어올거 --> 배열로 받아서 for문으로 insert해야됨
		//--> pur_num은 dao에서 받아야될듯
		String[] ssize_num=request.getParameterValues("size_num");
		String[] sorder_cnt=request.getParameterValues("order_cnt");
		String[] sitem_price=request.getParameterValues("item_price");
		if(ssize_num!=null) {
			int pur_num=PurchaseDao.getInstance().insert();
			if(pur_num>0) {
				ArrayList<PurchaseListVo> list=new ArrayList<>();
				for(int i=0;i<ssize_num.length;i++) {
					int size_num=Integer.parseInt(ssize_num[i].trim());
					int order_cnt=Integer.parseInt(sorder_cnt[i].trim());
					int item_price=Integer.parseInt(sitem_price[i].trim());
					list.add(new PurchaseListVo(0, pur_num,
							size_num, order_cnt, item_price));
				}
				int n=PurchaseListDao.getInstance().insert(list);
				if(n>0) {
					ArrayList<PurchaseViewVo> list1=PurchaseViewDao.getInstance().select(pur_num);
					if(list1!=null) {
						request.setAttribute("list", list1);
						request.getRequestDispatcher("item_order_list.jsp").forward(request, response);
					}else {
						request.setAttribute("msg", "구매목록 추가 성공!! but, 구매목록 불러오기 실패 ");
						request.getRequestDispatcher("msg.jsp").forward(request, response);
					}
				}else {
					request.setAttribute("msg", "구매목록 추가 실패..");
					request.getRequestDispatcher("msg.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("msg", "구매목록 추가 실패..");
				request.getRequestDispatcher("msg.jsp").forward(request, response);
			}
		}
	}
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<PurchaseListVo> list=PurchaseListDao.getInstance().list();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("PURCHASE_LIST_list.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "목록 불러오기 실패");
			request.getRequestDispatcher("msg.jsp").forward(request, response);
		}
	}
	protected void delete(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String spur_num=request.getParameter("pur_num");
		int pur_num=0;
		if(spur_num!=null && !spur_num.equals("")) {
			pur_num=Integer.parseInt(spur_num);
		}	
		int n=PurchaseListDao.getInstance().delete(pur_num);
		if(n>0) {
			request.setAttribute("success", "성공!");
			request.setAttribute("msg", "구매목록 삭제 성공!!");
		}else {
			request.setAttribute("msg", "구매목록 삭제 실패..");
		}
		request.getRequestDispatcher("msg.jsp").forward(request, response);
	}
	protected void select(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String spl_num=request.getParameter("pl_num");
		int pl_num=0;
		if(spl_num!=null && !spl_num.equals("")) {
			pl_num=Integer.parseInt(spl_num);
		}	
		PurchaseListVo vo=PurchaseListDao.getInstance().select(pl_num);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("PURCHASE_LIST_insert.jsp?do1=update").forward(request, response);
		}else {
			request.setAttribute("msg", "선택실패");
			request.getRequestDispatcher("msg.jsp").forward(request, response);
		}
	}
	protected void update(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String spl_num=request.getParameter("pl_num");
		String spur_num=request.getParameter("pur_num");
		String ssize_num=request.getParameter("size_num");
		String sorder_cnt=request.getParameter("order_cnt");
		String sitem_price=request.getParameter("item_price");
		int pl_num=0;
		int pur_num=0;
		int size_num=0;
		int order_cnt=0;
		int item_price=0;
		if(spl_num!=null && !spl_num.equals("")) {
			pl_num=Integer.parseInt(spl_num);
		}
		if(spur_num!=null && !spur_num.equals("")) {
			pur_num=Integer.parseInt(spur_num);
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
		int n=PurchaseListDao.getInstance().update(new PurchaseListVo(pl_num, pur_num,
				size_num, order_cnt, item_price));
		if(n>0) {
			request.setAttribute("success", "성공!");
			request.setAttribute("msg", "구매목록 수정 성공!!");
		}else {
			request.setAttribute("msg", "구매목록 수정 실패..");
		}
		request.getRequestDispatcher("msg.jsp").forward(request, response);
	}
}
