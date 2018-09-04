package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.ldk.vo.ItemCateVo;

public class ItemCateDao {
	private static ItemCateDao instance=new ItemCateDao();
	private ItemCateDao() {}
	public static ItemCateDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(cate_num),0) maxnum from sm3_itemcate";
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
	public int getCount(String search,String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			if(keyword.equals("")) {
				String sql="select NVL(count(cate_num),0) cnt from sm3_itemcate";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
			}else {
				String searchCase="";
				if(search.equals("cate_num")) {
					searchCase=" =? ";
				}else {
					searchCase=" like '%'||?||'%' ";
				}
				String sql="select NVL(count(cate_num),0) cnt from sm3_itemcate "
						+ "where " + search + searchCase;
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
				rs=pstmt.executeQuery();
			}
			if(rs.next()) {
				return rs.getInt("cnt");
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
	public int insert(String cate_name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="insert into sm3_itemcate values(?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum()+1);
			pstmt.setString(2, cate_name);
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
	public int delete(int cate_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="delete from sm3_itemcate where cate_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, cate_num);
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
	public int update(ItemCateVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="update sm3_itemcate set cate_name=? where cate_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getCate_name());
			pstmt.setInt(2, vo.getCate_num());
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
	public ItemCateVo select(int cate_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_itemcate where cate_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, cate_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String cate_name=rs.getString("cate_name");
				ItemCateVo vo=new ItemCateVo(cate_num, cate_name);
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
	public ArrayList<ItemCateVo> list(int startRow,int endRow,
			String search,String keyword){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ItemCateVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			if(search.equals("")) {
				String sql="SELECT *" + 
						"FROM" + 
						"(" + 
						"    SELECT AA.*,ROWNUM RNUM" + 
						"    FROM" + 
						"    (" + 
						"        SELECT *" + 
						"        FROM SM3_ITEMCATE" + 
						"        ORDER BY CATE_NUM DESC" + 
						"    )AA" + 
						")" + 
						"WHERE RNUM>=? AND RNUM<=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs=pstmt.executeQuery();
			}else {
				String searchCase="";
				if(search.equals("cate_num")) {
					searchCase=" =? ";
				}else {
					searchCase=" like '%'||?||'%' ";
				}
				String sql="SELECT *" + 
						"FROM" + 
						"(" + 
						"    SELECT AA.*,ROWNUM RNUM" + 
						"    FROM" + 
						"    (" + 
						"        SELECT *" + 
						"        FROM SM3_ITEMCATE" +
						"		 WHERE " + search + " " + searchCase +
						"        ORDER BY CATE_NUM DESC" + 
						"    )AA" + 
						")" + 
						"WHERE RNUM>=? AND RNUM<=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rs=pstmt.executeQuery();
			}
			if(rs.next()) {
				do {
					int cate_num=rs.getInt("cate_num");
					String cate_name=rs.getString("cate_name");
					ItemCateVo vo=new ItemCateVo(cate_num, cate_name);
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
