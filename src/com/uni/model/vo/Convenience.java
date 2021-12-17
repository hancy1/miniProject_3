package com.convenience.user.model.vo;

public class Convenience {
	
	private int cNo; //편의시설 넘버(카운팅 형식으로)
	private int con; //편의시설(1.안내데스크, 2.화장실)
	private char area; //구역(A,B,C,D)
	private String position; //위치
	
	
	
	//기본 생성자
	public Convenience() {
		// TODO Auto-generated constructor stub
	}

	
	//매개변수 생성자
	public Convenience(int cNo, int con, char area, String position) {
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

	
	public int getCon() {
		return con;
	}


	public void setCon(int con) {
		this.con = con;
	}


	public char getArea() {
		return area;
	}


	public void setArea(char area) {
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
		
		String con2 = "";
		
		if(con == 1) {
			con2 = "안내데스크";
		} else if(con == 2) {
			con2 = "화장실";
		}
		
		return area + "구역에는 " + position + "에 " + con2 + "가(이) 위치하고 있습니다.";
	}
	
	
	

	
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
