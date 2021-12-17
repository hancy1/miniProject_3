package com.uni.reviews;

public class Review {
	
	private int rNo;
	private String content;
	private String pwd;
	
	
	public Review() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Review(int rNO, String content) {
		super();
		this.rNo = rNo;
		this.content = content;
	}


	public int getrNo() {
		return rNo;
	}


	public void setrNo(int rNo) {
		this.rNo = rNo;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	@Override
	public String toString() {
		return "이용후기 [글번호 No. " + rNo + "] , 내용 : ";
	}
	
	
	
	
	

}
