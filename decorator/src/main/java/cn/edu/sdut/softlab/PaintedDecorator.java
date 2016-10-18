package cn.edu.sdut.softlab;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class PaintedDecorator implements Room {

  @Inject
  @Delegate
  Room roomToBeDecorated;

  public String showRoom() {
    doPainting();
    return roomToBeDecorated.showRoom() + "刷墙漆";
  }

  // 刷墙漆
  private void doPainting() {
  }
}
