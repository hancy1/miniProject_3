package com.uni.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.uni.model.vo.Review;

public class ReviewDao {

	ArrayList<Review> reviewList = new ArrayList<Review>();
	ArrayList<Review> reviewAdminList = new ArrayList<Review>();
	// vo클래스 자료형을 임시로 저장할 컬렉션(ArrayList)

	public ReviewDao() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Review.txt")))
		{
			reviewList.addAll((ArrayList<Review>)ois.readObject()); //addAll메소드를 이용해 reviewList 통으로 추가, 파일에 있는 객체들을 reviewList에 다 담는다.
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


	public int getLastReviewNo() { // 글번호 얻어오기

		return reviewList.get(reviewList.size()-1).getReviewNo();
	}


	public void writeReview(Review review) { // 글등록

		reviewList.add(review);

	}


	public ArrayList<Review> readAllReview() {

		return reviewList;
	}


	public Review readReview(int reviewNo) { // 글번호 수정할때 조회해서 불러오기

		Review review = null;

		for(int i = 0; i < reviewList.size(); i++) {
			if(reviewList.get(i).getReviewNo() == reviewNo) {
				review = reviewList.get(i);
				break;
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


	public void deleteReview(int reviewNo) { // 4. 글 삭제


		for(int i = 0; i < reviewList.size(); i++) {
			if(reviewList.get(i).getReviewNo() == reviewNo) {
				reviewList.remove(i);
				break;
			}

		}

	}


	public void saveListFile() { // txt에 저장
		
		try(ObjectOutputStream oos = new ObjectOutputStream
				(new FileOutputStream("Review.txt"))){
			System.out.println(reviewList);
			oos.writeObject(reviewList);
						
			System.out.println("Review.txt에 성공적으로 저장되었습니다.");
			
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}


	public void writeAdminReview(Review review) {
		
		reviewAdminList.add(review);
	}
}
