package sm3.jsh.vo;

import java.sql.Date;

//상품리뷰테이블 vo

public class ReviewVo {
	private int review_num; // 리뷰번호
	private String review_item; // 아이템이름
	private String review_orgimg; // 원본사진
	private String review_savimg; // 저장사진
	private int review_rating; // 리뷰평점
	private String review_content; // 리뷰내용
	private Date review_date; // 작성일
	private int order_num; // 주문번호
	private int user_num; // 유저번호
	
	public ReviewVo() {
		
	}
	
	public ReviewVo(int review_num, String review_item, String review_orgimg, String review_savimg, int review_rating,
			String review_content, Date review_date, int order_num, int user_num) {
		this.review_num = review_num;
		this.review_item = review_item;
		this.review_orgimg = review_orgimg;
		this.review_savimg = review_savimg;
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
	public String getReview_item() {
		return review_item;
	}
	public void setReview_item(String review_item) {
		this.review_item = review_item;
	}
	public String getReview_orgimg() {
		return review_orgimg;
	}
	public void setReview_orgimg(String review_orgimg) {
		this.review_orgimg = review_orgimg;
	}
	public String getReview_saving() {
		return review_savimg;
	}
	public void setReview_saving(String review_saving) {
		this.review_savimg = review_saving;
	}
	public int getReview_rating() {
		return review_rating;
	}
	public void setReview_rating(int review_rating) {
		this.review_rating = review_rating;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
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