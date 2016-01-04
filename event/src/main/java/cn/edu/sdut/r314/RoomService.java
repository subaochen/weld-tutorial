package cn.edu.sdut.r314;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

/**
 * 房间管理
 * @author subaochen
 *
 */
@ApplicationScoped
@Named("roomService")
public class RoomService {
	private List<Room> allRooms = new ArrayList<Room>(0);
	private List<Room> availableRooms = new ArrayList<Room>(0);
	private List<Room> checkedInRooms = new ArrayList<Room>(0);
	
	/**
	 * 客户入住
	 * @param room
	 */
	public void onRoomCheckIn(@Observes @CheckIn Room room ) {
		availableRooms.remove(room);
		checkedInRooms.add(room);
	}
	
	/**
	 * 客户退房
	 * @param room
	 */
	public void onRoomCheckOut(@Observes @CheckOut Room room) {
		checkedInRooms.remove(room);
		availableRooms.add(room);
	}
	
	@PostConstruct
	public void init(){
		Room r1 = new Room("101-1");// 单人间
		Room r2 = new Room("104-1");// 单人间
		Room r3 = new Room("102-2");// 双人间
		Room r4 = new Room("103-3");// 三人间
		
		allRooms.add(r1);
		allRooms.add(r2);
		allRooms.add(r3);
		allRooms.add(r4);
		
		availableRooms.add(r1);
		availableRooms.add(r2);
		availableRooms.add(r3);
		availableRooms.add(r4);
		
		checkedInRooms.clear();
	}


	public List<Room> getAvailableRooms(){
		return availableRooms;
	}
	
	public List<Room> getCheckedInRooms() {
		return checkedInRooms;
	}
	
	public List<Room> getAllRooms(){
		return allRooms;
	}
	
}
