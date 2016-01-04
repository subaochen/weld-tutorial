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
	RoomService roomService;
	
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
	
	
	public void checkInRoom(Room room){
		roomCheckInEvent.fire(room);
	}
	
	public void checkOutRoom(Room room){
		roomCheckOutEvent.fire(room);
	}
}
