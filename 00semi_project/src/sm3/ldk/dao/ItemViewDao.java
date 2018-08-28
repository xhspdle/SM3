package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import sm3.dbcp.DBConnection;
import sm3.ldk.vo.ItemViewVo;

public class ItemViewDao {
	private static ItemViewDao instance=new ItemViewDao();
	private ItemViewDao() {}
	public static ItemViewDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(item_num),0) maxnum from sm3_item_view";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("maxnum");
			}
			return -1;
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
	public int getCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(count(item_num),0) cnt from sm3_item_view";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			return -1;
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
	public ArrayList<ItemViewVo> select(int item_num) {//수정...리턴 ItemViewVo가 아니라 ArrayList<>임!
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ItemViewVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_item_view where item_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, item_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int cate_num=rs.getInt("cate_num");
					String cate_name=rs.getString("cate_name");
					String item_name=rs.getString("item_name");
					String item_info=rs.getString("item_info");
					int item_price=rs.getInt("item_price");
					String item_orgimg=rs.getString("item_orgimg");
					String item_savimg=rs.getString("item_savimg");
					int size_num=rs.getInt("size_num");
					String size_name=rs.getString("size_name");
					int size_cnt=rs.getInt("size_cnt");
					int color_num=rs.getInt("color_num");
					String color_name=rs.getString("color_name");
					String color_code=rs.getString("color_code");
					ItemViewVo vo=new ItemViewVo(cate_num, cate_name,
							item_num, item_name, item_info, item_price,
							item_orgimg, item_savimg, size_num, size_name,
							size_cnt, color_num, color_name, color_code);
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
	
	public ArrayList<ItemViewVo> select_cate(int cate_num) {//카테번호로 셀렉트
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ItemViewVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_item_view where cate_num=? order by size_num";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, cate_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					cate_num=rs.getInt("cate_num");
					String cate_name=rs.getString("cate_name");
					int item_num = rs.getInt("item_num");
					String item_name=rs.getString("item_name");
					String item_info=rs.getString("item_info");
					int item_price=rs.getInt("item_price");	
					String item_orgimg=rs.getString("item_orgimg");
					String item_savimg=rs.getString("item_savimg");
					int size_num=rs.getInt("size_num");
					String size_name=rs.getString("size_name");
					int size_cnt=rs.getInt("size_cnt");
					int color_num=rs.getInt("color_num");
					String color_name=rs.getString("color_name");
					String color_code=rs.getString("color_code");
					ItemViewVo vo=new ItemViewVo(cate_num, cate_name,
							item_num, item_name, item_info, item_price,
							item_orgimg, item_savimg, size_num, size_name,
							size_cnt, color_num, color_name, color_code);
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
	
	

	public HashMap<Integer, String> select_color(String item_name) {//컬러넘버 셀렉트
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		HashMap<Integer, String> list=new HashMap<Integer, String>();
		try {
			con=DBConnection.getConn();
			String sql="SELECT DISTINCT ITEM_NUM, COLOR_CODE FROM SM3_ITEM_VIEW WHERE ITEM_NAME LIKE '%'||?||'%'";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, item_name);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int item_num = rs.getInt(1);
					String color_code=rs.getString(2);
					list.put(item_num, color_code);
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
	
	
	
	public ArrayList<ItemViewVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ItemViewVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_item_view";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int item_num=rs.getInt("item_num");
					int cate_num=rs.getInt("cate_num");
					String cate_name=rs.getString("cate_name");
					String item_name=rs.getString("item_name");
					String item_info=rs.getString("item_info");
					int item_price=rs.getInt("item_price");
					String item_orgimg=rs.getString("item_orgimg");
					String item_savimg=rs.getString("item_savimg");
					int size_num=rs.getInt("size_num");
					String size_name=rs.getString("size_name");
					int size_cnt=rs.getInt("size_cnt");
					int color_num=rs.getInt("color_num");
					String color_name=rs.getString("color_name");
					String color_code=rs.getString("color_code");
					ItemViewVo vo=new ItemViewVo(cate_num, cate_name,
							item_num, item_name, item_info, item_price,
							item_orgimg, item_savimg, size_num, size_name,
							size_cnt, color_num, color_name, color_code);
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
