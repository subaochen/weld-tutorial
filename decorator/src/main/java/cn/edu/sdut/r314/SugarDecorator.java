package cn.edu.sdut.r314;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class SugarDecorator implements Bread {

	private int sugar = 5;
	
	@Inject
	@Delegate
	Bread bread;
	
	public String bake(){
		return bread.bake() + " with " + sugar + "g sugar";
	}

	public int getSugar() {
		return sugar;
	}

	public void setSugar(int sugar) {
		this.sugar = sugar;
	}
}
