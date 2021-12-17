package com.uni.model.vo;

public class Ticket implements Guest {
	private String mobile;
	private String howToPay;  // 결제방법
	private int tNum;  // TicketNumber - 예매번호
//	private int netFee;  // 합산 요금
	// ticket guest 나눠야 객체지향에 충실한 것 같은데 나누니까 뭔가 애매하기도..
	
	public Ticket(String mobile, String howToPay, int tNum/*, int netFee*/) {
		super();
		this.mobile = mobile;
		this.howToPay = howToPay;
		this.tNum = tNum;
//		this.netFee = netFee;
	}

	public void ticket(Guest guest) {
		// 여기에서 이제 연령에 따른 요금 정의
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getHowToPay() {
		return howToPay;
	}

	public void setHowToPay(String howToPay) {
		this.howToPay = howToPay;
	}

	public int gettNum() {
		return tNum;
	}

	public void settNum(int tNum) {
		this.tNum = tNum;
	}
	
	public String showTNum() {
		return "고객님의 예매번호는 " + tNum + "번 입니다.";
	}

//	public int getNetFee() {
//		return netFee;
//	}
//
//	public void setNetFee(int netFee) {
//		this.netFee = netFee;
//	}

	@Override
	public void age(int age) {
		// TODO Auto-generated method stub
		
	}

	
	
}
