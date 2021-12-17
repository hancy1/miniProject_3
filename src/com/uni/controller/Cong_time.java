package uni.controller;

import java.util.Scanner;

import uni.model.vo.Booking;

public class Cong_time {

	private Scanner sc = new Scanner(System.in);
	Booking[] bk = new Booking[4];
	{
		bk[0] = new Booking("바이킹", "보통");
		bk[1] = new Booking("회전목마", "쾌적");
		bk[2] = new Booking("범퍼카", "보통");
		bk[3] = new Booking("롤러코스터", "복잡");
	}

	public void congestion() {

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
				System.out.println("선택하신 놀이기구는 <<<" + bk[menu - 1].getAttraction() + ">>>입니다.\n" + "현재 "
						+ bk[menu - 1].getAttraction() + "의 혼잡도는 " + bk[menu - 1].getCong() + "입니다.");
				if (bk[menu - 1].getCong().equals("쾌적")) {
					System.out.println("예상 대기시간은 10분입니다.\n");
					break;

				} else if (bk[menu - 1].getCong().equals("보통")) {
					System.out.println("예상 대기시간은 30분입니다.\n");
					break;

				} else if (bk[menu - 1].getCong().equals("복잡")) {
					System.out.println("예상 대기시간은 60분 이상입니다. 혼잡도가 복잡일 때는 놀이기구 예약이 제한됩니다.\n");
					break;
				}

			case 9:
				System.out.println("이전 메뉴로 이동합니다.");
				return; // 이전으로 안 가짐
			}

		}
	}

	public void time() {

		String vikrun = "의 운행시간은 오전 10시부터 오후 5시 30분까지입니다.\n";
		String vikend = "탑승 마감 시간은 5시입니다.\n";

		String merrun = "의 운행시간은 오전 10시부터 오후 6시까지입니다.\n";
		String merend = "탑승 마감 시간은 5시 45분입니다.\n";

		String bumprun = "의 운행시간은 오전 11시부터 오후 5시 30분까지입니다.\n";
		String bumpend = "탑승 마감 시간은 5시입니다.\n";

		String rolrun = "의 운행시간은 오전 10시부터 오후 5시까지입니다.\n";
		String rolend = "탑승 마감 시간은 4시입니다.\n";

		while (true) {
			System.out.println("놀이기구의 운행시간을 조회할 수 있습니다.");

			System.out.println("1. 바이킹");
			System.out.println("2. 회전목마");
			System.out.println("3. 범퍼카");
			System.out.println("4. 롤러코스터");
			System.out.println("9. 이전 메뉴로");
			System.out.println("놀이기구를 선택해주세요: ");
			int menu = sc.nextInt();
			String attName = bk[menu - 1].getAttraction();

			switch (menu) {
			case 1:
			case 2:
			case 3:
			case 4:
				System.out.println("선택하신 놀이기구는 선택하신 놀이기구는 <<<" + attName + ">>>입니다.");

				if (menu == 1) {
					System.out.println(attName + vikrun + vikend);
				} else if (menu == 2) {
					System.out.println(attName + merrun + merend);
				} else if (menu == 3) {
					System.out.println(attName + bumprun + bumpend);
				} else if (menu == 4) {
					System.out.println(attName + rolrun + rolend);
				}
				break;

			case 9:
				System.out.println("이전 메뉴로 이동합니다.");
				return; // 이전으로 안 가짐 ㅡㅡ
			}

		}
	}
}
