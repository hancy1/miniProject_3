package com.uni.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.uni.model.vo.Review;
import com.uni.model.vo.ReviewAdmin;

public class ReviewDao {

	ArrayList<Review> reviewList = new ArrayList<Review>();
	ArrayList<ReviewAdmin> reviewAdminList = new ArrayList<ReviewAdmin>();
	// vo클래스 자료형을 임시로 저장할 컬렉션(ArrayList)

	public ReviewDao() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Review_Admin.txt")))
		{	reviewList.addAll((ArrayList<Review>)ois.readObject()); 
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
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Review_Admin.txt")))
		{	//reviewAdminList.addAll((ArrayList<ReviewAdmin>)ois.readObject()); 
			reviewAdminList.addAll((ArrayList<ReviewAdmin>)ois.readObject()); //addAll메소드를 이용해 reviewList 통으로 추가, 파일에 있는 객체들을 reviewList에 다 담는다.
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


	public ArrayList<Review> readAllReview() { //1. 사용자 글 조회

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
				(new FileOutputStream("Review_Admin.txt"))){
			//System.out.println(reviewList); // 글 등록 후 모든 글이 출력됨
			oos.writeObject(reviewList); // 사용자용
			oos.writeObject(reviewAdminList); // 관리자용

			
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}

	}


	public void writeAdminReview(ReviewAdmin reviewAdmin) { // 관리자 글등록

		reviewAdminList.add(reviewAdmin);

	}


	public int checkPwd(String pwd) { // 비밀번호 숫자4자리인지 체크하는 메소드
		if (Pattern.compile("[0~9]") != null && pwd.length() == 4) {
			return 1;
		}else {
			return 0;}

	}


	public Review rightPwd(String pwd) { // 수정,삭제시 비밀번호가 맞는 확인

		Review review = null;

		for(int i = 0; i < reviewList.size(); i++) {
			if(reviewList.get(i).getPwd().equals(pwd)) {
				review = reviewList.get(i);
				break;
			}
		}

		return review;
	}
	
	
	
	public ArrayList<ReviewAdmin> readAdminAllReview() { // 관리자용 읽기

		return reviewAdminList;
	}

}

