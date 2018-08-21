package sm3.lsu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sm3.lsu.dao.QaDao;
import sm3.lsu.vo.QaVo;
@WebServlet("/board/QA_board.do")
public class QaController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getParameter("cmd");
		System.out.println(cmd);
		if(cmd!=null && cmd.equals("insert")) {
			insert(request,response);
		}
		
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String snum=request.getParameter("qa_num");
		String qa_writer=request.getParameter("user_name");
		String qa_title=request.getParameter("qa_title");
		String qa_content=request.getParameter("qa_content");
		int qa_num=0;
		int ref=0;
		int lev=0;
		int step=0;
		/*if(snum!=null && !snum.equals("")){ //답글인경우
			num=Integer.parseInt(snum);
			ref=Integer.parseInt(request.getParameter("ref"));
			lev=Integer.parseInt(request.getParameter("lev"));
			step=Integer.parseInt(request.getParameter("step"));
		}*/
		
		QaDao qa=QaDao.getInstance();
		QaVo vo=new QaVo(qa_num, qa_writer, qa_title, qa_content, null, ref, lev, step);
		
		 qa.insert(vo);
			
	}

}
