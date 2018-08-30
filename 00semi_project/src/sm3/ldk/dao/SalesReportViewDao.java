package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.ldk.vo.SalesReportViewVo;

public class SalesReportViewDao {
	private static SalesReportViewDao instance=new SalesReportViewDao();
	private SalesReportViewDao() {}
	public static SalesReportViewDao getInstance() {
		return instance;
	}
	public int getCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(count(order_num),0) cnt from sm3_sales_report_view";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			return -1;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	public SalesReportViewVo select(int order_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_sales_report_view where order_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int order_total=rs.getInt("order_total");
				int order_point=rs.getInt("order_point");
				int order_pay=rs.getInt("order_pay");
				Date order_date=rs.getDate("order_date");
				int order_cnt=rs.getInt("order_cnt");
				int item_price=rs.getInt("item_price");
				int in_cnt=rs.getInt("in_cnt");
				int in_cost=rs.getInt("in_cost");
				SalesReportViewVo vo=new SalesReportViewVo(order_num,
						order_total, order_point, order_pay, order_date,
						order_cnt, item_price, in_cnt, in_cost);
				return vo;
			}else {
				return null;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}	
	public ArrayList<SalesReportViewVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<SalesReportViewVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_sales_report_view";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int order_num=rs.getInt("order_num");
					int order_total=rs.getInt("order_total");
					int order_point=rs.getInt("order_point");
					int order_pay=rs.getInt("order_pay");
					Date order_date=rs.getDate("order_date");
					int order_cnt=rs.getInt("order_cnt");
					int item_price=rs.getInt("item_price");
					int in_cnt=rs.getInt("in_cnt");
					int in_cost=rs.getInt("in_cost");
					SalesReportViewVo vo=new SalesReportViewVo(order_num,
							order_total, order_point, order_pay, order_date,
							order_cnt, item_price, in_cnt, in_cost);
					list.add(vo);
				}while(rs.next());
				return list;
			}else {
				return null;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}	
	public ArrayList<SalesReportViewVo> monthList(int year,int month){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<SalesReportViewVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_sales_report_view where order_date between ? and ?";
			int month1[]= {1,3,5,7,8,10,12};
			int month2[]= {4,6,9,11};
			String endDay="";
			for(int i=0;i<month1.length;i++) {
				if(month==month1[i]) {
					endDay="31";
				}
			}
			for(int i=0;i<month2.length;i++) {
				if(month==month2[i]) {
					endDay="30";
				}
			}
			if(month==2) {
				endDay="28";
			}
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(year) + "/" + String.valueOf(month) + "/1");
			pstmt.setString(2, String.valueOf(year) + "/" + String.valueOf(month) + "/" + endDay);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int order_num=rs.getInt("order_num");
					int order_total=rs.getInt("order_total");
					int order_point=rs.getInt("order_point");
					int order_pay=rs.getInt("order_pay");
					Date order_date=rs.getDate("order_date");
					int order_cnt=rs.getInt("order_cnt");
					int item_price=rs.getInt("item_price");
					int in_cnt=rs.getInt("in_cnt");
					int in_cost=rs.getInt("in_cost");
					SalesReportViewVo vo=new SalesReportViewVo(order_num,
							order_total, order_point, order_pay, order_date,
							order_cnt, item_price, in_cnt, in_cost);
					list.add(vo);
				}while(rs.next());
				return list;
			}else {
				return null;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}	
	public ArrayList<SalesReportViewVo> yearList(int year){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<SalesReportViewVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_sales_report_view where order_date between ? and ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(year) + "/1/1");
			pstmt.setString(2, String.valueOf(year) + "/12/13");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int order_num=rs.getInt("order_num");
					int order_total=rs.getInt("order_total");
					int order_point=rs.getInt("order_point");
					int order_pay=rs.getInt("order_pay");
					Date order_date=rs.getDate("order_date");
					int order_cnt=rs.getInt("order_cnt");
					int item_price=rs.getInt("item_price");
					int in_cnt=rs.getInt("in_cnt");
					int in_cost=rs.getInt("in_cost");
					SalesReportViewVo vo=new SalesReportViewVo(order_num,
							order_total, order_point, order_pay, order_date,
							order_cnt, item_price, in_cnt, in_cost);
					list.add(vo);
				}while(rs.next());
				return list;
			}else {
				return null;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}	
	public int grossSaleMonth(int year,int month){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select sum(order_total) sum from sm3_sales_report_view where order_date between ? and ?";
			int month1[]= {1,3,5,7,8,10,12};
			int month2[]= {4,6,9,11};
			String endDay="";
			for(int i=0;i<month1.length;i++) {
				if(month==month1[i]) {
					endDay="31";
				}
			}
			for(int i=0;i<month2.length;i++) {
				if(month==month2[i]) {
					endDay="30";
				}
			}
			if(month==2) {
				endDay="28";
			}
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(year) + "/" + String.valueOf(month) + "/1");
			pstmt.setString(2, String.valueOf(year) + "/" + String.valueOf(month) + "/" + endDay);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("sum");
			}else {
				return -1;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}	
	public int grossCostMonth(int year,int month){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select sum(in_cnt*in_cost) sum from sm3_sales_report_view where order_date between ? and ?";
			int month1[]= {1,3,5,7,8,10,12};
			int month2[]= {4,6,9,11};
			String endDay="";
			for(int i=0;i<month1.length;i++) {
				if(month==month1[i]) {
					endDay="31";
				}
			}
			for(int i=0;i<month2.length;i++) {
				if(month==month2[i]) {
					endDay="30";
				}
			}
			if(month==2) {
				endDay="28";
			}
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(year) + "/" + String.valueOf(month) + "/1");
			pstmt.setString(2, String.valueOf(year) + "/" + String.valueOf(month) + "/" + endDay);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("sum");
			}else {
				return -1;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}	
}
