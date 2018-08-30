package sm3.ldk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import sm3.ldk.dao.InItemDao;
import sm3.ldk.dao.OrderDao;
import sm3.ldk.dao.SalesReportViewDao;
import sm3.ldk.vo.InItemVo;
import sm3.ldk.vo.OrderVo;

@WebServlet("/saleReport.do")
public class SaleReportController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getParameter("cmd");
		if(cmd!=null && cmd.equals("month")) {
			month(request,response);
		}else if(cmd!=null && cmd.equals("test")) {
			test(request,response);
		}
	}
	protected void month(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		Date now=new Date(new java.util.Date().getTime());
		String[] date=String.valueOf(now).split("-");
		int[] grossSale=new int[6];
		int[] grossCost=new int[6];
		int[] orderCnt=new int[6];
		int[] inCnt=new int[6];
		int[] month=new int[6];
		int year=Integer.parseInt(date[0]);
		for(int i=0;i<5;i++) {
			month[i]=Integer.parseInt(date[1])-i;
			grossSale[i]=SalesReportViewDao.getInstance().grossSaleMonth(year,month[i]);
			grossCost[i]=SalesReportViewDao.getInstance().grossCostMonth(year,month[i]);
			orderCnt[i]=SalesReportViewDao.getInstance().orderCntMonth(year, month[i]);
			inCnt[i]=SalesReportViewDao.getInstance().inCntMonth(year, month[i]);
		}
		JSONArray arr=new JSONArray();
		for(int i=0;i<grossSale.length;i++) {
			JSONObject ob=new JSONObject();
			ob.put("x1",date[0] + "-" + month[i]);
			ob.put("grossSale", grossSale[i]);
			ob.put("grossCost", grossCost[i]);
			ob.put("orderCnt", orderCnt[i]);
			ob.put("inCnt", inCnt[i]);
			arr.add(ob);
		}
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.println(arr.toString());
		pw.close();
	}
	protected void test(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		Random rnd=new Random();
		Date now=new Date(new java.util.Date().getTime());
		String[] date=String.valueOf(now).split("-");
		for(int i=0;i<5;i++) {
			int order_total=rnd.nextInt(500000);
			int in_cnt=rnd.nextInt(10);
			int in_cost=rnd.nextInt(20000);
			String order_date=date[0] +"-"+ String.valueOf(Integer.parseInt(date[1])-i) +"-"+ date[2];
			int n=OrderDao.getInstance().insertTest(new OrderVo(0, 0, 3,
					order_total, 0, order_total, "test",
					"test", "test", "test",
					"test", Date.valueOf(order_date), 1));
			int nn=InItemDao.getInstance().insertTest(new InItemVo(0, 1,
					1, in_cnt, in_cost, Date.valueOf(order_date)));
			if(n<0) {
				System.out.println("판매테스트실패");
				return;
			}
			if(nn<0) {
				System.out.println("입고테스트실패");
				return;
			}
		}
		System.out.println("성공");
	}
}
