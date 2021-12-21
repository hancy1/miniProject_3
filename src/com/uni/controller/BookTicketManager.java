package com.uni.controller;

import java.util.Scanner;

import com.uni.model.dao.BookDao;
import com.uni.model.vo.BookTicket;

public class BookTicketManager {
	
	Scanner sc = new Scanner (System.in);	
	BookDao bd = new BookDao();
	
	
	
	public BookTicketManager() {
		// TODO Auto-generated constructor stub
	}
	
	

	public void bookTicket() { // 티켓예매
		
		System.out.println("<자바월드 티켓 예매>");
		System.out.println("티켓가격은 1인 30000원 입니다.");
		System.out.println("몇 명을 예매하시겠습니까?");
		int count = sc.nextInt();
		sc.nextLine();
		
		
		System.out.println("총 합계는 " + BookTicket.getPrice()*count + "원 입니다.");
		System.out.println("예매하시겠습니까? (Y/N)");
		String pay = sc.nextLine();
		
		int tNum = 0;
		if(pay.equalsIgnoreCase("Y")) {
			int tNo = 0; // 티켓번호 초기화
			try {
				tNo = bd.getTNo(); // bd.getTNo 메소드로 보내서 번호 얻어오기 (1~10000 랜덤값)
				
			}catch(IndexOutOfBoundsException e) { // 인덱스에 아무것도 없을 경우 0
				tNo = 0;
			}finally {
				
				bd.writeBookTicket(new BookTicket(tNo, count, BookTicket.getPrice()*count)); //bookList에 저장
				bd.saveListFile(); // book.txt 에 저장
				BookTicket result = bd.readBook(tNo); // bookList에서 똑같은 티켓넘버 내용 가져오기
				System.out.println(result);
				//System.out.println("BookTicketManager에서 객체불러오기" + result);			
				System.out.println("예매 완료!");				
			}
		}else {
			System.out.println("예매를 취소하셨습니다.");
			return;
		}
		
		
	}

}
