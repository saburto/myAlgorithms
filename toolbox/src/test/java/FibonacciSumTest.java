import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FibonacciSumTest {

	@Test
	public void testGetFibonacciSum() throws Exception {
		int fibonacciSum = FibonacciSum.getFibonacciSum(3);
		assertThat(fibonacciSum).isEqualTo(4);
	}

	@Test
	public void testGetFibonacciSum100() throws Exception {
		int fibonacciSum = FibonacciSum.getFibonacciSum(100);
		assertThat(fibonacciSum).isEqualTo(5);
	}

	@Test
	public void testGetFibonacciSum832564823476() throws Exception {
		int fibonacciSum = FibonacciSum.getFibonacciSum(832564823476L);
		assertThat(fibonacciSum).isEqualTo(3);
	}

}
