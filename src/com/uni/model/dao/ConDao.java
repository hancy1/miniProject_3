package com.convenience.user.model.dao;

import java.util.ArrayList;

import com.convenience.user.model.vo.Convenience;


public class ConDao {

	Convenience c = new Convenience();
	
	ArrayList<Convenience> list = new ArrayList<>();
	
	{//실행되는지 확인하려고 임의로 객체 만듦
		list.add(new Convenience(1, 1, 'A', "바이킹 옆"));
		list.add(new Convenience(2, 2, 'B', "회전목마 오른쪽"));
	}
	
	
	
	
	//기본생성자
	public ConDao() {
		// TODO Auto-generated constructor stub
	}

	
	
	//전달 받은 편의시설 번호가(1이나 2) 적절하면
	//1 아니면 0 리턴
	public int searchCon(int con) {
		
		//1이나 2가 아니면 0으로 리턴
		if(con != 1 && con != 2) {
			return 0;
		}
		
		//1이나 2이면 해당 편의시설 리턴
		return con;
	}

	
	
	//전달 받은 구역이(A,B,C,D) 적절하면
	//searchCon에서 리턴 받은 것과 전달 받은 구역을 리트스와 비교
	//둘 다 일치하는 객체가 있으면 출력 아니면 0리턴
	public int searchArea(char area) {
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
