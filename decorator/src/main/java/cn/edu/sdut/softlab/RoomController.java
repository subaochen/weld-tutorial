package cn.edu.sdut.softlab;

import javax.inject.Inject;
import javax.inject.Named;

@Named("room")
public class RoomController {

  @Inject
  Room room;

  public String showRoom() {
    return room.showRoom();
  }

}
