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
	protected Map<String,Room> rooms = new HashMap<String, Room>();
	
	public List<Room> getAvailableRooms(){
		List<Room> list = new ArrayList<Room>();
		
		return list;
	}

	/**
	 * 客户入住
	 * @param room
	 */
	public void onRoomCheckIn(@Observes @CheckIn Room room ) {
		rooms.remove(room.getNo());
	}
	
	/**
	 * 客户退房
	 * @param room
	 */
	public void onRoomCheckOut(@Observes @CheckOut Room room) {
		rooms.put(room.getNo(), room);
	}
	
	@PostConstruct
	public void init(){
		rooms.put("101-1", new Room("101-1")); // 单人间
		rooms.put("104-1", new Room("104-1")); // 单人间
		rooms.put("102-2", new Room("102-2")); // 双人间
		rooms.put("103-3", new Room("103-3")); // 三人间
	}
	
}
