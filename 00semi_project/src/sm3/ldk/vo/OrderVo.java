package sm3.ldk.vo;

import java.sql.Date;
//컬럼 수정해야댐
public class OrderVo {
	private int order_num;
	private int user_num;
	private int pur_num;
	private int order_total;
	private int order_point;//포인트사용액
	private int order_pay;//결제금액
	private String order_recipient;
	private String order_post_addr;
	private String order_basic_addr;
	private String order_detail_addr;
	private String order_phone;
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
	public OrderVo(int order_num, int user_num, int pur_num, int order_total, int order_point, int order_pay,
			String order_recipient, String order_post_addr, String order_basic_addr, String order_detail_addr,
			String order_phone, Date order_date, int order_status) {
		super();
		this.order_num = order_num;
		this.user_num = user_num;
		this.pur_num = pur_num;
		this.order_total = order_total;
		this.order_point = order_point;
		this.order_pay = order_pay;
		this.order_recipient = order_recipient;
		this.order_post_addr = order_post_addr;
		this.order_basic_addr = order_basic_addr;
		this.order_detail_addr = order_detail_addr;
		this.order_phone = order_phone;
		this.order_date = order_date;
		this.order_status = order_status;
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
	public int getPur_num() {
		return pur_num;
	}
	public void setPur_num(int pur_num) {
		this.pur_num = pur_num;
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
	public String getOrder_recipient() {
		return order_recipient;
	}
	public void setOrder_recipient(String order_recipient) {
		this.order_recipient = order_recipient;
	}
	public String getOrder_post_addr() {
		return order_post_addr;
	}
	public void setOrder_post_addr(String order_post_addr) {
		this.order_post_addr = order_post_addr;
	}
	public String getOrder_basic_addr() {
		return order_basic_addr;
	}
	public void setOrder_basic_addr(String order_basic_addr) {
		this.order_basic_addr = order_basic_addr;
	}
	public String getOrder_detail_addr() {
		return order_detail_addr;
	}
	public void setOrder_detail_addr(String order_detail_addr) {
		this.order_detail_addr = order_detail_addr;
	}
	public String getOrder_phone() {
		return order_phone;
	}
	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
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
	@Override
	public String toString() {
		return "OrderVo [order_num=" + order_num + ", user_num=" + user_num + ", pur_num=" + pur_num + ", order_total="
				+ order_total + ", order_point=" + order_point + ", order_pay=" + order_pay + ", order_recipient="
				+ order_recipient + ", order_post_addr=" + order_post_addr + ", order_basic_addr=" + order_basic_addr
				+ ", order_detail_addr=" + order_detail_addr + ", order_phone=" + order_phone + ", order_date="
				+ order_date + ", order_status=" + order_status + "]";
	}
}
