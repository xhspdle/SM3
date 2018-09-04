package sm3.ldk.vo;

import java.sql.Date;

public class SalesReportViewVo {
	private int order_num;
	private int order_total;
	private int order_point;
	private int order_pay;
	private Date order_date;
	private int order_cnt;
	private int item_price;
	private int in_cnt;
	private int in_cost;
	public SalesReportViewVo() {}
	public SalesReportViewVo(int order_num, int order_total, int order_point, int order_pay, Date order_date,
			int order_cnt, int item_price, int in_cnt, int in_cost) {
		super();
		this.order_num = order_num;
		this.order_total = order_total;
		this.order_point = order_point;
		this.order_pay = order_pay;
		this.order_date = order_date;
		this.order_cnt = order_cnt;
		this.item_price = item_price;
		this.in_cnt = in_cnt;
		this.in_cost = in_cost;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public int getOrder_total() {
		return order_total;
	}
	public void setOrder_total(int order_total) {
		this.order_total = order_total;
	}
	public int getOrder_point() {
		return order_point;
	}
	public void setOrder_point(int order_point) {
		this.order_point = order_point;
	}
	public int getOrder_pay() {
		return order_pay;
	}
	public void setOrder_pay(int order_pay) {
		this.order_pay = order_pay;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public int getOrder_cnt() {
		return order_cnt;
	}
	public void setOrder_cnt(int order_cnt) {
		this.order_cnt = order_cnt;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
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
	@Override
	public String toString() {
		return "SalesReportViewVo [order_num=" + order_num + ", order_total=" + order_total + ", order_point="
				+ order_point + ", order_pay=" + order_pay + ", order_date=" + order_date + ", order_cnt=" + order_cnt
				+ ", item_price=" + item_price + ", in_cnt=" + in_cnt + ", in_cost=" + in_cost + "]";
	}
}
