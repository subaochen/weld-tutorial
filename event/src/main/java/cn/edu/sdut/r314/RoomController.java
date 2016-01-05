package cn.edu.sdut.r314;

import java.util.List;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.util.AnnotationLiteral;

@Named("roomController")
@RequestScoped
public class RoomController {

    private Logger log = LoggerFactory.getLogger(RoomController.class);

    @Inject
    @Any
    Event<Room> roomEvent;

    @Inject
    @CheckIn
    Event<Room> roomCheckInEvent;

    @Inject
    @CheckOut
    Event<Room> roomCheckOutEvent;

    @Inject
    @Add
    Event<Room> roomAddEvent;

    @Inject
    @Remove
    Event<Room> roomRemoveEvent;

    @Inject
    RoomService roomService;

    private Room newRoom = new Room();

    /**
     * 可入住房间列表
     *
     * @return
     */
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

    /**
     * 已入住房间列表
     */
    public List<Room> getCheckedInRooms() {
        return roomService.getCheckedInRooms();
    }

    /**
     * 所有房间列表
     *
     * @return
     */
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    /**
     * 入住房间
     *
     * @return 这里利用JSF的特性：返回空字符串或者null表示刷新当前页面
     */
    public String checkIn(Room room) {
        roomCheckInEvent.fire(room);
        
        return null;
    }

    /**
     * 退订房间
     *
     * @return 这里利用JSF的特性：返回空字符串或者null表示刷新当前页面
     */
    public String checkOut(Room room) {
        //roomCheckOutEvent.fire(room);
        roomEvent.select(new AnnotationLiteral<CheckOut>(){}).fire(room);
        return null;
    }

    public String addRoom() {
        if (this.newRoom == null) {
            return null;
        }
        log.info("newRoom:{}.", this.newRoom);
        roomAddEvent.fire(this.newRoom);
        this.newRoom = new Room();
        return "";
    }

    public String removeRoom(Room room) {
        roomRemoveEvent.fire(room);
        return "";
    }

    public void setNewRoom(Room newRoom) {
        this.newRoom = newRoom;
    }

    public Room getNewRoom() {
        return this.newRoom;
    }
}
