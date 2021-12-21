package busresv;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class busBooking {
	String passengerName;
	int busNo;
	Date date; 
	
	public busBooking(){
		Scanner sc = new Scanner(System.in);   
		System.out.println("승객의 이름을 입력해주세요 : ") ;
		passengerName = sc.next();
		System.out.println("버스 번호 입력해주세요 : ");
		busNo = sc.nextInt();
		System.out.println("날짜 입력 dd-mm-yyyy : ");
		String dateInput = sc.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isAvailable(ArrayList<busBooking> bookings, ArrayList<Bus> buses) {
		int capacity = 0;
		for(Bus bus:buses) {
			if (bus.getBusNo() == busNo)
				capacity = bus.getCapacity();
		}
		
		int booked = 0;
		for(busBooking b:bookings) {
			if(b.busNo == busNo && b.date.equals(date)) {
				booked++;
			}
		}
		
		return booked<capacity?true:false;
		
	}

		
	}

