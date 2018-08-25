package sm3.ldk.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sm3.ldk.dao.ItemViewDao;
import sm3.ldk.vo.ItemViewVo;

@WebServlet("/dev/itemOrder/itemView.do")
public class ItemViewController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd!=null && cmd.equals("list")) {
			list(request,response);
		}else if(cmd!=null && cmd.equals("select")) {
			select(request,response);
		}
	}
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ItemViewVo> list=ItemViewDao.getInstance().list();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("ITEM_VIEW_list.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "목록 불러오기 실패");
			request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
		}
	}
	protected void select(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String sitem_num=request.getParameter("item_num");
		int item_num=0;
		if(sitem_num!=null && !sitem_num.equals("")) {
			item_num=Integer.parseInt(sitem_num);
		}
		ItemViewVo vo=ItemViewDao.getInstance().select(item_num);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			//추후 수정
			request.getRequestDispatcher("ITE_View_insert.jsp?do1=update").forward(request, response);
		}else {
			request.setAttribute("msg", "선택실패");
			request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
		}
	}
}
