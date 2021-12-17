package com.uni.view;

import java.util.Scanner;

import com.uni.controller.TicketManager;

public class TicketMenu {

	private TicketManager tm = new TicketManager();
	private Scanner sc = new Scanner(System.in);

	public void reservation() {

		while (true) {
			System.out.println("Hello Java World의 요금 정책은 다음과 같습니다.");
			System.out.println("유아(8세 미만) : 15000원");
			System.out.println("어린이(14세 미만) : 46000원"); // UI 설계서에 13세로 잘못 적음
			System.out.println("청소년(20세 미만) : 50000원");
			System.out.println("어른 : 56000원");
			System.out.println("[통신사 할인 : kt, u+, sk 50%]");
			System.out.println();

			System.out.println("해당 연령대를 선택해주세요.");
			System.out.println("1. 유아(8세 미만)");
			System.out.println("2. 어린이(14세 미만)");
			System.out.println("3. 청소년(20세 미만)");
			System.out.println("4. 어른");
			System.out.println("9. 이전 메뉴");
			System.out.println("메뉴를 선택하세요: ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
			case 2:
			case 3:
			case 4:
				selectMobile();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				continue;

			}
		}
	}
	public void selectMobile() {
		
		while(true) {
			
			System.out.println("통신사는 어떻게 되시나요?");
			System.out.println("KT는 'k'를, U+는 'u'를, SK는 's'를,");
			System.out.println("해당사항이 없으시면 'n'을 이전메뉴는 '9'를 입력하세요.");
			System.out.println("메뉴를 선택하세요: ");
			char input = sc.nextLine().charAt(0);
			
			if(input == 'k' || input == 'u' || input == 's') {
				
				break;
			} else if (input == '9') {
				return;
			} else {
				System.out.println("다시 입력해주세요.");
				continue;
			}
		}
	}
	
	
}
