package sm3.ldk.vo;

public class PurchaseListVo {
	private int pl_num;
	private int pur_num;
	private int size_num;
	private int order_cnt;
	private int item_price;
	public PurchaseListVo() {}
	public PurchaseListVo(int pl_num, int pur_num, int size_num, int order_cnt, int item_price) {
		super();
		this.pl_num = pl_num;
		this.pur_num = pur_num;
		this.size_num = size_num;
		this.order_cnt = order_cnt;
		this.item_price = item_price;
	}
	public int getPl_num() {
		return pl_num;
	}
	public void setPl_num(int pl_num) {
		this.pl_num = pl_num;
	}
	public int getPur_num() {
		return pur_num;
	}
	public void setPur_num(int pur_num) {
		this.pur_num = pur_num;
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
	@Override
	public String toString() {
		return "PurchaseListVo [pl_num=" + pl_num + ", pur_num=" + pur_num + ", size_num=" + size_num + ", order_cnt="
				+ order_cnt + ", item_price=" + item_price + "]";
	}
}
