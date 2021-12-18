package com.uni.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import com.uni.model.dao.ReviewDao;
import com.uni.model.vo.Review;

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
		//비밀번호 check 메소드만들기!
		
		
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
				reviewNo = rd.getLastReviewNo();
			}catch(IndexOutOfBoundsException e) { // 인덱스에 아무것도 없을 경우?
				reviewNo = 0;
			}finally {
				rd.writeAdminReview(new Review(reviewNo+1, reviewTitle, reviewDate, sb.toString(), pwd)); // 관리자용
				rd.writeReview(new Review(reviewNo+1, reviewTitle, reviewDate, sb.toString())); // 사용자용
				System.out.println("게시글이 등록되었습니다.");
			}
			rd.saveListFile();
		}
		
		
	

	public void readReview() { // 1. 후기조회
		
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
		
		Review r = rd.readReview(reviewNo);
		
		if(r == null) {
			System.out.println("입력한 글 번호의 후기가 없습니다.");
		}else {
			System.out.println(r);
		}
		
		System.out.println("비밀번호 입력 (숫자4자리) : ");
		String pwd = sc.nextLine();
		// 패스워드가 맞는지 체크 메소드만들기
		
		System.out.println("수정할 내용 입력 : ");
		String reviewContent = sc.nextLine();
		rd.editReview(reviewNo, reviewContent);
		
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
			System.out.println(r);
		}
		
		System.out.println("비밀번호 입력 (숫자4자리) : ");
		String pwd = sc.nextLine();
		// 패스워드가 맞는지 체크 메소드만들기
		
		rd.deleteReview(reviewNo);
		System.out.println("삭제가 완료되었습니다.");
		
		rd.saveListFile();
	}

	
}
