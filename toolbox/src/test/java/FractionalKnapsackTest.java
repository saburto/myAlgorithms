import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FractionalKnapsackTest {

	@Test
	public void testGetOptimalValue() throws Exception {
		String result = FractionalKnapsack.getOptimalValue(50,
				new FractionalKnapsack.ValueWight[] {
						new FractionalKnapsack.ValueWight(60, 20),
						new FractionalKnapsack.ValueWight(100, 50),
						new FractionalKnapsack.ValueWight(120, 30) });
		assertThat(result).isEqualTo("180.0000");
	}

	@Test
	public void testGetOptimalValue50030() throws Exception {
		String result = FractionalKnapsack.getOptimalValue(10,
				new FractionalKnapsack.ValueWight[] { new FractionalKnapsack.ValueWight(500, 30) });
		assertThat(result).isEqualTo("166.6667");
	}

	@Test
	public void testGetOptimalValue50030Capacity1000() throws Exception {
		String result = FractionalKnapsack.getOptimalValue(1000,
				new FractionalKnapsack.ValueWight[] { new FractionalKnapsack.ValueWight(500, 30) });
		assertThat(result).isEqualTo("500.0000");
	}

}

