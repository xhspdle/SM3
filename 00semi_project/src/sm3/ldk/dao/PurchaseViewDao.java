package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.ldk.vo.PurchaseViewVo;

public class PurchaseViewDao {
	private static PurchaseViewDao instance=new PurchaseViewDao();
	private PurchaseViewDao() {}
	public static PurchaseViewDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(pl_num),0) maxnum from sm3_purchase_view";
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
			String sql="select NVL(count(pl_num),0) cnt from sm3_purchase_view";
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
	public ArrayList<PurchaseViewVo> select(int pur_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<PurchaseViewVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_purchase_view where pur_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pur_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int pl_num=rs.getInt("pl_num");
					int size_num=rs.getInt("size_num");
					int order_cnt=rs.getInt("order_cnt");
					int item_price=rs.getInt("item_price");
					String item_savimg=rs.getString("item_savimg");
					String item_name=rs.getString("item_name");
					String color_name=rs.getString("color_name");
					PurchaseViewVo vo=new PurchaseViewVo(pl_num, pur_num,
							size_num, order_cnt, item_price,
							item_savimg, item_name, color_name);
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
	public ArrayList<PurchaseViewVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<PurchaseViewVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_cart_view";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int pl_num=rs.getInt("pl_num");
					int pur_num=rs.getInt("pur_num");
					int size_num=rs.getInt("size_num");
					int order_cnt=rs.getInt("order_cnt");
					int item_price=rs.getInt("item_price");
					String item_savimg=rs.getString("item_savimg");
					String item_name=rs.getString("item_name");
					String color_name=rs.getString("color_name");
					PurchaseViewVo vo=new PurchaseViewVo(pl_num, pur_num,
							size_num, order_cnt, item_price,
							item_savimg, item_name, color_name);
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
