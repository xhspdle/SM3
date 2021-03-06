package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.ldk.vo.AdminVo;

public class AdminDao {
	private static AdminDao instance=new AdminDao();
	private AdminDao() {}
	public static AdminDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			//con=BatchDBConnection.getConn();
			String sql="select NVL(max(admin_num),0) maxnum from sm3_admin";
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
	public int getCount(String search,String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			if(keyword.equals("")) {
				String sql="select NVL(count(admin_num),0) cnt from sm3_admin";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
			}else {
				String searchCase="";
				if(search.equals("admin_num")) {
					searchCase=" =? ";
				}else {
					searchCase=" like '%'||?||'%' ";
				}
				String sql="select NVL(count(admin_num),0) cnt from sm3_admin "
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
	public int insert(AdminVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			//con=BatchDBConnection.getConn();
			String sql="insert into sm3_admin values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum()+1);
			pstmt.setString(2, vo.getAdmin_id());
			pstmt.setString(3, vo.getAdmin_pwd());
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
	public int update(AdminVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			//con=BatchDBConnection.getConn();
			String sql="update sm3_admin set admin_id=?,admin_pwd=? where admin_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getAdmin_id());
			pstmt.setString(2, vo.getAdmin_pwd());
			pstmt.setInt(3, vo.getAdmin_num());
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
	public int delete(int admin_num) {//추후 admin_id랑 admin_pwd받아서 지우는걸로 수정
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			//con=BatchDBConnection.getConn();
			String sql="delete from sm3_admin where admin_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, admin_num);
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
	public AdminVo select(int admin_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			//con=BatchDBConnection.getConn();
			String sql="select * from sm3_admin where admin_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, admin_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return new AdminVo(admin_num, 
						rs.getString("admin_id"), rs.getString("admin_pwd"));
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
	public AdminVo login(AdminVo vo) {//리턴타입 String에서 다 담아서 보낼 수 있도록 AdminVo로 수정
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_admin where admin_id=? and admin_pwd=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getAdmin_id());
			pstmt.setString(2, vo.getAdmin_pwd());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int admin_num=rs.getInt("admin_num");
				String admin_id=rs.getString("admin_id");
				String admin_pwd=rs.getString("admin_pwd");
				AdminVo voo=new AdminVo(admin_num, admin_id, admin_pwd);
				return voo;
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
	public ArrayList<AdminVo> list(int startRow,int endRow,
			String search,String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<AdminVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			//con=BatchDBConnection.getConn();
			if(search.equals("")) {
				String sql="SELECT *" + 
						"FROM" + 
						"(" + 
						"    SELECT AA.*,ROWNUM RNUM" + 
						"    FROM" + 
						"    (" + 
						"        SELECT *" + 
						"        FROM SM3_ADMIN" + 
						"        ORDER BY ADMIN_NUM DESC" + 
						"    )AA" + 
						")" + 
						"WHERE RNUM>=? AND RNUM<=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs=pstmt.executeQuery();
			}else {
				String searchCase="";
				if(search.equals("admin_num")) {
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
						"        FROM SM3_ADMIN" +
						"		 WHERE " + search + " " + searchCase +
						"        ORDER BY ADMIN_NUM DESC" + 
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
					int admin_num=rs.getInt("admin_num");
					String admin_id=rs.getString("admin_id");
					String admin_pwd=rs.getString("admin_pwd");
					AdminVo vo=new AdminVo(admin_num, admin_id, admin_pwd);
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
