package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.ldk.vo.ItemSizeVo;

public class ItemSizeDao {//사이즈번호 --> 재고번호
	private static ItemSizeDao instance=new ItemSizeDao();
	private ItemSizeDao() {}
	public static ItemSizeDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(size_num),0) maxnum from sm3_item_size";
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
	public int insert(ItemSizeVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="insert into sm3_item_size values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum()+1);
			pstmt.setString(2, vo.getSize_name());
			pstmt.setInt(3, vo.getItem_num());
			pstmt.setInt(4, vo.getColor_num());
			pstmt.setInt(5, vo.getSize_cnt());
			int n=pstmt.executeUpdate();
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
	public int delete(int size_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="delete from sm3_item_size where size_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, size_num);
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
	public int updateInfo(ItemSizeVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="update sm3_item_size set size_name=?,"
					+ "item_num=?,color_num=? where size_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getSize_name());
			pstmt.setInt(2, vo.getItem_num());
			pstmt.setInt(3, vo.getColor_num());
			pstmt.setInt(4, vo.getSize_num());
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
	public int update(ItemSizeVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="update sm3_item_size set size_name=?,"
					+ "item_num=?,color_num=?,size_cnt=? where size_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getSize_name());
			pstmt.setInt(2, vo.getItem_num());
			pstmt.setInt(3, vo.getColor_num());
			pstmt.setInt(4, vo.getSize_cnt());
			pstmt.setInt(5, vo.getSize_num());
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
	public int updateCnt(Connection con,int size_num,int order_cnt) {
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="update sm3_item_size set "
					+ "size_cnt=? where size_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, size_num);
			pstmt.setInt(2, order_cnt);
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
	public int updateColor(int color_num,int item_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="update sm3_item_size set "
					+ "color_num=? where item_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, color_num);
			pstmt.setInt(2, item_num);
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
	public ItemSizeVo select(int size_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_item_size where size_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, size_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String size_name=rs.getString("size_name");
				int item_num=rs.getInt("item_num");
				int color_num=rs.getInt("color_num");
				int size_cnt=rs.getInt("size_cnt");
				ItemSizeVo vo=new ItemSizeVo(size_num, size_name,
						item_num, color_num, size_cnt);
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
	public ArrayList<ItemSizeVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ItemSizeVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_item_size";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int size_num=rs.getInt("size_num");
					String size_name=rs.getString("size_name");
					int item_num=rs.getInt("item_num");
					int color_num=rs.getInt("color_num");
					int size_cnt=rs.getInt("size_cnt");
					ItemSizeVo vo=new ItemSizeVo(size_num, size_name,
							item_num, color_num, size_cnt);
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
