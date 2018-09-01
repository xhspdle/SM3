package sm3.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sm3.dbcp.BatchDBConnection;

public class BatchDB {
	public int batchPur() {
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		try {
			con=BatchDBConnection.getConn();
			con.setAutoCommit(false);
			String sql1="DELETE FROM SM3_PURCHASE_LIST P " + 
					"WHERE P.PUR_NUM " + 
					"IN " + 
					"(" + 
					"    SELECT * " + 
					"    FROM SM3_PURCHASE PU " + 
					"    WHERE NOT EXISTS (SELECT * FROM SM3_ORDER O WHERE O.PUR_NUM=PU.PUR_NUM) " + 
					")";
			String sql2="DELETE FROM SM3_PURCHASE PU " + 
					"WHERE NOT EXISTS (SELECT * FROM SM3_ORDER O WHERE O.PUR_NUM=PU.PUR_NUM)";
			pstmt1=con.prepareStatement(sql1);
			pstmt2=con.prepareStatement(sql2);
			int n1=pstmt1.executeUpdate();
			int n2=pstmt2.executeUpdate();
			if(n1>0 && n2>0) {
				con.commit();
				return n1+n2;
			}else {
				con.rollback();
				return -2;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
		}finally {
			try {
				if(pstmt2!=null) pstmt2.close();
				if(pstmt1!=null) pstmt1.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
}
