package sm3.ldk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import sm3.ldk.dao.ItemSizeDao;
import sm3.ldk.vo.ItemSizeVo;

@WebServlet("/admin/itemSize.do")
public class ItemSizeController extends HttpServlet{
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
		}else if(cmd!=null && cmd.equals("updateInfo")) {
			updateInfo(request,response);
		}else if(cmd!=null && cmd.equals("select")) {
			select(request,response);
		}
	}
	protected void insert(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String ssize_num=request.getParameter("size_num");
		int size_num=0;
		if(ssize_num!=null) {
			size_num=Integer.parseInt(ssize_num);
		}
		String size_name=request.getParameter("size_name");
		String sitem_num=request.getParameter("item_num");
		String scolor_num=request.getParameter("color_num");
		String ssize_cnt=request.getParameter("size_cnt");
		int item_num=0;
		int color_num=0;
		int size_cnt=0;
		if(sitem_num!=null && !sitem_num.equals("")) {
			item_num=Integer.parseInt(sitem_num);
		}
		if(scolor_num!=null && !scolor_num.equals("")) {
			color_num=Integer.parseInt(scolor_num);
		}
		if(ssize_cnt!=null && !ssize_cnt.equals("")) {
			size_cnt=Integer.parseInt(ssize_cnt);
		}
		int n=ItemSizeDao.getInstance().insert(new ItemSizeVo(size_num,
				size_name, item_num, color_num, size_cnt));
		if(n>0) {
			request.setAttribute("success", "성공!");
			request.setAttribute("msg", "사이즈 추가 성공!!");
		}else {
			request.setAttribute("msg", "사이즈 추가 실패..");
		}
		request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
	}
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ItemSizeVo> list=ItemSizeDao.getInstance().list();
		String ajax=request.getParameter("ajax");
		if(ajax!=null && ajax.equals("true")) {
			JSONArray arr=new JSONArray();
			for(ItemSizeVo vo:list) {
				JSONObject ob=new JSONObject();
				ob.put("size_num", String.valueOf(vo.getSize_num()));
				arr.add(ob);
			}
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter pw=response.getWriter();
			pw.println(arr.toString());
			pw.close();
			return;
		}
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("ITEM_SIZE_list.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "목록 불러오기 실패");
			request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
		}
	}
	protected void delete(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String ssize_num=request.getParameter("size_num");
		int size_num=0;
		if(ssize_num!=null && !ssize_num.equals("")) {
			size_num=Integer.parseInt(ssize_num);
		}	
		int n=ItemSizeDao.getInstance().delete(size_num);
		if(n>0) {
			request.setAttribute("success", "성공!");
			request.setAttribute("msg", "사이즈 삭제 성공!!");
		}else {
			request.setAttribute("msg", "사이즈 삭제 실패..");
		}
		request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
	}
	protected void select(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String ssize_num=request.getParameter("size_num");
		int size_num=0;
		if(ssize_num!=null && !ssize_num.equals("")) {
			size_num=Integer.parseInt(ssize_num);
		}	
		ItemSizeVo vo=ItemSizeDao.getInstance().select(size_num);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("ITEM_SIZE_insert.jsp?do1=update").forward(request, response);
		}else {
			request.setAttribute("msg", "선택실패");
			request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
		}
	}
	protected void updateInfo(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String ssize_num=request.getParameter("size_num");
		int size_num=0;
		if(ssize_num!=null && !ssize_num.equals("")) {
			size_num=Integer.parseInt(ssize_num);
		}
		String size_name=request.getParameter("size_name");
		String sitem_num=request.getParameter("item_num");
		String scolor_num=request.getParameter("color_num");
		String ssize_cnt=request.getParameter("size_cnt");
		int item_num=0;
		int color_num=0;
		int size_cnt=0;
		if(sitem_num!=null && !sitem_num.equals("")) {
			item_num=Integer.parseInt(sitem_num);
		}
		if(scolor_num!=null && !scolor_num.equals("")) {
			color_num=Integer.parseInt(scolor_num);
		}
		if(ssize_cnt!=null && !ssize_cnt.equals("")) {
			size_cnt=Integer.parseInt(ssize_cnt);
		}
		int n=ItemSizeDao.getInstance().updateInfo(new ItemSizeVo(size_num,
				size_name, item_num, color_num, size_cnt));
		if(n>0) {
			request.setAttribute("success", "성공!");
			request.setAttribute("msg", "사이즈 수정 성공!!");
		}else {
			request.setAttribute("msg", "사이즈 수정 실패..");
		}
		request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
	}
}
