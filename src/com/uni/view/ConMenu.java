package com.uni.view;

import java.util.Scanner;

public class ConMenu {

	//PlayMenu pm = new PlayMenu();
	Scanner sc = new Scanner(System.in);
	
	//편의시설 관리 메뉴
	public void conMenu() {
		
		while(true) {
			System.out.println();
			System.out.println("*** 편의시설 관리 ***");
			System.out.println("1. 편의시설 등록");
			System.out.println("2. 편의시설 수정");
			System.out.println("3. 편의시설 삭제");
			System.out.println("4. 편의시설 출력");
			System.out.println("9. 이전 메뉴");
			System.out.println("0. 프로그램 종료");
			System.out.println("메뉴 번호 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch(menu) {
			case 1 : break;
			case 2 : break;
			case 3 : break;
			case 4 : break;
			case 9 : //pm.managerMenu(); break;
			case 0 : System.out.println("프로그램 종료"); System.exit(0);
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
				break;
		
			}
	
		}
		
	}
	
	
	
	
	
	
}
