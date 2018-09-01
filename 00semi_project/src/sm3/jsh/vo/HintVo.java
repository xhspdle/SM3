package sm3.jsh.vo;

public class HintVo {
	public int hint_num;
	public String hint_q;
	
	public HintVo() {}
	
	public HintVo(int hint_num, String hint_q) {
		super();
		this.hint_num = hint_num;
		this.hint_q = hint_q;
	}
	public int getHint_num() {
		return hint_num;
	}
	public void setHint_num(int hint_num) {
		this.hint_num = hint_num;
	}
	public String getHint_q() {
		return hint_q;
	}
	public void setHint_q(String hint_q) {
		this.hint_q = hint_q;
	}
	
	
	
}
