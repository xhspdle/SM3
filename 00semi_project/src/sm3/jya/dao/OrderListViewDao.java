package sm3.jya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.jya.vo.OrderListViewVo;

public class OrderListViewDao {
	private static OrderListViewDao instance = new OrderListViewDao();
	private OrderListViewDao() {}
	public static OrderListViewDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(order_num),0) maxnum from sm3_orderlist_view";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("maxnum");
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
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	public int getCount() {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(count(order_num),0) cnt from sm3_orderlist_view";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
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
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	public ArrayList<OrderListViewVo> select(int order_num){
		Connection con=null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		ArrayList<OrderListViewVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_orderlist_view where order_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int order_num1=rs.getInt("order_num");
					int user_num=rs.getInt("user_num");
					int pur_num=rs.getInt("pur_num");
					String item_name=rs.getString("item_name");
					String item_savimg=rs.getString("item_savimg");
					String item_info=rs.getString("item_info");
					int order_cnt=rs.getInt("order_cnt");
					int order_pay=rs.getInt("order_pay");
					int order_status=rs.getInt("order_status");
					OrderListViewVo vo = new OrderListViewVo(order_num,user_num,pur_num,item_name,item_savimg,item_info,order_cnt,order_pay,order_status);
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
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	public ArrayList<OrderListViewVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		ArrayList<OrderListViewVo> list = new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select *from sm3_orderlist_view";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int order_num1=rs.getInt("order_num");
					int user_num=rs.getInt("user_num");
					int pur_num=rs.getInt("pur_num");
					String item_name=rs.getString("item_name");
					String item_savimg=rs.getString("item_savimg");
					String item_info=rs.getString("item_info");
					int order_cnt=rs.getInt("order_cnt");
					int order_pay=rs.getInt("order_pay");
					int order_status=rs.getInt("order_status");
					OrderListViewVo vo = new OrderListViewVo(order_num1,user_num,pur_num,item_name,item_savimg,item_info,order_cnt,order_pay,order_status);
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
//	public int delete(int order_num) {
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		try {
//			con=DBConnection.getConn();
//			String sql="delete from sm3_orderlist_view where order_num=?";
//			pstmt=con.prepareStatement(sql);
//			pstmt.setInt(1, order_num);
//			return pstmt.executeUpdate();
//		}catch(SQLException se) {
//			System.out.println(se.getMessage());
//			return -1;
//		}finally {
//			try {
//				if(pstmt!=null)pstmt.close();
//				if(con!=null)con.close();
//			}catch(SQLException se) {
//				System.out.println(se.getMessage());
//			}
//		}
//	}
//	public int update(OrderListViewVo vo) {
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		try {
//			con=DBConnection.getConn();
//			String sql="update sm3_orderlist_view set order_cnt=? where order_num=?";
//			pstmt=con.prepareStatement(sql);
//			pstmt.setInt(1, vo.getOrder_cnt());
//			pstmt.setInt(2, vo.getOrder_num());
//			return pstmt.executeUpdate();
//	}catch(SQLException se) {
//		System.out.println(se.getMessage());
//		return -1;
//	}finally {
//		try {
//			if(pstmt!=null)pstmt.close();
//			if(con!=null)con.close();
//		}catch(SQLException se) {
//			System.out.println(se.getMessage());
//		}
//	  }
//	}
	public int getCount(String search,String keyword) {//검색
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			con=DBConnection.getConn();
			if(keyword.equals("")) {
				String sql="select NVL(count(order_num),0) cnt from sm3_orderlist_view";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
			}else {
				String searchCase="";
				if(search.equals("title")) {
					searchCase=" =? ";
				}else {
					searchCase=" like '%'||?||'%' ";
				}
				String sql="select NVL(count(order_num),0) cnt from sm3_orderlist_view"
							+ "where " +search+searchCase;
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
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}   
		}
	}
	//검색페이지 검색리스트보이기
	public ArrayList<OrderListViewVo> list(int startRow,int endRow,String search,String keyword){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderListViewVo> list = new ArrayList<>();
		try {
			con=DBConnection.getConn();
			if(search.equals("")) {
				String sql="select *" +
						"from" +
						"(" +
						" select aa.*,rownum rnum" +
						" from" +
						" (" +
						" select *" +
						" sm3_orderlist_view" +
						" order by order_num desc" +
						" )aa" +
						")" +
						"where rnum>=? and rnum<=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs=pstmt.executeQuery();
			}else {
				String searchCase="";
				if(search.equals("title")) {
					searchCase=" =?";
				}else {
					searchCase=" like '%'||?||'%' ";
				}
				String sql="SELECT *" + 
						"FROM" + 
						"(" + 
						"    SELECT AA.*,ROWNUM RNUM" + 
						"    FROM" + 
						"    (" + 
						"        SELECT *" + 
						"        FROM sm3_event_notice" + 
						"		 WHERE "+search+" "+searchCase+
						"        ORDER BY en_num DESC" + 
						"    )AA" + 
						")" + 
						"WHERE RNUM>=? AND RNUM<=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, keyword);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rs=pstmt.executeQuery();
			}
			if(rs.next()) {
				do {
					int order_num1=rs.getInt("order_num");
					int user_num=rs.getInt("user_num");
					int pur_num=rs.getInt("pur_num");
					String item_name=rs.getString("item_name");
					String item_savimg=rs.getString("item_savimg");
					String item_info=rs.getString("item_info");
					int order_cnt=rs.getInt("order_cnt");
					int order_pay=rs.getInt("order_pay");
					int order_status=rs.getInt("order_status");
					OrderListViewVo vo = new OrderListViewVo(order_num1,user_num,pur_num,item_name,item_savimg,item_info,order_cnt,order_pay,order_status);
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