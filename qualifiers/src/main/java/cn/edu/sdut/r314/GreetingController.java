
package cn.edu.sdut.r314;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GreetingController {
    @Inject @Fancy Greeting greeting;
    
    public String sayHello(String name){
        return greeting.greet(name);
    }
    
}
