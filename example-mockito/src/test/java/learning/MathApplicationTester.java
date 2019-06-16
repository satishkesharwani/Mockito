package learning;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

	// @InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	MathApplication mathApplication = new MathApplication();

	// @Mock annotation is used to create the mock object to be injected
	@Mock
	CalculatorService calcService;

	@Test
	public void testAdd() {

//		MockitoAnnotations.initMocks(this);
		// add the behavior of calc service to add two numbers
		when(calcService.add(10.0, 20.0)).thenReturn(30.00);

		// test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);

		// verify the behavio only 1 time
//	    verify(calcService).add(10.0, 20.0);

		verify(calcService, times(3)).add(10.0, 20.0);

		// check if add function is called minimum 2 times
		verify(calcService, atLeast(2)).add(10.0, 20.0);

		// check if add function is called maximum 3 times
		verify(calcService, atMost(3)).add(10.0, 20.0);
		
		
		//add the behavior to add numbers
		when(calcService.add(20.0,10.0)).thenAnswer(new Answer<Double>() {
		   public Double answer(InvocationOnMock invocation) throws Throwable {
		      //get the arguments passed to mock
		      Object[] args = invocation.getArguments();
		      //get the mock 
		      Object mock = invocation.getMock();	
		      //return the result
		      return 30.0;
		   }
		});
	}

	@Test(expected = RuntimeException.class)
	public void testAdds() {
		// add the behavior to throw exception
		doThrow(new RuntimeException("Add operation not implemented")).when(calcService).add(10.0, 20.0);

		// test the add functionality
		Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
	}
	
	
	

}

//org.mockito.exceptions.base.MockitoException: 
//Cannot instantiate @InjectMocks field named 'calcService'.
//You haven't provided the instance at field declaration so I tried to construct the instance.
//However, I failed because: the type 'CalculatorService' is an interface.
//Examples of correct usage of @InjectMocks:
//   @InjectMocks Service service = new Service();
//   @InjectMocks Service service;
// also, don't forget about MockitoAnnotations.initMocks();
// and... don't forget about some @Mocks for injection :)