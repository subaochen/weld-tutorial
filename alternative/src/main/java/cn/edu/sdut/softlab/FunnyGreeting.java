package cn.edu.sdut.softlab;

import javax.enterprise.inject.Alternative;


public class FunnyGreeting implements Greeting {

  public String greet(String name) {
    return "where are you going, " + name;
  }

}
