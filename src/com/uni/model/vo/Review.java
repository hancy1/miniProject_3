package com.uni.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Review implements Serializable{ 
	// 직렬화 : 자바에서 입출력에 사용되는 것은 스트림이라는 데이터 통로를 통해 이동했습니다. 
	//하지만 객체는 바이트형이 아니라서 스트림을 통해 파일에 저장하거나 네트워크로 전송할 수 없습니다. 
	//따라서 객체를 스트림을 통해 입출력하려면 바이트 배열로 변환하는 것이 필요한데, 이를 '직렬화' 라고 합니다.



	/**
	 * 
	 */
	private static final long serialVersionUID = 7259096934643179311L; // 직렬화
	private int reviewNo; // 글번호
	private String reviewTitle; // 글제목
	private Date reviewDate; // 등록날짜
	private String reviewContent; // 내용
	private String pwd; // 비밀번호

	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int reviewNo, String reviewTitle, Date reviewDate, String reviewContent, String pwd) {
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
				+ ", 내용 : " + reviewContent + "]";
	}

	


}
