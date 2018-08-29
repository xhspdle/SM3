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


@WebServlet("/ReviewControll.do")
public class ReviewController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd");
		if(cmd.equals("insert")) {
			insert(request,response);
		}else if(cmd.equals("list")) {
			list(request,response);
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletContext().getRealPath("/DBImages");
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
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "리뷰등록실패");
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
	}
	
	//ItemViewController에 보내놓음
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mpageNum = request.getParameter("pageNum");
		int pageNum = 1;
		if (mpageNum != null) {
			pageNum = Integer.parseInt(mpageNum);
		}
		String search = request.getParameter("search");
		String keyword = request.getParameter("keyword");
		if (keyword == null || keyword.equals("")) {
			search = "";
			keyword = "";
		}
		int endRow = 10 * pageNum;
		int startRow = endRow - 9;
		ReviewDao dao = ReviewDao.getInstance();
		ArrayList<ReviewVo> list = dao.list(startRow, endRow, search, keyword ,search);
		System.out.println(list);
		if (list != null) {
			int pageCount = (int)(Math.ceil(dao.getCount(search, keyword) / 10.0));
			System.out.println(pageCount);
			int startPage = ((pageNum - 1) / 3 * 3) + 1;
			int endPage = startPage + 2;
			if (pageCount < endPage) {
				endPage = pageCount;
			}
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("search", search);
			request.setAttribute("keyword", keyword);
			request.setAttribute("list", list);
			request.getRequestDispatcher("item_detail.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "리스트소환실패");
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
	}
	
}
