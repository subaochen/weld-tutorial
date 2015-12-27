package cn.edu.sdut.r314;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class EggDecorator implements Bread {
	private int egg = 1;
	
	@Inject
	@Delegate
	Bread bread;
	
	public String bake(){
		return bread.bake() + " with " + egg + " egg";
	}

	public int getEgg() {
		return egg;
	}

	public void setEgg(int egg) {
		this.egg = egg;
	}
	
	

}
