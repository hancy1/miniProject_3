package uni.controller;

import java.util.ArrayList;

import uni.model.vo.Booking;

public class BookingController {

	public ArrayList<Booking> check(int bnum) {

		ArrayList<Booking> list = new ArrayList<>();

		for (Booking b : list) {
			if (bnum == b.getNum()) {
				list.add(b);
			}
		}
		return list;
	}

	public void delete(int bnum) {

		ArrayList<Booking> list = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (bnum == i) {
				list.remove(i);
			}
		}

	}

}
