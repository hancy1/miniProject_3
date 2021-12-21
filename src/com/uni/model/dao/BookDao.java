package com.uni.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.uni.model.vo.BookTicket;

public class BookDao {
	
	public static ArrayList<BookTicket> bookList = new ArrayList<BookTicket>();
	
	public BookDao() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Book.txt"))) 
		{	bookList.addAll((ArrayList<BookTicket>)ois.readObject()); 
		//addAll메소드를 이용해 reviewList 통으로 추가, 파일에 있는 객체들을 reviewList에 다 담는다.
		} catch (EOFException e) {
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		} catch (FileNotFoundException e) {
			//파일이 없어도 아무것도 안뜨기
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public int getTNo() { // 티켓넘버 구하기 
		
		int tNo = (int) (Math.random()*10000+1);
		
		return tNo;
	}

	public String writeBookTicket(BookTicket bookTicket) { 
		
		bookList.add(bookTicket);
		
		return bookList.toString();
	}

	public void saveListFile() { // txt에 예매리스트 저장
		
		try(ObjectOutputStream oos = new ObjectOutputStream //ObjectOutputStream는 파일로 입출력할 수 있는 기능. 객체는 문자가 아니므로 직렬화 필수
				(new FileOutputStream("Book.txt"))){
			//System.out.println(reviewList); // 글 등록 후 모든 글이 출력됨
			oos.writeObject(bookList); 
						
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public BookTicket readBook(int tNo) { // 맞는 티켓넘버의 정보 불러오기

		BookTicket bt = null;

		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).gettNo() == tNo) {
				bt = bookList.get(i);
				
			}
		}
		//System.out.println("티켓넘버와 같은 객체 BookDao" + bt); 
		return bt; // 티켓번호와 맞는 글
	}
}
