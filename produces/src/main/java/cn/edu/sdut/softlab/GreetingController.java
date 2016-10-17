package cn.edu.sdut.softlab;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class GreetingController {

  @Inject
  @Preferred
  Task task;

  public String sayHello() {
    return "hello task:" + task.getName();
  }

  @PostConstruct
  public void init() {
    System.out.println("post construct......");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("pre destroy......");
  }

}
