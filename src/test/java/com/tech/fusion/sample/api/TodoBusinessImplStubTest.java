package com.tech.fusion.sample.api;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TodoBusinessImplStubTest {

  @Test
  public void testRetrieveTodoListRelatedToSpring_usingStub(){
    TodoService todoServiceStub = new TodoServiceStub();
    TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceStub);

    List<String> filteredTodoList = todoBusiness.retrieveTodoListRelatedToSpring("Dummy");

    assertEquals(2, filteredTodoList.size());
  }

  @Test
  public void testRetrieveTodoListRelatedToSpring_usingStub2(){
    TodoService todoServiceStub = new TodoServiceStub();
    TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceStub);

    List<String> filteredTodoList = todoBusiness.retrieveTodoListRelatedToSpring("Dummy1");

    assertEquals(0, filteredTodoList.size());
  }

}