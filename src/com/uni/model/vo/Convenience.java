package com.uni.model.vo;


import java.io.Serializable;

public class Convenience implements Serializable{
	
	private int cNo; //편의시설 넘버(카운팅 형식으로)
	private String con; //편의시설
	private String area; //구역(A,B,C,D,정문)
	private String position; //위치
	
	
	
	//기본 생성자
	public Convenience() {
		// TODO Auto-generated constructor stub
	}

	
	//매개변수 생성자
	public Convenience(int cNo, String con, String area, String position) {
		super();
		this.cNo = cNo;
		this.con = con;
		this.area = area;
		this.position = position;
	}

	
	//get set 메소드
	public int getcNo() {
		return cNo;
	}


	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	
	public String getCon() {
		return con;
	}


	public void setCon(String con) {
		this.con = con;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}

	

	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	@Override
	public String toString() {
		
	
		return cNo + ". " + area + "구역 " + con + "은(는) " + position + "에 위치하고 있습니다.";

	
	}
	
}