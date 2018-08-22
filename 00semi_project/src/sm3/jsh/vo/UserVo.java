package sm3.jsh.vo;

import java.sql.Date;

//SM3_USER ���̺�
public class UserVo {
	private int user_num; //������ȣ
	private String user_id; //�������̵�
	private String user_pwd; //������й�ȣ
	private String user_name; //�����̸�
	private String user_email; //�����̸���
	private String user_phone; //������ȭ��ȣ
	private String user_addr; //�����ּ�
	private Date user_regdate; //������
	private String hint_num; //��й�ȣ ã��
	private String hint_ok; //��й�ȣ ã�� ��
	
	public UserVo() {}
	
	public UserVo(int user_num, String user_id, String user_pwd, String user_name, String user_email, String user_phone,
			String user_addr, Date user_regdate, String hint_num, String hint_ok) {
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.user_addr = user_addr;
		this.user_regdate = user_regdate;
		this.hint_num = hint_num;
		this.hint_ok = hint_ok;
	}
	
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	public Date getUser_regdate() {
		return user_regdate;
	}
	public void setUser_regdate(Date user_regdate) {
		this.user_regdate = user_regdate;
	}
	public String getHint_num() {
		return hint_num;
	}
	public void setHint_num(String hint_num) {
		this.hint_num = hint_num;
	}
	public String getHint_ok() {
		return hint_ok;
	}
	public void setHint_ok(String hint_ok) {
		this.hint_ok = hint_ok;
	}
}
