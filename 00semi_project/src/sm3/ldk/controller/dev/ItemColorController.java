package sm3.ldk.controller.dev;

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

import sm3.ldk.dao.ItemColorDao;
import sm3.ldk.vo.ItemColorVo;

@WebServlet("/dev/itemOrder/itemColor.do")
public class ItemColorController extends HttpServlet{
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
		String scolor_num=request.getParameter("color_num");
		int color_num=0;
		if(scolor_num!=null && !scolor_num.equals("")) {
			color_num=Integer.parseInt(scolor_num);
		}
		String color_name=request.getParameter("color_name");
		String color_code=request.getParameter("color_code");
		int n=ItemColorDao.getInstance().insert(new ItemColorVo(color_num,
				color_name, color_code));
		if(n>0) {
			request.setAttribute("msg", "컬러 추가 성공!!");
		}else {
			request.setAttribute("msg", "컬러 추가 실패..");
		}
		request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
	}
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ItemColorVo> list=ItemColorDao.getInstance().list();
		String ajax=request.getParameter("ajax");
		if(ajax!=null && ajax.equals("true")) {
			JSONArray arr=new JSONArray();
			for(ItemColorVo vo:list) {
				JSONObject ob=new JSONObject();
				ob.put("color_num", String.valueOf(vo.getColor_num()));
				ob.put("color_name", vo.getColor_name());
				ob.put("color_code", vo.getColor_code());
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
			request.getRequestDispatcher("ITEM_COLOR_list.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "목록 불러오기 실패");
			request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
		}
	}
	protected void delete(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String scolor_num=request.getParameter("color_num");
		int color_num=0;
		if(scolor_num!=null && !scolor_num.equals("")) {
			color_num=Integer.parseInt(scolor_num);
		}	
		int n=ItemColorDao.getInstance().delete(color_num);
		if(n>0) {
			request.setAttribute("msg", "컬러 삭제 성공!!");
		}else {
			request.setAttribute("msg", "컬러 삭제 실패..");
		}
		request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
	}
	protected void select(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String scolor_num=request.getParameter("color_num");
		int color_num=0;
		if(scolor_num!=null) {
			color_num=Integer.parseInt(scolor_num);
		}	
		ItemColorVo vo=ItemColorDao.getInstance().select(color_num);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("ITEM_COLOR_insert.jsp?do1=update").forward(request, response);
		}else {
			request.setAttribute("msg", "선택실패");
			request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
		}
	}
	protected void update(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String scolor_num=request.getParameter("color_num");
		int color_num=0;
		if(scolor_num!=null && !scolor_num.equals("")) {
			color_num=Integer.parseInt(scolor_num);
		}
		String color_name=request.getParameter("color_name");
		String color_code=request.getParameter("color_code");
		int n=ItemColorDao.getInstance().update(new ItemColorVo(color_num,
				color_name, color_code));
		if(n>0) {
			request.setAttribute("msg", "컬러 수정 성공!!");
		}else {
			request.setAttribute("msg", "컬러 수정 실패..");
		}
		request.getRequestDispatcher("ITEM_msg.jsp").forward(request, response);
	}
}
