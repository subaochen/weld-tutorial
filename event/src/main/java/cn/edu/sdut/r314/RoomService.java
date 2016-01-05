package cn.edu.sdut.r314;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

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
     * 监听所有的客房事件
     */
    public void onRoomEvent(@Observes Room room) {
        log.info("listening all room event:{}.",room);
    }

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
                r.setStatus(status);
                break;
            }
        }
    }

    public void onAddRoom(@Observes @Add Room room){
        log.info("add room:{}.",room);
            room.setStatus(RoomStatus.AVAILABLE);
        rooms.add(room);
    }

    public void onRemoveRoom(@Observes @Remove Room room){
        log.info("remove room:{}.",room);
        rooms.remove(room);
    }

    @PostConstruct
    public void init(){
        rooms.add(new Room("101",RoomStatus.AVAILABLE,RoomType.ONE));
        rooms.add(new Room("104",RoomStatus.AVAILABLE,RoomType.ONE));
        rooms.add(new Room("102",RoomStatus.AVAILABLE,RoomType.TWO));
        rooms.add(new Room("103",RoomStatus.AVAILABLE,RoomType.THREE));
    }


    private List<Room> getRooms(RoomStatus status) {
        List<Room> list = new ArrayList<Room>(0);
        for(Room r:rooms)
            if(r.getStatus().equals(status)) list.add(r);

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
