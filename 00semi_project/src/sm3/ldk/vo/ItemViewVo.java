package sm3.ldk.vo;

public class ItemViewVo {
	private int cate_num;
	private String cate_name;
	private int item_num;
	private String item_name;
	private String item_info;
	private int item_price;
	private String item_orgimg;
	private String item_savimg;
	private int size_num;
	private String size_name;
	private int size_cnt;
	private int color_num;
	private String color_name;
	private String color_code;
	public ItemViewVo() {}
	public ItemViewVo(int cate_num, String cate_name, int item_num, String item_name, String item_info, int item_price,
			String item_orgimg, String item_savimg, int size_num, String size_name, int size_cnt, int color_num,
			String color_name, String color_code) {
		super();
		this.cate_num = cate_num;
		this.cate_name = cate_name;
		this.item_num = item_num;
		this.item_name = item_name;
		this.item_info = item_info;
		this.item_price = item_price;
		this.item_orgimg = item_orgimg;
		this.item_savimg = item_savimg;
		this.size_num = size_num;
		this.size_name = size_name;
		this.size_cnt = size_cnt;
		this.color_num = color_num;
		this.color_name = color_name;
		this.color_code = color_code;
	}
	public int getCate_num() {
		return cate_num;
	}
	public void setCate_num(int cate_num) {
		this.cate_num = cate_num;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
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
	public int getSize_num() {
		return size_num;
	}
	public void setSize_num(int size_num) {
		this.size_num = size_num;
	}
	public String getSize_name() {
		return size_name;
	}
	public void setSize_name(String size_name) {
		this.size_name = size_name;
	}
	public int getSize_cnt() {
		return size_cnt;
	}
	public void setSize_cnt(int size_cnt) {
		this.size_cnt = size_cnt;
	}
	public int getColor_num() {
		return color_num;
	}
	public void setColor_num(int color_num) {
		this.color_num = color_num;
	}
	public String getColor_name() {
		return color_name;
	}
	public void setColor_name(String color_name) {
		this.color_name = color_name;
	}
	public String getColor_code() {
		return color_code;
	}
	public void setColor_code(String color_code) {
		this.color_code = color_code;
	}
	@Override
	public String toString() {
		return "ItemViewVo [cate_num=" + cate_num + ", cate_name=" + cate_name + ", item_num=" + item_num
				+ ", item_name=" + item_name + ", item_info=" + item_info + ", item_price=" + item_price
				+ ", item_orgimg=" + item_orgimg + ", item_savimg=" + item_savimg + ", size_num=" + size_num
				+ ", size_name=" + size_name + ", size_cnt=" + size_cnt + ", color_num=" + color_num + ", color_name="
				+ color_name + ", color_code=" + color_code + "]";
	}
}
