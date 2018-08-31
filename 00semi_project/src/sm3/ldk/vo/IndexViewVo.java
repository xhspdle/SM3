package sm3.ldk.vo;
//I.ITEM_SAVIMG,I.ITEM_NAME,I.ITEM_PRICE,
//PU.ORDER_CNT
public class IndexViewVo {
	private String item_savimg;
	private String item_name;
	private int item_price;
	private int order_cnt;
	public IndexViewVo() {}
	public IndexViewVo(String item_savimg, String item_name, int item_price, int order_cnt) {
		super();
		this.item_savimg = item_savimg;
		this.item_name = item_name;
		this.item_price = item_price;
		this.order_cnt = order_cnt;
	}
	public String getItem_savimg() {
		return item_savimg;
	}
	public void setItem_savimg(String item_savimg) {
		this.item_savimg = item_savimg;
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
	public int getOrder_cnt() {
		return order_cnt;
	}
	public void setOrder_cnt(int order_cnt) {
		this.order_cnt = order_cnt;
	}
	@Override
	public String toString() {
		return "IndexViewVo [item_savimg=" + item_savimg + ", item_name=" + item_name + ", item_price=" + item_price
				+ ", order_cnt=" + order_cnt + "]";
	}
}
