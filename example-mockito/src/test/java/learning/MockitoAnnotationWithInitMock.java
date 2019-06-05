package learning;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class MockitoAnnotationWithInitMock {


//	Alternatively, we can enable these annotations programmatically as well, by invoking MockitoAnnotations.initMocks() as in the following example:
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
}
