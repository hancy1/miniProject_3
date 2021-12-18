package com.uni.model.vo;

import java.io.Serializable;
import java.util.Date;

public class ReviewAdmin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4857986591404337532L;
	private int reviewNo; // 글번호
	private String reviewTitle; // 글제목
	private Date reviewDate; // 등록날짜
	private String reviewContent; // 내용
	private String pwd; // 비밀번호
	
	public ReviewAdmin() {
		// TODO Auto-generated constructor stub
	}

	public ReviewAdmin(int reviewNo, String reviewTitle, Date reviewDate, String reviewContent, String pwd) {
		super();
		this.reviewNo = reviewNo;
		this.reviewTitle = reviewTitle;
		this.reviewDate = reviewDate;
		this.reviewContent = reviewContent;
		this.pwd = pwd;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "이용후기 [No." + reviewNo + ", 제목 : " + reviewTitle + ", 등록날짜 : " + reviewDate
				+ ", 내용 : " + reviewContent + ", 비밀번호 : " +  pwd + "]";
	}
	
	
}
