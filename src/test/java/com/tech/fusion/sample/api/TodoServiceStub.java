package com.tech.fusion.sample.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Disadvantages of using a stub
// Dynamic conditions - To test different scenarios, more logic needs to be added to the stub.
// Service Definition : If a new method is coming into the interface, it has to be implemented in the stub as well.
public class TodoServiceStub implements TodoService{

  public List<String> retrieveTodoList(String user){
    if(user.equals("Dummy")){
      return Arrays.asList("Learn Spring", "Spring MVN Tutorial", "Lean Java");
    } else{
      return new ArrayList<String>();
    }
  }
}
