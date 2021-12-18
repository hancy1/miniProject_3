package com.uni.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import com.uni.model.dao.ReviewDao;
import com.uni.model.vo.Review;
import com.uni.model.vo.ReviewAdmin;

public class ReviewManager {

	Scanner sc = new Scanner(System.in);
	ReviewDao rd = new ReviewDao();

	public ReviewManager() {
		// TODO Auto-generated constructor stub
	}

	public void writeReview() { // 2. 등록
		System.out.println("<이용후기 등록>");
		System.out.println("예매번호 입력 (예매완료자만 후기등록 가능) : ");
		int tNum = sc.nextInt();
		//예몌번호 체크 메소드 만들기
		//if(메소드전달받음)
		sc.nextLine(); // 버퍼없애주기

		System.out.println("제목 : ");
		String reviewTitle = sc.nextLine();

		Date today = new Date();
		Date reviewDate = today;

		System.out.println("수정/삭제를 위한 비밀번호 (숫자4자리): ");
		String pwd = sc.nextLine();

		rd.checkPwd(pwd); // 비밀번호 조건 체크하는 메소드

		if(rd.checkPwd(pwd) == 1) { // 1이면 조건적합, 0이면 조건 부적합
			System.out.println("내용입력 (exit 입력시 내용입력 종료) : ");
			StringBuilder sb = new StringBuilder();
			while(true) { 

				String reviewContent = sc.nextLine();

				if(reviewContent.equalsIgnoreCase("exit")) {
					break;
				}else {
					sb.append(reviewContent + "\n"); // 줄바꾸기를 적용하며 저장.
				}
			}
			int reviewNo = 0;
			try {
				reviewNo = rd.getLastReviewNo(); // rd 메소드로 보내서 번호 얻어오기
			}catch(IndexOutOfBoundsException e) { // 인덱스에 아무것도 없을 경우?
				reviewNo = 0;
			}finally {
				rd.writeAdminReview(new ReviewAdmin(reviewNo+1, reviewTitle, reviewDate, sb.toString(), pwd)); // 관리자용
				rd.writeReview(new Review(reviewNo+1, reviewTitle, reviewDate, sb.toString(), pwd)); // 사용자용
				System.out.println("게시글이 등록되었습니다.");
			}
		}else {
			System.out.println("비밀번호는 숫자 4자리 여야 합니다.");
			return;
		}

		rd.saveListFile();
	}




	public void readReview() { // 1. 후기조회 (전체글이 다 나옴)

		ArrayList<Review> reviewList = rd.readAllReview();

		Iterator<Review> it = reviewList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()+"\n");
		}
	}

	public void editReview() { // 3. 후기수정
		System.out.println("수정할 글 번호 : ");
		int reviewNo = sc.nextInt();
		sc.nextLine();

		Review r = rd.readReview(reviewNo); // r에 맞는 글번호의 글을 담음

		if(r == null) {
			System.out.println("입력한 글 번호의 후기가 없습니다.");
		}else {
			System.out.println("비밀번호 입력 (숫자4자리) : ");
			String pwd = sc.nextLine();			
			Review rightPwd = rd.rightPwd(pwd); //맞는 비밀번호인지 확인하는 메소드
			if(rightPwd == null) {
				System.out.println("비밀번호가 틀렸습니다.");
				return;
			}else{
				System.out.println(rightPwd); // 패스워드가 맞다면 그 글 보여주기
			}
		}

		StringBuilder sb = new StringBuilder();
		System.out.println("수정할 내용 입력 : ");
		while(true) { 

			String reviewContent = sc.nextLine();

			if(reviewContent.equalsIgnoreCase("exit")) {
				break;
			}else {
				sb.append(reviewContent + "\n"); // 줄바꾸기를 적용하며 저장.
			}
		}


		System.out.println("수정내용을 저장하시겠습니까? (Y/N)");
		String edit = sc.nextLine();
		if(edit.equalsIgnoreCase("Y")) {
			rd.editReview(reviewNo, sb.toString());
			System.out.println("수정을 완료했습니다.");

			rd.saveListFile();
		}else {
			System.out.println("내용수정을 취소하셨습니다.");
			return;
		}

		rd.saveListFile();

	}

	public void deleteReview() { // 4. 글 삭제하기
		System.out.println("삭제할 글 번호 : ");
		int reviewNo = sc.nextInt();
		sc.nextLine();

		Review r = rd.readReview(reviewNo);

		if(r == null) {
			System.out.println("입력한 글 번호의 후기가 없습니다.");
		}else {
			System.out.println("비밀번호 입력 (숫자4자리) : ");
			String pwd = sc.nextLine();			
			Review rightPwd = rd.rightPwd(pwd); // 맞는 비밀번호인지 확인하는 메소드

			if(rightPwd == null) {
				System.out.println("비밀번호가 틀렸습니다.");
				return;
			}else{
				System.out.println(rightPwd); // 패스워드가 맞다면 그 글 보여주기
				System.out.println("정말 삭제하시겠습니까? (Y/N)");
				String delete = sc.nextLine();
				if(delete.equalsIgnoreCase("Y")) {
					rd.deleteReview(reviewNo);
					System.out.println("삭제가 완료되었습니다.");

					rd.saveListFile();
				}else {
					System.out.println("삭제를 취소하셨습니다.");
					return;
				}
			}
		}


		rd.saveListFile();
	}

	public void readAdminReview() { // 관리자가 조회를 할때는 비밀번호도 보여진다.

		ArrayList<ReviewAdmin> reviewAdminList = rd.readAdminAllReview();

		Iterator<ReviewAdmin> it = reviewAdminList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()+"\n");
		}

	}

	public void deleteAdminReview() { // 관리자는 비밀번호 인증 없이 삭제 가능
		System.out.println("삭제할 글 번호 : ");
		int reviewNo = sc.nextInt();
		sc.nextLine();

		Review r = rd.readReview(reviewNo);

		if(r == null) {
			System.out.println("입력한 글 번호의 후기가 없습니다.");
		}else {
			System.out.println(r); 
		}

		System.out.println("정말 삭제하시겠습니까? (Y/N)");
		String delete = sc.nextLine();
		if(delete.equalsIgnoreCase("Y")) {
			rd.deleteReview(reviewNo);
			System.out.println("삭제가 완료되었습니다.");

			rd.saveListFile();
		}else {
			System.out.println("삭제를 취소하셨습니다.");
			return;
		}

		rd.saveListFile();

	}


}
