package cn.edu.sdut.r314;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 房间管理
 * @author subaochen
 *
 */
@ApplicationScoped
public class RoomService {
    private Logger log = LoggerFactory.getLogger(RoomService.class);
	private List<Room> rooms = new ArrayList<Room>(0);

	/**
	 * 客户入住
	 * @param room
	 */
	public void onRoomCheckIn(@Observes @CheckIn Room room ) {
        log.info("check in room:{}.",room);
		setRoomStatus(room,RoomStatus.CHECKED_IN);
	}

	/**
	 * 客户退房
	 * @param room
	 */
	public void onRoomCheckOut(@Observes @CheckOut Room room) {
        log.info("check out room:{}.",room);
		setRoomStatus(room,RoomStatus.AVAILABLE);
	}

	private void setRoomStatus(Room room,RoomStatus status) {
		for(Room r:rooms){
			if(r.getNo().equals(room.getNo())) {
				r.setStatus(status.toString());
				break;
			}
		}
	}

    public void onAddRoom(@Observes @Add Room room){
        log.info("add room:{}.",room);
    	room.setStatus(RoomStatus.AVAILABLE.toString());
        rooms.add(room);
    }

    public void onRemoveRoom(@Observes @Remove Room room){
        log.info("remove room:{}.",room);
        rooms.remove(room);
    }

	@PostConstruct
	public void init(){
		rooms.add(new Room("101",RoomStatus.AVAILABLE.toString(),1));
		rooms.add(new Room("104",RoomStatus.AVAILABLE.toString(),1));
		rooms.add(new Room("102",RoomStatus.AVAILABLE.toString(),2));
		rooms.add(new Room("103",RoomStatus.AVAILABLE.toString(),3));
	}


	private List<Room> getRooms(RoomStatus status) {
		List<Room> list = new ArrayList<Room>(0);
		for(Room r:rooms)
			if(r.getStatus().equals(status.toString())) list.add(r);

		return list;
	}
	public List<Room> getAvailableRooms(){
		return getRooms(RoomStatus.AVAILABLE);
	}

	public List<Room> getCheckedInRooms() {
		return getRooms(RoomStatus.CHECKED_IN);
	}

	public List<Room> getAllRooms(){
		return rooms;
	}

}
