import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FibonacciPartialSumTest {

	@Test
	public void testGetFibonacciPartialSum() throws Exception {
		int fibonacciPartialSum = FibonacciPartialSum.getFibonacciPartialSum(10, 10);
		assertThat(fibonacciPartialSum).isEqualTo(5);
	}

	@Test
	public void testGetFibonacciPartialSum3_7() throws Exception {
		int fibonacciPartialSum = FibonacciPartialSum.getFibonacciPartialSum(3, 7);
		assertThat(fibonacciPartialSum).isEqualTo(1);
	}

	@Test
	public void testGetFibonacciPartialSum10_200() throws Exception {
		int fibonacciPartialSum = FibonacciPartialSum.getFibonacciPartialSum(10, 200);
		assertThat(fibonacciPartialSum).isEqualTo(2);
	}

}
