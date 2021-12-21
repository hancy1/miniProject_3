package com.uni.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.uni.model.vo.BookTicket;
import com.uni.model.vo.Review;

public class ReviewDao {

	ArrayList<Review> reviewList = new ArrayList<Review>();
	ArrayList<BookTicket> bookList = new ArrayList<BookTicket>();


	// vo클래스 자료형을 임시로 저장할 컬렉션(ArrayList)

	public ReviewDao() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Review.txt")))
		{	reviewList.addAll((ArrayList<Review>)ois.readObject()); 
		//addAll메소드를 이용해 reviewList 통으로 추가, 파일에 있는 객체들을 reviewList에 다 담는다.	
		}catch (StreamCorruptedException e) {
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		} catch (FileNotFoundException e) {
			//파일이 없어도 아무것도 뜨지않게			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 


	}

	public int checkPwd(String pwd) { // 비밀번호 4자리인지 체크하는 메소드
		if (pwd.length() == 4) {
			return 1;
		}else {
			return 0;}

	}

	public int getLastReviewNo() { // 글번호 얻어오기

		return reviewList.get(reviewList.size()-1).getReviewNo();
	}


	public void writeReview(Review review) { // 글등록

		reviewList.add(review);

	}


	public void saveListFile() { // txt에 저장

		try(ObjectOutputStream oos = new ObjectOutputStream //ObjectOutputStream는 파일로 입출력할 수 있는 기능. 객체는 문자가 아니므로 직렬화 필수
				(new FileOutputStream("Review.txt"))){

			oos.writeObject(reviewList); 			


		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}

	}


	public ArrayList<Review> readAllReview() { //1. 사용자 글 조회

		return reviewList;
	}


	public Review readReview(int reviewNo) { // 글번호 수정할때 조회해서 불러오기

		Review review = null;

		for(int i = 0; i < reviewList.size(); i++) {
			if(reviewList.get(i).getReviewNo() == reviewNo) {
				review = reviewList.get(i);

			}
		}

		return review;
	}


	public void editReview(int reviewNo, String reviewContent) { // 3. 글수정

		for(int i = 0; i < reviewList.size(); i++) {
			if(reviewList.get(i).getReviewNo() == reviewNo) {
				reviewList.get(i).setReviewContent(reviewContent);
				break;
			}
		}

	}

	public Review rightPwd(Review r, String pwd) { // 수정,삭제시 비밀번호가 맞는지 확인

		Review review = null;


		if(r.getPwd().equals(pwd)) {
			review = r;
		}else {review = null;}

		return review;
	}

	public void deleteReview(int reviewNo) { // 4. 글 삭제


		for(int i = 0; i < reviewList.size(); i++) {
			if(reviewList.get(i).getReviewNo() == reviewNo) {
				reviewList.remove(i);
				break;
			}

		}

	}


}

