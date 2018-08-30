package sm3.lsu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.lsu.vo.QaCommVo;

public class QaCommDao {
	private static QaCommDao instance = new QaCommDao();

	private QaCommDao() {
	}

	public static QaCommDao getInstance() {
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

	
	public int maxnum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConn();
			String sql = "select NVL(max(comm_num),0) maxnum from sm3_qa_comm";
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
	public int insert(QaCommVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		System.out.println(+vo.getComm_num());
		System.out.println(vo.getComm_writer());
		System.out.println(vo.getComm_content());
		System.out.println(vo.getUser_num());
		System.out.println("°ü¸®ÀÚ"+vo.getAdmin_num());
	
		
		try {
		con=DBConnection.getConn();
		String sql="insert into sm3_qa_comm values(?,?,?,sysdate,?,?,?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, maxnum()+1);
		pstmt.setString(2, vo.getComm_writer());
		pstmt.setString(3, vo.getComm_content());
		pstmt.setInt(4, vo.getQa_num());
		pstmt.setInt(5, vo.getUser_num());
		pstmt.setInt(6, vo.getAdmin_num());
		System.out.println("gggggggg");
		int n=pstmt.executeUpdate();
		System.err.println("n:" + n);
		return n;
		}catch(SQLException se) {
		System.out.println(se.getMessage());
		return -1;
		}finally {
			try {
				if (pstmt != null)pstmt.close();
				if (con != null)con.close();		
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	public ArrayList<QaCommVo> Cmmdetail(int qa_num){
		 Connection con=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		
		 try {
			 con=DBConnection.getConn();
			 
			 String sql="select * from sm3_qa_comm where qa_num=?";
			 pstmt=con.prepareStatement(sql);
			 
			 pstmt.setInt(1, qa_num);
			 ArrayList<QaCommVo> list= new ArrayList<>();
			 
			 rs=pstmt.executeQuery();
			 while(rs.next()) {
				int comm_num=rs.getInt("comm_num");
				String comm_writer=rs.getString("comm_writer");
				String comm_content=rs.getString("comm_content");
			
				Date comm_date=rs.getDate("comm_date");			 
				qa_num=rs.getInt("qa_num");
				int user_num=rs.getInt("user_num");
				int admin_num=rs.getInt("admin_num");
				
				QaCommVo vo=new QaCommVo(comm_num, comm_writer, comm_content, comm_date, qa_num, user_num, admin_num);
				list.add(vo);		
				}
			 	 return list;
			 	 
		 }catch(SQLException se) {
			 System.out.println(se.getMessage());
			 return null;
		 }finally {
				try {
					if (pstmt != null)pstmt.close();
					if (con != null)con.close();		
				}catch(SQLException se) {
					System.out.println(se.getMessage());		
				}
		 }
	}
	public int delete (int comm_num) {
		Connection con=null;
		PreparedStatement pstmt =null;
		try {
		con=DBConnection.getConn();
		
		String sql="delete from sm3_qa_comm where comm_num=?";
		pstmt=con.prepareStatement(sql);
		
		pstmt.setInt(1, comm_num);
		int n=pstmt.executeUpdate();
		return n;
		
	}catch(SQLException se) {
		System.out.println(se.getMessage());
		return -1;
	}finally {
		try {
			if(pstmt != null)pstmt.close();
			if(con != null) con.close();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
	}
	}
}













	