package cn.edu.sdut.softlab;

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

  public String sayHello() {
    return greeting.greet(username);
  }

}
