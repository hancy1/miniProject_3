package com.uni.busresv;

import java.util.Scanner;
import java.util.ArrayList;

public class Busdemo {

	public static void main(String[] args) {
	
		ArrayList<Bus> buses  = new ArrayList<Bus>();
		ArrayList<Booking> bookings  = new ArrayList<Booking>();
		
		
		buses.add(new Bus(1,true,45));
		buses.add(new Bus(2,false,50));
		
		
		int userOpt = 1;
		Scanner sc = new Scanner(System.in);
		
		for(Bus b:buses) {
			b.displayBusInfo(); 
		}
		while(userOpt==1) {
			System.out.println("== 자바월드 버스 예약 시스템==");
			System.out.println("1. 버스 예약");
			System.out.println("2. 버스 정거장 정보");
			System.out.println("9. 이전 메뉴 ");
			System.out.println("0. 프로그램 종료 ");
			System.out.println("번호를 입력해주세요 :");
		
			userOpt = sc.nextInt();
			if(userOpt == 1) {
				System.out.println("예약중..........");
				System.out.println("=====================");
					Booking booking  = new Booking();
					if(booking.isAvailable(bookings,buses)) {
						bookings.add(booking);
						System.out.println("예약이 확인 되었습니다.");
					}
					else
						System.out.println("죄송합니다. 버스 좌석이 꽉찼습니다.");
			}else if(userOpt == 2) {
				System.out.println("버스 정거장 정보");
				System.out.println("=====================");
				System.out.println("1.평일 셔틀버스 시간표 ");
				System.out.println("2.주말 셔틀더스 시간표 ");
				System.out.println("9.이전 메뉴  ");
				System.out.println("번호를 입력해주세요 :");
			}else if (userOpt == 9) {
				System.out.println("이전메뉴로 돌아갑니다.");
				System.out.println("=====================");
				return;
			}else{
				System.out.println("번호를 잘못입력하였습니다 .다시 입력해주세요");
				System.out.println("=====================");
				break;
			}
				
				
			
				int num = sc.nextInt();
				
				switch(num) {// 주말 버스 메뉴 번호
			    case 1:
			    	weekbutime();
			    	break;
			    case 2:
			    	weekendbustime();
			    	break;
			    case 9:
			    	return;
			    default :
			    	System.out.println("번호를 잘못 입력하였습니다. 다시 입력해주세요");
			    	break;
			    	
			    	
				
				
			}
			
			
			
				
			
			}
			
			
		}

	

	private static void weekbutime() {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("  ");
		System.out.println("==== 평일 셔틀버스 시간표 ====");
		System.out.println("1. cc역 ---> 자바월드 버스시간표");
		System.out.println("2. 자바월드 --> cc역");
		System.out.println("9. 이전메뉴");
		System.out.println("번호를 입력해주세요(숫자만 입력) : ");
		System.out.print(">");
		
		int num = sc.nextInt();
		
	    switch(num) {// 평일 버스 메뉴 번호
	    case 1:
	    	printWeekSchedule1();
	    	break;
	    case 2:
	    	printWeekSchedule2();
	    	break;
	    case 9:
	    	return;
	    default :
	    	System.out.println("번호를 잘못 입력하였습니다. 다시 입력해주세요");
	    	break;		
		
		}		
		
	}
	private static void printWeekSchedule1() {
		System.out.println("평일 cc 역에서 자바월드까지 가는 셔틀버스");
		System.out.println("=================================");
		System.out.println("08:20,08:40,09:00");
		System.out.println("09:20,09:40,00:00");
		System.out.println("10:20,10:40,11:00");
		System.out.println("11:20,11:40,12:00");
		System.out.println("12:20,12:40,13:00");
		System.out.println("13:20,13:40,14:00");
		System.out.println("14:20,14:40,15:00");
		System.out.println("15:20,15:40,16:00");
		System.out.println("16:20,16:40,17:00");
		System.out.println("17:20,17:40,18:00");
		System.out.println("18:20,18:40,19:00");
		System.out.println("=================================");
		
	}
	
	private static void printWeekSchedule2() {
		System.out.println("평일 자바월드에서 cc역까지 가는 셔틀버스");
		System.out.println("=================================");
		System.out.println("08:00,08:20,08:40");
		System.out.println("09:00,09:20,09:40");
		System.out.println("10:00,10:20,10:40");
		System.out.println("11:00,11:20,11:40");
		System.out.println("12:00,12:20,12:40");
		System.out.println("13:00,13:20,13:40");
		System.out.println("14:00,14:20,14:40");
		System.out.println("15:00,15:20,15:40");
		System.out.println("16:00,16:20,16:40");
		System.out.println("17:00,17:20,17:40");
		System.out.println("18:00,18:20,18:40");
		System.out.println("=================================");
		
	}
	
	private static void weekendbustime() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("  ");
		System.out.println("==== 주말 셔틀버스 시간표 ====");
		System.out.println("1. cc역 ---> 자바월드 버스시간표");
		System.out.println("2. 자바월드 --> cc역");
		System.out.println("9. 이전메뉴");
		System.out.println("번호를 입력해주세요(숫자만 입력) : ");
		System.out.print(">");
		
		int num = sc.nextInt();
		
	    switch(num) {// 평일 버스 메뉴 번호
	    case 1:
	    	printWeekendSchedule1();
	    	break;
	    case 2:
	    	printWeekedSchedule2();
	    	break;
	    case 9:
	    	return;
	    default :
	    	System.out.println("번호를 잘못 입력하였습니다. 다시 입력해주세요");
	    	break;		
		
		}
		
	}



	private static void printWeekedSchedule2() {
		System.out.println("주말 cc 역에서 자바월드까지 가는 셔틀버스");
		System.out.println("=================================");
		System.out.println("09:20,09:40,00:00");
		System.out.println("10:20,10:40,11:00");
		System.out.println("11:20,11:40,12:00");
		System.out.println("12:20,12:40,13:00");
		System.out.println("13:20,13:40,14:00");
		System.out.println("14:20,14:40,15:00");
		System.out.println("15:20,15:40,16:00");
		System.out.println("16:20,16:40,17:00");
		System.out.println("17:20,17:40,18:00");
		System.out.println("18:20,18:40,19:00");
		System.out.println("=================================");
		
	}



	private static void printWeekendSchedule1() {
		System.out.println("주말 자바월드에서 cc역까지 가는 셔틀버스");
		System.out.println("=================================");
		System.out.println("09:00,09:20,09:40");
		System.out.println("10:00,10:20,10:40");
		System.out.println("11:00,11:20,11:40");
		System.out.println("12:00,12:20,12:40");
		System.out.println("13:00,13:20,13:40");
		System.out.println("14:00,14:20,14:40");
		System.out.println("15:00,15:20,15:40");
		System.out.println("16:00,16:20,16:40");
		System.out.println("17:00,17:20,17:40");
		System.out.println("18:00,18:20,18:40");
		System.out.println("=================================");
		
	}
}


	
