package com.uni.view;

import java.util.Scanner;

public class PlayAmuseMenu {
	
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() { // 메인메뉴 --> 2.놀이기구 이용
		
		System.out.println("===== 놀이기구 이용 =====");
		System.out.println("2. 이용 제한 요건 조회");
		System.out.println("9. 이전 메뉴");
		System.out.println("0. 프로그램 종료");

		System.out.println("메뉴 번호 선택 : ");
		int menu = sc.nextInt();
		sc.nextLine();

		switch (menu) {
		case 2:
			System.out.println("2. 이용 제한 요건 조회");
			showGuideAmuse();
			break;
		case 9:
			break;
		case 0: 
			System.out.println("프로그램 종료");
			return;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			break;
		}
		
	}

	private void showGuideAmuse() { // 메인메뉴 --> 2.놀이기구 이용 --> 2.이용 제한 요건 조회
		// TODO Auto-generated method stub
		
	}

}
