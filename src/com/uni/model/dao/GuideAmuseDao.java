package com.uni.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

import com.uni.model.vo.GuideAmuse;

public class GuideAmuseDao {

	ArrayList<GuideAmuse> list = new ArrayList<GuideAmuse>(); // 어레이리스트 생성

	public GuideAmuseDao() {  

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("guideAmuse_list.txt"))) {

			// addAll 메서드를 통해 list를 통으로 추가
			list.addAll((ArrayList<GuideAmuse>) ois.readObject());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (StreamCorruptedException e) { //----------StreamCorruptedException
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

	public void writeGuideAmuse(GuideAmuse guideAmuse) { // 이용 제한 등록
		// 입력받은 값 매개변수로 입력받아 리스트에 저장
		list.add(guideAmuse); 
	}

	public ArrayList<GuideAmuse> displayAllList() { // 이용 제한 전체 조회
		
		// 리스트에 저장된 놀이기구가 없을 때 
		if(list.isEmpty()) {
			System.out.println("이용 제한 조건이 없습니다.");
		}
		
		// 리스트에 저장한 값을 컨트롤러의 displayAllList 로 보내준다
		return list;
	}
	
	public void saveGuideAmuse() { // 저장 
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("guideAmuse_list.txt"))) {
			oos.writeObject(list);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (StreamCorruptedException e) { //----------StreamCorruptedException
//			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}