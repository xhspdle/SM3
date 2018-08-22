package sm3.ldk.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import sm3.ldk.dao.ItemDao;
import sm3.ldk.vo.ItemVo;

@WebServlet("/dev/itemOrder/item.do")
public class ItemController extends HttpServlet{
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
		String path=request.getServletContext().getRealPath("/images");
		MultipartRequest mr=new MultipartRequest(request,
				path,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		String item_name=mr.getParameter("item_name");
		String scate_num=mr.getParameter("cate_num");
		int cate_num=0;
		if(scate_num!=null) {
			cate_num=Integer.parseInt(scate_num);
		}
		String item_info=mr.getParameter("item_info");
		String sitem_price=mr.getParameter("item_price");
		int item_price=0;
		if(sitem_price!=null) {
			item_price=Integer.parseInt(sitem_price);
		}
		String item_orgimg=mr.getOriginalFileName("file1");
		String item_savimg=mr.getFilesystemName("file1");
		int n=ItemDao.getInstance().insert(new ItemVo(0, item_name,
				cate_num, item_info, item_price, item_orgimg, item_savimg));
		if(n>0) {
			request.setAttribute("msg", "상품 추가 성공!!");
		}else {
			request.setAttribute("msg", "상품 추가 실패..");
		}
		request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
	}
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ItemVo> list=ItemDao.getInstance().list();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("ITEM_list.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "목록 불러오기 실패");
			request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
		}
	}
	protected void delete(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String sitem_num=request.getParameter("item_num");
		int item_num=0;
		if(sitem_num!=null) {
			item_num=Integer.parseInt(sitem_num);
		}
		int n=ItemDao.getInstance().delete(item_num);
		if(n>0) {
			request.setAttribute("msg", "상품 삭제 성공!!");
		}else {
			request.setAttribute("msg", "상품 삭제 실패..");
		}
		request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
	}
	protected void select(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String sitem_num=request.getParameter("item_num");
		int item_num=0;
		if(sitem_num!=null) {
			item_num=Integer.parseInt(sitem_num);
		}
		ItemVo vo=ItemDao.getInstance().select(item_num);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("ITEM_insert.jsp?do1=update").forward(request, response);
		}else {
			request.setAttribute("msg", "선택실패");
			request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
		}
	}
	protected void update(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletContext().getRealPath("/images");
		MultipartRequest mr=new MultipartRequest(request,
				path,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		String sitem_num=mr.getParameter("item_num");
		int item_num=0;
		if(sitem_num!=null) {
			item_num=Integer.parseInt(sitem_num);
		}
		String item_name=mr.getParameter("item_name");
		String scate_num=mr.getParameter("cate_num");
		int cate_num=0;
		if(scate_num!=null) {
			cate_num=Integer.parseInt(scate_num);
		}
		String item_info=mr.getParameter("item_info");
		String sitem_price=mr.getParameter("item_price");
		int item_price=0;
		if(sitem_price!=null) {
			item_price=Integer.parseInt(sitem_price);
		}
		String item_orgimg=mr.getOriginalFileName("file1");
		String item_savimg=mr.getFilesystemName("file1");
		int n=ItemDao.getInstance().update(new ItemVo(item_num,
				item_name, cate_num, item_info, item_price, item_orgimg, item_savimg));
		if(n>0) {
			request.setAttribute("msg", "상품 수정 성공!!");
		}else {
			request.setAttribute("msg", "상품 수정 실패..");
		}
		request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
	}
}
