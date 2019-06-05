package learning;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class ManualWayWithOutMockExample {

	@Test
	public void whenNotUseMockAnnotation_thenCorrect() {
	    List<String> mockList = Mockito.mock(ArrayList.class);
	    mockList.add("one");
	    Mockito.verify(mockList).add("one");
	    assertEquals(0, mockList.size());
	 
	    Mockito.when(mockList.size()).thenReturn(100);
	    assertEquals(100, mockList.size());
	}
}
