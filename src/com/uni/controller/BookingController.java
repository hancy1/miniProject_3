package com.uni.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

import com.uni.model.vo.Booking;

public class BookingController implements Serializable {

	private Booking bk = new Booking();
	private Scanner sc = new Scanner(System.in);

	public BookingController() {
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
			System.out.println("선택하신 놀이기구는 범퍼카입니다. 현재 범퍼카의 혼잡도는 보통입니다.");
			bk.setAttraction("범퍼카");
			bookingTime();
			break;
		case 4:
			System.out.println("선택하신 놀이기구는 롤러코스터입니다. 현재 롤러코스터의 혼잡도는 복잡입니다. 혼잡도가 복잡일 경우 예약이 제한되고 현장 대기만 가능합니다.");
			bk.setAttraction("롤러코스터");
			return;
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
			if (bk.getAttraction().equals("범퍼카")) {
				System.out.println("범퍼카의 운행시간은 11시부터입니다. 이후 시간대를 선택해주세요.");
				return;
			}
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
			if (bk.getAttraction().equals("롤러코스터")) {
				System.out.println("롤러코스터의 탑승마감 시간은 오후 4시입니다. 이전 시간대를 선택해주세요.");
				return;
			}
			bk.setTime("16:00 ~ 17:00");
			break;
		case 8:
			System.out.println("선택하신 시간대는 17:00 ~ 18:00입니다.");
			if (bk.getAttraction().equals("바이킹")) {
				System.out.println("바이킹의 탑승마감 시간은 오후 5시입니다. 이전 시간대를 선택해주세요.");
				return;
			} else if (bk.getAttraction().equals("롤러코스터")) {
				System.out.println("롤러코스터의 탑승마감 시간은 오후 4시입니다. 이전 시간대를 선택해주세요.");
				return;
			} else if (bk.getAttraction().equals("범퍼카") || bk.getAttraction().equals("회전목마")) {
				System.out.println(bk.getAttraction() + "의 탑승마감시간은 5시 45분입니다. 안내드린 시간보다 늦는 경우 탑승이 제한될 수 있습니다.");
			}
			bk.setTime("17:00 ~ 18:00");
			break;

		}

		method1();
	}

	public void method1() { // 인원 수 입력 후 예약확정하는 메소드

		int num = (int) (Math.random() * 100 + 1); // 예약번호
		bk.setNum(num);

		System.out.println("예약인원을 입력해주세요: ");
		int count = sc.nextInt();
		sc.nextLine();

		if (count > 4) {
			System.out.println("죄송합니다. 최대 예약인원은 4명입니다. 다시 입력해주세요.");
			return;
		}
		bk.setcount(count); // 인원 수 set

		System.out.println(count + "명이 맞습니까? 맞으면 Y, 틀리면 N을 입력해주세요.");
		String yn = sc.nextLine();

		ObjectOutputStream oos = null;

		if (yn.equalsIgnoreCase("y")) {
			System.out.println("예약 완료!!\n" + bk.toString() + "예약 번호는 " + bk.getNum() + "입니다.\n");
			try {
				oos = new ObjectOutputStream(new FileOutputStream("booking" + bk.getNum() + "txt")); // booking+예약번호 이름의
																										// 예약파일 생성

				bk = new Booking(bk.getAttraction(), bk.getTime(), bk.getcount());
				oos.writeObject(bk);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (oos != null) {
					try {
						oos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else if (yn.equalsIgnoreCase("n")) {
			System.out.println("다시 입력해주세요.");
		}
	}

	public void bookingCheck() {

		System.out.println("예약번호를 입력해주세요: ");
		int bnum = sc.nextInt();
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream("booking" + bnum + "txt"));
			Booking bk = (Booking) ois.readObject();
			System.out.println(bk.toString());

		} catch (IOException e) {
			System.out.println("예약 내역이 없습니다.");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public void bookingDelete() {

		System.out.println("예약번호를 입력해주세요: ");
		int bnum = sc.nextInt();
		sc.nextLine();

		File file = new File("booking" + bnum + "txt");
		if (file.exists()) {
			System.out.println("정말 예약취소 하겠습니까? (Y/N)");
			String yn = sc.nextLine();
			if (yn.equalsIgnoreCase("y")) {
				file.delete();
				System.out.println("예약이 취소되었습니다.");
			}
		} else if (!file.exists()) {
			System.out.println("예약 내역이 없습니다. 예약번호를 다시 확인해주세요.");
			return;
		}
	}
}