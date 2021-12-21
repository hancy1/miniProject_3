package com.uni.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

import com.uni.model.vo.Convenience;







public class ConDao {

	Convenience c = new Convenience();
	
	ArrayList<Convenience> list = new ArrayList<>();
	

	

	//convenience_list.dat 파일의 내용을 읽어서 list에 저장함
	//null 될 때까지 저장함
	public ConDao() {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("convenience_list.txt"))) {

			list.addAll((ArrayList<Convenience>)ois.readObject()); 
		
		} catch (StreamCorruptedException e) {
			
		} catch (EOFException e) {	

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (FileNotFoundException e) {
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	//convenience_list.dat 파일 저장하기
	//Obj 입출력 사용
	public void saveListFile() {
					
		try 
			(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("convenience_list.txt"))){
			
			for(int i = 0; i < list.size(); i++) {
				
				oos.writeObject(list);
			}
		//파일 없어서 오류 나면
		} catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
	
	//전달 받든 편의시설과 구역 비교
	//둘 다 일치하는 객체가 있으면 해당 리스트 출력
	public Convenience searchCon(String con, String area) {
		
		Convenience result = null;
		
		for(int i = 0; i < list.size(); i++) {
			
			//둘 다 일치하면 객체 출력
			if(con.equals(list.get(i).getCon())
					&& area.toUpperCase().equalsIgnoreCase(list.get(i).getArea())) {
				
					result = list.get(i);
		
			}
		}
		
		return result;
		
	}
	
	
	
	
	
	
	//편의시설 마지막 등록 번호 리턴
	public int getLastBoardNo() {
		
		//마지막 인덱스는 사이즈보다 하나 작음
		return list.get(list.size()-1).getcNo();
		
	}
	
	
	
	
	//전달받은 편의시설 정보를 list에 추가
	public void insertCon(Convenience C) {
		
		list.add(C);
		//saveListFile();
		
	}
	
	
	
	
	//편의시설 정보 전체 list를 리턴
	public ArrayList<Convenience> displayAllList() {
		
		return list;
	}
	
	
	
	
	//전달 받은 편의시설 번호와 일치하는 편의시설 리턴
	public Convenience displayCon(int no) {
		
		Convenience result = null;
		
		for(int i = 0; i < list.size(); i++) {
			
			if(no == list.get(i).getcNo()) {
				
				result = list.get(i);
				
				
			} 
			
		}
		
		return result;
		
	}
	
	
	
	
	//전달 받은 편의시설 번호와 일치하는 편의시설 내용 수정하기
	public void modifyCon(int no, String con, String area, String position) {
		
		for(int i = 0; i < list.size(); i++) {
	         
	         if(no == list.get(i).getcNo()) {
	            
	            list.get(i).setCon(con);
	            list.get(i).setArea(area.toUpperCase());
	            list.get(i).setPosition(position);
	            
	            saveListFile();
	            System.out.println(list.get(i));
	         }
	         
	 
	      }
	
	}
	
	
	
	
	//전달 받은 편의시설 번호와 일치하는 편의시설 삭제
	public void deleteCon(int no) {
		
		for(int i = 0; i < list.size(); i++) {
			
			if(no == list.get(i).getcNo()) {
				
				list.remove(i);
				
				saveListFile();
				
				
				return;
			}
		}
		
		
	}
	
	
	
	
	




	
}
