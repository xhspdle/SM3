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

@WebServlet("/itemOrder/itemCate.do")
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
		request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
	}
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ItemCateVo> list=ItemCateDao.getInstance().list();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("ITEMCATE_list.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "목록 불러오기 실패");
			request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
		}
	}
	protected void delete(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		int cate_num=Integer.parseInt(request.getParameter("cate_num"));
		int n=ItemCateDao.getInstance().delete(cate_num);
		if(n>0) {
			request.setAttribute("msg", "카테고리 삭제 성공!!");
		}else {
			request.setAttribute("msg", "카테고리 삭제 실패..");
		}
		request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
	}
	protected void select(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		int cate_num=Integer.parseInt(request.getParameter("cate_num"));
		ItemCateVo vo=ItemCateDao.getInstance().select(cate_num);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("ITEMCATE_insert.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "선택실패");
			request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
		}
	}
	protected void update(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		int cate_num=Integer.parseInt(request.getParameter("cate_num"));
		String cate_name=request.getParameter("cate_name");
		int n=ItemCateDao.getInstance().update(new ItemCateVo(cate_num, cate_name));
		if(n>0) {
			request.setAttribute("msg", "카테고리 수정 성공!!");
		}else {
			request.setAttribute("msg", "카테고리 수정 실패..");
		}
		request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
	}
}
