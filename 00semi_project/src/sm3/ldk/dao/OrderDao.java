package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.ldk.vo.OrderVo;
/*
 * 주문--> 배송지 주소API 사용...컬럼 수정 여기 수정 해야댐
 * 
 */
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
			String sql="insert into sm3_order values(?,?,?,?,?,?,?,?,?,sysdate,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum()+1);
			pstmt.setInt(2, vo.getSize_num());
			pstmt.setInt(3, vo.getUser_num());
			pstmt.setInt(4, vo.getOrder_cnt());
			pstmt.setInt(5, vo.getItem_price());
			pstmt.setInt(6, vo.getOrder_total());
			pstmt.setInt(7, vo.getOrder_point());
			pstmt.setInt(8, vo.getOrder_pay());
			pstmt.setString(9, vo.getOrder_addr());
			pstmt.setInt(10, vo.getOrder_status());
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
			String sql="update sm3_order set size_num=?,user_num=?,"
					+ "order_cnt=?,item_price=?,order_total=?,"
					+ "order_point=?,order_pay=?,order_addr=?,"
					+ "order_status=? where color_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getSize_num());
			pstmt.setInt(2, vo.getUser_num());
			pstmt.setInt(3, vo.getOrder_cnt());
			pstmt.setInt(4, vo.getItem_price());
			pstmt.setInt(5, vo.getOrder_total());
			pstmt.setInt(6, vo.getOrder_point());
			pstmt.setInt(7, vo.getOrder_pay());
			pstmt.setString(8, vo.getOrder_addr());
			pstmt.setInt(9, vo.getOrder_status());
			pstmt.setInt(10, vo.getOrder_num());
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
	public ItemColorVo select(int color_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_item_color where color_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, color_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String color_name=rs.getString("color_name");
				String color_code=rs.getString("color_code");
				ItemColorVo vo=new ItemColorVo(color_num, color_name, color_code);
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
	public ArrayList<ItemColorVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ItemColorVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_item_color";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int color_num=rs.getInt("color_num");
					String color_name=rs.getString("color_name");
					String color_code=rs.getString("color_code");
					ItemColorVo vo=new ItemColorVo(color_num, color_name,
							color_code);
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
