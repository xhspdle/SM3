package sm3.ldk.vo;
//I.ITEM_SAVIMG,I.ITEM_NAME,I.ITEM_PRICE,
//PU.ORDER_CNT
public class IndexViewVo {
	private String item_orgimg;
	private String item_name;
	private int item_price;
	private int item_num;
	private int order_cnt;
	public IndexViewVo() {}
	public IndexViewVo(String item_orgimg, String item_name, int item_price, int item_num, int order_cnt) {
		super();
		this.item_orgimg = item_orgimg;
		this.item_name = item_name;
		this.item_price = item_price;
		this.item_num = item_num;
		this.order_cnt = order_cnt;
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
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
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
		return "IndexViewVo [item_orgimg=" + item_orgimg + ", item_name=" + item_name + ", item_price=" + item_price
				+ ", item_num=" + item_num + ", order_cnt=" + order_cnt + "]";
	}
}
