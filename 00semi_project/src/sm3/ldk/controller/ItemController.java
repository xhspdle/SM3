package sm3.ldk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sm3.ldk.dao.ItemCateDao;

@WebServlet("/itemOrder/item.do")
public class ItemController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd!=null && cmd.equals("insert")) {
			insert(request,response);
		}
	}
	protected void insert(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String cate_name=request.getParameter("cate_name");
		int n=ItemCateDao.getInstance().insert(cate_name);
		if(n>0) {
			request.setAttribute("msg", "카테고리 추가 성공!!");
		}else {
			request.setAttribute("msg", "카테고리 추가 실패..");
		}
		request.getRequestDispatcher("ITEMCATE_msg.jsp").forward(request, response);
	}
}
