package sm3.ldk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import sm3.ldk.vo.IndexViewVo;

public class IndexViewDao {
	private static IndexViewDao instance=new IndexViewDao();
	private IndexViewDao() {}
	public static IndexViewDao getInstance() {
		return instance;
	}
	public ArrayList<IndexViewVo> list() {
		Connection con=null;
		PreparedStatement pstmt=null;
		
	}
}
