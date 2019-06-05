package learning;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class InjectMockExample {

	@Mock
	Map<String, String> wordMap;
	 
	@InjectMocks
	MyDictionary dic = new MyDictionary();
	 
	@Test
	public void whenUseInjectMocksAnnotation_thenCorrect() {
	    Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");
	 
	    assertEquals("aMeaning", dic.getMeaning("aWord"));
	}
}
