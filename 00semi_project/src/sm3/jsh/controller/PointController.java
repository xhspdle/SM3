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
@WebServlet("/pointControll.do")
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
		int user_num = Integer.parseInt(request.getParameter("user_num"));
		ArrayList<PointVo> allList = PointDao.getInstance().allList(user_num);
		ArrayList<PointVo> list = PointDao.getInstance().select(user_num);
		int allPoint = 0;
		int point = 0;
		
		int order_cnt = list.size();
		
		for (PointVo vo : allList) { //��ü ������
			allPoint = allPoint + vo.getPoint();
		}
		
		for (PointVo vo : list) { //��밡�� ������
			point = point + vo.getPoint();
		}
		
		int hidePoint = allPoint - point; 
		
		if(list != null) {
			request.setAttribute("allPoint", allPoint);
			request.setAttribute("point", point);
			request.setAttribute("hidePoint", hidePoint);
			request.setAttribute("order_cnt", order_cnt);
			request.getRequestDispatcher("mypage_mypage.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "����Ʈ ��ȯ����");
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
		
	}
}
