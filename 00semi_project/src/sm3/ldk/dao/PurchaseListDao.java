package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.ldk.vo.OrderVo;
import sm3.ldk.vo.PurchaseListVo;

public class PurchaseListDao {
	private static PurchaseListDao instance=new PurchaseListDao();
	private PurchaseListDao() {}
	public static PurchaseListDao getInstance() {
		return instance;
	}
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select NVL(max(pl_num),0) maxnum from sm3_purchase_list";
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
	public int getCount(String search,String keyword,int pur_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			if(keyword.equals("")) {
				String sql="select NVL(count(pl_num),0) cnt from sm3_purchase_list where pur_num=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, pur_num);
				rs=pstmt.executeQuery();
			}else {
				String searchCase="";
				if(search.equals("size_num")) {
					searchCase=" =? ";
				}else {
					searchCase=" like '%'||?||'%' ";
				}
				String sql="select NVL(count(pl_num),0) cnt from sm3_purchase_list where pur_num=? "
						+ "and " + search + searchCase;
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, pur_num);
				pstmt.setString(2, keyword);
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
	public int insert(ArrayList<PurchaseListVo> list) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			con.setAutoCommit(false);
			int n=0;
			int pl_num=getMaxNum()+1;
			for(PurchaseListVo vo : list) {
				String sql="insert into sm3_purchase_list values(?,?,?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, pl_num++);
				pstmt.setInt(2, vo.getPur_num());
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
	public int delete(int pur_num) {//구매번호로 한방에 몽창 지우기
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			String sql="delete from sm3_purchase_list where pur_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pur_num);
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
	public int update(PurchaseListVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DBConnection.getConn();
			con.setAutoCommit(false);
			String sql="update sm3_purchase_list set pur_num=?,"
					+ "size_num=?,order_cnt=?,item_price=? where pl_num=?";
			pstmt=con.prepareStatement(sql);
			int pur_num=vo.getPur_num();
			pstmt.setInt(1, pur_num);
			pstmt.setInt(2, vo.getSize_num());
			pstmt.setInt(3, vo.getOrder_cnt());
			pstmt.setInt(4, vo.getItem_price());
			pstmt.setInt(5, vo.getPl_num());
			int n=pstmt.executeUpdate();
			if(n>0) {
				con.commit();
				ArrayList<PurchaseListVo> list=purNumList(pur_num);
				int order_total=0;
				if(list!=null) {
					for(PurchaseListVo voo:list) {
						order_total += voo.getItem_price()*voo.getOrder_cnt();
					}
					int nn=OrderDao.getInstance().updateTotal(con, order_total,pur_num);
					if(nn>0) {
						con.commit();
						return nn;
					}else {
						con.rollback();
						return -4;
					}
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
	public PurchaseListVo select(int pl_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_purchase_list where pl_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pl_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				int pur_num=rs.getInt("pur_num");
				int size_num=rs.getInt("size_num");
				int order_cnt=rs.getInt("order_cnt");
				int item_price=rs.getInt("item_price");
				PurchaseListVo vo=new PurchaseListVo(pl_num, pur_num,
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
	public ArrayList<PurchaseListVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<PurchaseListVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_purchase_list";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int pl_num=rs.getInt("pl_num");
					int pur_num=rs.getInt("pur_num");
					int size_num=rs.getInt("size_num");
					int order_cnt=rs.getInt("order_cnt");
					int item_price=rs.getInt("item_price");
					PurchaseListVo vo=new PurchaseListVo(pl_num, pur_num,
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
	public ArrayList<PurchaseListVo> purNumList(int pur_num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<PurchaseListVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_purchase_list where pur_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pur_num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int pl_num=rs.getInt("pl_num");
					int size_num=rs.getInt("size_num");
					int order_cnt=rs.getInt("order_cnt");
					int item_price=rs.getInt("item_price");
					PurchaseListVo vo=new PurchaseListVo(pl_num, pur_num,
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
	public ArrayList<PurchaseListVo> purNumListPaging(int pur_num,int startRow,int endRow,
			String search,String keyword){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<PurchaseListVo> list=new ArrayList<>();
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
						"        FROM SM3_PURCHASE_LIST" + 
						"		 WHERE PUR_NUM=? " +
						"        ORDER BY SIZE_NUM DESC" + 
						"    )AA" + 
						")" + 
						"WHERE RNUM>=? AND RNUM<=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, pur_num);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rs=pstmt.executeQuery();
			}else {
				String searchCase="";
				if(search.equals("size_num")) {
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
						"        FROM SM3_PURCHASE_LIST" +
						"		 WHERE PUR_NUM=? AND " + search + " " + searchCase +
						"        ORDER BY SIZE_NUM DESC" + 
						"    )AA" + 
						")" + 
						"WHERE RNUM>=? AND RNUM<=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, pur_num);
				pstmt.setString(2, keyword);
				pstmt.setInt(3, startRow);
				pstmt.setInt(4, endRow);
				rs=pstmt.executeQuery();
			}
			if(rs.next()) {
				do {
					int pl_num=rs.getInt("pl_num");
					int size_num=rs.getInt("size_num");
					int order_cnt=rs.getInt("order_cnt");
					int item_price=rs.getInt("item_price");
					PurchaseListVo vo=new PurchaseListVo(pl_num, pur_num,
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
