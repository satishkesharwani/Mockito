package learning;

import org.junit.Test;
import org.mockito.Mockito;

public class MemoryLeakTest {

	class BigClass {
		void accept(SmallClass small) {
		}
	}

	class SmallClass {
		void accept(BigClass big) {
		}
	}
	
	@Test
	void leak() {
		BigClass a = Mockito.mock(BigClass.class);
		SmallClass b = Mockito.mock(SmallClass.class);

		// Remove any one of the 2 lines below will stop leaking
		a.accept(b);
		b.accept(a);
	}

}
