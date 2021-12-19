package com.uni.view;

import java.util.Scanner;

import com.uni.controller.ConManager;



public class ConMenu {

	PlayMenu pm = new PlayMenu();
	Scanner sc = new Scanner(System.in);
	
	ConManager cm = new ConManager();
	
	//편의시설 관리 메뉴
	public void conMenu() {
		
		while(true) {
			
			//try {
				System.out.println();
				System.out.println("*** 편의시설 관리 ***");
				System.out.println("1. 편의시설 등록");
				System.out.println("2. 편의시설 수정");
				System.out.println("3. 편의시설 삭제");
				System.out.println("4. 편의시설 출력");
				System.out.println("5. 파일에 저장하기");
				System.out.println("9. 메인 메뉴");
				System.out.println("0. 프로그램 종료");
				System.out.println("메뉴 번호 선택 : ");
				int menu = sc.nextInt();
				sc.nextLine();

				switch(menu) {
				case 1 : cm.insertCon(); break;
				case 2 : cm.modifyCon(); break;
				case 3 : cm.deleteCon(); break;
				case 4 : cm.displayAllList(); break;
				case 5 : cm.saveListFile(); break;
				case 9 : pm.mainMenu(); break;
				case 0 : System.out.println("프로그램 종료"); System.exit(0);
				default :
					System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
					break;
			
				}
				
			//try catcch 안 하면 다른 숫자 입력했을 땐 잘 됨. 그런데 문자 치면 메인 메뉴로 감
				
			/*} catch(InputMismatchException e) {
				
				//문자 치면 왜 메인 메뉴로 넘어가지 ...................
				//다른 숫자 치면 관리자 메뉴로 넘어감 개짱나
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				System.out.println();
				sc.nextLine();
				break;
			}*/
	
		}
		
	}
	
	
	
	
	
	
}
