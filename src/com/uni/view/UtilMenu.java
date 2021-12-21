package com.uni.view;

import java.util.Scanner;

import com.uni.controller.BookingController;
import com.uni.controller.Cong_timeController;
import com.uni.controller.GuideAmuseController;
import com.uni.model.vo.Booking;

public class UtilMenu {

	private Scanner sc = new Scanner(System.in);	
	private BookingController bc = new BookingController();
	private Cong_timeController ct = new Cong_timeController();
	private GuideAmuseController gc = new GuideAmuseController();

	public UtilMenu() {

	}

	public void util() {

		while (true) {
			System.out.println("1. 혼잡도 조회");
			System.out.println("2. 이용 제한 요건 조회");
			System.out.println("3. 운행시간 조회");
			System.out.println("4. 예약");
			System.out.println("9. 이전 메뉴");
			System.out.println("메뉴를 입력해주세요: ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				congestion();
				break;
			case 2:
				System.out.println("===== 놀이기구 이용 조건 =====");
				gc.displayAllList();
				break;
			case 3:
				operatingTime();
				break;
			case 4:
				bookingMenu();
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

	

	public void congestion() { // 혼잡도 볼 수 있는 메소드

		while (true) {

			System.out.println("놀이기구의 혼잡도를 조회할 수 있습니다.");

			System.out.println("1. 바이킹");
			System.out.println("2. 회전목마");
			System.out.println("3. 범퍼카");
			System.out.println("4. 롤러코스터");
			System.out.println("9. 이전 메뉴로");
			System.out.println("놀이기구를 선택해주세요: ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
			case 2:
			case 3:
			case 4:
				System.out.println(ct.congestion(menu));
				break;

			case 9:
				System.out.println("이전 메뉴로 이동합니다.");
				return;
			}

		}
	}

	public void operatingTime() { // 운행시간 출력하는 메소드

		while (true) {
			System.out.println("놀이기구의 운행시간을 조회할 수 있습니다.");

			System.out.println("1. 바이킹");
			System.out.println("2. 회전목마");
			System.out.println("3. 범퍼카");
			System.out.println("4. 롤러코스터");
			System.out.println("9. 이전 메뉴로");
			System.out.println("놀이기구를 선택해주세요: ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
			case 2:
			case 3:
			case 4:
				System.out.println(ct.operatingTime(menu));
				break;

			case 9:
				System.out.println("이전 메뉴로 이동합니다.");
				return;
			}

		}
	}
	
	public void bookingMenu() {

		while (true) {
			System.out.println("=====예약 메뉴=====");
			System.out.println("1. 예약 등록");
			System.out.println("2. 예약 조회");
			System.out.println("3. 예약 삭제");
			System.out.println("9. 이전 메뉴로");
			System.out.println("메뉴를 선택하세요: ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				bc.bookingAtt();
				break;
			case 2:
				bc.bookingCheck();
				break;
			case 3:
				bc.bookingDelete();
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
