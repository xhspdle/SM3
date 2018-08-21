package sm3.ldk.vo;

public class ItemVo {
	private int item_num;
	private String item_name;
	private int cate_num;
	private String item_info;
	private int item_price;
	private String item_big_orgimg;
	private String item_big_savimg;
	private String item_small_orgimg;
	private String item_small_savimg;
	public ItemVo() {}
	public ItemVo(int item_num, String item_name, int cate_num, String item_info, int item_price,
			String item_big_orgimg, String item_big_savimg, String item_small_orgimg, String item_small_savimg) {
		super();
		this.item_num = item_num;
		this.item_name = item_name;
		this.cate_num = cate_num;
		this.item_info = item_info;
		this.item_price = item_price;
		this.item_big_orgimg = item_big_orgimg;
		this.item_big_savimg = item_big_savimg;
		this.item_small_orgimg = item_small_orgimg;
		this.item_small_savimg = item_small_savimg;
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
	public String getItem_big_orgimg() {
		return item_big_orgimg;
	}
	public void setItem_big_orgimg(String item_big_orgimg) {
		this.item_big_orgimg = item_big_orgimg;
	}
	public String getItem_big_savimg() {
		return item_big_savimg;
	}
	public void setItem_big_savimg(String item_big_savimg) {
		this.item_big_savimg = item_big_savimg;
	}
	public String getItem_small_orgimg() {
		return item_small_orgimg;
	}
	public void setItem_small_orgimg(String item_small_orgimg) {
		this.item_small_orgimg = item_small_orgimg;
	}
	public String getItem_small_savimg() {
		return item_small_savimg;
	}
	public void setItem_small_savimg(String item_small_savimg) {
		this.item_small_savimg = item_small_savimg;
	}
}
