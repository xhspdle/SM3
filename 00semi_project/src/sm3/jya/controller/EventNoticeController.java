package sm3.jya.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import sm3.jya.dao.EventNoticeDao;
import sm3.jya.vo.EventNoticeVo;

@WebServlet("/dev/board/EventNotice.do")
public class EventNoticeController extends HttpServlet{
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
	protected void insert(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		String path=request.getServletContext().getRealPath("/images");	
		MultipartRequest mr=new MultipartRequest(request,
			path,
			1024*1024*5,
			"UTF-8",
			new DefaultFileRenamePolicy());
		String en_writer=mr.getParameter("en_writer");
		String en_title=mr.getParameter("en_title");
		String en_orgimg=mr.getOriginalFileName("file1");
		String en_savimg=mr.getFilesystemName("file1");
		int admin_num=Integer.parseInt(mr.getParameter("admin_num"));

		String en_content=mr.getParameter("en_content");
		
		int n=EventNoticeDao.getInstance().insert(new EventNoticeVo(0, en_writer, en_title, en_content, null, en_orgimg, en_savimg,admin_num));
		if(n>0) {
			request.setAttribute("msg", "이벤트이미지 추가 성공");
		}else {
			request.setAttribute("msg", "이벤트이미지 추가 실패");
		}
		request.getRequestDispatcher("/dev/board/Event_msg.jsp").forward(request,response);
	}
	protected void list(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		ArrayList<EventNoticeVo> list = EventNoticeDao.getInstance().list();
		if(list!=null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/dev/board/EN_list.jsp").forward(request, response);
		}
		String search=request.getParameter("search");
		String keyword = request.getParameter("keyword");
		if(keyword==null || keyword.equals("")) {
			search="";
			keyword="";
		}
		String spageNum=request.getParameter("pageNum");
		int pageNum=1; //기본값
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*5+1; //페이지의 첫번째 글
		int endRow=startRow+4; //마지막 글
		EventNoticeDao dao = EventNoticeDao.getInstance();
		ArrayList<EventNoticeVo> list1=dao.list(startRow, endRow, search, keyword);
		System.out.println("list:"+list1);
		if(list1!=null) {
			int pageCount=(int)Math.ceil(dao.getCount(search,keyword)/5.0); //전체페이지수
			int startPage=((pageNum-1)/5*5)+1; //첫번째 페이지 번호
			int endPage=startPage+9;
			if(endPage>pageCount) {
				endPage=pageCount;
			}
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("endPage", endPage);
			request.setAttribute("search", search);
			request.setAttribute("keyword", keyword);
			request.setAttribute("list", list);
			
			
			
		}
		
		
		
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		int en_num = Integer.parseInt(request.getParameter("en_num"));
		int n = EventNoticeDao.getInstance().delete(en_num);
		if(n>0) {
			request.setAttribute("msg", "이미지삭제성공");
		}else {
			request.setAttribute("msg", "이미지 삭제 실패");
		}
		request.getRequestDispatcher("/dev/board/Event_msg.jsp").forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		String path=request.getServletContext().getRealPath("/images");	
		MultipartRequest mr=new MultipartRequest(request,
			path,
			1024*1024*5,
			"UTF-8",
			new DefaultFileRenamePolicy());
		int en_num = Integer.parseInt(mr.getParameter("en_num"));
		String en_writer=mr.getParameter("en_writer");
		String en_title=mr.getParameter("en_title");
		String en_content=mr.getParameter("en_content");  
		String en_orgimg=mr.getOriginalFileName("file1");
		String en_savimg=mr.getFilesystemName("file1");
		int admin_num=Integer.parseInt(mr.getParameter("admin_num"));
		int n=EventNoticeDao.getInstance().update(new EventNoticeVo(en_num, en_writer, en_title, en_content, null, en_orgimg, en_savimg, admin_num));
		if(n>0) {
			request.setAttribute("msg", "이벤트공지 수정 성공");
		}else {
			request.setAttribute("msg", "이벤트공지 수정 실패");
		}
		request.getRequestDispatcher("/dev/board/Event_msg.jsp").forward(request, response);		
	 }
	protected void select(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		int en_num=Integer.parseInt(request.getParameter("en_num"));
		EventNoticeVo vo = EventNoticeDao.getInstance().select(en_num);
		if(vo!=null) {
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("EN_imginput.jsp?cmd1=update").forward(request, response);
		}else {
			request.setAttribute("msg", "실패");
			request.getRequestDispatcher("Event_msg.jsp").forward(request, response);
		}
	 }
	
  }		

