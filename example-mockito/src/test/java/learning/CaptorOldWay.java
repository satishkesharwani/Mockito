package learning;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class CaptorOldWay {

	@Test
	public void whenNotUseCaptorAnnotation_thenCorrect() {
	    List mockList = Mockito.mock(List.class);
	    ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
	 
	    mockList.add("one");
	    Mockito.verify(mockList).add(arg.capture());
	 
	    assertEquals("one", arg.getValue());
	}	
}
