import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ChangeTest {

	@Test
	public void testGetChangeTwo() throws Exception {
		int result = Change.getChange(2);
		assertThat(result).isEqualTo(2);
	}

	@Test
	public void testGetChange28() throws Exception {
		int result = Change.getChange(28);
		assertThat(result).isEqualTo(6);
	}

}
