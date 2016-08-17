import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GCDParamTest {

	private int a;
	private int b;

	@Parameters
	public static Collection<Object[]> data() {

		Collection<Object[]> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Random random = new Random();
			Integer a = Math.abs(random.nextInt());
			Integer b = Math.abs(random.nextInt());
			list.add(new Object[] { a, b });
		}
		return list;
		// return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 }, {
		// 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
	}

	public GCDParamTest(final int a, final int b) {
		this.a = a;
		this.b = b;
	}

	@Test
	public void test() {
		int gcdFast = GCD.gcd(a, b);
		int gcdOld = GCD.gcdOld(a, b);
		assertThat(gcdFast).isEqualTo(gcdOld);
	}
}
