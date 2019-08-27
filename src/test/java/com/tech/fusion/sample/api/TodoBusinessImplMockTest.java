package com.tech.fusion.sample.api;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {
  // Mocking
  // mocking is creating objects that simulate the behaviour of real objects
  // unlike stubs, mocks can be dynamically created from code at runtime.
  // Mocks offer more functionality than stubbing
  // Method calls can be verified along with other things

  @Test
  public void testRetrieveTodoListRelatedToSpring_usingMock(){

    List<String> todoList = Arrays.asList("Learn Spring", "Spring MVN Tutorial", "Lean Java");

    // Creates a mock object of a class or an interface
    TodoService mockTodoService = mock(TodoService.class);
    // if not stubbed , default values are returned
    when(mockTodoService.retrieveTodoList("Dummy")).thenReturn(todoList);

    TodoBusinessImpl todoBusiness = new TodoBusinessImpl(mockTodoService);

    List<String> filteredTodoList = todoBusiness.retrieveTodoListRelatedToSpring("Dummy");

    assertEquals(2, filteredTodoList.size());
  }


  @Test
  public void testRetrieveTodoListRelatedToSpring_usingEmptyList(){

    List<String> todoList = Arrays.asList();

    // Creates a mock object of a class or an interface
    TodoService mockTodoService = mock(TodoService.class);
    // if not stubbed , default values are returned
    when(mockTodoService.retrieveTodoList("Dummy")).thenReturn(todoList);

    TodoBusinessImpl todoBusiness = new TodoBusinessImpl(mockTodoService);

    List<String> filteredTodoList = todoBusiness.retrieveTodoListRelatedToSpring("Dummy");

    assertEquals(0, filteredTodoList.size());
  }

}