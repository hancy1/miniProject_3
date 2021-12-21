package com.uni.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
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


			//System.out.println("편의시설을 입력하세요(exit 입력 시 이전 메뉴로) : ");

			while(true) {

				System.out.println("편의시설을 입력하세요(exit 입력 시 이전 메뉴로) : ");
				String con = sc.nextLine();

				if(con.equalsIgnoreCase("exit")) {
					System.out.println("이전 메뉴로 돌아갑니다.");
					System.out.println();
					return;
				}
				//편의시설 잘 입력한 경우
				System.out.println("구역을 입력하세요 : ");
				String area = sc.nextLine();

				
				if(cd.searchCon(con, area) == null) {
					
					System.out.println("해당 편의시설이 검색되지 않습니다. 다시 입력해주세요.");
					System.out.println();
					continue;
					
				} else {
					
					System.out.println(cd.searchCon(con, area));
					System.out.println();
					return;
				}
				
				
				
			}


	}



	//편의시설 등록
	public void insertCon() {


		System.out.println("등록할 편의시설 : ");
		String con = sc.nextLine();


		System.out.println("등록할 편의시설 구역 : ");
		while(true) {


			String area = sc.nextLine();

			//구역 제대로 입력하면 순서대로 실행
			if(area.equalsIgnoreCase("a") || area.equalsIgnoreCase("b") || area.equalsIgnoreCase("c")
					|| area.equalsIgnoreCase("d") || area.equals("정문")) {

				System.out.println("등록할 편의시설 위치 : ");
				String position = sc.nextLine();


				//정말 등록할 것인지 확인. 잘못 입력했을 경우 취소할 수 있도록
				System.out.println("정말 등록하시겠습니까? (y/n): ");
				String str = sc.nextLine();

				if(str.equalsIgnoreCase("y")) {
					
					int no = 0; //여기서 초기화 해줘야 finally에서 가져다 쓸 수 있음
					
					try {
						no = cd.getLastBoardNo();

					} catch(IndexOutOfBoundsException e) {
						
						//첫 글일 때 그 편의시설 번호 1로 등록되도록
						no = 0;

					} finally {
						cd.insertCon(new Convenience(no+1, con, area.toUpperCase(), position));
						cd.saveListFile(); // savefile
						System.out.println("등록이 완료되었습니다.");

						return;

					}

				} else {
					System.out.println("등록이 취소되었습니다. 이전 메뉴로 돌아갑니다.");
					return;
				}

			//놀이공원 구역 외에 다른 것 입력되면 다시 입력하도록
			} else {
				System.out.println("해당 구역은 존재하지 않습니다. 다시 입력해주세요.");
				continue;

			}


		}

	}




	//수정할 편의시설 번호, 수정할 내용 입력
	//ConDao의 modifyCon() 메소드로 해당 편의시설 번호와 수정할 내용 전달
	public void modifyCon() {

		//전체 출력 후 시작
		displayAllList();
		System.out.println();

		while(true) {
			
			//정수 외 다른 것 입력하면 런타임 오류 나서 try-catch로 잡음
			try {
				System.out.println("수정할 편의시설 번호 : ");
				int no = sc.nextInt();
				sc.nextLine(); // 버퍼 없애기
		
		
				Convenience result = cd.displayCon(no); // 객체불러오기
				//System.out.println("ConManager로 가져오기 : " + result); // 확인차 해봤어요
		
		
				//--------------------------------------------------이어서 실행
				//ConDao의 displayCon() 메소드에 편의시설 번호 전달
				//해당하는 편의시설 없을 경우 "조회한 번호의 편의시설이 없습니다." 출력
				if(result == null) {
					System.out.println("해당 번호의 편의시설이 없습니다. 이전 메뉴로 돌아갑니다.");
					return;
				} else {
		
					//해당 편의시설 번호와 편의시설 전달 받아 출력하고
					System.out.println(result);
					System.out.println();
		
					//변경할 내용 입력 받음
					System.out.println("변경할 편의시설 : ");
					String con = sc.nextLine();
		
					
					while(true) {
						
						System.out.println("변경할 편의시설 구역 : ");
						String area = sc.nextLine();
						
						//구역 제대로 입력하면 순서대로 실행
						if(area.equalsIgnoreCase("a") || area.equalsIgnoreCase("b") || area.equalsIgnoreCase("c")
								|| area.equalsIgnoreCase("d") || area.equals("정문")) {
		
							System.out.println("변경할 편의시설 위치 : ");
							String position = sc.nextLine();
		
		
							//정말 수정할 것인지 확인. 잘못 입력했을 경우 취소할 수 있도록
							System.out.println("정말 수정하시겠습니까? (y/n): ");
							String str = sc.nextLine();
		
							if(str.equalsIgnoreCase("y")) {
		
								//수정ConDao의 modifyCon() 메소드에 해당 편의시설 번호와 변경할 내용 전달
								cd.modifyCon(no, con, area, position);
								//수정 내용 파일에 저장
								cd.saveListFile();
								System.out.println("수정되었습니다.");
								
								return;
		
							} else {
								System.out.println("수정이 취소되었습니다. 이전 메뉴로 돌아갑니다.");
								return;
							}
		
						//놀이공원 구역 외에 다른 것 입력되면 다시 입력하도록
						} else {
							System.out.println("해당 구역은 존재하지 않습니다. 다시 입력해주세요.");
							continue;
		
		
						}
		
					
					}
		
				}
			} catch(InputMismatchException e) {
				
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				System.out.println();
				sc.nextLine();
				continue;
			
				}
			}
			
		
		
	}






	//편의시설 정보 삭제
	public void deleteCon() {

		//전체 출력 후 시작
		displayAllList();
		System.out.println();
		
		while(true) {
			
			//정수 외 다른 것 입력하면 런타임 오류 나서 try-catch로 잡음
			try {
		
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
					System.out.println("정말 삭제하시겠습니까? (y/n): ");
					String str = sc.nextLine();
			
					// 대소문자 관계없이 Y 일 경우 ConDao의 deleteCon() 메소드에 해당 글 번호 전달
					if(str.equalsIgnoreCase("y")) {
			
						try {
							cd.deleteCon(no);
			
			
						} catch(IndexOutOfBoundsException e ) {
							e.printStackTrace();
							return;
			
						} finally {
							cd.saveListFile();
							System.out.println(no + "번 편의시설이 삭제되었습니다.");
							return;
							
						}
			
					} else {
						System.out.println("삭제가 취소되었습니다. 이전 메뉴로 돌아갑니다.");
						return;
					}
			
				}
				
			} catch(InputMismatchException e) {
				
			System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			System.out.println();
			sc.nextLine();
			continue;
		
			}
			
			return;
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
