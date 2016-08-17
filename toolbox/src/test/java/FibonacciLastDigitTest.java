import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FibonacciLastDigitTest {

	@Test
	public void testGetFibonacciLastDigit() throws Exception {
		int fibonacciLastDigit = FibonacciLastDigit.getFibonacciLastDigit(331);
		assertThat(fibonacciLastDigit).isEqualTo(9);
	}

	@Test
	public void testGetFibonacciLastDigit3_Returns2() throws Exception {
		int fibonacciLastDigit = FibonacciLastDigit.getFibonacciLastDigit(3);
		assertThat(fibonacciLastDigit).isEqualTo(2);
	}

	@Test
	public void testGetFibonacciLastDigit327305_Returns2() throws Exception {
		int fibonacciLastDigit = FibonacciLastDigit.getFibonacciLastDigit(327305);
		assertThat(fibonacciLastDigit).isEqualTo(5);
	}

	@Test
	public void testGetFibonacciLastDigit613455_Returns2() throws Exception {
		int fibonacciLastDigit = FibonacciLastDigit.getFibonacciLastDigit(613455);
		assertThat(fibonacciLastDigit).isEqualTo(0);
	}
}
