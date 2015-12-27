package cn.edu.sdut.r314;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class FlooredDecorator implements Room{

	@Inject
	@Delegate
	Room roomToBeDecorated;

	
	public String showRoom(){
		doFlooring();
		return roomToBeDecorated.showRoom() + "铺地板";
	}
	
	// 铺地板
	private void doFlooring(){}
}
