package uni.model.vo;

public class Booking {
	// 놀이기구 이름, 시간대, 인원 수, 혼잡도
	private String attraction;
	private String time;
	private int count;
	private String cong; // 1: 쾌적, 2: 보통, 3: 복잡
	private int num;

	public Booking(String attraction, String time, int count, int num) {
		this.attraction = attraction;
		this.time = time;
		this.count = count;
		this.num = num;
	}

	public Booking(String attraction, String cong) {
		super();
		this.attraction = attraction;
		this.cong = cong;
	}

	public String getAttraction() {
		return attraction;
	}

	public String getCong() {
		return cong;
	}

	public void setCong(String cong) {
		this.cong = cong;
	}

	public void setAttraction(String attraction) {
		this.attraction = attraction;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getcount() {
		return count;
	}

	public void setcount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "선택하신 놀이기구는 " + attraction + "이고, 예약시간은 " + time + "입니다. 예약인원은 " + count + "명입니다.";
	}

}
