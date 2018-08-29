package sm3.jsh.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.jsh.vo.UserVo;

public class UserDao {
	// 싱글톤패턴
	private static UserDao instance = new UserDao();

	private UserDao() {
	}

	public static UserDao getInstance() {
		return instance;
	}

	public int getCount(String search, String keyword) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConn();
			if (search.equals("")) {
				String sql = "SELECT NVL(COUNT(USER_NUM),0) FROM SM3_USER";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
			} else {
				String searchCase = "";
				if (search.equals("writer")) {
					searchCase = " = ? ";
				} else {
					searchCase = "like '%'||?||'%'";
				}
				String sql = "SELECT NVL(COUNT(USER_NUM),0) " + search + " " + searchCase + " FROM SM3_USER";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}
			if (rs.next()) {
				int cnt = rs.getInt(1);
				return cnt;
			}
			return 0;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return 0;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}

	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConn();
			String sql = "select NVL(max(user_num),0) maxnum from sm3_user";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 값이 없을리가 없다.
				return rs.getInt("maxnum");
			}
			return 0;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}

	public int update(UserVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getConn();
			String sql = "update SM3_USER set user_pwd= ?, user_name = ?, user_email = ?, user_phone = ?, user_post_addr=?, user_basic_addr=?, user_detail_addr=?, hint_num = ?, hint_ok = ? where user_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getUser_pwd());
			pstmt.setString(2, vo.getUser_name());
			pstmt.setString(3, vo.getUser_email());
			pstmt.setString(4, vo.getUser_phone());
			pstmt.setString(5, vo.getUser_post_addr());
			pstmt.setString(6, vo.getUser_basic_addr());
			pstmt.setString(7, vo.getUser_detail_addr());
			pstmt.setInt(8, vo.getHint_num());
			pstmt.setString(9, vo.getHint_ok());
			pstmt.setInt(10, vo.getUser_num());
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

	public int delete(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getConn();
			String sql = "DELETE FROM SM3_USER WHERE USER_NUM = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
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

	public int insert(UserVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getConn();
			String sql = "insert into sm3_user values(?,?,?,?,?,?,?,?,?,sysdate,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum() + 1);
			pstmt.setString(2, vo.getUser_id());
			pstmt.setString(3, vo.getUser_pwd());
			pstmt.setString(4, vo.getUser_name());
			pstmt.setString(5, vo.getUser_email());
			pstmt.setString(6, vo.getUser_phone());
			pstmt.setString(7, vo.getUser_post_addr());
			pstmt.setString(8, vo.getUser_basic_addr());
			pstmt.setString(9, vo.getUser_detail_addr());
			pstmt.setInt(10, vo.getHint_num());
			pstmt.setString(11, vo.getHint_ok());
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

	public ArrayList<UserVo> list(int startRow, int endRow, String search, String keyword) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UserVo> list = new ArrayList<UserVo>();
		try {
			con = DBConnection.getConn();
			if (search.equals("")) {
				String sql = "SELECT * FROM " + "(SELECT AA.*, ROWNUM RNUM FROM "
						+ "(SELECT * FROM SM3_USER ORDER BY USER_NUM DESC)AA) " + "WHERE RNUM >= ? AND RNUM <= ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs = pstmt.executeQuery();
			} else {
				String searchCase = "";
				if (search.equals("writer")) {
					searchCase = " =  ?";
				} else {
					searchCase = "like '%'||?||'%'";
				}
				String sql = "SELECT * FROM " + "(SELECT AA.*, ROWNUM RNUM FROM " + "(SELECT * FROM SM3_USER WHERE "
						+ search + "" + searchCase + " ORDER BY USER_NUM DESC)AA)" + "WHERE RNUM >= ? AND RNUM <= ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, keyword);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rs = pstmt.executeQuery();
			}
			if (rs.next()) {
				do {
					int user_num = rs.getInt(1);
					String user_id = rs.getNString(2);
					String user_pwd = rs.getNString(3);
					String user_name = rs.getNString(4);
					String user_email = rs.getNString(5);
					String user_phone = rs.getNString(6);
					String user_post_addr = rs.getNString(7);
					String user_basic_addr = rs.getNString(8);
					String user_detail_addr = rs.getNString(9);
					Date user_regdate = rs.getDate(10);
					int hint_num = rs.getInt(11);
					String hint_ok = rs.getNString(12);
					list.add(new UserVo(user_num, user_id, user_pwd, user_name, user_email, user_phone, user_post_addr,
							user_basic_addr, user_detail_addr, user_regdate, hint_num, hint_ok));
				} while (rs.next());
				return list;
			} else {
				return null;
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}

	public UserVo getinfo(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConn();
			String sql = "SELECT * FROM SM3_USER WHERE USER_NUM = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int user_num = rs.getInt(1);
				String user_id = rs.getNString(2);
				String user_pwd = rs.getNString(3);
				String user_name = rs.getNString(4);
				String user_email = rs.getNString(5);
				String user_phone = rs.getNString(6);
				String user_post_addr = rs.getNString(7);
				String user_basic_addr = rs.getNString(8);
				String user_detail_addr = rs.getNString(9);
				Date user_regdate = rs.getDate(10);
				int hint_num = rs.getInt(11);
				String hint_ok = rs.getNString(12);
				return new UserVo(user_num, user_id, user_pwd, user_name, user_email, user_phone, user_post_addr,
						user_basic_addr, user_detail_addr, user_regdate, hint_num, hint_ok);

			}
			return null;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}

	public ArrayList<UserVo> allView(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UserVo> list = new ArrayList<UserVo>();
		try {
			con = DBConnection.getConn();
			String sql = "SELECT * FROM SM3_USER";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					int user_num = rs.getInt(1);
					String user_id = rs.getNString(2);
					String user_pwd = rs.getNString(3);
					String user_name = rs.getNString(4);
					String user_email = rs.getNString(5);
					String user_phone = rs.getNString(6);
					String user_post_addr = rs.getNString(7);
					String user_basic_addr = rs.getNString(8);
					String user_detail_addr = rs.getNString(9);
					Date user_regdate = rs.getDate(10);
					int hint_num = rs.getInt(11);
					String hint_ok = rs.getNString(12);
					list.add(new UserVo(user_num, user_id, user_pwd, user_name, user_email, user_phone, user_post_addr,
							user_basic_addr, user_detail_addr, user_regdate, hint_num, hint_ok));
				} while (rs.next());
				return list;
			}
			return null;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	
	
	public ArrayList<String> idSearch() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> idList = new ArrayList<String>();
		try {
			con = DBConnection.getConn();
			String sql = "SELECT USER_ID FROM SM3_USER";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					String id = rs.getNString(1);
					idList.add(id);
				} while (rs.next());
				return idList;
			}
			return null;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}

	}

}
