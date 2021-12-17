package com.uni.model.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

import com.uni.reviews.Review;

public class ReviewDao {

	private ArrayList<Review> list = new ArrayList<>();
	
	public ReviewDao() {
		// TODO Auto-generated constructor stub
	}
	
	public static int checkPwd(String pwd) {
		
		if (Pattern.compile("[0~9]") != null && pwd.length() == 4) {
			return 1;
		}else {
			return 0;}
		
	}
	
	public int getLastReviewNo() { // list 크기 -1 이 마지막번호
		Review r = list.get(list.size()-1);
		return r.getrNo();		
	}
	
	public void writeReview(Review review) { // 전달받은 review를 list에 저장
		list.add(review);
		
	}

	public Review displayReview(int rNo) {
		for(Review r : list) {
			if(r.getrNo() == rNo)
				return r;
		}
		return null;
	}

	public void editContent(int rNo, String content) { // 전달받은 글번호와 내용을
		for(Review r : list) {
			if( rNo == r.getrNo()) { // 글번호가 같다면
				r.setContent(content); // 내용 더해주기
			}
		}
		
	}

	public void deleteContent(int rNo) {
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			Review r = (Review) it.next(); // r에 list의 객체들을 담고
			if(r.getrNo() == rNo) { // 전달받은 번호와 같다면
				it.remove(); // 삭제시킨다.
			}
		}
		
	}
	
	
	
	public ArrayList<Review> displayAllList() {
		ArrayList<Review> clone = (ArrayList<Review>) list.clone();
		return clone;
	}
}
