package sm3.jsh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sm3.dbcp.DBConnection;
import sm3.jsh.vo.HintVo;

public class HintDao {
	private static HintDao instance=new HintDao();
	private HintDao() {}
	public static HintDao getInstance() {
		return instance;
	}
	public ArrayList<HintVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<HintVo> list=new ArrayList<>();
		try {
			con=DBConnection.getConn();
			String sql="select * from sm3_hint";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					int hint_num=rs.getInt("hint_num");
					String hint_q=rs.getString("hint_q");
					HintVo vo=new HintVo(hint_num, hint_q);
					list.add(vo);
				}while(rs.next());
				return list;
			}else {
				return null;
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return null;
		}
	}
}
