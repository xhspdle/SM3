package sm3.jsh.vo;

import java.sql.Date;

public class PointVo {
	private int order_num;
	private int user_num;
	private Date order_date;
	private int point;
	private Date end_date;
	
	public PointVo() {}
	
	public PointVo(int order_num, int user_num, Date order_date, int point, Date end_date) {
		super();
		this.order_num = order_num;
		this.user_num = user_num;
		this.order_date = order_date;
		this.point = point;
		this.end_date = end_date;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	
}
