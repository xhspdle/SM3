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
import sm3.ldk.dao.ItemSizeDao;
import sm3.ldk.dao.ItemViewDao;
import sm3.ldk.vo.ItemVo;

@WebServlet("/admin/item.do")
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
		}else if(cmd!=null && cmd.equals("goInsert")) {
			goInsert(request,response);
		}
	}
	protected void insert(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletContext().getRealPath("/DBImages");
		MultipartRequest mr=new MultipartRequest(request,
				path,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		String item_name=mr.getParameter("item_name");
		String scate_num=mr.getParameter("cate_num");
		int cate_num=0;
		if(scate_num!=null && !scate_num.equals("")) {
			cate_num=Integer.parseInt(scate_num);
		}
		String item_info=mr.getParameter("item_info");
		String sitem_price=mr.getParameter("item_price");
		int item_price=0;
		if(sitem_price!=null && !sitem_price.equals("")) {
			item_price=Integer.parseInt(sitem_price);
		}
		String item_orgimg=mr.getOriginalFileName("file1");
		String item_savimg=mr.getFilesystemName("file1");
		String scolor_num=mr.getParameter("color_num");
		int color_num=1;//자바스크립트(ajax)가 작동하지 않아도 기본 컬러로 인서트 할 수 있도록
		if(scolor_num!=null && !scolor_num.equals("")) {
			color_num=Integer.parseInt(scolor_num);
		}
		int n=ItemDao.getInstance().insert(new ItemVo(0, item_name,
				cate_num, item_info, item_price,
				item_orgimg, item_savimg),color_num);
		if(n>0) {
			request.setAttribute("success", "성공!");
			request.setAttribute("msg", "상품 추가 성공!!");
		}else {
			request.setAttribute("msg", "상품 추가 실패..");
		}
		request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
	}
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ItemVo> list=ItemDao.getInstance().list();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("../admin.jsp?page1=ITEM_list.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "목록 불러오기 실패");
			request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
		}
	}
	protected void delete(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String sitem_num=request.getParameter("item_num");
		int item_num=0;
		if(sitem_num!=null && !sitem_num.equals("")) {
			item_num=Integer.parseInt(sitem_num);
		}
		int n=ItemDao.getInstance().delete(item_num);
		if(n>0) {
			request.setAttribute("success", "성공!");
			request.setAttribute("msg", "상품 삭제 성공!!");
		}else {
			request.setAttribute("msg", "상품 삭제 실패..");
		}
		request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
	}
	protected void select(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String sitem_num=request.getParameter("item_num");
		int item_num=0;
		if(sitem_num!=null && !sitem_num.equals("")) {
			item_num=Integer.parseInt(sitem_num);
		}
		ItemVo vo=ItemDao.getInstance().select(item_num);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("../admin.jsp?page1=ITEM_insert.jsp?do1=update").forward(request, response);
		}else {
			request.setAttribute("msg", "선택실패");
			request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
		}
	}
	protected void update(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletContext().getRealPath("/DBImages");
		MultipartRequest mr=new MultipartRequest(request,
				path,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		String sitem_num=mr.getParameter("item_num");
		int item_num=0;
		if(sitem_num!=null && !sitem_num.equals("")) {
			item_num=Integer.parseInt(sitem_num);
		}
		String item_name=mr.getParameter("item_name");
		String scate_num=mr.getParameter("cate_num");
		int cate_num=0;
		if(scate_num!=null && !scate_num.equals("")) {
			cate_num=Integer.parseInt(scate_num);
		}
		String item_info=mr.getParameter("item_info");
		String sitem_price=mr.getParameter("item_price");
		int item_price=0;
		if(sitem_price!=null && !sitem_price.equals("")) {
			item_price=Integer.parseInt(sitem_price);
		}
		String sitem_orgimg=mr.getParameter("item_orgimg");
		String sitem_savimg=mr.getParameter("item_savimg");
		String item_orgimg="";
		String item_savimg="";
		if(sitem_orgimg!=null && !sitem_orgimg.equals("")) {
			item_orgimg=sitem_orgimg;
			item_savimg=sitem_savimg;
		}else {
			item_orgimg=mr.getOriginalFileName("file1");
			item_savimg=mr.getFilesystemName("file1");
		}
		String scolor_num=mr.getParameter("color_num");
		int color_num=ItemViewDao.getInstance().select(item_num).get(0).getColor_num();
		if(scolor_num!=null && !scolor_num.equals("")) {
			color_num=Integer.parseInt(scolor_num);
		}
		int n=ItemDao.getInstance().update(new ItemVo(item_num,
				item_name, cate_num, item_info, item_price, item_orgimg, item_savimg),color_num);
		if(n>0) {
			request.setAttribute("success", "성공!");
			request.setAttribute("msg", "상품 수정 성공!!");
		}else {
			request.setAttribute("msg", "상품 수정 실패..");
		}
		request.getRequestDispatcher("../admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
	}
	protected void goInsert(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String do1=request.getParameter("do1");
		request.getRequestDispatcher("../admin.jsp?page1=ITEM_insert.jsp?do1=" + do1).forward(request, response);
		//주의! page1=으로 넘긴 파라미터에 &로 파라미터 붙이는게 아니라, ?로 파라미터 붙여야함...(page1이 링크주소로 붙을거라서)
	}
}
