package sm3.ldk.vo;

import java.sql.Date;
//컬럼 수정해야댐
public class OrderVo {
	private int order_num;
	private int size_num;
	private int user_num;
	private int order_cnt;//주문수량
	private int item_price;
	private int order_total;//총금액
	private int order_point;//포인트사용액
	private int order_pay;//결제금액
	private String order_addr;
	private Date order_date;
	private int order_status;
	/*	주문상태 : 
		1 배송중
		2 배송완료
		3 구매확정
		4 취소
		5 반품
	 */
	public OrderVo() {}
	public OrderVo(int order_num, int size_num, int user_num, int order_cnt, int item_price, int order_total,
			int order_point, int order_pay, String order_addr, Date order_date, int order_status) {
		super();
		this.order_num = order_num;
		this.size_num = size_num;
		this.user_num = user_num;
		this.order_cnt = order_cnt;
		this.item_price = item_price;
		this.order_total = order_total;
		this.order_point = order_point;
		this.order_pay = order_pay;
		this.order_addr = order_addr;
		this.order_date = order_date;
		this.order_status = order_status;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public int getSize_num() {
		return size_num;
	}
	public void setSize_num(int size_num) {
		this.size_num = size_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
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
	public String getOrder_addr() {
		return order_addr;
	}
	public void setOrder_addr(String order_addr) {
		this.order_addr = order_addr;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public int getOrder_status() {
		return order_status;
	}
	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}
}
