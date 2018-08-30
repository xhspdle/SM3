package sm3.jya.vo;

public class OrderListViewVo {
	private int order_num;
	private int user_num;
	private int pur_num;
	private String item_name;
	private String item_savimg;
	private String item_info;
	private int order_cnt;
	private int order_pay;
	private int order_status;
	
	public OrderListViewVo() {}

	public OrderListViewVo(int order_num, int user_num, int pur_num, String item_name, String item_savimg,
			String item_info, int order_cnt, int order_pay, int order_status) {
		super();
		this.order_num = order_num;
		this.user_num = user_num;
		this.pur_num = pur_num;
		this.item_name = item_name;
		this.item_savimg = item_savimg;
		this.item_info = item_info;
		this.order_cnt = order_cnt;
		this.order_pay = order_pay;
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

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_savimg() {
		return item_savimg;
	}

	public void setItem_savimg(String item_savimg) {
		this.item_savimg = item_savimg;
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

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	@Override
	public String toString() {
		return "OrderListViewVo [order_num=" + order_num + ", user_num=" + user_num + ", pur_num=" + pur_num
				+ ", item_name=" + item_name + ", item_savimg=" + item_savimg + ", item_info=" + item_info
				+ ", order_cnt=" + order_cnt + ", order_pay=" + order_pay + ", order_status=" + order_status + "]";
	}

}