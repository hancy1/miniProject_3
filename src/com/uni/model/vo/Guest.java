package com.uni.model.vo;

public interface Guest {	// 정수 age라는 추상메소드를 가진 Guest 인터페이스
	public void age(int age);
}

class Baby implements Guest {	// 인터페이스 Guest를 구현하는 Baby 구현체
	@Override
	// 연령 정의		
	public void age(int age) {	
		for(int i = 0; i < 8; i++) {
			age = i;
		}
	}
}

class Child implements Guest {

	@Override
	public void age(int age) {
		for(int i = 8; i < 14; i++) {
			age = i;
		}
	}
}

class Teen implements Guest {

	@Override
	public void age(int age) {
		for(int i = 14; i < 20; i++) {
			age = i;
		}
	}
}

class Adult implements Guest {

	@Override
	public void age(int age) {
		for(int i = 150; i > 19; i--) {
			age = i;
		}
	}

}