package cn.edu.sdut.softlab;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class GreetingController {

  private String username;

  @Inject
  Greeting greeting;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
  
  @PostConstruct
  public void init(){
    System.out.println("post construct......");
  }
  
  @PreDestroy
  public void destroy(){
    System.out.println("pre destroy......");
  }

  public String sayHello() {
    return greeting.greet(username);
  }

}
