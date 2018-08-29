package sm3.lsu.vo;

import java.sql.Date;

public class QaCommVo {
private int comm_num;
private String comm_writer;
private String comm_content;
private Date comm_date;
private int qa_num;
private int user_num;
private int admin_num;

public QaCommVo() {}

public QaCommVo(int comm_num, String comm_writer, String comm_content, Date comm_date, int qa_num, int user_num,
		int admin_num) {
	super();
	this.comm_num = comm_num;
	this.comm_writer = comm_writer;
	this.comm_content = comm_content;
	this.comm_date = comm_date;
	this.qa_num = qa_num;
	this.user_num = user_num;
	this.admin_num = admin_num;
}

public int getComm_num() {
	return comm_num;
}

public void setComm_num(int comm_num) {
	this.comm_num = comm_num;
}

public String getComm_writer() {
	return comm_writer;
}

public void setComm_writer(String comm_writer) {
	this.comm_writer = comm_writer;
}

public String getComm_content() {
	return comm_content;
}

public void setComm_content(String comm_content) {
	this.comm_content = comm_content;
}

public Date getComm_date() {
	return comm_date;
}

public void setComm_date(Date comm_date) {
	this.comm_date = comm_date;
}

public int getQa_num() {
	return qa_num;
}

public void setQa_num(int qa_num) {
	this.qa_num = qa_num;
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