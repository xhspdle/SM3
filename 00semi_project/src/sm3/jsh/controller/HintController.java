package sm3.jsh.controller;

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

import sm3.jsh.dao.HintDao;
import sm3.jsh.vo.HintVo;

@WebServlet("/hint.do")
public class HintController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<HintVo> list=HintDao.getInstance().list();
		JSONArray arr=new JSONArray();
		for(HintVo vo:list) {
			JSONObject ob=new JSONObject();
			ob.put("hint_num", vo.getHint_num());
			ob.put("hint_q", vo.getHint_q());
			arr.add(ob);
		}
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println(arr.toString());
		pw.close();
	}
}
