package com.uni.controller;

import com.uni.model.vo.Ticket;

public class TicketManager {

	private Ticket ti = new Ticket(null, null, 0);
	public void selectMobile() {
		
	}
	
	public void checkFee() {
		ti.getMobile(); // 
	}
	
	public int getFee() {
		// netFee 리턴
		return 0;
	}
}
