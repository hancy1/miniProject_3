package uni.view;

import java.util.Scanner;

import uni.controller.Cong_time;

public class UtilMenu {

	private Scanner sc = new Scanner(System.in);
	private Cong_time ct = new Cong_time();
	private BookingMenu bm = new BookingMenu();

	public void util() {

		System.out.println("1. 혼잡도 조회");
		System.out.println("2. 이용 제한 요건 조회");
		System.out.println("3. 운행시간 조회");
		System.out.println("4. 예약");
		System.out.println("9. 이전 메뉴");
		System.out.println("메뉴를 입력해주세요: ");
		int menu = sc.nextInt();

		while (true) {
			switch (menu) {
			case 1:
				ct.congestion();
				break;
			case 2:
				// 이용 제한 요건 조회
				break;
			case 3:
				ct.time();
				break;
			case 4:
				bm.bookingMenu();
				break;
			case 9:
				System.out.println("이전 메뉴로 이동합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
		}
	}

}
