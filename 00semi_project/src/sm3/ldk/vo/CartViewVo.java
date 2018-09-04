package sm3.ldk.vo;

public class CartViewVo {
	private int cart_num;
	private int user_num;
	private int size_num;
	private int order_cnt;
	private int item_price;
	private String item_orgimg;
	private String item_name;
	private String color_name;
	public CartViewVo() {}
	public CartViewVo(int cart_num, int user_num, int size_num, int order_cnt, int item_price, String item_orgimg,
			String item_name, String color_name) {
		super();
		this.cart_num = cart_num;
		this.user_num = user_num;
		this.size_num = size_num;
		this.order_cnt = order_cnt;
		this.item_price = item_price;
		this.item_orgimg = item_orgimg;
		this.item_name = item_name;
		this.color_name = color_name;
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
	public String getItem_orgimg() {
		return item_orgimg;
	}
	public void setItem_orgimg(String item_orgimg) {
		this.item_orgimg = item_orgimg;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getColor_name() {
		return color_name;
	}
	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}
	@Override
	public String toString() {
		return "CartViewVo [cart_num=" + cart_num + ", user_num=" + user_num + ", size_num=" + size_num + ", order_cnt="
				+ order_cnt + ", item_price=" + item_price + ", item_orgimg=" + item_orgimg + ", item_name=" + item_name
				+ ", color_name=" + color_name + "]";
	}
}
