package sm3.jsh.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.jsh.vo.PointVo;
import sm3.ldk.dao.OrderDao;
import sm3.ldk.vo.ItemViewVo;

public class PointDao {

	private static PointDao instance = new PointDao();
	private PointDao() {
	}
	public static PointDao getInstance() {
		return instance;
	}
	public int insert(PointVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getConn();
			String sql = "insert into sm3_point values(?,?,sysdate,?, sysdate + 180)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getOrder_num());
			pstmt.setInt(2, vo.getUser_num());
			pstmt.setInt(3, vo.getPoint());
			return pstmt.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public ArrayList<PointVo> select(int user_num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<PointVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_point where user_num= ? and sysdate < end_date" ;
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, user_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int order_num=rs.getInt(1);
					user_num=rs.getInt(2);
					Date order_date = rs.getDate(3);
					int point=rs.getInt(4);
					Date end_date = rs.getDate(5);
					list.add(new PointVo(order_num, user_num, order_date, point, end_date));
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
	
	public ArrayList<PointVo> allList(int user_num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<PointVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_point where user_num = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, user_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int order_num=rs.getInt(1);
					user_num=rs.getInt(2);
					Date order_date = rs.getDate(3);
					int point=rs.getInt(4);
					Date end_date = rs.getDate(5);
					list.add(new PointVo(order_num, user_num, order_date, point, end_date));
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
