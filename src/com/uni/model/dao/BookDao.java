package com.uni.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.uni.model.vo.BookTicket;

public class BookDao {
	
	ArrayList<BookTicket> bookList = new ArrayList<BookTicket>();
	
	public BookDao() {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Book.txt")))
		{	bookList.addAll((ArrayList<BookTicket>)ois.readObject()); 
			//reviewList.addAll((ArrayList<Review>)ois.readObject()); //addAll메소드를 이용해 reviewList 통으로 추가, 파일에 있는 객체들을 reviewList에 다 담는다.
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		} catch (FileNotFoundException e) {
			System.out.println("등록된 글이 없습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int getTNo() {
		
		int tNo = (int) (Math.random()*10000+1);
		
		return tNo;
	}

	public String writeBookTicket(BookTicket bookTicket) { 
		
		bookList.add(bookTicket);
		
		return bookList.toString();
	}

	public void saveListFile() { // txt에 예매리스트 저장
		
		try(ObjectOutputStream oos = new ObjectOutputStream
				(new FileOutputStream("Book.txt"))){
			//System.out.println(reviewList); // 글 등록 후 모든 글이 출력됨
			oos.writeObject(bookList); // 사용자용
						
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public BookTicket readBook(int tNo) { // 글번호 수정할때 조회해서 불러오기

		BookTicket bt = null;

		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).gettNo() == tNo) {
				bt = bookList.get(i);
				
			}
		}

		return bt; // 티켓번호와 맞는 글
	}
}
