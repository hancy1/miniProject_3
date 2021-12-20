package com.uni.view;

import java.util.Scanner;

import com.uni.controller.GuideAmuseController;

public class GuideAmuseMenu { 

	Scanner sc = new Scanner(System.in);
	GuideAmuseController gc = new GuideAmuseController();

	public void mainMenu() { // 메인메뉴 --> 6.관리자페이지 --> 2.이용 제한 관리
		while (true) {
			System.out.println("===== 이용 제한 관리 메뉴 =====");
			System.out.println("1. 이용 제한 등록");
			System.out.println("2. 이용 제한 수정");
			System.out.println("3. 이용 제한 전체 조회");
			System.out.println("4. 이용 제한 삭제");
			System.out.println("9. 이전 메뉴 ");
			System.out.println("0. 프로그램 종료");
			System.out.println("메뉴 번호 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				gc.insertGuideAmusement();
				break;
			case 2:
				gc.modifyGuideAmusement();
				break;
			case 3:
				System.out.println("===== 놀이기구 이용 제한 전체 조회 =====");
				gc.displayAllList();
				break;
			case 4:
				gc.deleteGuideAmusement();
				break;
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

}