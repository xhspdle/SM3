package sm3.jya.vo;

import java.sql.Date;

public class OrderListViewVo {
	private int order_num;
	private int user_num;
	private int pur_num;
	private int item_num;
	private String item_name;
	private String item_orgimg;
	private String item_info;
	private int order_cnt;
	private int order_pay;
	private String order_recipient;
	private String order_phone;
	private String order_basic_addr;
	private String order_detail_addr;
	private int order_point;
	private int order_status;
	private Date order_date;
	
	public OrderListViewVo() {}

	public OrderListViewVo(int order_num, int user_num, int pur_num, int item_num, String item_name, String item_orgimg,
			String item_info, int order_cnt, int order_pay, String order_recipient, String order_phone,
			String order_basic_addr, String order_detail_addr, int order_point, int order_status, Date order_date) {
		super();
		this.order_num = order_num;
		this.user_num = user_num;
		this.pur_num = pur_num;
		this.item_num = item_num;
		this.item_name = item_name;
		this.item_orgimg = item_orgimg;
		this.item_info = item_info;
		this.order_cnt = order_cnt;
		this.order_pay = order_pay;
		this.order_recipient = order_recipient;
		this.order_phone = order_phone;
		this.order_basic_addr = order_basic_addr;
		this.order_detail_addr = order_detail_addr;
		this.order_point = order_point;
		this.order_status = order_status;
		this.order_date = order_date;
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

	public int getItem_num() {
		return item_num;
	}

	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_orgimg() {
		return item_orgimg;
	}

	public void setItem_orgimg(String item_orgimg) {
		this.item_orgimg = item_orgimg;
	}

	public String getItem_info() {
		return item_info;
	}

	public void setItem_info(String item_info) {
		this.item_info = item_info;
	}

	public int getOrder_cnt() {
		return order_cnt;
	}

	public void setOrder_cnt(int order_cnt) {
		this.order_cnt = order_cnt;
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

	public String getOrder_phone() {
		return order_phone;
	}

	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
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

	public int getOrder_point() {
		return order_point;
	}

	public void setOrder_point(int order_point) {
		this.order_point = order_point;
	}

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	
}