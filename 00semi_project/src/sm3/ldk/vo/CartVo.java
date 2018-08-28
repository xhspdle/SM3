package sm3.ldk.vo;

public class CartVo {
	private int cart_num;
	private int user_num;
	private int size_num;
	private int order_cnt;
	private int item_price;
	private int order_total;
	public CartVo() {}
	public CartVo(int cart_num, int user_num, int size_num, int order_cnt, int item_price, int order_total) {
		super();
		this.cart_num = cart_num;
		this.user_num = user_num;
		this.size_num = size_num;
		this.order_cnt = order_cnt;
		this.item_price = item_price;
		this.order_total = order_total;
	}
	public int getCart_num() {
		return cart_num;
	}
	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public int getSize_num() {
		return size_num;
	}
	public void setSize_num(int size_num) {
		this.size_num = size_num;
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
	@Override
	public String toString() {
		return "CartVo [cart_num=" + cart_num + ", user_num=" + user_num + ", size_num=" + size_num + ", order_cnt="
				+ order_cnt + ", item_price=" + item_price + ", order_total=" + order_total + "]";
	}
}
