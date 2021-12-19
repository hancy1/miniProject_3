package com.uni.view;

import java.util.Scanner;

import com.uni.controller.GuideAmuseMenuController;

public class PlayAmuseMenu {
	
	Scanner sc = new Scanner(System.in);
	GuideAmuseMenuController gc = new GuideAmuseMenuController();
	
	public void mainMenu() { // 메인메뉴 --> 2.놀이기구 이용
		
		System.out.println("===== 놀이기구 이용 =====");
		System.out.println("1. 혼잡도 조회");
		System.out.println("2. 이용 제한 요건 조회");
		System.out.println("3. 운행시간 조회 ");
		System.out.println("4. 예약");
		System.out.println("9. 이전 메뉴");
		System.out.println("0. 프로그램 종료");

		System.out.println("메뉴 번호 선택 : ");
		int menu = sc.nextInt();
		sc.nextLine();

		switch (menu) {
		case 1: break;
		case 2:
			System.out.println("<놀이기구 이용 조건>");
			gc.displayAllList();
			break;
		case 3: break;
		case 4: break;
		case 9:
			return;
		case 0: 
			System.out.println("프로그램 종료");
			return;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			break;
		}
		
	}

}
