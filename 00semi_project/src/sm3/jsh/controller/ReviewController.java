package sm3.jsh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import sm3.jsh.dao.ReviewDao;
import sm3.jsh.dao.UserDao;
import sm3.jsh.vo.ReviewVo;
import sm3.jsh.vo.UserVo;


@WebServlet("/reviewControll.do")
public class ReviewController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd");
		if(cmd.equals("insert")) {
			insert(request,response);
		}else if(cmd.equals("list")) {
			list(request,response);
		}else if(cmd.equals("delete")) {
			delete(request,response);
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletContext().getRealPath("/DBImages");
		int item_num = Integer.parseInt(request.getParameter("item_num"));
		MultipartRequest mr=new MultipartRequest(request,
				path,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		String review_item = mr.getParameter("review_item");
		String review_orgimg = mr.getOriginalFileName("file1");
		String review_savimg = mr.getFilesystemName("file1");
		String review_content = mr.getParameter("review_content").replace("\r\n", "<br>");
		
		String mreview_rating = mr.getParameter("review_rating");
		int review_rating=0;
		if(mreview_rating !=null && !mreview_rating.equals("")) {
			review_rating=Integer.parseInt(mreview_rating);
		}
		
		String morder_num = mr.getParameter("order_num");
		int order_num=0;
		if(morder_num !=null && !morder_num.equals("")) {
			 order_num=Integer.parseInt(morder_num);
		}
		
		String muser_num = mr.getParameter("user_num");
		int user_num=0;
		if(muser_num !=null && !muser_num.equals("")) {
			user_num=Integer.parseInt(muser_num);
		}
		
		int n = ReviewDao.getInstance().insert(new ReviewVo(0, review_item, review_orgimg, review_savimg, review_rating, review_content, null, order_num, user_num));
		if(n>0) {
			request.setAttribute("msg", "리뷰등록성공");
			request.getRequestDispatcher("itemView.do?cmd=select&item_num"+item_num+"&item_name="+review_item).forward(request, response);
		}else {
			request.setAttribute("msg", "리뷰등록실패");
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
	}
	
	//ItemViewController에 보내놓음
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		String item_num = request.getParameter("item_num");
		String item_name = request.getParameter("item_name");
		int n = ReviewDao.getInstance().delete(review_num);
		if(n>0) {
			request.getRequestDispatcher("itemView.do?cmd=select&item_num"+item_num+"&item_name="+item_name).forward(request, response);
		}
	}
	
}
