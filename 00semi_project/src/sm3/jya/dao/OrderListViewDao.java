package sm3.jya.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.jya.vo.OrderListViewVo;

public class OrderListViewDao {
	private static OrderListViewDao instance = new OrderListViewDao();

	private OrderListViewDao() {
	}

	public static OrderListViewDao getInstance() {
		return instance;
	}

	public int getMaxNum() {  
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConn();
			String sql = "select NVL(max(order_num),0) maxnum from sm3_orderlist_view";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
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
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConn();
			String sql = "select NVL(count(order_num),0) cnt from sm3_orderlist_view";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt");
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

	public ArrayList<OrderListViewVo> select(int order_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderListViewVo> list = new ArrayList<>();
		try {
			con = DBConnection.getConn();
			String sql = "select * from sm3_orderlist_view where order_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					int order_num1 = rs.getInt("order_num");
					int user_num = rs.getInt("user_num");
					int pur_num = rs.getInt("pur_num");
					int item_num = rs.getInt("item_num");
					String item_name = rs.getString("item_name");
					String item_savimg = rs.getString("item_savimg");
					String item_info = rs.getString("item_info");
					int order_cnt = rs.getInt("order_cnt");
					int order_pay = rs.getInt("order_pay");
					String order_recipient = rs.getString("order_recipient");
					String order_phone = rs.getString("order_phone");
					String order_basic_addr = rs.getString("order_basic_addr");
					String order_detail_addr = rs.getString("order_detail_addr");
					int order_point = rs.getInt("order_point");
					int order_status = rs.getInt("order_status");
					Date order_date = rs.getDate("order_date");
					OrderListViewVo vo = new OrderListViewVo(order_num1, user_num, item_num,pur_num, item_name, item_savimg,
							item_info, order_cnt, order_pay, order_recipient, order_phone, order_basic_addr,
							order_detail_addr, order_point, order_status, order_date);
					list.add(vo);
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

	public ArrayList<OrderListViewVo> list() { // 전체리스트를 보여주는.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderListViewVo> list = new ArrayList<>();
		try {
			con = DBConnection.getConn();
			String sql = "select *from sm3_orderlist_view";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					int order_num1 = rs.getInt("order_num");
					int user_num = rs.getInt("user_num");
					int pur_num = rs.getInt("pur_num");
					int item_num = rs.getInt("item_num");
					String item_name = rs.getString("item_name");
					String item_savimg = rs.getString("item_savimg");
					String item_info = rs.getString("item_info");
					int order_cnt = rs.getInt("order_cnt");
					int order_pay = rs.getInt("order_pay");
					String order_recipient = rs.getString("order_recipient");
					String order_phone = rs.getString("order_phone");
					String order_basic_addr = rs.getString("order_basic_addr");
					String order_detail_addr = rs.getString("order_detail_addr");
					int order_point = rs.getInt("order_point");
					int order_status = rs.getInt("order_status");
					Date order_date = rs.getDate("order_date");
					OrderListViewVo vo = new OrderListViewVo(order_num1, user_num, pur_num, item_num, item_name, item_savimg,
							item_info, order_cnt, order_pay, order_recipient, order_phone, order_basic_addr,
							order_detail_addr, order_point, order_status, order_date);
					list.add(vo);
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

	public ArrayList<OrderListViewVo> listUser(int user_num) { // 로그인한 사용자의 주문내역을 보여줌.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderListViewVo> list = new ArrayList<>();
		try {
			con = DBConnection.getConn();
			String sql = "select *from sm3_orderlist_view where user_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					int order_num1 = rs.getInt("order_num");
					int pur_num = rs.getInt("pur_num");
					int item_num = rs.getInt("item_num");
					String item_name = rs.getString("item_name");
					String item_savimg = rs.getString("item_savimg");
					String item_info = rs.getString("item_info");
					int order_cnt = rs.getInt("order_cnt");
					int order_pay = rs.getInt("order_pay");
					String order_recipient = rs.getString("order_recipient");
					String order_phone = rs.getString("order_phone");
					String order_basic_addr = rs.getString("order_basic_addr");
					String order_detail_addr = rs.getString("order_detail_addr");
					int order_point = rs.getInt("order_point");
					int order_status = rs.getInt("order_status");
					Date order_date = rs.getDate("order_date");
					OrderListViewVo vo = new OrderListViewVo(order_num1, user_num, item_num,  pur_num, item_name, item_savimg,
							item_info, order_cnt, order_pay, order_recipient, order_phone, order_basic_addr,
							order_detail_addr, order_point, order_status, order_date);
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

	public ArrayList<OrderListViewVo> getInfoList(int order_num) { // 로그인한 사용자의 주문내역을 보여줌.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderListViewVo> list=new ArrayList<>();
		try {
			con = DBConnection.getConn();
			String sql = "select *from sm3_orderlist_view where order_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					order_num = rs.getInt("order_num");
					int user_num = rs.getInt("user_num");
					int pur_num = rs.getInt("pur_num");
					int item_num = rs.getInt("item_num");
					String item_name = rs.getString("item_name");
					String item_savimg = rs.getString("item_savimg");
					String item_info = rs.getString("item_info");
					int order_cnt = rs.getInt("order_cnt");
					int order_pay = rs.getInt("order_pay");
					String order_recipient = rs.getString("order_recipient");
					String order_phone = rs.getString("order_phone");
					String order_basic_addr = rs.getString("order_basic_addr");
					String order_detail_addr = rs.getString("order_detail_addr");
					int order_point = rs.getInt("order_point");
					int order_status = rs.getInt("order_status");
					Date order_date = rs.getDate("order_date");
					OrderListViewVo vo=new OrderListViewVo(order_num, user_num, pur_num, item_num, item_name, item_savimg, item_info, order_cnt,
							order_pay, order_recipient, order_phone, order_basic_addr, order_detail_addr, order_point,
							order_status, order_date);
					list.add(vo);
				}while(rs.next());
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
	public OrderListViewVo getInfo(int order_num) { 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConn();
			String sql = "select *from sm3_orderlist_view where order_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				order_num = rs.getInt("order_num");
				int user_num = rs.getInt("user_num");
				int pur_num = rs.getInt("pur_num");
				int item_num = rs.getInt("item_num");
				String item_name = rs.getString("item_name");
				String item_savimg = rs.getString("item_savimg");
				String item_info = rs.getString("item_info");
				int order_cnt = rs.getInt("order_cnt");
				int order_pay = rs.getInt("order_pay");
				String order_recipient = rs.getString("order_recipient");
				String order_phone = rs.getString("order_phone");
				String order_basic_addr = rs.getString("order_basic_addr");
				String order_detail_addr = rs.getString("order_detail_addr");
				int order_point = rs.getInt("order_point");
				int order_status = rs.getInt("order_status");
				Date order_date = rs.getDate("order_date");
				OrderListViewVo vo=new OrderListViewVo(order_num, user_num, pur_num, item_num, item_name, item_savimg, item_info, order_cnt,
						order_pay, order_recipient, order_phone, order_basic_addr, order_detail_addr, order_point,
						order_status, order_date);
				return vo;			
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

	public int getCount(int user_num) {// 로그인한 사용자의 주문목록 수를 센다.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConn();
			String sql = "select NVL(count(order_num),0) cnt " + "from sm3_orderlist_view where user_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt");
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
	
	public int getCountMonth(int user_num,int sDate) {  //달별로 주문수를 셈.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConn();
			String sql = "select NVL(count(order_num),0) cnt from sm3_orderlist_view where user_num= ? and sysdate - ?  <  order_date order by order_date desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_num);
			pstmt.setInt(2, sDate);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int n=rs.getInt("cnt");
				return n;
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

	public ArrayList<OrderListViewVo> list(int user_num, int startRow, int endRow) { // 로그인한 사용자의 주문내역 목록 보기.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderListViewVo> list = new ArrayList<>();
		try {
			con = DBConnection.getConn();
			String sql = "select *" + "from" + "(" + " select aa.*,rownum rnum" + " from" + " (" + " select *"
					+ " from sm3_orderlist_view" + " where user_num=?" + " order by order_date desc" + " )aa" + ")"
					+ "where rnum>=? and rnum<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_num);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					int order_num1 = rs.getInt("order_num");
					int pur_num = rs.getInt("pur_num");
					int item_num = rs.getInt("item_num");
					String item_name = rs.getString("item_name");
					String item_savimg = rs.getString("item_savimg");
					String item_info = rs.getString("item_info");
					int order_cnt = rs.getInt("order_cnt");
					int order_pay = rs.getInt("order_pay");
					String order_recipient = rs.getString("order_recipient");
					String order_phone = rs.getString("order_phone");
					String order_basic_addr = rs.getString("order_basic_addr");
					String order_detail_addr = rs.getString("order_detail_addr");
					int order_point = rs.getInt("order_point");
					int order_status = rs.getInt("order_status");
					Date order_date = rs.getDate("order_date");
					OrderListViewVo vo = new OrderListViewVo(order_num1, user_num, pur_num, item_num, item_name, item_savimg,
							item_info, order_cnt, order_pay, order_recipient, order_phone, order_basic_addr,
							order_detail_addr, order_point, order_status, order_date);
					list.add(vo);
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
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	//1,3페이징처리.
	public ArrayList<OrderListViewVo> Monthlist(int user_num,int sDate, int startRow, int endRow) { // 로그인한 사용자의 주문내역 목록 보기.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderListViewVo> list = new ArrayList<>();
		try {
			con = DBConnection.getConn();
			String sql = "select *" + "from" + "(" + " select aa.*,rownum rnum" + " from" + " (" + " select *"
					+ " from sm3_orderlist_view" + " where user_num=? and sysdate - ?  <  order_date" + " order by order_date desc" + " )aa" + ")"
					+ "where rnum>=? and rnum<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_num);
			pstmt.setInt(2, sDate);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					int order_num1 = rs.getInt("order_num");
					int pur_num = rs.getInt("pur_num");
					int item_num = rs.getInt("item_num");
					String item_name = rs.getString("item_name");
					String item_savimg = rs.getString("item_savimg");
					String item_info = rs.getString("item_info");
					int order_cnt = rs.getInt("order_cnt");
					int order_pay = rs.getInt("order_pay");
					String order_recipient = rs.getString("order_recipient");
					String order_phone = rs.getString("order_phone");
					String order_basic_addr = rs.getString("order_basic_addr");
					String order_detail_addr = rs.getString("order_detail_addr");
					int order_point = rs.getInt("order_point");
					int order_status = rs.getInt("order_status");
					Date order_date = rs.getDate("order_date");
					OrderListViewVo vo = new OrderListViewVo(order_num1, user_num, pur_num, item_num, item_name, item_savimg,
							item_info, order_cnt, order_pay, order_recipient, order_phone, order_basic_addr,
							order_detail_addr, order_point, order_status, order_date);
					list.add(vo);
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
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// 날짜 출력하기.(1개월,3개월 단위로 데이터 목록 보는거)
	public ArrayList<OrderListViewVo> orderMonth(int user_num, int sDate) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderListViewVo> list = new ArrayList<>();
		try {
			con = DBConnection.getConn();
			String sql = "select * from sm3_orderlist_view where user_num =? and sysdate - ?  <  order_date order by order_date desc ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_num);
			pstmt.setInt(2, sDate);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					int order_num1 = rs.getInt("order_num");
					int pur_num = rs.getInt("pur_num");
					int item_num = rs.getInt("item_num");
					String item_name = rs.getString("item_name");
					String item_savimg = rs.getString("item_savimg");
					String item_info = rs.getString("item_info");
					int order_cnt = rs.getInt("order_cnt");
					int order_pay = rs.getInt("order_pay");
					String order_recipient = rs.getString("order_recipient");
					String order_phone = rs.getString("order_phone");
					String order_basic_addr = rs.getString("order_basic_addr");
					String order_detail_addr = rs.getString("order_detail_addr");
					int order_point = rs.getInt("order_point");
					int order_status = rs.getInt("order_status");
					Date order_date = rs.getDate("order_date");
					OrderListViewVo vo = new OrderListViewVo(order_num1, user_num, pur_num, item_num, item_name, item_savimg,
							item_info, order_cnt, order_pay, order_recipient, order_phone, order_basic_addr,
							order_detail_addr, order_point, order_status, order_date);
					list.add(vo);
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
	
}