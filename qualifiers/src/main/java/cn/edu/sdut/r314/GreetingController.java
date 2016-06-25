
package cn.edu.sdut.r314;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class GreetingController {
    @Inject  Greeting greeting;
    @Inject @Any Instance<Greeting> greetings;
    
    public String sayHello(String name){
        return greeting.greet(name);
    }
    
    public String hello(String name) {
        String helloString = "";
        for(Greeting greeting:greetings) {
            helloString += greeting.greet(name);
        }
        
        return helloString;
    }
    
}
