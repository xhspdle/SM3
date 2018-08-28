package sm3.ldk.vo;

public class PurchaseVo {
	private int pur_num;
	public PurchaseVo() {}
	public PurchaseVo(int pur_num) {
		super();
		this.pur_num = pur_num;
	}
	public int getPur_num() {
		return pur_num;
	}
	public void setPur_num(int pur_num) {
		this.pur_num = pur_num;
	}
	@Override
	public String toString() {
		return "PurchaseVo [pur_num=" + pur_num + "]";
	}
}
