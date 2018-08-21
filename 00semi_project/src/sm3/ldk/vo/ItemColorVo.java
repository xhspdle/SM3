package sm3.ldk.vo;

public class ItemColorVo {
	private int color_num;
	private String color_name;
	private String color_code;
	private int item_num;
	public ItemColorVo(int color_num, String color_name, String color_code, int item_num) {
		super();
		this.color_num = color_num;
		this.color_name = color_name;
		this.color_code = color_code;
		this.item_num = item_num;
	}
	public ItemColorVo() {}
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
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
}
