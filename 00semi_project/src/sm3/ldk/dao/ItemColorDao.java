package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.ldk.vo.ItemColorVo;

public class ItemColorDao {
	private static ItemColorDao instance=new ItemColorDao();
	private ItemColorDao() {}
	public static ItemColorDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(color_num),0) maxnum from sm3_item_color";
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
				String sql="select NVL(count(color_num),0) cnt from sm3_item_color";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
			}else {
				String searchCase="";
				if(search.equals("color_num")) {
					searchCase=" =? ";
				}else {
					searchCase=" like '%'||?||'%' ";
				}
				String sql="select NVL(count(color_num),0) cnt from sm3_item_color "
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
	public int insert(ItemColorVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="insert into sm3_item_color values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum()+1);
			pstmt.setString(2, vo.getColor_name());
			pstmt.setString(3, vo.getColor_code());
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
	public int delete(int color_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="delete from sm3_item_color where color_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, color_num);
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
	public int update(ItemColorVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="update sm3_item_color set color_name=?,color_code=? where color_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getColor_name());
			pstmt.setString(2, vo.getColor_code());
			pstmt.setInt(3, vo.getColor_num());
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
	public ItemColorVo select(int color_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_item_color where color_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, color_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String color_name=rs.getString("color_name");
				String color_code=rs.getString("color_code");
				ItemColorVo vo=new ItemColorVo(color_num, color_name, color_code);
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
	public ArrayList<ItemColorVo> list(int startRow,int endRow,
			String search,String keyword){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ItemColorVo> list=new ArrayList<>();
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
						"        FROM SM3_ITEM_COLOR" + 
						"        ORDER BY COLOR_NUM DESC" + 
						"    )AA" + 
						")" + 
						"WHERE RNUM>=? AND RNUM<=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs=pstmt.executeQuery();
			}else {
				String searchCase="";
				if(search.equals("color_num")) {
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
						"        FROM SM3_ITEM_COLOR" +
						"		 WHERE " + search + " " + searchCase +
						"        ORDER BY COLOR_NUM DESC" + 
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
					int color_num=rs.getInt("color_num");
					String color_name=rs.getString("color_name");
					String color_code=rs.getString("color_code");
					ItemColorVo vo=new ItemColorVo(color_num, color_name,
							color_code);
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
