package sm3.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import sm3.ldk.dao.AdminDao;
import sm3.ldk.vo.AdminVo;

public class JunitTest {
	@Test
	public void adminList() throws Exception {
		ArrayList<AdminVo> list=AdminDao.getInstance().list(1, 10, "", "");
		assertNotNull(list);
	}
	@Test
	public void adminInsert() throws Exception {
		int n=AdminDao.getInstance().insert(new AdminVo(7, "junit", "1111"));
		assertEquals(n, 1);
	}
	@Test
	public void adminUpdate() throws Exception {
		int n=AdminDao.getInstance().update(new AdminVo(5, "junit4", "4444"));
		assertEquals(n, 1);
	}
	@Test
	public void adminSelect() throws Exception {
		AdminVo vo=AdminDao.getInstance().select(1);
		assertNotNull(vo);
	}
	@Test
	public void adminDelete() throws Exception {
		int n=AdminDao.getInstance().delete(6);
		assertEquals(n, 1);
	}
	
}
