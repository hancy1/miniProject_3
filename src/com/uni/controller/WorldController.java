package com.uni.controller;

public class WorldController {

	//전달 받은 관리자 아이디, 패스워드 일치하는지 확인
	public boolean login(String id, String pwd) {

		//둘 다 일치하면 true 리턴
		if(id.equals("kh3") && pwd.equals("3333")) {

			return true;
		}

		//둘 중 하나라도 일치하지 않으면 false 리턴
		return false;
	}

	
	
}
