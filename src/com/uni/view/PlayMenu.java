package com.uni.view;

public class PlayMenu {


	public PlayMenu() {
		// TODO Auto-generated constructor stub
	}

	public void mainmenu() {
		while(true) {
			System.out.println("*** Hello Java World! ***");
			System.out.println("1. 이용권예매");
			System.out.println("2. 놀이기구 이용");
			System.out.println("3. 편의시설 안내");
			System.out.println("4. 놀이기구 이용후기");
			System.out.println("5. 셔틀버스 이용");
			System.out.println("6. 관리자 페이지");
			System.out.println("0. 프로그램 종료");
			System.out.println("메뉴 번호 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch(menu) {
			case 1 : 
			break;
			case 2 : 
			break;
			case 3 : 
			break;
			case 4 : 
			break;
			case 5 : 
			break;
			case 6 : 
			break;
			case 0 : System.out.println("프로그램 종료");
			return;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			break;

			}
		}
	}
}
