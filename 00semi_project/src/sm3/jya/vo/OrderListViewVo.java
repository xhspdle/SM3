package sm3.jya.vo;

public class OrderListViewVo {
	private int order_num;
	private int order_status;
	private int order_pay;
	private int order_cnt;
	private String item_info;
	private String item_savimg;
	
	public OrderListViewVo() {}

	public OrderListViewVo(int order_num, int order_status, int order_pay, int order_cnt, String item_info,
			String item_savimg) {
		super();
		this.order_num = order_num;
		this.order_status = order_status;
		this.order_pay = order_pay;
		this.order_cnt = order_cnt;
		this.item_info = item_info;
		this.item_savimg = item_savimg;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	public int getOrder_pay() {
		return order_pay;
	}

	public void setOrder_pay(int order_pay) {
		this.order_pay = order_pay;
	}

	public int getOrder_cnt() {
		return order_cnt;
	}

	public void setOrder_cnt(int order_cnt) {
		this.order_cnt = order_cnt;
	}

	public String getItem_info() {
		return item_info;
	}

	public void setItem_info(String item_info) {
		this.item_info = item_info;
	}

	public String getItem_savimg() {
		return item_savimg;
	}

	public void setItem_savimg(String item_savimg) {
		this.item_savimg = item_savimg;
	}

	@Override
	public String toString() {
		return "OrderListViewVo [order_num=" + order_num + ", order_status=" + order_status + ", order_pay=" + order_pay
				+ ", order_cnt=" + order_cnt + ", item_info=" + item_info + ", item_savimg=" + item_savimg + "]";
	}
}
