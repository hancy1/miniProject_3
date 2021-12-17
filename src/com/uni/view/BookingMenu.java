package uni.view;

import java.util.ArrayList;
import java.util.Scanner;

import uni.controller.BookingController;
import uni.model.vo.Booking;

public class BookingMenu {

	private Booking bk = new Booking(null, null, 0, 0);
	private BookingController bc = new BookingController();
	private Scanner sc = new Scanner(System.in);

	public BookingMenu() {
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
				bookingAtt();
				break;
			case 2:
				bookingCheck();
				break;
			case 3:
				bookingDelete();
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

	public void bookingAtt() {

		System.out.println("1. 바이킹");
		System.out.println("2. 회전목마");
		System.out.println("3. 범퍼카");
		System.out.println("4. 롤러코스터");
		System.out.println("놀이기구를 선택하세요.: ");

		int menu = sc.nextInt();

		switch (menu) {
		case 1:
			System.out.println("선택하신 놀이기구는 바이킹입니다. 현재 바이킹의 혼잡도는 보통입니다.");
			bk.setAttraction("바이킹");
			bookingTime();
			break;
		case 2:
			System.out.println("선택하신 놀이기구는 회전목마입니다. 현재 회전목마의 혼잡도는 쾌적입니다.");
			bk.setAttraction("회전목마");
			bookingTime();
			break;
		case 3:
			System.out.println("선택하신 놀이기구는 범퍼카입니다. 현재 범퍼카의 혼잡도는 복잡입니다. 예약이 불가능합니다.");
			bk.setAttraction("범퍼카");
			return;
		case 4:
			System.out.println("선택하신 놀이기구는 롤러코스터입니다. 현재 롤러코스터의 혼잡도는 보통입니다.");
			bk.setAttraction("롤러코스터");
			bookingTime();
			break;
		default:
			System.out.println("잘못 선택하셨습니다.");
			return;
		}

	}

	public void bookingTime() {

		System.out.println("=====예약 시간=====");

		System.out.println("1. 10:00 ~ 11:00");
		System.out.println("2. 11:00 ~ 12:00");
		System.out.println("3. 12:00 ~ 13:00");
		System.out.println("4. 13:00 ~ 14:00");
		System.out.println("5. 14:00 ~ 15:00");
		System.out.println("6. 15:00 ~ 16:00");
		System.out.println("7. 16:00 ~ 17:00");
		System.out.println("8. 17:00 ~ 18:00");

		System.out.println("시간을 선택해주세요: ");
		int menu = sc.nextInt();

		switch (menu) {
		case 1:
			System.out.println("선택하신 시간대는 10:00 ~ 11:00입니다.");
			bk.setTime("10:00 ~ 11:00");
			break;
		case 2:
			System.out.println("선택하신 시간대는 11:00 ~ 12:00입니다.");
			bk.setTime("11:00 ~ 12:00");
			break;
		case 3:
			System.out.println("선택하신 시간대는 12:00 ~ 13:00입니다.");
			bk.setTime("12:00 ~ 13:00");
			break;
		case 4:
			System.out.println("선택하신 시간대는 13:00 ~ 14:00입니다.");
			bk.setTime("13:00 ~ 14:00");
			break;
		case 5:
			System.out.println("선택하신 시간대는 14:00 ~ 15:00입니다.");
			bk.setTime("14:00 ~ 15:00");
			break;
		case 6:
			System.out.println("선택하신 시간대는 15:00 ~ 16:00입니다.");
			bk.setTime("15:00 ~ 16:00");
			break;
		case 7:
			System.out.println("선택하신 시간대는 16:00 ~ 17:00입니다.");
			bk.setTime("16:00 ~ 17:00");
			break;
		case 8:
			System.out.println("선택하신 시간대는 17:00 ~ 18:00입니다.");
			bk.setTime("17:00 ~ 18:00");
			break;
		}
		bookingPeople();

	}

	public void bookingPeople() {

		int num = 1;
		bk.setNum(num++);
		System.out.println("예약인원을 입력해주세요: ");
		int count = sc.nextInt();
		bk.setcount(count);
		sc.nextLine();

		System.out.println(count + "명이 맞습니까? 맞으면 Y, 틀리면 N을 입력해주세요.");
		String yn = sc.nextLine();

		if (yn.equalsIgnoreCase("y")) {
			System.out.println("예약 완료!!");
			System.out.println(bk.toString());
			System.out.println("예약 번호는 : " + bk.getNum() + "입니다.");
		ArrayList<Booking> bookingList = new ArrayList<>();
		bookingList.add(new Booking(bk.getAttraction(), bk.getTime(), bk.getcount(), bk.getNum()));			

		} else if (yn.equalsIgnoreCase("n")) {
			System.out.println("다시 입력해주세요.");
			return;
		}
	}

	public void bookingCheck() { //체크

		System.out.println("예약번호를 입력해주세요: ");
		int bnum = sc.nextInt();

		ArrayList<Booking> searchList = bc.check(bnum);

		if (searchList == null) {
			System.out.println("검색 결과가 존재하지 않습니다.");
		} else if (searchList != null) {
			for (Booking b : searchList) {
				System.out.println(b.toString());
			}
		}

	}

	public void bookingDelete() {

		System.out.println("예약번호를 입력해주세요: ");
		int bnum = sc.nextInt();
		sc.nextLine();

		ArrayList<Booking> searchList = bc.check(bnum);

		if (searchList == null) {
			System.out.println("검색 결과가 존재하지 않습니다.");
		} else if (searchList != null) {
			for (Booking b : searchList) {
				System.out.println("정말 삭제하시겠습니까?(Y/N)");
				String yn = sc.nextLine();
				if (yn.equalsIgnoreCase("y")) {
					bc.delete(bnum);
					System.out.println("삭제되었습니다.");
				} else if (yn.equalsIgnoreCase("n")) {
					System.out.println("취소되었습니다. 이전 메뉴로 돌아갑니다.");
					return;
				}

			}
		}

	}
}
