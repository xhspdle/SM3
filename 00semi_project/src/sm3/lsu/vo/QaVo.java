package sm3.lsu.vo;

import java.sql.Date;

public class QaVo {
	private int qa_num;
	private String qa_writer;
	private String qa_title;
	private String qa_content;
	private Date qa_date;
	private int ref;
	private int lev;
	private int step;
	private int user_num;
	private int admin_num;
	public QaVo() {}
	public QaVo(int qa_num, String qa_writer, String qa_title, String qa_content, Date qa_date, int ref, int lev,
			int step, int user_num, int admin_num) {
		super();
		this.qa_num = qa_num;
		this.qa_writer = qa_writer;
		this.qa_title = qa_title;
		this.qa_content = qa_content;
		this.qa_date = qa_date;
		this.ref = ref;
		this.lev = lev;
		this.step = step;
		this.user_num = user_num;
		this.admin_num = admin_num;
	}

	public int getQa_num() {
		return qa_num;
	}
	public void setQa_num(int qa_num) {
		this.qa_num = qa_num;
	}
	public String getQa_writer() {
		return qa_writer;
	}
	public void setQa_writer(String qa_writer) {
		this.qa_writer = qa_writer;
	}
	public String getQa_title() {
		return qa_title;
	}
	public void setQa_title(String qa_title) {
		this.qa_title = qa_title;
	}
	public String getQa_content() {
		return qa_content;
	}
	public void setQa_content(String qa_content) {
		this.qa_content = qa_content;
	}
	public Date getQa_date() {
		return qa_date;
	}
	public void setQa_date(Date qa_date) {
		this.qa_date = qa_date;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public int getAdmin_num() {
		return admin_num;
	}
	public void setAdmin_num(int admin_num) {
		this.admin_num = admin_num;
	}

	
}
