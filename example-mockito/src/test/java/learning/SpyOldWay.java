package learning;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class SpyOldWay {

	@Test
	public void whenNotUseSpyAnnotation_thenCorrect() {
	    List<String> spyList = Mockito.spy(new ArrayList<String>());
	     
	    spyList.add("one");
	    spyList.add("two");
	 
	    Mockito.verify(spyList).add("one");
	    Mockito.verify(spyList).add("two");
	 
	    assertEquals(2, spyList.size());
	 
	    Mockito.doReturn(100).when(spyList).size();
	    assertEquals(100, spyList.size());
	}
}
