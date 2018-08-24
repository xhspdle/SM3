package sm3.ldk.vo;

public class ItemCateVo {
	private int cate_num;
	private String cate_name;
	public ItemCateVo() {}
	public ItemCateVo(int cate_num, String cate_name) {
		super();
		this.cate_num = cate_num;
		this.cate_name = cate_name;
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
	@Override
	public String toString() {
		return "ItemCateVo [cate_num=" + cate_num + ", cate_name=" + cate_name + "]";
	}
}
