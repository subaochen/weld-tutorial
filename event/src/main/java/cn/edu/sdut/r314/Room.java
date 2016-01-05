package cn.edu.sdut.r314;

public class Room {
	private String no; // 房间号
	private RoomStatus status; // 状态
	private RoomType type; // 人数

    public Room(){}

    public Room(String no, RoomStatus status, RoomType type) {
        this.no = no;
        this.status = status;
        this.type = type;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Room{" + "no=" + no + ", status=" + status + ", type=" + type + '}';
    }
    

}
