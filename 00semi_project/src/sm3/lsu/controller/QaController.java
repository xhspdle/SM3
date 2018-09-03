package sm3.lsu.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sm3.lsu.dao.QaCommDao;
import sm3.lsu.dao.QaDao;
import sm3.lsu.vo.QaCommVo;
import sm3.lsu.vo.QaVo;

@WebServlet("/QA_board.do")
public class QaController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		if (cmd != null && cmd.equals("insert")) {
			insert(request, response);
		} else if (cmd != null && cmd.equals("list")) {
			list(request, response);
		} else if (cmd != null && cmd.equals("delete")) {
			delete(request, response);
		} else if (cmd != null && cmd.equals("detail")) {
			detail(request, response);
		}

	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String snum = request.getParameter("qa_num");
		String qa_writer = request.getParameter("qa_writer");
		String qa_title = request.getParameter("qa_title");
		String qa_content = request.getParameter("qa_content");
		String user_id = request.getParameter("user_id");
		String admin_id = request.getParameter("admin_id");
		
		int qa_num = 0;
		int ref = 0;
		int lev = 0;
		int step = 0;
		
		  if(snum!=null && !snum.equals("")){ //답글인경우
		
		 qa_num=Integer.parseInt(snum);
		 ref=Integer.parseInt(request.getParameter("ref"));
		 
		 lev=Integer.parseInt(request.getParameter("lev"));
		 step=Integer.parseInt(request.getParameter("step")); 
		 }
		
		QaDao qa = QaDao.getInstance();
		QaVo vo = new QaVo(qa_num, qa_writer, qa_title, qa_content, null, ref, lev, step, 0, 0);
		int n=qa.insert(vo, user_id);
		if(n>0) {
			request.getRequestDispatcher("QA_board.do?cmd=list").forward(request, response);
		}else {
			
		}
	}
				//리스트
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spageNum = request.getParameter("pageNum");
		
		/*검색*/
		String keyField= request.getParameter("keyField");
		String keyWord= request.getParameter("keyWord");
		/*검색단어가없을때*/
		if (keyWord==null  ||  keyWord.equals("")  ){
			keyField="";
			keyWord="";
		}
		
		int pageNum = 1;
		if (spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
		int startRow = (pageNum - 1) * 10 + 1;
		int endRow = startRow + 9;
		
		ArrayList<QaVo> list = new ArrayList<>();
		QaDao qa = QaDao.getInstance();
		
		list = qa.Getlist(startRow, endRow, keyField ,keyWord);
		int pageCount=(int)Math.ceil(qa.getCount()/10.0);
		
		int startPage=((pageNum-1)/10*10)+1;
		int endPage=startPage+9;
		if(endPage>pageCount) {
			endPage=pageCount;
		}
		request.setAttribute("keyWord", keyWord);
		request.setAttribute("keyField", keyField);
		request.setAttribute("pageCount",pageCount);
		request.setAttribute("startPage",startPage);
		request.setAttribute("endPage",endPage);
		request.setAttribute("pageNum",pageNum);
		request.setAttribute("list", list);
		request.getRequestDispatcher("community_qna_list.jsp").forward(request, response);
	}
				//삭제
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int qa_num = Integer.parseInt(request.getParameter("qa_num"));
		QaDao qa = QaDao.getInstance();
		qa.delete(qa_num);
		request.getRequestDispatcher("QA_board.do?cmd=list").forward(request, response);

	}
				//상세보기
	protected void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int qa_num = Integer.parseInt(request.getParameter("qa_num"));
		QaDao qa = QaDao.getInstance();
		
		QaVo vo = qa.detail(qa_num);
		
		
		//  댓글정보
	    QaCommDao qa1= QaCommDao.getInstance(); 
	    ArrayList<QaCommVo> list=qa1.Cmmdetail(qa_num);
	    int count=qa1.count(qa_num);
	    request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("community_qna_detail.jsp").forward(request, response);
		;

	}
}
