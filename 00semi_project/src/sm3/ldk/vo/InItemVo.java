package sm3.ldk.vo;

import java.sql.Date;

public class InItemVo {
	private int in_num;
	private int size_num;
	private int admin_num;
	private int in_cnt;
	private int in_cost;
	private Date in_date;
	public InItemVo() {}
	public InItemVo(int in_num, int size_num, int admin_num, int in_cnt, int in_cost, Date in_date) {
		super();
		this.in_num = in_num;
		this.size_num = size_num;
		this.admin_num = admin_num;
		this.in_cnt = in_cnt;
		this.in_cost = in_cost;
		this.in_date = in_date;
	}
	public int getIn_num() {
		return in_num;
	}
	public void setIn_num(int in_num) {
		this.in_num = in_num;
	}
	public int getSize_num() {
		return size_num;
	}
	public void setSize_num(int size_num) {
		this.size_num = size_num;
	}
	public int getAdmin_num() {
		return admin_num;
	}
	public void setAdmin_num(int admin_num) {
		this.admin_num = admin_num;
	}
	public int getIn_cnt() {
		return in_cnt;
	}
	public void setIn_cnt(int in_cnt) {
		this.in_cnt = in_cnt;
	}
	public int getIn_cost() {
		return in_cost;
	}
	public void setIn_cost(int in_cost) {
		this.in_cost = in_cost;
	}
	public Date getIn_date() {
		return in_date;
	}
	public void setIn_date(Date in_date) {
		this.in_date = in_date;
	}
	@Override
	public String toString() {
		return "InItemVo [in_num=" + in_num + ", size_num=" + size_num + ", admin_num=" + admin_num + ", in_cnt="
				+ in_cnt + ", in_cost=" + in_cost + ", in_date=" + in_date + "]";
	}
}
