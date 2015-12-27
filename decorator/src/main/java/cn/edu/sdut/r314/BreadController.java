package cn.edu.sdut.r314;

import javax.inject.Inject;
import javax.inject.Named;

@Named("bread")
public class BreadController {
	
	@Inject
	Bread bread;
	
	public String bake(){
		return bread.bake();
	}

}
