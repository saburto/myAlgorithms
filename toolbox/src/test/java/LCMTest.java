import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LCMTest {

	@Test
	public void testLcm() throws Exception {
		long lcm = LCM.lcm(6, 8);
		assertThat(lcm).isEqualTo(24);
	}

	@Test
	public void testLcmLargeNumber() throws Exception {
		long lcm = LCM.lcm(28851538, 1183019);
		assertThat(lcm).isEqualTo(1933053046);
	}

}
