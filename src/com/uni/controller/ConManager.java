package com.convenience.user.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.convenience.user.model.dao.ConDao;
import com.convenience.user.model.vo.Convenience;
import com.convenient.user.model.dao.Dao;
import com.convenient.user.model.vo.Convenient;

public class ConManager {
	
	//기본생성자
	public ConManager() {
		// TODO Auto-generated constructor stub
	}
	
	
	//list 객체 생성
	ArrayList<Convenience> list = new ArrayList<>();
	
	//입력받기 위해서
	Scanner sc = new Scanner(System.in);
	
	//Manager 객체 생성
	ConDao d = new ConDao();
	
	
	
	
	
	//메뉴에서 3.편의시설 안내 넘어와서
	public void conInfo() {
		
		while(true) {
			
			System.out.println("편의시설을 입력하세요 (1.안내데스크 2.화장실): ");
			int con = sc.nextInt();
			sc.nextLine();
			
			//Manager로 con 전달
			d.searchCon(con);
			
			//리턴 받은 결과가 0이면 다시 입력받도록
			if(d.searchCon(con) == 0) {
				System.out.println("해당하는 편의시설이 없습니다. 다시 입력해주세요.");
				continue;
			}
			
			while(true) {
				
				System.out.println("구역을 입력하세요(A,B,C,D): ");
				char area = sc.nextLine().charAt(0);
				
				//Manager로 area 전달하고 list로 결과 전달 받음
				d.searchArea(area);
				
				//리턴 받은 결과가 0이면 다시 입력받도록
				if(d.searchArea(area) == 0) {
					System.out.println("해당하는 구역이 없습니다. 다시 입력해주세요.");
					continue;
					
				//2이면 (해당 구역에 찾는 편의시설이 없는 경우)
				} else if(d.searchArea(area) == 0) {
					System.out.println(area + "구역에는 " + con + "가 없습니다. 가까운 구역을 다시 입력하세요.");
				
				//1이면 해당 list로 안내메시지 출력
				} else {
					System.out.println(list.toString());
					return;
				}
			}
			
			
		}
		
	}


	
	
	

}
