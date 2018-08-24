package sm3.ldk.vo;

public class ItemSizeVo {
	private int size_num;
	private String size_name;
	private int item_num;
	private int color_num;
	private int size_cnt;
	public ItemSizeVo() {}
	public ItemSizeVo(int size_num, String size_name, int item_num, int color_num, int size_cnt) {
		super();
		this.size_num = size_num;
		this.size_name = size_name;
		this.item_num = item_num;
		this.color_num = color_num;
		this.size_cnt = size_cnt;
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
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	public int getColor_num() {
		return color_num;
	}
	public void setColor_num(int color_num) {
		this.color_num = color_num;
	}
	public int getSize_cnt() {
		return size_cnt;
	}
	public void setSize_cnt(int size_cnt) {
		this.size_cnt = size_cnt;
	}
	@Override
	public String toString() {
		return "ItemSizeVo [size_num=" + size_num + ", size_name=" + size_name + ", item_num=" + item_num
				+ ", color_num=" + color_num + ", size_cnt=" + size_cnt + "]";
	}
}
