package sm3.lsu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sm3.dbcp.DBConnection;
import sm3.lsu.vo.QaVo;

public class QaDao {
	private static QaDao instance=new QaDao();
	private QaDao() {}
	public static QaDao getInstance() {
		return instance;
	}
/*	public int select(UserVo vo) {
		Connection con=null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		con=DBConnection.getConn();
		//String sql="select * from sm3_user where user_num=?";
		 pstmt.setInt(1, vo.num());
		String user_id
				
	}*/
	public int insert(QaVo vo) {
		Connection con=null;
		PreparedStatement pstmt =null;
	try {
		con=DBConnection.getConn();
		//글번호, 작성자, 글제목,글내용,sysdate,부모글번호,그룹,등록순서,유저번호,관리자번호
		String sql="insert into sm3_qa values (?,?,?,?,sysdate,?,?,?,?,?)";
		
		pstmt.setInt(1, vo.getQa_num());
		pstmt.setString(2, vo.getQa_writer());
		pstmt.setString(3, vo.getQa_title());
		pstmt.setString(4, vo.getQa_content());
		pstmt.setDate(5, vo.getQa_date());
		pstmt.setInt(6, vo.getRef());
		pstmt.setInt(7, vo.getLev());
		pstmt.setInt(8, vo.getLev());
		//QaVo vo = new QaVo(qa_num, qa_writer, qa_title, qa_content, qa_date, ref, lev, step)			
		int n=0;
		return n;
        }catch (SQLException e) {
        	System.out.println(e.getMessage());		
		}
	return 0;
	}
}
