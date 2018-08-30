package sm3.jsh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sm3.dbcp.DBConnection;
import sm3.jsh.vo.PointVo;
import sm3.ldk.dao.OrderDao;

public class PointDao {
	
	private static PointDao instance=new PointDao();
	private PointDao() {}
	public static PointDao getInstance() {
		return instance;
	}
	
	public int insert(PointVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getConn();
			String sql = "insert into sm3_point values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			/*pstmt.setInt(1, getMaxNum() + 1);
			pstmt.setString(2, vo.getUser_id());
			pstmt.setString(3, vo.getUser_pwd());*/
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
}
