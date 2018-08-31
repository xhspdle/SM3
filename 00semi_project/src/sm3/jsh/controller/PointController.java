package sm3.jsh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sm3.jsh.dao.PointDao;
import sm3.jsh.vo.PointVo;

/**
 * Servlet implementation class PointController
 */
@WebServlet("/PointControll.do")
public class PointController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("select")) {
			select(request,response);
			
		}
	}
	
	protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<PointVo> list = PointDao.getInstance().select(2);
		
		
	}

}
