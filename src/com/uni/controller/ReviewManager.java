package com.uni.controller;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.uni.model.dao.ReviewDao;
import com.uni.reviews.Review;

public class ReviewManager {

	Scanner sc = new Scanner(System.in);
	ArrayList<Review> list = new ArrayList<Review>();
	ReviewDao rd = new ReviewDao();

	public ReviewManager() { // 기본생성자
		// TODO Auto-generated constructor stub
	}

	public void readReview() { // 후기조회
		BufferedReader br = null;
		String s = null;
		int count = 0;
		
		ArrayList<Review> list = rd.displayAllList(); // BoardDao의 displayAllList() 메소드를 호출하여 ArrayList를 전달받음

		Iterator it = list.iterator(); // Iterator를 이용하여 list 에 기록된 정보를 모두 화면에 출력시킴
		while(it.hasNext()) {
			System.out.println(it.next()); // 글번호표기실패.....
		}
		
		try {
			for(int i = 0; i < list.size(); i++) {
				count = i;
			}
			br = new BufferedReader(new FileReader( count + ".txt"));
			try {
				while((s = br.readLine()) != null) {
					System.out.println(s);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("등록된 이용후기가 없습니다.");
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}


	public void writeReview() { //후기등록

		StringBuilder sb = new StringBuilder(); // String 연산을 위해 쓴 메소드


		System.out.println("예매번호 입력 : ");
		int tNum = sc.nextInt();
		sc.nextLine();

		/*
		 * if(민호님티켓넘버와 비교)
		 * */


		System.out.println("이용후기를 등록해주세요 (\"exit\" 을 입력하면 내용 입력 끝) : ");

		while(true) { // 반복문으로 내용입력 받기

			String content = sc.nextLine();

			if(content.equalsIgnoreCase("exit")) {break;} // exit 를 입력하면 끝.
			else {sb.append(content + "\n");} // 내용 + 내용

		}

		System.out.println("저장하시겠습니까? (Y/N)");
		String save = sc.nextLine();


		if(save.equalsIgnoreCase("Y")) { // 대문자소문자 구분없이 y면 저장
			System.out.println("수정/삭제 시 필요한 글의 비밀번호를 입력해주세요 (숫자4자리) : ");
			String pwd = sc.nextLine(); // 비밀번호 입력받기

			if(rd.checkPwd(pwd) == 0) { // rd.checkPwd로 보내서 비밀번호 조건 체크, 비밀번호는 슛자 4자리여야 하므로 
				System.out.println("숫자 4자리를 입력해주세요. 이용후기 메뉴로 돌아갑니다.");
				return;
			}


		}


		int rNo = 0; // 글번호 초기화선언
		BufferedWriter bw = null;// 변수 밖에서 초기화
		int count = 0;
		try {			
			for(int i = 0; i < bw.toString().length(); i++) {
				count = i;
			}
			
			bw = new BufferedWriter(new FileWriter( count + ".txt"));
			bw.write(sb.toString());
			rNo = count;

		}catch (IOException e) {
			e.printStackTrace();
		}catch(IndexOutOfBoundsException e) { // 등록된 글이 없다면
			rNo = 0;
		}finally {
			
			try {
			rd.writeReview(new Review(rNo+1, sb.toString())); // 글번호와 내용을 rd의 writeReview로 보내 list에 저장
			System.out.println("글번호 No." + rNo + "에 등록되었습니다."); // 왜 자꾸 0으로 출력되는건지......
				bw.close(); // 열었던 BufferedWriter 닫아주기
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public void editReview() { //후기수정
		System.out.println("수정할 글번호 : ");
		int rNo = sc.nextInt();
		sc.nextLine();

		Review r = rd.displayReview(rNo); // 글번호와 똑같은 글 불러오기
		if(r == null) {
			System.out.println("조회된 글이 존재하지 않습니다.");
		}else {System.out.println(r);} // 글 출력

		System.out.println("변경할 내용 : ");
		String content = sc.nextLine();

		rd.editContent(rNo, content);
	}

	public void deleteReview() { //후기삭제

		System.out.println("삭제할 글번호 : ");
		int rNo = sc.nextInt();
		sc.nextLine();

		Review r = rd.displayReview(rNo);
		if(r == null) {
			System.out.println("조회된 글이 존재하지 않습니다.");
		}else {
			System.out.println("정말 삭제하시겠습니까? (Y/N)");
			String delete = sc.nextLine();

			if(delete.equalsIgnoreCase("Y")) {
				rd.deleteContent(rNo);
				System.out.println("삭제가 완료되었습니다.");
			}
		}

	}
}
