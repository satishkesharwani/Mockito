package learning;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CaptorMockWay {

	@Mock
	List mockedList;
	 
	@Captor
	ArgumentCaptor argCaptor;
	 
	@Test
	public void whenUseCaptorAnnotation_thenTheSam() {
	    mockedList.add("one");
	    Mockito.verify(mockedList).add(argCaptor.capture());
	 
	    assertEquals("one", argCaptor.getValue());
	}
}
