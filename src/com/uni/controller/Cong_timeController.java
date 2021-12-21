package com.uni.controller;

import java.util.Scanner;

import com.uni.model.vo.Booking;

public class Cong_timeController {

	private Scanner sc = new Scanner(System.in);
	Booking[] bk = new Booking[4];
	{
		bk[0] = new Booking("바이킹", "보통");
		bk[1] = new Booking("회전목마", "쾌적");
		bk[2] = new Booking("범퍼카", "보통");
		bk[3] = new Booking("롤러코스터", "복잡");
	}

	public String congestion(int menu) {

		String cong = "선택하신 놀이기구는 <<<" + bk[menu - 1].getAttraction() + ">>>입니다.\n" + "현재 "
				+ bk[menu - 1].getAttraction() + "의 혼잡도는 " + bk[menu - 1].getCong() + "입니다.";

		String ctime = null;
		if (bk[menu - 1].getCong().equals("쾌적")) {
			ctime = "예상 대기시간은 10분입니다.\n";

		} else if (bk[menu - 1].getCong().equals("보통")) {
			ctime = "예상 대기시간은 30분입니다.\n";

		} else if (bk[menu - 1].getCong().equals("복잡")) {
			ctime = "예상 대기시간은 60분 이상입니다. 혼잡도가 복잡일 때는 놀이기구 예약이 제한됩니다.\n";
		}

		return cong + ctime;

	}

	public String operatingTime(int menu) {

		String viking = "바이킹의 운행시간은 오전 10시부터 오후 5시 30분까지입니다.\n 탑승 마감 시간은 5시입니다.\n";

		String merry = "회전목마의 운행시간은 오전 10시부터 오후 6시까지입니다.\n 탑승 마감 시간은 5시 45분입니다.\n";

		String bumper = "범퍼카의 운행시간은 오전 11시부터 오후 5시 30분까지입니다.\n 탑승 마감 시간은 5시 45분입니다.\n";

		String roller = "롤러코스터의 운행시간은 오전 10시부터 오후 5시까지입니다.\n 탑승 마감 시간은 4시입니다.\n";

		String attName = bk[menu - 1].getAttraction();

		String attraction = "선택하신 놀이기구는 선택하신 놀이기구는 <<<" + attName + ">>>입니다.";
		String operatingTime = "";

		if (menu == 1) {
			operatingTime = viking;
		} else if (menu == 2) {
			operatingTime = merry;
		} else if (menu == 3) {
			operatingTime = bumper;
		} else if (menu == 4) {
			operatingTime = roller;
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}

		return attraction + operatingTime;
	}

}
