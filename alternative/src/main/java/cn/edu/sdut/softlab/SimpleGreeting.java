package cn.edu.sdut.softlab;


public class SimpleGreeting implements Greeting {

  public String greet(String name) {
    return name == null ? "welcome!" : "Hello " + name;
  }

}
