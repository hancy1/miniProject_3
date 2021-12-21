package com.uni.model.vo;

import java.io.Serializable;

public class BookTicket implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2066021464291574309L; // 직렬화
	private static final int price = 30000; // 티켓가격
	private int tNo; // 티켓넘버
	private int count; // 인원수
	private int total;  // 총합계
	
	
	public BookTicket(int tNo, int count, int total) {
		super();
		this.tNo = tNo;
		this.count = count;
		this.total = total;
	}


	public int gettNo() {
		return tNo;
	}


	public void settNo(int tNo) {
		this.tNo = tNo;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public static int getPrice() {
		return price;
	}


	@Override
	public String toString() {
		return "[티켓예매] 티켓번호 : " + tNo + ", 인원 수 : " + count + "명, 티켓 총합계 : " + total + "원";
	}
	
	
	
	

	
	
	
	
}
