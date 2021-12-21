package com.uni.controller;

import java.util.Iterator;
import java.util.Scanner;

import com.uni.model.dao.GuideAmuseDao;
import com.uni.model.vo.GuideAmuse;

public class GuideAmuseController {

	Scanner sc = new Scanner(System.in);
	GuideAmuseDao ad = new GuideAmuseDao();
	

	public void insertGuideAmusement() { // 이용 제한 등록

		System.out.println("===== 놀이기구 이용 제한 등록 =====");

		// 입력
		System.out.println("놀이기구 이름 : ");
		String amuseName = sc.nextLine();

		System.out.println("나이 제한 (숫자만 입력) : ");
		int amuseAge = sc.nextInt();

		System.out.println("키 제한 (숫자만 입력) : ");
		double amuseHeight = sc.nextDouble();
		sc.nextLine();

		System.out.println("보호자 동반 (y / n) : ");
		char amuseParent = sc.nextLine().charAt(0);

		// ad.writeGuideAmuse 로 입력 받은 값 전달
		ad.writeGuideAmuse(new GuideAmuse(amuseName, amuseAge, amuseHeight, amuseParent));
		System.out.println(amuseName + " 놀이기구 이용 제한 등록 완료되었습니다.");
		ad.saveGuideAmuse(); // 파일에 저장

	}

	public void modifyGuideAmusement() { // 이용 메뉴 수정

		System.out.println("===== 놀이기구 이용 제한 수정 =====");

		// 입력
		System.out.println("놀이기구 이름 : ");
		String amuseName = sc.nextLine();

		// 찾아서 불러오기
		for (int i = 0; i < ad.displayAllList().size(); i++) { // 리스트를 0부터 사이즈 끝까지 돌려서
			if (ad.displayAllList().get(i).getAmuseName().equals(amuseName)) { // 입력 받은 타이틀과 같은 타이틀이 있을 때

				// 입력
				System.out.println("나이 제한 (숫자만 입력) : ");
				int amuseAge = sc.nextInt();

				System.out.println("키 제한 (숫자만 입력) : ");
				double amuseHeight = sc.nextDouble();
				sc.nextLine();

				System.out.println("보호자 동반 (y / n) : ");
				char amuseParent = sc.nextLine().charAt(0);

				// 입력 받은 값으로 변경
				ad.displayAllList().set(i, new GuideAmuse(amuseName, amuseAge, amuseAge, amuseParent));
				System.out.println(amuseName + " 놀이기구 이용 제한 수정 완료되었습니다.");

				break;

			} 

		}

		ad.saveGuideAmuse(); // 파일에 저장

	}

	public void displayAllList() { // 이용 제한 전체 조회

		Iterator it = ad.displayAllList().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

	public void deleteGuideAmusement() { // 이용 제한 삭제

		System.out.println("===== 놀이기구 이용 제한 삭제 =====");

		// 입력
		System.out.println("놀이기구 이름 : ");
		String amuseName = sc.nextLine();

		// 찾아서 불러오기
		for (int i = 0; i < ad.displayAllList().size(); i++) { // 리스트를 0부터 사이즈 끝까지 돌려서
			if (ad.displayAllList().get(i).getAmuseName().equals(amuseName)) { // 입력 받은 타이틀과 같은 타이틀이 있을 때

				// 삭제
				ad.displayAllList().remove(i);
				System.out.println(amuseName + " 놀이기구 이용 제한 삭제 완료되었습니다.");
				break;

			} 

		}

		ad.saveGuideAmuse(); // 파일에 저장
	}

}
