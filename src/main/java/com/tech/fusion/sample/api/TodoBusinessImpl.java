package com.tech.fusion.sample.api;

import java.util.ArrayList;
import java.util.List;

// System under test :: SUT

/**
 * Actual implementation of TodoService is not with us. TodoService is a dependency.
 * It is implemented by some other team or is an external interface.
 *
 * 1. We need to create a stub, which is a sample implementation of this TodoService.
 * We want to write test for retrieveTodoListRelatedToSpring
 */
public class TodoBusinessImpl {

  private TodoService todoService;

  public TodoBusinessImpl(TodoService todoService) {
    this.todoService = todoService;
  }

  public List<String> retrieveTodoListRelatedToSpring(String user){
    List<String> filteredTodoList = new ArrayList<String>();
    List<String> todoList = todoService.retrieveTodoList(user);

    for (String todo : todoList){
      if(todo.contains("Spring")){
        filteredTodoList.add(todo);
      }
    }

    return filteredTodoList;
  }
}


