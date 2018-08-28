package sm3.jsh.vo;

import java.sql.Date;

//��ǰ�������̺� vo
public class ReviewVo {
	private int review_num; // �����ȣ
	private String review_orgimg; // ��������
	private String review_saving; // �������
	private int review_rating; // ��������
	private int review_content; // ���䳻��
	private Date review_date; // �ۼ���
	private int order_num; // �ֹ���ȣ
	private int user_num; // ������ȣ
	
	public ReviewVo() {}
	
	public ReviewVo(int review_num, String review_orgimg, String review_saving, int review_rating, int review_content,
			Date review_date, int order_num, int user_num) {
		this.review_num = review_num;
		this.review_orgimg = review_orgimg;
		this.review_saving = review_saving;
		this.review_rating = review_rating;
		this.review_content = review_content;
		this.review_date = review_date;
		this.order_num = order_num;
		this.user_num = user_num;
	}
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public String getReview_orgimg() {
		return review_orgimg;
	}
	public void setReview_orgimg(String review_orgimg) {
		this.review_orgimg = review_orgimg;
	}
	public String getReview_saving() {
		return review_saving;
	}
	public void setReview_saving(String review_saving) {
		this.review_saving = review_saving;
	}
	public int getReview_rating() {
		return review_rating;
	}
	public void setReview_rating(int review_rating) {
		this.review_rating = review_rating;
	}
	public int getReview_content() {
		return review_content;
	}
	public void setReview_content(int review_content) {
		this.review_content = review_content;
	}
	public Date getReview_date() {
		return review_date;
	}
	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	
}