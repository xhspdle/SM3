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

import sm3.ldk.dao.IndexViewDao;
import sm3.ldk.vo.IndexViewVo;

@WebServlet("/index.do")
public class IndexViewController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd!=null && cmd.equals("list")) {
			list(request,response);
		}else if(cmd!=null && cmd.equals("listRecent")) {
			listRecent(request,response);
		}
	}
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String ajax=request.getParameter("ajax");
		ArrayList<IndexViewVo> list=IndexViewDao.getInstance().list();
		if(ajax!=null && ajax.equals("true")) {
			JSONArray arr=new JSONArray();
			for(IndexViewVo vo:list) {
				JSONObject ob=new JSONObject();
				ob.put("item_orgimg", vo.getItem_savimg());
				ob.put("item_name", vo.getItem_name());
				ob.put("order_cnt", vo.getOrder_cnt());
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
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "welcome to SM3");
			request.getRequestDispatcher("msg.jsp").forward(request, response);
		}
	}
	protected void listRecent(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String ajax=request.getParameter("ajax");
		ArrayList<IndexViewVo> list=IndexViewDao.getInstance().recentList();
		if(ajax!=null && ajax.equals("true")) {
			JSONArray arr=new JSONArray();
			for(IndexViewVo vo:list) {
				JSONObject ob=new JSONObject();
				ob.put("item_orgimg", vo.getItem_savimg());
				ob.put("item_name", vo.getItem_name());
				ob.put("item_num", vo.getItem_num());
				arr.add(ob);
			}
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter pw=response.getWriter();
			pw.println(arr.toString());
			pw.close();
			return;
		}
		if(list!=null) {
			request.setAttribute("listRecent", list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "welcome to SM3");
			request.getRequestDispatcher("msg.jsp").forward(request, response);
		}
	}
}
