package cn.edu.sdut.softlab;

import javax.enterprise.inject.Alternative;

@Alternative
public class FancyGreeting implements Greeting {

  public String greet(String name) {
    return "Nice to meet you, " + name;
  }

}
