package com.uni.model.vo;

public class GuideAmuse {

	private String amuseName; // 놀이기구 이름 
	private int amuseAge; // 놀이기구 이용 나이 
	private double amuseHeight; // 놀이기구 이용 키 
	private char amuseParent; // 놀이기구 보호자 동반 여부 

	public GuideAmuse() {
		// TODO Auto-generated constructor stub
	}

	public GuideAmuse(String amuseName, int amuseAge, double amuseHeight, char amuseParent) {
		super();
		this.amuseName = amuseName;
		this.amuseAge = amuseAge;
		this.amuseHeight = amuseHeight;
		this.amuseParent = amuseParent;
	}

	public String getAmuseName() {
		return amuseName;
	}

	public void setAmuseName(String amuseName) {
		this.amuseName = amuseName;
	}

	public int getAmuseAge() {
		return amuseAge;
	}

	public void setAmuseAge(int amuseAge) {
		this.amuseAge = amuseAge;
	}

	public double getAmuseHeight() {
		return amuseHeight;
	}

	public void setAmuseHeight(double amuseHeight) {
		this.amuseHeight = amuseHeight;
	}

	public char getAmuseParent() {
		return amuseParent;
	}

	public void setAmuseParent(char amuseParent) {
		this.amuseParent = amuseParent;
	}

	@Override
	public String toString() {
		return "GuideAmuse [amuseName=" + amuseName + ", amuseAge=" + amuseAge + ", amuseHeight=" + amuseHeight
				+ ", amuseParent=" + amuseParent + "]";
	}

}
