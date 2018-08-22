package sm3.jya.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.jya.vo.EventNoticeVo;
import sm3.ldk.vo.ItemVo;

public class EventNoticeDao {
	//싱글톤패턴
	private static EventNoticeDao instance = new EventNoticeDao();
	private EventNoticeDao() {}
	public static EventNoticeDao getInstance() {
		return instance;
	}
	public int getMaxNum() {     //가장큰수얻어오기.
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(en_num),0) maxnum from sm3_event_notice";
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
	public int insert(EventNoticeVo vo) {
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="insert into sm3_event_notice values(?,?,?,?,sysdate,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum()+1);
			pstmt.setString(2, vo.getEn_writer());
			pstmt.setString(3, vo.getEn_title());
			pstmt.setString(4, vo.getEn_content());
			pstmt.setString(5, vo.getEn_orgimg());
			pstmt.setString(6, vo.getEn_savimg());
			pstmt.setInt(7, vo.getAdmin_num());
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public int delete(int en_num) {
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="delete from sm3_event_notice where en_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, en_num);
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
	public int update(EventNoticeVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="update sm3_event_notice set en_title=?,"
					  +"en_content=?, en_orgimg=? en_savimg=? where en_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getEn_title());
			pstmt.setString(2, vo.getEn_content());
			pstmt.setString(3, vo.getEn_orgimg());
			pstmt.setString(4, vo.getEn_savimg());
			pstmt.setInt(5, vo.getEn_num());
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
	public EventNoticeVo getinfo(int en_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con=DBConnection.getConn();
			String sql = "select *from sm3_event_notice where en_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, en_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String en_writer=rs.getString("en_writer");
				String en_title=rs.getString("en_title");
				String en_content=rs.getString("en_content");
				Date en_date = rs.getDate("en_date");
				String en_orgimg = rs.getString("en_orgimg");
				String en_savimg = rs.getString("en_savimg");
				int admin_num = rs.getInt("admin_num");
				EventNoticeVo vo = new EventNoticeVo(en_num, en_writer, en_title, en_content,en_date, en_orgimg, en_savimg, admin_num);
				return vo;
			}
			return null;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
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
	}
	//검색해서 나온 데이터갯수
	public int getCount(String search,String keyword) {  //검색된 데이터 갯수.
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			con=DBConnection.getConn();
			if(keyword.equals("")) { //검색어 없으면 전체목록보여줌.
				String sql="select NVL(count(num),0) cnt from sm3_event_notice";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
			}else {  //검색된게 있으면
				String searchCase="";
				if(search.equals("title")) {
					searchCase=" =? ";
				}else {
					searchCase=" like '%'||?||'%' "; //부분검색, 특정 단어나 글씨 검색.
				}
					String sql="select NVL(count(num),0) cnt from sm3_event_notice"
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
	public ArrayList<EventNoticeVo> list(){ //파일업로드한 리스트
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		ArrayList<EventNoticeVo> list = new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select *from sm3_event_notice";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int en_num = rs.getInt("en_num");
					String en_writer = rs.getString("en_writer");
					String en_title = rs.getString("en_title");
					String en_content = rs.getString("en_content");
					Date en_date = rs.getDate("en_date");
					String en_orgimg = rs.getString("en_orgimg");
					String en_savimg = rs.getString("en_savimg");
					int admin_num = rs.getInt("admin_num");
					EventNoticeVo vo = new EventNoticeVo(en_num, en_writer, en_title, en_content,en_date, en_orgimg, en_savimg, admin_num);
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
			}catch(SQLException se) {
				System.out.println(se.getMessage());
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
					int en_num = rs.getInt("en_num");
					String en_writer = rs.getString("en_writer");
					String en_title = rs.getString("en_title");
					String en_content = rs.getString("en_content");
					Date en_date = rs.getDate("en_date");
					String en_orgimg = rs.getString("en_orgimg");
					String en_savimg = rs.getString("en_savimg");
					int admin_num = rs.getInt("admin_num");
					EventNoticeVo vo = new EventNoticeVo(en_num, en_writer, en_title, en_content, 
							en_date, en_orgimg, en_savimg, admin_num);
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
	//페이징처리..ㅎㅎ..
	
}
	
	
	

