package sm3.ldk.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sm3.ldk.dao.OrderDao;
import sm3.ldk.dao.SalesReportViewDao;
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
		for(int i=0;i<5;i++) {
			grossSale[i]=SalesReportViewDao.getInstance().grossSaleMonth(Integer.parseInt(date[0]),
					Integer.parseInt(date[1])+i);
			grossCost[i]=SalesReportViewDao.getInstance().grossCostMonth(Integer.parseInt(date[0]),
					Integer.parseInt(date[1])+i);
		}
		for(int i=0;i<grossSale.length;i++) {
			System.out.println(grossSale[i]);
		}
	}
	protected void test(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		Random rnd=new Random();
		int order_total=rnd.nextInt(100000);
		Date now=new Date(new java.util.Date().getTime());
		String[] date=String.valueOf(now).split("-");
		for(int i=0;i<5;i++) {
			String order_date=date[0] +"-"+ String.valueOf(Integer.parseInt(date[1])-i) +"-"+ date[2];
			System.out.println(order_date);
			int n=OrderDao.getInstance().insert(new OrderVo(0, 0, 1,
					order_total, 0, order_total, "test",
					"test", "test", "test",
					"test", Date.valueOf(order_date), 1));
			if(n<0) {
				System.out.println("실패");
				return;
			}
		}
		System.out.println("성공");
	}
}
