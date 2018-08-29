package sm3.jya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.jya.vo.OrderListViewVo;

public class OrderListViewDao {
	private static OrderListViewDao instance=new OrderListViewDao();
	private OrderListViewDao() {}
	private static OrderListViewDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(order_num),0) maxnum from sm3_orderlist_view";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("maxnum");
			}
			return 0;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	public int getCount() {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(count(order_num),0) cnt from sm3_orderlist_view";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			return 0;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	public ArrayList<OrderListViewVo> select(int order_num){
		Connection con=null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		ArrayList<OrderListViewVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_orderlist_view where order_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int order_num1=rs.getInt("order_num");
					int order_status=rs.getInt("order_status");
					int order_pay=rs.getInt("order_pay");
					int order_cnt=rs.getInt("order_cnt");
					String item_info=rs.getString("item_info");
					String item_savimg=rs.getString("item_savimg");
					OrderListViewVo vo = new OrderListViewVo(order_num,order_status,order_pay,order_cnt,item_info,item_savimg);
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
	public ArrayList<OrderListViewVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		ArrayList<OrderListViewVo> list = new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select *from sm3_orderlist_view";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int order_num1=rs.getInt("order_num");
					int order_status=rs.getInt("order_status");
					int order_pay=rs.getInt("order_pay");
					int order_cnt=rs.getInt("order_cnt");
					String item_info=rs.getString("item_info");
					String item_savimg=rs.getString("item_savimg");
					OrderListViewVo vo = new OrderListViewVo(order_num,order_status,order_pay,order_)
				}while(rs.next());
			}
			
			
		}
	}

}
