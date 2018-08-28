package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			String sql="select NVL(max(order_num_num),0) maxnum from sm3_order";
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
			/*	�ֹ����� : 
			1 �����
			2 ��ۿϷ�
			3 ����Ȯ��
			4 ���
			5 ��ǰ
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
					+ "order_post_addr=?,oder_basic_addr=?,order_detail_addr=?,"
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
	public ArrayList<OrderVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<OrderVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_order";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
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