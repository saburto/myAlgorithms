import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FibTest {

	@Test
	public void testCalc_fibOLD() throws Exception {
		long fib = Fib.calc_fibOLD(42);
		assertThat(fib).isEqualTo(267914296L);
	}

	@Test
	public void testCalc_fib() throws Exception {
		long fib = Fib.calc_fib(42);
		assertThat(fib).isEqualTo(267914296L);
	}

	@Test
	public void testCalc_fib_and_old() throws Exception {

		List<Long> old = new ArrayList<>();
		List<Long> newL = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			old.add(Fib.calc_fibOLD(i));
			newL.add(Fib.calc_fib(i));
		}
		assertThat(newL).hasSameElementsAs(old);
	}

}
