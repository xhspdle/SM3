package sm3.lsu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import sm3.lsu.dao.QaCommDao;
import sm3.lsu.dao.QaDao;
import sm3.lsu.vo.QaCommVo;

@WebServlet("/QA_COMMboard.do")
public class QaCommcontroller extends HttpServlet{

	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd");
		if(cmd !=null && cmd.equals("insert")) {
			insert(request, response);
		}else if(cmd !=null && cmd.equals("delete")) {
			delete(request, response);
		}
	}
	public void insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
	//	int comm_num=Integer.parseInt(request.getParameter("board_idx"));
		String comm_writer=request.getParameter("comm_writer");
		String comm_content=request.getParameter("comm_content");
	//	String comm_date=request.getParameter("comm_date");
		HttpSession session=request.getSession();
		int qa_num=Integer.parseInt(request.getParameter("qa_num"));
		
		
		int user_num=(Integer)(session.getAttribute("user_num"));
	//	int admin_num=Integer.parseInt(request.getParameter("admin_num"));
		
		QaCommVo vo= new QaCommVo(0, comm_writer, comm_content, null, qa_num, user_num,1);
		QaCommDao qao=QaCommDao.getInstance();
		qao.insert(vo);
		
		
		
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int comm_num=Integer.parseInt(request.getParameter("comm_num"));
		System.out.println("µô¸®Æ®");
		String sqa_num=request.getParameter("qa_num");
		int qa_num=0;
		if(sqa_num!=null && !sqa_num.equals("")) {
			qa_num=Integer.parseInt(sqa_num);
		}
		QaCommDao dao=QaCommDao.getInstance();
		dao.delete(comm_num);
		
	}
	
}

