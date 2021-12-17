package com.uni.view;

import java.util.Scanner;

import com.uni.controller.GuideAmuseMenuController;
import com.uni.model.vo.GuideAmuse;

public class GuideAmuseMenu {

	Scanner sc = new Scanner(System.in);
	GuideAmuseMenuController gc = new GuideAmuseMenuController();

	public void mainMenu() { // 메인메뉴 --> 6.관리자페이지 --> 2.이용 제한 관리
		while (true) {
			System.out.println("===== 이용 제한 관리 메뉴 =====");
			System.out.println("1. 이용 제한 등록");
			System.out.println("2. 이용 제한 수정");
			System.out.println("3. 이용 제한 전체 조회");
			System.out.println("9. 이전 메뉴 ");
			System.out.println("0. 프로그램 종료");
			System.out.println("메뉴 번호 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				insertGuideAmusement();
				break;
			case 2:
				modifyGuideAmusement();
				break;
			case 3:
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
	}

	private void insertGuideAmusement() { // 메인메뉴 --> 6.관리자페이지 --> 2.이용 제한 관리 --> 1.이용 제한 등록

		System.out.println("놀이기구 이름");
		String amuseName = sc.nextLine();

		System.out.println("나이 제한 (숫자만 입력) : ");
		int amuseAge = sc.nextInt();

		System.out.println("키 제한 (숫자만 입력) : ");
		double amuseHeight = sc.nextDouble();
		sc.nextLine();

		System.out.println("보호자 동반 (y / n) : ");
		char amuseParent = sc.nextLine().charAt(0);

		GuideAmuse a = new GuideAmuse(amuseName, amuseAge, amuseHeight, amuseParent); // 입력 받은 자료를 a 에 담고
		gc.insertGuideAmusement(a); // 컨트롤러 메서드로 전달

	}

	private void modifyGuideAmusement() { // 메인메뉴 --> 6.관리자페이지 --> 2.이용 제한 관리 --> 2.이용 제한 수정

		System.out.println("놀이기구 이름");
		String amuseName = sc.nextLine();

		System.out.println("나이 제한 (숫자만 입력) : ");
		int amuseAge = sc.nextInt();

		System.out.println("키 제한 (숫자만 입력) : ");
		double amuseHeight = sc.nextDouble();
		sc.nextLine();

		System.out.println("보호자 동반 (y / n) : ");
		char amuseParent = sc.nextLine().charAt(0);

		GuideAmuse b = new GuideAmuse(amuseName, amuseAge, amuseHeight, amuseParent); // 입력 받은 자료를 a 에 담고
		gc.modifytGuideAmusement(b); // 컨트롤러 메서드로 전달

	}

}
