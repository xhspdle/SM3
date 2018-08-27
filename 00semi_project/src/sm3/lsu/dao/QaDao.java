package sm3.lsu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.lsu.vo.QaVo;

public class QaDao {
	private static QaDao instance = new QaDao();

	private QaDao() {
	}

	public static QaDao getInstance() {
		return instance;
	}
	/*
	 * public int select(UserVo vo) { Connection con=null; PreparedStatement pstmt=
	 * null; ResultSet rs= null; con=DBConnection.getConn(); //String
	 * sql="select * from sm3_user where user_num=?"; pstmt.setInt(1, vo.num());
	 * String user_id
	 * 
	 * }
	 */

	// insert 페이지에서 글작성 정보와, 유저아이디 DB저장
	public int maxnum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConn();
			String sql = "select NVL(max(qa_num),0) maxnum from sm3_qa";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getInt("maxnum"));
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
	public int getCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(count(qa_num),0) cnt from sm3_qa";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}else {
				return 0;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
			
		}
	}
	public int insert(QaVo vo, String user_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;

		try {
			// 로그인하면 아이디를 받아서 유저번호를 저장
			con = DBConnection.getConn();
			int boardNum=maxnum()+1;//추가될글번호
			int qa_num=vo.getQa_num();
			int ref=vo.getRef();
			int lev=vo.getLev();
			int step=vo.getStep();
			System.out.println(qa_num);
			if(qa_num==0) {
				System.out.println("boardNum:" + boardNum);
				ref=boardNum;
			}else {//답글인경우
				String sql3="update sm3_qa set step=step+1 where ref=? and step>?";
				pstmt3=con.prepareStatement(sql3);
				System.out.println("ref답글인경우:" + ref);
				pstmt3.setInt(1,ref);
				pstmt3.setInt(2,step);
				pstmt3.executeUpdate();
				lev+=1;
				step+=1;
			}	
			
			String sql2 = "select user_name, user_num from sm3_user where user_id=?";
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1, user_id);
			rs = pstmt2.executeQuery();
			String user_name = "";
			int user_num = 0;
			if (rs.next()) {
				user_name = rs.getString("user_name");
				user_num = rs.getInt("user_num");
			}
			// 글번호, 작성자, 글제목,글내용,sysdate,부모글번호,그룹,등록순서,유저번호,관리자번호
			String sql = "insert into sm3_qa values (?,?,?,?,sysdate,?,?,?,?,1)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			pstmt.setString(2, user_name);
			pstmt.setString(3, vo.getQa_title());
			pstmt.setString(4, vo.getQa_content());
			System.out.println("ref쿼리직전:" +ref);
			pstmt.setInt(5, ref);
			pstmt.setInt(6, lev);
			pstmt.setInt(7, step);
			pstmt.setInt(8, user_num);
			// pstmt.setInt(9, vo.getAdmin_num());

			int n = pstmt.executeUpdate();
			// QaVo vo = new QaVo(qa_num, qa_writer, qa_title, qa_content, qa_date, ref,
			// lev, step, user_num, admin_num)
			return n;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		}
		
	}

	public ArrayList<QaVo> Getlist(int startRow,int endRow) {
		String sql="SELECT * FROM " +
			    "(  " +
				"	   SELECT AA.*,ROWNUM RNUM FROM "+
				"	   ( "  +
				"	     SELECT * FROM sm3_qa " +
				"	     ORDER BY REF DESC,STEP ASC " +
				"	   )AA " +
				")" +
				" WHERE RNUM>=? AND RNUM<=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConn();
			
			pstmt = con.prepareStatement(sql);
			//페이징처리
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			
			rs = pstmt.executeQuery();
			ArrayList<QaVo> list = new ArrayList<>();
			while (rs.next()) {
				int qa_num = rs.getInt("qa_num");
				System.out.println("list num값확인" + rs.getInt("qa_num"));
				String qa_writer = rs.getString("qa_writer");
				String qa_title = rs.getString("qa_title");
				String qa_content = rs.getString("qa_content");
				int ref = rs.getInt("ref");
				int lev = rs.getInt("lev");
				int step = rs.getInt("step");
				Date qa_date = rs.getDate("qa_date");
				int user_num = rs.getInt("user_num");
				int admin_num = rs.getInt("admin_num");

				QaVo vo = new QaVo(qa_num, qa_writer, qa_title, qa_content, qa_date, ref, lev, step, user_num,
						admin_num);

				list.add(vo);
			}
			return list;
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

	public QaVo detail(int qa_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConn();
		String sql= "select * from sm3_qa where qa_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, qa_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
			qa_num=rs.getInt("qa_num");
			String qa_writer=rs.getString("qa_writer");
			String qa_title=rs.getString("qa_title");
			String qa_content=rs.getString("qa_content");
			int ref=rs.getInt("ref");
			int lev=rs.getInt("lev");
			int step=rs.getInt("step");
			
			int user_num=rs.getInt("user_num");
			
			QaVo vo= new QaVo(qa_num, qa_writer, qa_title, qa_content, null, ref, lev, step, user_num, 0);
			return vo;
			}			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
		return null;
	}
	// 글삭제
	public int delete(int qa_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBConnection.getConn();
			String sql = "delete from sm3_qa where qa_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qa_num);
			pstmt.executeUpdate();
			System.out.println("delete num값" + qa_num);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return qa_num;
	}
}
