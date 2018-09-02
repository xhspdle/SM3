package sm3.jya.controller;

import java.io.IOException;
import java.sql.Clob;
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

@WebServlet("/EventNotice.do")
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
			1024*1024*10,
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
			request.setAttribute("msg", "�̺�Ʈ�̹��� �߰� ����");
		}else {
			request.setAttribute("msg", "�̺�Ʈ�̹��� �߰� ����");
		}
		request.getRequestDispatcher("EventNotice.do?cmd=list").forward(request,response);
	}
	protected void list(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		String search=request.getParameter("search");
		String keyword = request.getParameter("keyword");
		if(keyword==null || keyword.equals("")) {
			search="";
			keyword="";
		}
		String spageNum=request.getParameter("pageNum");
		int pageNum=1; //�⺻��
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*9+1; //�������� ù��° ��
		int endRow=startRow+8; //������ ��
		EventNoticeDao dao = EventNoticeDao.getInstance();
		ArrayList<EventNoticeVo> list1=dao.list(startRow, endRow, search, keyword);
		//System.out.println("list:"+list1); //toString�޼ҵ� ȣ���ϴ�..
		if(list1!=null) {
			int pageCount=(int)Math.ceil(dao.getCount(search,keyword)/9.0); //��ü��������
			int startPage=((pageNum-1)/3*3)+1; //ù��° ������ ��ȣ
			int endPage=startPage+2; //��������
			if(endPage>pageCount) {
				endPage=pageCount;
			}
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("search", search);
			request.setAttribute("keyword", keyword);
			request.setAttribute("list", list1);
			request.getRequestDispatcher("community_event_list.jsp").forward(request, response);
			request.setAttribute("msg", "��Ϻ��� ����");
		}else {
			request.setAttribute("list", list1);
			request.getRequestDispatcher("community_event_list.jsp").forward(request, response);
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		String sen_num=request.getParameter("en_num");
		int en_num=0;
		if(sen_num!=null && !sen_num.equals("")) {
			en_num=Integer.parseInt(sen_num);
		}
		int n = EventNoticeDao.getInstance().delete(en_num);
		if(n>0) {
			request.setAttribute("msg", "�̹�����������");
		}else {
			request.setAttribute("msg", "�̹��� ���� ����");
		}
		request.getRequestDispatcher("EventNotice.do?cmd=list").forward(request, response);
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		String path=request.getServletContext().getRealPath("/images");	
		MultipartRequest mr=new MultipartRequest(request,
			path,
			1024*1024*10,      
			"UTF-8",
			new DefaultFileRenamePolicy());
		int en_num = Integer.parseInt(mr.getParameter("en_num"));
		String en_writer=mr.getParameter("en_writer");
		String en_title=mr.getParameter("en_title");            
		String en_content=mr.getParameter("en_content");  
		String sen_orgimg=mr.getParameter("en_orgimg"); //���� ���ε��� ����.������ �� �ٲ� �̹���
		String sen_savimg=mr.getParameter("en_savimg");
		String en_orgimg="";
		String en_savimg="";
		if(sen_orgimg!=null && !sen_orgimg.equals("")) {  //���γ��� ������ null�� �ƴϰ� ������ �ƴϸ� �� ������ ������
			en_orgimg=sen_orgimg;     /*����ٰ� ������ �� ������ ���������� db���� �޾ƿ���(dao,controller,db�� ������) ���������� ������ multipartrequest���� �޴µ� ���� �������� �����ٴϴ� �κ��� controller�̱� ������.*/
			en_savimg=sen_savimg;
		}else {   
		 en_orgimg=mr.getOriginalFileName("file1");  //�̹��������� ���� ������ ���� �״��
		 en_savimg=mr.getFilesystemName("file1");
		}
		int admin_num=Integer.parseInt(mr.getParameter("admin_num"));
		int n=EventNoticeDao.getInstance().update(new EventNoticeVo(en_num, en_writer, en_title, en_content, null, en_orgimg, en_savimg, admin_num));
		if(n>0) {
			request.setAttribute("msg", "�̺�Ʈ���� ���� ����");
			request.getRequestDispatcher("EventNotice.do?cmd=list").forward(request, response);
		}else {
			request.setAttribute("msg", "�̺�Ʈ���� ���� ����");
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
				
	 }
	protected void select(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		String sen_num=request.getParameter("en_num");
		int en_num=0;
		if(sen_num!=null && !sen_num.equals("")) {
			en_num=Integer.parseInt(sen_num);
		}
		EventNoticeVo vo = EventNoticeDao.getInstance().select(en_num);
		if(vo!=null) { 
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("community_event_update.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "����");
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
	 }
  }		

