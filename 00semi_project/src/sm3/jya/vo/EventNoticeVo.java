package sm3.jya.vo;

import java.util.Date;

public class EventNoticeVo {
	private int EN_NUM;
	private String EN_WRITER;
	private String EN_TITLE;
	private long EN_CONTENT;
	private Date EN_DATE;
	private String EN_ORGIMG;
	private String EN_SAVIMG;
	private int ADMIN_NUM;
	
	public EventNoticeVo () {}

	public EventNoticeVo(int eN_NUM, String eN_WRITER, String eN_TITLE, long eN_CONTENT, Date eN_DATE, String eN_ORGIMG,
			String eN_SAVIMG, int aDMIN_NUM) {
		super();
		EN_NUM = eN_NUM;
		EN_WRITER = eN_WRITER;
		EN_TITLE = eN_TITLE;
		EN_CONTENT = eN_CONTENT;
		EN_DATE = eN_DATE;
		EN_ORGIMG = eN_ORGIMG;
		EN_SAVIMG = eN_SAVIMG;
		ADMIN_NUM = aDMIN_NUM;
	}

	public int getEN_NUM() {
		return EN_NUM;
	}

	public void setEN_NUM(int eN_NUM) {
		EN_NUM = eN_NUM;
	}

	public String getEN_WRITER() {
		return EN_WRITER;
	}

	public void setEN_WRITER(String eN_WRITER) {
		EN_WRITER = eN_WRITER;
	}

	public String getEN_TITLE() {
		return EN_TITLE;
	}

	public void setEN_TITLE(String eN_TITLE) {
		EN_TITLE = eN_TITLE;
	}

	public long getEN_CONTENT() {
		return EN_CONTENT;
	}

	public void setEN_CONTENT(long eN_CONTENT) {
		EN_CONTENT = eN_CONTENT;
	}

	public Date getEN_DATE() {
		return EN_DATE;
	}

	public void setEN_DATE(Date eN_DATE) {
		EN_DATE = eN_DATE;
	}

	public String getEN_ORGIMG() {
		return EN_ORGIMG;
	}

	public void setEN_ORGIMG(String eN_ORGIMG) {
		EN_ORGIMG = eN_ORGIMG;
	}

	public String getEN_SAVIMG() {
		return EN_SAVIMG;
	}

	public void setEN_SAVIMG(String eN_SAVIMG) {
		EN_SAVIMG = eN_SAVIMG;
	}

	public int getADMIN_NUM() {
		return ADMIN_NUM;
	}

	public void setADMIN_NUM(int aDMIN_NUM) {
		ADMIN_NUM = aDMIN_NUM;
	}

	@Override
	public String toString() {
		return "SM3Vo [EN_NUM=" + EN_NUM + ", EN_WRITER=" + EN_WRITER + ", EN_TITLE=" + EN_TITLE + ", EN_CONTENT="
				+ EN_CONTENT + ", EN_DATE=" + EN_DATE + ", EN_ORGIMG=" + EN_ORGIMG + ", EN_SAVIMG=" + EN_SAVIMG
				+ ", ADMIN_NUM=" + ADMIN_NUM + "]";
	}
	
}
