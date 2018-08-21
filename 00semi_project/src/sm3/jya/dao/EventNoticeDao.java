package sm3.jya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import sm3.dbcp.DBConnection;
import sm3.jya.vo.EventNoticeVo;

public class EventNoticeDao {
	//�̱�������
	private static EventNoticeDao instance = new EventNoticeDao();
	private EventNoticeDao() {}
	public static EventNoticeDao getInstance() {
		return instance;
	}
	public int getMaxNum() {    //����ū��������.
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(num),0) maxnum from SM3_EVENT_NOTICE";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) { //���� �������� ����.
				return rs.getInt("maxnum");
			}
			return 0;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	//�˻��ؼ� ���� �����Ͱ���
	public int getCount(String search,String keyword) {  //�˻��� ������ ����.
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			con=DBConnection.getConn();
			if(keyword.equals("")) { //�˻��� ������ ��ü��Ϻ�����.
				String sql="select NVL(count(num),0) cnt from SM3_EVENT_NOTICE";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
			}else {  //�˻��Ȱ� ������
				String searchCase="";
				if(search.equals("title")) {
					searchCase=" =? ";
				}else {
					searchCase=" like '%'||?||'%' "; //�κа˻�, Ư�� �ܾ �۾� �˻�.
				}
					String sql="select NVL(count(num),0) cnt from SM3_EVENT_NOTICE"
							+ "where" +search+searchCase;
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
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	//�˻��ϰ� ����Ʈ�����ֱ�
	public ArrayList<EventNoticeVo> list(int startRow,int endRow, String search, String keyword){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EventNoticeVo> list = new ArrayList<>();
		try {
			con=DBConnection.getConn();
			if(search.equals("")) { //��ü����Ʈ
			String sql = "select *from"
					+
					"("+ 
					"select AA.*,ROWNUM RNUM FROM" + 
					"("+ 
					"    SELECT *FROM SM3_EVENT_NOTICE" + 
					"    ORDER BY EN_NUM DESC" + 
					")AA" + 
					")"+
					"where rnum>=? and rnum<=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
				}else{ //�˻������� ����Ʈ���̱�.
					String searchCase="";
					if(search.equals("title")) { //������ �˻��ϸ�..
						searchCase=" =? ";
					}else {
						searchCase=" like '%'||?||'%' "; 
					}
					String sql="select *from"
							+
							"("+
							"select AA.*,rownum rnum from"+
							"("+
							" select *from SM3_EVENT_NOTICE" +
							" order by EN_NUM DESC" +
							")AA" +
							")" +
							"WHERE RNUM<=? AND RNUM<=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					rs=pstmt.executeQuery();
			}
		}
	}
}
	
	
	

