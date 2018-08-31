package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.ldk.vo.InItemVo;
import sm3.ldk.vo.ItemSizeVo;

public class InItemDao {
	private static InItemDao instance=new InItemDao();
	private InItemDao() {}
	public static InItemDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(in_num),0) maxnum from sm3_in_item";
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
	public int insert(InItemVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			con.setAutoCommit(false);
			String sql="insert into sm3_in_item values(?,?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum()+1);
			pstmt.setInt(2, vo.getSize_num());
			pstmt.setInt(3, vo.getAdmin_num());
			pstmt.setInt(4, vo.getIn_cnt());
			pstmt.setInt(5, vo.getIn_cost());
			int n=pstmt.executeUpdate();
			if(n>0) {
				ItemSizeVo voo=ItemSizeDao.getInstance().select(vo.getSize_num());
				int nn=ItemSizeDao.getInstance().update(new ItemSizeVo(vo.getSize_num(),
						voo.getSize_name(), voo.getItem_num(), voo.getColor_num(),
						voo.getSize_cnt()+vo.getIn_cnt()));
				if(nn>0) {
					con.commit();
					return nn;
				}else {
					con.rollback();
					return -3;
				}
			}else {
				con.rollback();
				return -2;
			}
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
	public int insertTest(InItemVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			con.setAutoCommit(false);
			String sql="insert into sm3_in_item values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum()+1);
			pstmt.setInt(2, vo.getSize_num());
			pstmt.setInt(3, vo.getAdmin_num());
			pstmt.setInt(4, vo.getIn_cnt());
			pstmt.setInt(5, vo.getIn_cost());
			pstmt.setDate(6, vo.getIn_date());
			int n=pstmt.executeUpdate();
			if(n>0) {
				ItemSizeVo voo=ItemSizeDao.getInstance().select(vo.getSize_num());
				int nn=ItemSizeDao.getInstance().update(new ItemSizeVo(vo.getSize_num(),
						voo.getSize_name(), voo.getItem_num(), voo.getColor_num(),
						voo.getSize_cnt()+vo.getIn_cnt()));
				if(nn>0) {
					con.commit();
					return nn;
				}else {
					con.rollback();
					return -3;
				}
			}else {
				con.rollback();
				return -2;
			}
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
	public int delete(int in_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			con.setAutoCommit(false);
			String sql="delete from sm3_in_item where in_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, in_num);
			int n=pstmt.executeUpdate();
			if(n>0) {
				InItemVo vo=InItemDao.getInstance().select(in_num);
				ItemSizeVo voo=ItemSizeDao.getInstance().select(vo.getSize_num());
				int nn=ItemSizeDao.getInstance().update(new ItemSizeVo(vo.getSize_num(),
						voo.getSize_name(), voo.getItem_num(), voo.getColor_num(),
						voo.getSize_cnt()-vo.getIn_cnt()));
				if(nn>0) {
					con.commit();
					return nn;
				}else {
					con.rollback();
					return -3;
				}
			}else {
				con.rollback();
				return -2;
			}
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
	public int update(InItemVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			con.setAutoCommit(false);
			int old_cnt=InItemDao.getInstance().select(vo.getIn_num()).getIn_cnt();
			int new_cnt=vo.getIn_cnt();
			int differ_cnt=old_cnt-new_cnt;
			String sql="update sm3_in_item set size_num=?,"
					+ "admin_num=?,in_cnt=?,in_cost=? where in_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getSize_num());
			pstmt.setInt(2, vo.getAdmin_num());
			pstmt.setInt(3, new_cnt);
			pstmt.setInt(4, vo.getIn_cost());
			pstmt.setInt(5, vo.getIn_num());
			int n=pstmt.executeUpdate();
			if(n>0) {
				if(differ_cnt>0) {//1000
					ItemSizeVo voo=ItemSizeDao.getInstance().select(vo.getSize_num());
					int nn=ItemSizeDao.getInstance().update(new ItemSizeVo(vo.getSize_num(),
							voo.getSize_name(), voo.getItem_num(), voo.getColor_num(),
							voo.getSize_cnt()-differ_cnt));
					if(nn>0) {
						con.commit();
						return nn;
					}else {
						con.rollback();
						return -3;
					}
				}else if(differ_cnt==0) {
					con.commit();
					return n;
				}else {//-2000
					ItemSizeVo voo=ItemSizeDao.getInstance().select(vo.getSize_num());
					int nn=ItemSizeDao.getInstance().update(new ItemSizeVo(vo.getSize_num(),
							voo.getSize_name(), voo.getItem_num(), voo.getColor_num(),
							voo.getSize_cnt()-differ_cnt));
					if(nn>0) {
						con.commit();
						return nn;
					}else {
						con.rollback();
						return -3;
					}
				}
			}else {
				con.rollback();
				return -2;
			}
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
	public InItemVo select(int in_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_in_item where in_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, in_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int size_num=rs.getInt("size_num");
				int admin_num=rs.getInt("admin_num");
				int in_cnt=rs.getInt("in_cnt");
				int in_cost=rs.getInt("in_cost");
				Date in_date=rs.getDate("in_date");
				InItemVo vo=new InItemVo(in_num, size_num,
						admin_num, in_cnt, in_cost, in_date);
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
	public ArrayList<InItemVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<InItemVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_in_item";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int in_num=rs.getInt("in_num");
					int size_num=rs.getInt("size_num");
					int admin_num=rs.getInt("admin_num");
					int in_cnt=rs.getInt("in_cnt");
					int in_cost=rs.getInt("in_cost");
					Date in_date=rs.getDate("in_date");
					InItemVo vo=new InItemVo(in_num, size_num,
							admin_num, in_cnt, in_cost, in_date);
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
