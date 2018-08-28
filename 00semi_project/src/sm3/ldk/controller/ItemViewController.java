package sm3.ldk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import sm3.jsh.vo.UserVo;
import sm3.ldk.dao.ItemViewDao;
import sm3.ldk.vo.ItemViewVo;

@WebServlet("/itemView.do")
public class ItemViewController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getParameter("cmd");
		if(cmd!=null && cmd.equals("list")) {
			list(request,response);
		}else if(cmd!=null && cmd.equals("select")) {
			select(request,response);
		}else if(cmd!=null && cmd.equals("select_cate")) {
			select_cate(request,response);
		}
	}
	
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ItemViewVo> list=ItemViewDao.getInstance().list();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin.jsp?page1=ITEM_VIEW_list.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "��� �ҷ����� ����");
			request.getRequestDispatcher("admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
		}
	}
	
	protected void select(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String sitem_num=request.getParameter("item_num");
		String item_nameVal=request.getParameter("item_name");
		String item_name= item_nameVal.substring(0, 5);
		
		int item_num=0;
		if(sitem_num!=null && !sitem_num.equals("")) {
			item_num=Integer.parseInt(sitem_num);
		}
		
		//��ǰ���� ����Ʈ
		ArrayList<ItemViewVo> list=ItemViewDao.getInstance().select(item_num);
		HashMap<Integer, String> list2=ItemViewDao.getInstance().select_color(item_name);
		if(list!=null && list2 != null) {
			request.setAttribute("list", list);
			request.setAttribute("list2", list2);
			request.getRequestDispatcher("item_detail.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "���ý���");
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
	}
	

	
	//ī�װ����ѹ� ����Ʈ 
		protected void select_cate(HttpServletRequest request, 
				HttpServletResponse response) throws ServletException, IOException {
			int cate_num=Integer.parseInt(request.getParameter("cate_num"));
			ArrayList<ItemViewVo> list=ItemViewDao.getInstance().select_cate(cate_num);
			JSONObject obj = new JSONObject();
			JSONArray arr = new JSONArray();
			for(ItemViewVo vo : list) {
				JSONObject ob = new JSONObject();
				ob.put("cate_num",vo.getCate_num());
				ob.put("item_num",vo.getItem_num());
				ob.put("item_name",vo.getItem_name());
				ob.put("item_price",vo.getItem_price());
				ob.put("item_orgimg",vo.getItem_orgimg());
				ob.put("size_name",vo.getSize_name());
				ob.put("size_num",vo.getSize_num());
				arr.add(ob);
			}
			obj.put("arr", arr);
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print(obj.toString());
			pw.close();
		}
}