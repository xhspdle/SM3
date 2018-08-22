package sm3.ldk.vo;

public class ItemVo {
	private int item_num;
	private String item_name;
	private int cate_num;
	private String item_info;
	private int item_price;
	private String item_orgimg;
	private String item_savimg;
	public ItemVo() {}
	public ItemVo(int item_num, String item_name, int cate_num, String item_info, int item_price, String item_orgimg,
			String item_savimg) {
		super();
		this.item_num = item_num;
		this.item_name = item_name;
		this.cate_num = cate_num;
		this.item_info = item_info;
		this.item_price = item_price;
		this.item_orgimg = item_orgimg;
		this.item_savimg = item_savimg;
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
	public int getCate_num() {
		return cate_num;
	}
	public void setCate_num(int cate_num) {
		this.cate_num = cate_num;
	}
	public String getItem_info() {
		return item_info;
	}
	public void setItem_info(String item_info) {
		this.item_info = item_info;
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
	public String getItem_savimg() {
		return item_savimg;
	}
	public void setItem_savimg(String item_savimg) {
		this.item_savimg = item_savimg;
	}
}
