package sm3.ldk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import sm3.jsh.dao.ReviewDao;
import sm3.jsh.vo.ReviewVo;
import sm3.jsh.vo.UserVo;
import sm3.ldk.dao.ItemViewDao;
import sm3.ldk.vo.ItemViewVo;

@WebServlet("/itemView.do")
public class ItemViewController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd=request.getParameter("cmd");
		if(cmd!=null && cmd.equals("list")) {
			list(request,response);
		}else if(cmd!=null && cmd.equals("select")) {
			select(request,response);
		}else if(cmd!=null && cmd.equals("select_cate")) {
			select_cate(request,response);
		}
	}
	
	protected void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//ArrayList<ItemViewVo> list=ItemViewDao.getInstance().list();
				String search=request.getParameter("search");
				String keyword=request.getParameter("keyword");
				if(keyword==null || keyword.equals("")) {
					search="";
					keyword="";
				}
				String spageNum=request.getParameter("pageNum");
				int pageNum=1;
				if(spageNum!=null && !spageNum.equals("")) {
					pageNum=Integer.parseInt(spageNum);
				}
				int startRow=(pageNum-1)*10+1;
				int endRow=startRow+9;
				ItemViewDao dao=ItemViewDao.getInstance();
				ArrayList<ItemViewVo> list=dao.list(startRow, endRow, search, keyword.toUpperCase());
				if(list!=null) {
					int pageCount=(int)Math.ceil(dao.getCount(search, keyword.toUpperCase())/10.0);
					int startPage=((pageNum-1)/10*10)+1;
					int endPage=startPage+9;
					if(endPage>pageCount) {
						endPage=pageCount;
					}
					request.setAttribute("pageNum", pageNum);
					request.setAttribute("pageCount", pageCount);
					request.setAttribute("startPage", startPage);
					request.setAttribute("endPage", endPage);
					request.setAttribute("search", search);
					request.setAttribute("keyword", keyword);
					request.setAttribute("list", list);
					request.getRequestDispatcher("admin.jsp?page1=ITEM_VIEW_list.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", "��� �ҷ����� ����");
					request.getRequestDispatcher("admin.jsp?page1=ADMIN_msg.jsp").forward(request, response);
				}
	}
	
	
	protected void select(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String sitem_num=request.getParameter("item_num");
		String item_nameVal=request.getParameter("item_name");
		String sorder_num=request.getParameter("order_num");
		String item_name= item_nameVal.substring(0, 5);
		
		int order_num=0;
		if(sorder_num!=null && !sorder_num.equals("")) {
			order_num=Integer.parseInt(sorder_num);
		}
		
		int item_num=0;
		if(sitem_num!=null && !sitem_num.equals("")) {
			item_num=Integer.parseInt(sitem_num);
		}
		//��ǰ���� ����Ʈ
		ArrayList<ItemViewVo> list=ItemViewDao.getInstance().select(item_num);
		HashMap<Integer, String> list2=ItemViewDao.getInstance().select_color(item_name);
		
		//���� ����Ʈ
		
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
		ArrayList<ReviewVo> review_list = dao.list(startRow, endRow, search, keyword, item_name);
		if(review_list==null) review_list = new ArrayList<ReviewVo>();
		//������Ʈ�������� ����
		if(list!=null && list2 != null) {
			int pageCount = (int)(Math.ceil(dao.getCount(search, keyword, item_name) / 10.0));
			int startPage = ((pageNum - 1) / 3 * 3) + 1;
			int endPage = startPage + 2;
			if (pageCount < endPage) {
				endPage = pageCount;
			}
			int reviewCount = (int)(Math.ceil(dao.getCount(search, keyword, item_name)));
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("search", search);
			request.setAttribute("keyword", keyword);
			request.setAttribute("reviewCount", reviewCount);
			request.setAttribute("order_num", order_num);
			request.setAttribute("list", list);
			request.setAttribute("list2", list2);
			request.setAttribute("review_list", review_list);
			
			request.getRequestDispatcher("item_detail.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "���ý���");
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
	}
	
	
	//ī�װ��ѹ� ����Ʈ 
		protected void select_cate(HttpServletRequest request, 
				HttpServletResponse response) throws ServletException, IOException {
			int cate_num=Integer.parseInt(request.getParameter("cate_num"));
			ArrayList<ItemViewVo> list=ItemViewDao.getInstance().select_cate(cate_num);
			ReviewDao dao = ReviewDao.getInstance();
			JSONObject obj = new JSONObject();
			JSONArray arr = new JSONArray();
			
			if(list != null) {	
				for(ItemViewVo vo : list) {
				JSONObject ob = new JSONObject();
				//int reviewCount = (int)(Math.ceil(dao.getCount(null, null, vo.getItem_name())));
				ob.put("cate_num",vo.getCate_num());
				ob.put("item_num",vo.getItem_num());
				ob.put("item_name",vo.getItem_name());
				ob.put("item_price",vo.getItem_price());
				ob.put("item_orgimg",vo.getItem_orgimg());
				ob.put("size_name",vo.getSize_name());
				ob.put("size_num",vo.getSize_num());
				//ob.put("review_cnt", reviewCount );
				arr.add(ob);
			}
			obj.put("arr", arr);
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print(obj.toString());
			pw.close();
			}
		
		}
}
