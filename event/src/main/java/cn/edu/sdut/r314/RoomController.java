package cn.edu.sdut.r314;

import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@Named("roomController")
public class RoomController {
	@Inject
	@CheckIn
	Event<Room> roomCheckInEvent;

	@Inject
	@CheckOut
	Event<Room> roomCheckOutEvent;

	@Inject
	@CheckOut
	Event<Room> roomAddEvent;

	@Inject
	@CheckOut
	Event<Room> roomRemoveEvent;


	@Inject
	RoomService roomService;

    private Room newRoom = new Room();

	/**
	 * 可入住房间列表
	 * @return
	 */
	public List<Room> getAvailableRooms(){
		return roomService.getAvailableRooms();
	}

	/**
	 * 已入住房间列表
	 */
	public List<Room> getCheckedInRooms(){
		return roomService.getCheckedInRooms();
	}

	/**
	 * 所有房间列表
	 * @return
	 */
	public List<Room> getAllRooms(){
		return roomService.getAllRooms();
	}


    /**
     * 入住房间
     * @return 这里利用JSF的特性：返回空字符串或者null表示刷新当前页面
     */
	public String checkIn(Room room){
		roomCheckInEvent.fire(room);
        return null;
	}

    /**
     * 退订房间
     * @return 这里利用JSF的特性：返回空字符串或者null表示刷新当前页面
     */
	public String checkOut(Room room){
		roomCheckOutEvent.fire(room);
        return null;
	}

    public String addRoom(){
        if(this.newRoom == null) return null;
        roomAddEvent.fire(this.newRoom);
        this.newRoom = new Room();
        return "";
    }

    public String removeRoom(Room room){
        roomRemoveEvent.fire(room);
        return "";
    }

    public void setNewRoom(Room newRoom){
        this.newRoom = newRoom;
    }

    public Room getNewRoom(){
        return this.newRoom;
    }
}
