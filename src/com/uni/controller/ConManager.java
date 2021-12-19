package com.uni.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.uni.model.dao.ConDao;
import com.uni.model.vo.Convenience;




public class ConManager {
	
	//기본생성자
	public ConManager() {
		// TODO Auto-generated constructor stub
	}
	
	
	//list 객체 생성
	ArrayList<Convenience> list = new ArrayList<>();
	
	//입력받기 위해서
	Scanner sc = new Scanner(System.in);
	
	//
	ConDao cd = new ConDao();
	Convenience c = new Convenience();
	
	
	
	
	
	//메뉴에서 3.편의시설 안내 넘어와서
	//편의시설이랑 구역 한 번에 받아서 일치하는 거 있으면 출력하는 걸로 바꿀까 ..?
	public void conInfo() {
		
		while(true) {
			
			System.out.println("편의시설을 입력하세요 (안내데스크, 화장실): ");
			String con = sc.nextLine();
			//sc.nextLine();
			
			System.out.println("구역을 입력하세요 (A,B,C,D,정문): ");
			String area = sc.nextLine();
			
			//Dao의 searchCon으로 편의시설과 구역 전달
			cd.searchCon(con, area);
			
			
			//리턴값이 null이면 다시 입력받도록
			if(cd.searchCon(con, area) == null) {
				
				System.out.println("해당 편의시설이 없습니다. 다시 입력해주세요.");
				System.out.println();
				continue;
			}
			
			//null이 아니면 객체 출력하도록
			System.out.println(cd.searchCon(con, area));
			System.out.println();
			break;
			
		}
	}
	
	
	
	
	//편의시설 등록
	public void insertCon() {
		
		System.out.println("등록할 편의시설 : ");
		String con = sc.nextLine();
		
		System.out.println("등록할 편의시설 구역 : ");
		String area = sc.nextLine();
		
		System.out.println("등록할 편의시설 위치 : ");
		String position = sc.nextLine();
		
		// ConDao의 getLastConNo() 메소드를 통해 게시글의 마지막 번호를 알아옴
		//-> cd.getLastCondNo();
		//-> Convenience 객체 생성시 +1 되도록
		
		// ConDao의 insertCon() 메소드 호출 시 해당 Convenience 전달
		//-> cd.insertCon();
		
		// 파일이 존재하지 않을 경우 -> 첫 등록일 경우 예외 발생
		//-> IndexOutOfBoundsException 파일 없으면 발생
		// try catch로 오류 해결
		
		int lastNo = 0;
		
		try {
			lastNo = cd.getLastBoardNo();
		
		} catch(IndexOutOfBoundsException e) {
			
			//첫 글일 때 그 편의시설 번호 1로 등록
			cd.insertCon(new Convenience(1, con, area, position));
			
			
		} finally {
			
			if(lastNo != 0) {
				cd.insertCon(new Convenience(cd.getLastBoardNo()+1, con, area, position));
				//cd.saveListFile();
			}
			System.out.println("등록이 완료되었습니다.");
			
		}
		
		
	}
	
	
	
	
	//수정할 편의시설 번호, 수정할 내용 입력
	//ConDao의 modifyCon() 메소드로 해당 편의시설 번호와 수정할 내용 전달
	public void modifyCon() {
		
		System.out.println("수정할 편의시설 번호 : ");
		int no = sc.nextInt();
		sc.nextLine();
		
		//ConDao의 displayCon() 메소드에 편의시설 번호 전달
		//해당하는 편의시설 없을 경우 "조회한 번호의 편의시설이 없습니다." 출력
		if(cd.displayCon(no) == null) {
			System.out.println("해당 번호의 편의시설이 없습니다. 이전 메뉴로 돌아갑니다.");
		
		} else {
			//해당 편의시설 번호와 편의시설 전달 받아 출력하고
			System.out.println(cd.displayCon(no));
			
			//변경할 내용 입력 받음
			System.out.println("변경할 편의시설 : ");
			String con = sc.nextLine();
			
			/*while(true) {
				
				System.out.println("변경할 편의시설 구역 : ");
				String area = sc.nextLine();
				
				if(area == "A") {
					
				}
			}*/
			
			System.out.println("변경할 편의시설 구역 : ");
			String area = sc.nextLine();
			
			System.out.println("변경할 편의시설 위치 : ");
			String position = sc.nextLine();
			
			//수정한 내용으로 객체 생성(편의시설 번호는 그대로)
			
			
			//수정ConDao의 modifyCon() 메소드에 해당 편의시설 번호와 변경할 내용 전달
			cd.modifyCon(no, con, area, position);
			
			System.out.println("수정되었습니다.");
			cd.saveListFile();
				
		}
		
	}



	
	//편의시설 정보 삭제
	public void deleteCon() {
		
		System.out.println("삭제할 글 번호 : ");
		int no = sc.nextInt();
		sc.nextLine();
		
		// ConDao의 displayCon() 메소드에 글 번호를 전달하여
		// 만약 없을 경우 “조회된 글이 없습니다.” 출력
		if(cd.displayCon(no) == null) {
			System.out.println("해당 번호의 편의시설이 없습니다. 이전 메뉴로 돌아갑니다.");
			
		// 있을 경우 해당 번호 편의시설 내용 출력하고
		//“정말로 삭제하시겠습니까? (y/n) : “ >> 입력 받음
		} else {
			
			System.out.println(cd.displayCon(no));
			System.out.println("정말로 삭제하시겠습니까? (y/n): ");
			String str = sc.nextLine();
			
			// 대소문자 관계없이 Y 일 경우 ConDao의 deleteCon() 메소드에 해당 글 번호 전달
			if(str.equalsIgnoreCase("y")) {
				
				try {
					cd.deleteCon(no);
					
				} catch(IndexOutOfBoundsException e ) {
					e.printStackTrace();
					return;
					
				} finally {
					System.out.println(no + "번 편의시설이 삭제되었습니다.");
				}
				
			} else {
				System.out.println("삭제가 취소되었습니다. 이전 메뉴로 돌아갑니다.");
				return;
			}
			
		}
			
	}
	

	
	
	//ConDao의 displayAllList() 메소드를 통해 list를 전달받고
	//Iterator를 이용하여 전체 리스트 출력
	public void displayAllList() {
		
		
		//ConDao의 displayAllList() 메소드를 통해 ArrayList를 전달 받음
		ArrayList<Convenience> list = cd.displayAllList();
		
		// Iterator를 이용하여 list 에 기록된 정보를 모두 화면에 출력시킴
		Iterator it = list.iterator();
		while(it.hasNext()) { //다음 출력할 게 있냐
			System.out.println(it.next()); //있으면 출력
		}
		
		
	}
	
	
	
	
	//ConDao의 saveListFile()로 메소드 호출
	public void saveListFile() {
		
		cd.saveListFile();
	}
		



}
