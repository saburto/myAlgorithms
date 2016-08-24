import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FibonacciHugeTest {

	@Test
	public void testGetPisanoPeriod_1() throws Exception {
		long period = FibonacciHuge.getPisanoPeriod(1).length;
		assertThat(period).isEqualTo(1);
	}

	@Test
	public void testGetPisanoPeriod_2() throws Exception {
		long period = FibonacciHuge.getPisanoPeriod(2).length;
		assertThat(period).isEqualTo(3);
	}

	@Test
	public void testGetPisanoPeriod_3() throws Exception {
		long period = FibonacciHuge.getPisanoPeriod(3).length;
		assertThat(period).isEqualTo(8);
	}

	@Test
	public void testGetPisanoPeriod_239() throws Exception {
		long period = FibonacciHuge.getPisanoPeriod(239).length;
		assertThat(period).isEqualTo(238);
	}

	@Test
	public void testGetPisanoPeriod_1000() throws Exception {
		long period = FibonacciHuge.getPisanoPeriod(1000).length;
		assertThat(period).isEqualTo(1500);
	}

	@Test
	public void testGetPisanoPeriod_30524() throws Exception {
		long period = FibonacciHuge.getPisanoPeriod(30524).length;
		assertThat(period).isEqualTo(1176);
	}

	@Test
	public void testGetFibHuge() throws Exception {
		long fibHuge = FibonacciHuge.getFibHuge(1, 239);
		assertThat(fibHuge).isEqualTo(1);
	}

	@Test
	public void testGetFibHuge_1000() throws Exception {
		long fibHuge = FibonacciHuge.getFibHuge(239, 1000);
		assertThat(fibHuge).isEqualTo(161);
	}

	@Test
	public void testGetFibHuge_2() throws Exception {
		long fibHuge = FibonacciHuge.getFibHuge(10, 2);
		assertThat(fibHuge).isEqualTo(1);
	}

	@Test
	public void testGetFibHuge_3() throws Exception {
		long fibHuge = FibonacciHuge.getFibHuge(10, 3);
		assertThat(fibHuge).isEqualTo(1);
	}

	@Test
	public void testGetFibHuge_100() throws Exception {
		long fibHuge = FibonacciHuge.getFibHuge(100, 100000);
		assertThat(fibHuge).isEqualTo(15075);
	}

	@Test
	public void testGetFibHuge_4() throws Exception {
		long fibHuge = FibonacciHuge.getFibHuge(10, 4);
		assertThat(fibHuge).isEqualTo(3);
	}

	@Test
	public void testGetFibHuge_30524() throws Exception {
		long fibHuge = FibonacciHuge.getFibHuge(2816213588L, 30524);
		assertThat(fibHuge).isEqualTo(10249);
	}
}
