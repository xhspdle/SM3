package sm3.ldk.vo;

public class CartVo {
	private int user_num;
	private int item_num;
	private int order_cnt;
	public CartVo() {}
	public CartVo(int user_num, int item_num, int order_cnt) {
		super();
		this.user_num = user_num;
		this.item_num = item_num;
		this.order_cnt = order_cnt;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public int getOrder_cnt() {
		return order_cnt;
	}
	public void setOrder_cnt(int order_cnt) {
		this.order_cnt = order_cnt;
	}
	@Override
	public String toString() {
		return "CartVo [user_num=" + user_num + ", item_num=" + item_num + ", order_cnt=" + order_cnt + "]";
	}
}
