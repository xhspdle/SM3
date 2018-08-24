package sm3.ldk.vo;

public class AdminVo {
	private int admin_num;
	private String admin_id;
	private String admin_pwd;
	public AdminVo() {}
	public AdminVo(int admin_num, String admin_id, String admin_pwd) {
		super();
		this.admin_num = admin_num;
		this.admin_id = admin_id;
		this.admin_pwd = admin_pwd;
	}
	public int getAdmin_num() {
		return admin_num;
	}
	public void setAdmin_num(int admin_num) {
		this.admin_num = admin_num;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_pwd() {
		return admin_pwd;
	}
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	@Override
	public String toString() {
		return "AdminVo [admin_num=" + admin_num + ", admin_id=" + admin_id + ", admin_pwd=" + admin_pwd + "]";
	}
}
