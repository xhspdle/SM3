package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.ldk.vo.IndexViewVo;

public class IndexViewDao {
	private static IndexViewDao instance=new IndexViewDao();
	private IndexViewDao() {}
	public static IndexViewDao getInstance() {
		return instance;
	}
	public ArrayList<IndexViewVo> list() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<IndexViewVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="SELECT AA.* " + 
					"FROM " + 
					"(" + 
					"    SELECT * " + 
					"    FROM SM3_INDEX_VIEW " + 
					"    ORDER BY ORDER_CNT DESC " + 
					") AA " + 
					"WHERE ROWNUM<=24";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					String item_savimg=rs.getString("item_savimg");
					String item_name=rs.getString("item_name");
					int item_price=rs.getInt("item_price");
					int item_num=rs.getInt("item_num");
					int order_cnt=rs.getInt("order_cnt");
					IndexViewVo vo=new IndexViewVo(item_savimg,
							item_name, item_price, item_num, order_cnt);
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
	public ArrayList<IndexViewVo> recentList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<IndexViewVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="SELECT AA.* " + 
					"FROM " + 
					"(" + 
					"    SELECT * " + 
					"    FROM SM3_INDEX_VIEW " + 
					"    ORDER BY ITEM_NUM DESC " + 
					") AA " + 
					"WHERE ROWNUM<=24";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					String item_savimg=rs.getString("item_savimg");
					String item_name=rs.getString("item_name");
					int item_price=rs.getInt("item_price");
					int item_num=rs.getInt("item_num");
					int order_cnt=rs.getInt("order_cnt");
					IndexViewVo vo=new IndexViewVo(item_savimg,
							item_name, item_price, item_num, order_cnt);
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
