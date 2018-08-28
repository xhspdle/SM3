package sm3.jya.vo;

import java.util.Date;

public class EventNoticeVo {
	private int en_num;
	private String en_writer;
	private String en_title;
	private String en_content;
	private Date en_date;
	private String en_orgimg;
	private String en_savimg;
	private int admin_num;
	
	public EventNoticeVo () {}

	public EventNoticeVo(int en_num, String en_writer, String en_title, String en_content, Date en_date,
			String en_orgimg, String en_savimg, int admin_num) {
		super();
		this.en_num = en_num;
		this.en_writer = en_writer;
		this.en_title = en_title;
		this.en_content = en_content;
		this.en_date = en_date;
		this.en_orgimg = en_orgimg;
		this.en_savimg = en_savimg;
		this.admin_num = admin_num;
	}

	public int getEn_num() {
		return en_num;
	}

	public void setEn_num(int en_num) {
		this.en_num = en_num;
	}

	public String getEn_writer() {
		return en_writer;
	}

	public void setEn_writer(String en_writer) {
		this.en_writer = en_writer;
	}

	public String getEn_title() {
		return en_title;
	}

	public void setEn_title(String en_title) {
		this.en_title = en_title;
	}

	public String getEn_content() {
		return en_content;
	}

	public void setEn_content(String en_content) {
		this.en_content = en_content;
	}

	public Date getEn_date() {
		return en_date;
	}

	public void setEn_date(Date en_date) {
		this.en_date = en_date;
	}

	public String getEn_orgimg() {
		return en_orgimg;
	}

	public void setEn_orgimg(String en_orgimg) {
		this.en_orgimg = en_orgimg;
	}

	public String getEn_savimg() {
		return en_savimg;
	}

	public void setEn_savimg(String en_savimg) {
		this.en_savimg = en_savimg;
	}

	public int getAdmin_num() {
		return admin_num;
	}

	public void setAdmin_num(int admin_num) {
		this.admin_num = admin_num;
	}

	@Override
	public String toString() {
		return "EventNoticeVo [en_num=" + en_num + ", en_writer=" + en_writer + ", en_title=" + en_title
				+ ", en_content=" + en_content + ", en_date=" + en_date + ", en_orgimg=" + en_orgimg + ", en_savimg="
				+ en_savimg + ", admin_num=" + admin_num + "]";
	}
}