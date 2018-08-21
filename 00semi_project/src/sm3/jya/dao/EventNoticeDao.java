package sm3.jya.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.jya.vo.EventNoticeVo;

public class EventNoticeDao {
	//싱글톤패턴
	private static EventNoticeDao instance = new EventNoticeDao();
	private EventNoticeDao() {}
	public static EventNoticeDao getInstance() {
		return instance;
	}
//	public int insert(EventNoticeVo vo) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		
//		
//	}
	public int getMaxNum() {    //가장큰수얻어오기.
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(num),0) maxnum from SM3_EVENT_NOTICE";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) { //값이 없을리가 없다.
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
	//검색해서 나온 데이터갯수
	public int getCount(String search,String keyword) {  //검색된 데이터 갯수.
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			con=DBConnection.getConn();
			if(keyword.equals("")) { //검색어 없으면 전체목록보여줌.
				String sql="select NVL(count(num),0) cnt from SM3_EVENT_NOTICE";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
			}else {  //검색된게 있으면
				String searchCase="";
				if(search.equals("title")) {
					searchCase=" =? ";
				}else {
					searchCase=" like '%'||?||'%' "; //부분검색, 특정 단어나 글씨 검색.
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
	//검색하고 리스트보여주기
	public ArrayList<EventNoticeVo> list(int startRow,int endRow, String search, String keyword){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EventNoticeVo> list = new ArrayList<>();
		try {
			con=DBConnection.getConn();
			if(search.equals("")) { //전체리스트
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
				}else{ //검색했을때 리스트보이기.
					String searchCase="";
					if(search.equals("title")) { //제목을 검색하면..
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
							" WHERE " +search+" "+searchCase+
							" order by EN_NUM DESC" +
							")AA" +
							")" +
							"WHERE RNUM<=? AND RNUM<=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, keyword);
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
					rs=pstmt.executeQuery();
			}
			if(rs.next()) {
				do {
					int EN_NUM = rs.getInt("EN_NUM");
					String EN_WRITER = rs.getString("EN_WRITER");
					String EN_TITLE = rs.getString("EN_TITLE");
					Long EN_CONTENT = rs.getLong("EN_CONTENT");
					Date EN_DATE = rs.getDate("EN_DATE");
					String EN_ORGIMG = rs.getString("EN_ORGIMG");
					String EN_SAVIMG = rs.getString("EN_SAVIMG");
					int ADMIN_NUM = rs.getInt("ADMIN_NUM");
					EventNoticeVo vo = new EventNoticeVo(EN_NUM,EN_WRITER,EN_TITLE,EN_CONTENT,EN_DATE,EN_ORGIMG,EN_SAVIMG,ADMIN_NUM);
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
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
	
	
	

