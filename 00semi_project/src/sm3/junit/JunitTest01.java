package sm3.junit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import sm3.jya.dao.EventNoticeDao;
import sm3.jya.vo.EventNoticeVo;

public class JunitTest01 {
	@Test
	public void insert() throws Exception {
		int n=EventNoticeDao.getInstance().insert(new EventNoticeVo(1,"관리자","여름신제품","짧게",null,"2.jpg","2.jpg",3));
		assertEquals(n, 1);
	}
	@Test
	public void update() throws Exception {
		int n=EventNoticeDao.getInstance().update(new EventNoticeVo(4,"관리1","겨울신제품","보온",null,"4.jpg","4.jpg",5));
		assertEquals(n, 1);
	}
	@Test
	public void delete() throws Exception {
		int n=EventNoticeDao.getInstance().delete(5);
		assertEquals(n, 1);
	}
	@Test
	public void select() throws Exception{
		EventNoticeVo vo =EventNoticeDao.getInstance().select(3);
		assertNotNull(vo);
	}
	@Test
	public void list() throws Exception{
		ArrayList<EventNoticeVo> list=EventNoticeDao.getInstance().list(1,10,"","");
		assertNotNull(list);
	}
}
