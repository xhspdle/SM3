package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.ldk.vo.ItemVo;

public class ItemDao {
	public static ItemDao instance=new ItemDao();
	private ItemDao() {}
	public static ItemDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(item_num),0) maxnum from sm3_item";
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
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	public int insert(ItemVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="insert into sm3_item values(?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum()+1);
			pstmt.setString(2, vo.getItem_name());
			pstmt.setInt(3, vo.getCate_num());
			pstmt.setString(4, vo.getItem_info());
			pstmt.setInt(5, vo.getItem_price());
			pstmt.setString(6, vo.getItem_orgimg());
			pstmt.setString(7, vo.getItem_savimg());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	public int delete(int item_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="delete from sm3_item where item_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, item_num);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	public int update(ItemVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="update sm3_item set item_name=?,"
					+ "cate_num=?,item_info=?,item_price=?,"
					+ "item_orgimg=?,item_savimg=? where item_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getItem_name());
			pstmt.setInt(2, vo.getCate_num());
			pstmt.setString(3, vo.getItem_info());
			pstmt.setInt(4, vo.getItem_price());
			pstmt.setString(5, vo.getItem_orgimg());
			pstmt.setString(6, vo.getItem_savimg());
			pstmt.setInt(7, vo.getItem_num());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	public ItemVo select(int item_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_item where item_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, item_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String item_name=rs.getString("item_name");
				int cate_num=rs.getInt("cate_num");
				String item_info=rs.getString("item_info");
				int item_price=rs.getInt("item_price");
				String item_orgimg=rs.getString("item_orgimg");
				String item_savimg=rs.getString("item_savimg");
				ItemVo vo=new ItemVo(item_num, item_name, cate_num,
						item_info, item_price, item_orgimg,
						item_savimg);
				return vo;
			}
			return null;
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
	public ArrayList<ItemVo> list(){//페이징처리는 나중에
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ItemVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_item";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int item_num=rs.getInt("item_num");
					String item_name=rs.getString("item_name");
					int cate_num=rs.getInt("cate_num");
					String item_info=rs.getString("item_info");
					int item_price=rs.getInt("item_price");
					String item_orgimg=rs.getString("item_orgimg");
					String item_savimg=rs.getString("item_savimg");
					ItemVo vo=new ItemVo(item_num, item_name, cate_num,
							item_info, item_price, item_orgimg,
							item_savimg);
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
