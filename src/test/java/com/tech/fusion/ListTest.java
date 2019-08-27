package com.tech.fusion;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

  @Test
  public void letsMockListSizeMethod(){
    List listMock = mock(List.class);

    when(listMock.size()).thenReturn(2);

    assertEquals(2, listMock.size());
  }

  @Test
  public void letsMockListSize_ReturnMultipleValues(){
    List listMock = mock(List.class);

    when(listMock.size()).thenReturn(2).thenReturn(3);

    assertEquals(2, listMock.size());
    assertEquals(3, listMock.size());
  }

  @Test
  public void letsMockListGetMethod(){
    List listMock = mock(List.class);

    when(listMock.get(0)).thenReturn("returnValue");

    assertEquals("returnValue", listMock.get(0));
    assertNull(listMock.get(1));
  }

  @Test
  public void letsMockListGetMethod_usingArgumentMatcher(){
    List listMock = mock(List.class);

    when(listMock.get(anyInt())).thenReturn("returnValue");

    assertEquals("returnValue", listMock.get(0));
    assertEquals("returnValue", listMock.get(1));
    assertEquals("returnValue", listMock.get(2));
    assertEquals("returnValue", listMock.get(3));
  }

  @Test(expected = RuntimeException.class)
  public void letsMockListGetMethod_throwException(){
    List listMock = mock(List.class);

    when(listMock.get(anyInt())).thenThrow(new RuntimeException("mock exception"));

    listMock.get(0);
  }
}
