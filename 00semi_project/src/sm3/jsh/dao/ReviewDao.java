package sm3.jsh.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.jsh.vo.ReviewVo;

public class ReviewDao {
	// 싱글톤패턴
		private static ReviewDao instance = new ReviewDao();

		private ReviewDao() {
		}

		public static ReviewDao getInstance() {
			return instance;
		}

		
		public ArrayList<ReviewVo> list(int startRow, int endRow, String search, String keyword, String item_search) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
			try {
				con = DBConnection.getConn();
				if (search.equals("")) {
					String sql = 
							"SELECT * FROM "
							+ "(SELECT AA.*, ROWNUM RNUM FROM "
							+ "(SELECT RV.REVIEW_NUM, RV.REVIEW_ITEM, RV.REVIEW_ORGIMG, RV.REVIEW_SAVIMG, RV.REVIEW_RATING, RV.REVIEW_CONTENT, RV.REVIEW_DATE, US.USER_ID "
							+ "FROM SM3_REVIEW RV, SM3_USER US WHERE RV.USER_NUM = US.USER_NUM AND RV.REVIEW_ITEM LIKE '%'||?||'%' ORDER BY RV.REVIEW_NUM DESC)AA) "
							+ "WHERE RNUM >= ? AND RNUM <= ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, item_search);
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
					rs = pstmt.executeQuery();
				} else {
					String searchCase = "";
					if (search.equals("writer")) {
						searchCase = " =  ?";
					} else {
						searchCase = "like '%'||?||'%'";
					}
					String sql=
							"SELECT * FROM "
							+ "(SELECT AA.*, ROWNUM RNUM FROM "
							+ "(SELECT RV.REVIEW_NUM, RV.REVIEW_ITEM, RV.REVIEW_ORGIMG, RV.REVIEW_SAVIMG, RV.REVIEW_RATING, RV.REVIEW_CONTENT, RV.REVIEW_DATE, US.USER_ID "
							+ "FROM SM3_REVIEW RV, SM3_USER US WHERE RV.USER_NUM = US.USER_NUM AND RV.REVIEW_ITEM LIKE '%'||?||'%' AND "+ search +""+ searchCase +"ORDER BY RV.REVIEW_NUM DESC)AA)"
							+ "WHERE RNUM >= ? AND RNUM <= ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, item_search);
					pstmt.setString(2, keyword);
					pstmt.setInt(3, startRow);
					pstmt.setInt(4, endRow);
					rs = pstmt.executeQuery();
				}
				if (rs.next()) {
					do {
						int review_num = rs.getInt(1);
						String review_item = rs.getString(2);
						String review_orgimg = rs.getString(3);
						String review_savimg = rs.getString(4);
						int review_rating = rs.getInt(5);
						String review_content = rs.getString(6);
						Date review_date = rs.getDate(7);
						String user_id = rs.getString(8);
						list.add(new ReviewVo(review_num, review_item, review_orgimg, review_savimg, review_rating, review_content, review_date, user_id));
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
		
		

		public int getCount(String search, String keyword) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DBConnection.getConn();
				if (search.equals("")) {
					String sql = "SELECT NVL(COUNT(REVIEW_NUM),0) FROM SM3_REVIEW";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
				} else {
					String searchCase = "";
					if (search.equals("writer")) {
						searchCase = " = ? ";
					} else {
						searchCase = "like '%'||?||'%'";
					}
					String sql = "SELECT NVL(COUNT(REVIEW_NUM),0) " + search + " " + searchCase + " FROM SM3_REVIEW";
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
		
		
		public int insert(ReviewVo vo) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBConnection.getConn();
				String sql = "insert into sm3_review values(?,?,?,?,?,?,sysdate,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, getMaxNum() + 1);
				pstmt.setString(2, vo.getReview_item());
				pstmt.setString(3, vo.getReview_orgimg());
				pstmt.setString(4, vo.getReview_saving());
				pstmt.setInt(5, vo.getReview_rating());
				pstmt.setString(6, vo.getReview_content());
				pstmt.setInt(7, vo.getOrder_num());
				pstmt.setInt(8, vo.getUser_num());
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
		
		public int getMaxNum() {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DBConnection.getConn();
				String sql = "select NVL(max(review_num),0) maxnum from sm3_review";
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
		
}
