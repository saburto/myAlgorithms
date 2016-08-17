import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class GCDTest {

	@Test
	public void testGcd() throws Exception {
		int gcd = GCD.gcd(18, 35);
		assertThat(gcd).isEqualTo(1);
	}

	@Test
	public void testGcdLargeNumber() throws Exception {
		int gcd = GCD.gcd(28851538, 1183019);
		assertThat(gcd).isEqualTo(17657);
	}

}
