package sm3.ldk.vo;

public class ItemColorVo {
	private int color_num;
	private String color_name;
	private String color_code;
	public ItemColorVo() {}
	public ItemColorVo(int color_num, String color_name, String color_code) {
		super();
		this.color_num = color_num;
		this.color_name = color_name;
		this.color_code = color_code;
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
		return "ItemColorVo [color_num=" + color_num + ", color_name=" + color_name + ", color_code=" + color_code
				+ "]";
	}
}
