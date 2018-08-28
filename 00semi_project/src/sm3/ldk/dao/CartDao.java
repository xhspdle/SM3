package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.ldk.vo.CartVo;

public class CartDao {
	private static CartDao instance=new CartDao();
	private CartDao() {}
	public static CartDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(cart_num),0) maxnum from sm3_cart";
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
	public int insert(ArrayList<CartVo> list) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			con.setAutoCommit(false);
			int n=0;
			int cart_num=getMaxNum()+1;
			for(CartVo vo : list) {
				String sql="insert into sm3_cart values(?,?,?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, cart_num++);
				pstmt.setInt(2, vo.getUser_num());
				pstmt.setInt(3, vo.getSize_num());
				pstmt.setInt(4, vo.getOrder_cnt());
				pstmt.setInt(5, vo.getItem_price());
				n=pstmt.executeUpdate();
				if(n<=0) {
					con.rollback();
					return -2;
				}
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
	public int delete(int user_num) {//유저번호로 한방에 몽창 지우기
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="delete from sm3_cart where user_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, user_num);
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
	public int update(CartVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="update sm3_cart set user_num=?,"
					+ "size_num=?,order_cnt=?,item_price=? where cart_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getUser_num());
			pstmt.setInt(2, vo.getSize_num());
			pstmt.setInt(3, vo.getOrder_cnt());
			pstmt.setInt(4, vo.getItem_price());
			pstmt.setInt(5, vo.getCart_num());
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
	public CartVo select(int cart_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_cart where cart_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, cart_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int user_num=rs.getInt("user_num");
				int size_num=rs.getInt("size_num");
				int order_cnt=rs.getInt("order_cnt");
				int item_price=rs.getInt("item_price");
				CartVo vo=new CartVo(cart_num, user_num,
						size_num, order_cnt, item_price);
				return vo;
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
	public ArrayList<CartVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<CartVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_cart";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int cart_num=rs.getInt("cart_num");
					int user_num=rs.getInt("user_num");
					int size_num=rs.getInt("size_num");
					int order_cnt=rs.getInt("order_cnt");
					int item_price=rs.getInt("item_price");
					CartVo vo=new CartVo(cart_num, user_num,
							size_num, order_cnt, item_price);
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
