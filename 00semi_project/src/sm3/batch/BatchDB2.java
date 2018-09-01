package sm3.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.BatchDBConnection;
import sm3.ldk.dao.ItemSizeDao;

public class BatchDB2 {
	public int batchCnt() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=BatchDBConnection.getConn();
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
}
