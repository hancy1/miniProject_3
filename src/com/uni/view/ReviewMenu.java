package com.uni.view;

import java.util.Scanner;

import com.uni.controller.ReviewManager;

public class ReviewMenu {

	Scanner sc = new Scanner(System.in);
	ReviewManager rm = new ReviewManager();

	public ReviewMenu() {
		// TODO Auto-generated constructor stub
	}

	public void mainMenu() {
		while(true) {
			System.out.println("*** 자바월드 이용 후기 ***");
			System.out.println("1. 이용후기 조회");
			System.out.println("2. 이용후기 등록");
			System.out.println("3. 이용후기 수정");
			System.out.println("4. 이용후기 삭제");
			System.out.println("9. 이전메뉴");
			System.out.println("선택 메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch(menu) {
			case 1 : // 이용후기조회
				rm.readReview();
				break;
			case 2 : // 이용후기등록
				rm.writeReview();
				break;
			case 3 : // 이용후기 수정
				rm.editReview();
				break;
			case 4 : // 이용후기 삭제
				rm.deleteReview();
				break;
			case 9 : // 이전메뉴로
				return;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			break;
			}
		}
	}

	public void reviewAdminMenu() {

		while(true) {
			System.out.println("< 이용 후기 관리 >");
			System.out.println("1. 이용후기 조회 ");
			System.out.println("2. 이용후기 삭제 ");
			System.out.println("0. 이전메뉴로 ");
			int menu = sc.nextInt();
			sc.nextLine(); // 버퍼없애기
			
			switch(menu) {
			case 1 : rm.readAdminReview();
			break;
			case 2 : rm.deleteAdminReview();
			break;
			case 3 : return;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			break;
			}
			

		}
	}
}

