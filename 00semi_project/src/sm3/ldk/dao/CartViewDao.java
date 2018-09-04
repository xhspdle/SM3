package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.ldk.vo.CartViewVo;

public class CartViewDao {
	private static CartViewDao instance=new CartViewDao();
	private CartViewDao() {}
	public static CartViewDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(cart_num),0) maxnum from sm3_cart_view";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("maxnum");
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
	public int getCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(count(cart_num),0) cnt from sm3_cart_view";
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
	public ArrayList<CartViewVo> select(int user_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<CartViewVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_cart_view where user_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, user_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int cart_num=rs.getInt("cart_num");
					int size_num=rs.getInt("size_num");
					int order_cnt=rs.getInt("order_cnt");
					int item_price=rs.getInt("item_price");
					String item_orgimg=rs.getString("item_orgimg");
					String item_name=rs.getString("item_name");
					String color_name=rs.getString("color_name");
					CartViewVo vo=new CartViewVo(cart_num, user_num, size_num,
							order_cnt, item_price, item_orgimg,
							item_name, color_name);
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
	public ArrayList<CartViewVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<CartViewVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_cart_view";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int cart_num=rs.getInt("cart_num");
					int user_num=rs.getInt("user_num");
					int size_num=rs.getInt("size_num");
					int order_cnt=rs.getInt("order_cnt");
					int item_price=rs.getInt("item_price");
					String item_orgimg=rs.getString("item_orgimg");
					String item_name=rs.getString("item_name");
					String color_name=rs.getString("color_name");
					CartViewVo vo=new CartViewVo(cart_num, user_num, size_num,
							order_cnt, item_price, item_orgimg,
							item_name, color_name);
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
}
