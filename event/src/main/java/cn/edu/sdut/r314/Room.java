package cn.edu.sdut.r314;

public class Room {
	private String no; // 房间号
	private String status; // 状态
	private int capacity; // 人数

    public Room(){}

	public Room(String no,String status,int capacity) {
		super();
		this.no = no;
		this.status = status;
		this.capacity = capacity;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Room [no=" + no + ", status=" + status + ", capacity=" + capacity + "]";
	}


}
