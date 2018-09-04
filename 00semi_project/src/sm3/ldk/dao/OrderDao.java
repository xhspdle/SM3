package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.BatchDBConnection;
import sm3.dbcp.DBConnection;
import sm3.ldk.vo.OrderVo;

public class OrderDao {
	private static OrderDao instance=new OrderDao();
	private OrderDao() {}
	public static OrderDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(order_num),0) maxnum from sm3_order";
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
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	public int getCount(String search,String keyword) {//페이징처리
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			if(keyword.equals("")) {
				String sql="select NVL(count(order_num),0) cnt from sm3_order";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
			}else {
				String searchCase="";
				if(search.equals("order_num") || search.equals("user_num")) {
					searchCase=" =? ";
				}else {
					searchCase=" like '%'||?||'%' ";
				}
				String sql="select NVL(count(order_num),0) cnt from sm3_order "
						+ "where " + search + searchCase;
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
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	public int insert(OrderVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="insert into sm3_order values(?,?,?,?,?,?,?,?,?,?,?,sysdate,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum()+1);
			pstmt.setInt(2, vo.getUser_num());
			pstmt.setInt(3, vo.getPur_num());
			pstmt.setInt(4, vo.getOrder_total());
			pstmt.setInt(5, vo.getOrder_point());
			pstmt.setInt(6, vo.getOrder_pay());
			pstmt.setString(7, vo.getOrder_recipient());
			pstmt.setString(8, vo.getOrder_post_addr());
			pstmt.setString(9, vo.getOrder_basic_addr());
			pstmt.setString(10, vo.getOrder_detail_addr());
			pstmt.setString(11, vo.getOrder_phone());
			pstmt.setInt(12, vo.getOrder_status());
			/*	주문상태 : 
			1 배송중
			2 배송완료
			3 구매확정
			4 취소
			5 반품
			*/
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
	public int insertTest(OrderVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="insert into sm3_order values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum()+1);
			pstmt.setInt(2, vo.getUser_num());
			pstmt.setInt(3, vo.getPur_num());
			pstmt.setInt(4, vo.getOrder_total());
			pstmt.setInt(5, vo.getOrder_point());
			pstmt.setInt(6, vo.getOrder_pay());
			pstmt.setString(7, vo.getOrder_recipient());
			pstmt.setString(8, vo.getOrder_post_addr());
			pstmt.setString(9, vo.getOrder_basic_addr());
			pstmt.setString(10, vo.getOrder_detail_addr());
			pstmt.setString(11, vo.getOrder_phone());
			pstmt.setDate(12, vo.getOrder_date());
			pstmt.setInt(13, vo.getOrder_status());
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
	public int delete(int order_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="delete from sm3_order where order_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
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
	public int update(OrderVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="update sm3_order set user_num=?,pur_num=?,"
					+ "order_total=?,order_point=?,order_pay=?,"
					+ "order_recipient=?,"
					+ "order_post_addr=?,order_basic_addr=?,order_detail_addr=?,"
					+ "order_phone=?,order_status=? where order_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getUser_num());
			pstmt.setInt(2, vo.getPur_num());
			pstmt.setInt(3, vo.getOrder_total());
			pstmt.setInt(4, vo.getOrder_point());
			pstmt.setInt(5, vo.getOrder_pay());
			pstmt.setString(6, vo.getOrder_recipient());
			pstmt.setString(7, vo.getOrder_post_addr());
			pstmt.setString(8, vo.getOrder_basic_addr());
			pstmt.setString(9, vo.getOrder_detail_addr());
			pstmt.setString(10, vo.getOrder_phone());
			pstmt.setInt(11, vo.getOrder_status());
			pstmt.setInt(12, vo.getOrder_num());
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
	public int orderSizeCnt() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			con.setAutoCommit(false);
			String sql="SELECT *  " + 
					"FROM SM3_PURCHASE_LIST P,SM3_PURCHASE PU,SM3_ORDER O " + 
					"WHERE O.PUR_NUM=P.PUR_NUM AND P.PUR_NUM=PU.PUR_NUM AND ORDER_STATUS=3";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			int n=0;
			if(rs.next()) {
				do {
					int size_num=rs.getInt("size_num");
					int order_cnt=rs.getInt("order_cnt");
					n=ItemSizeDao.getInstance().updateCnt(con,size_num, order_cnt);
					if(n<=0) {
						con.rollback();
						return -3;
					}
				}while(rs.next());
			}
			con.commit();
			return n;
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
	public int user_update(int order_num,int order_status) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="update sm3_order set order_status = ? where order_num = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, order_status);
			pstmt.setInt(2, order_num);
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
	
	
	public int updateTotal(Connection con,int order_total,int pur_num) {
		PreparedStatement pstmt=null;
		try {
			String sql="update sm3_order set "
					+ "order_total=?,order_pay=? "
					+ "where pur_num=?";
			pstmt=con.prepareStatement(sql);
			int order_point=selectOrderPoint(con, pur_num);
			if(order_point<0) {
				return -1;
			}
			int order_pay=order_total-order_point;
			pstmt.setInt(1, order_total);
			pstmt.setInt(2, order_pay);
			pstmt.setInt(3, pur_num);
			return pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	public int selectOrderPoint(Connection con,int pur_num) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select order_point from sm3_order where pur_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pur_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("order_point");
			}
			return -1;
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	public OrderVo select(int order_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_order where order_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int user_num=rs.getInt("user_num");
				int pur_num=rs.getInt("pur_num");
				int order_total=rs.getInt("order_total");
				int order_point=rs.getInt("order_point");
				int order_pay=rs.getInt("order_pay");
				String order_recipient=rs.getString("order_recipient");
				String order_post_addr=rs.getString("order_post_addr");
				String order_basic_addr=rs.getString("order_basic_addr");
				String order_detail_addr=rs.getString("order_detail_addr");
				String order_phone=rs.getString("order_phone");
				Date order_date=rs.getDate("order_date");
				int order_status=rs.getInt("order_status");
				OrderVo vo=new OrderVo(order_num, user_num, pur_num,
						order_total, order_point, order_pay, order_recipient,
						order_post_addr, order_basic_addr, order_detail_addr,
						order_phone, order_date, order_status);
				return vo;
			}
			return null;
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
	public ArrayList<OrderVo> list(int startRow,int endRow,
			String search,String keyword){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<OrderVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			if(search.equals("")) {
				String sql="SELECT *" + 
						"FROM" + 
						"(" + 
						"    SELECT AA.*,ROWNUM RNUM" + 
						"    FROM" + 
						"    (" + 
						"        SELECT *" + 
						"        FROM SM3_ORDER" + 
						"        ORDER BY ORDER_NUM DESC" + 
						"    )AA" + 
						")" + 
						"WHERE RNUM>=? AND RNUM<=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				rs=pstmt.executeQuery();
			}else {
				String searchCase="";
				if(search.equals("order_num") || search.equals("user_num")) {
					searchCase=" =? ";
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
						"        FROM SM3_ORDER" +
						"		 WHERE " + search + " " + searchCase +
						"        ORDER BY ORDER_NUM DESC" + 
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
					int order_num=rs.getInt("order_num");
					int user_num=rs.getInt("user_num");
					int pur_num=rs.getInt("pur_num");
					int order_total=rs.getInt("order_total");
					int order_point=rs.getInt("order_point");
					int order_pay=rs.getInt("order_pay");
					String order_recipient=rs.getString("order_recipient");
					String order_post_addr=rs.getString("order_post_addr");
					String order_basic_addr=rs.getString("order_basic_addr");
					String order_detail_addr=rs.getString("order_detail_addr");
					String order_phone=rs.getString("order_phone");
					Date order_date=rs.getDate("order_date");
					int order_status=rs.getInt("order_status");
					OrderVo vo=new OrderVo(order_num, user_num, pur_num,
							order_total, order_point, order_pay, order_recipient,
							order_post_addr, order_basic_addr, order_detail_addr,
							order_phone, order_date, order_status);
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
}
