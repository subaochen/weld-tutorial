package cn.edu.sdut.r314;

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
	
	public void checkInRoom(Room room){
		roomCheckInEvent.fire(room);
	}
	
	public void checkOutRoom(Room room){
		roomCheckOutEvent.fire(room);
	}
}
