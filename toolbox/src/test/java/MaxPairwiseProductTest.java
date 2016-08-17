import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MaxPairwiseProductTest {

	@Test
	public void testGetMaxPairwiseProduct() throws Exception {
		long maxProduct = MaxPairwiseProduct.getMaxPairwiseProduct(new long[] { 1, 3, 2 });
		assertThat(maxProduct).isEqualTo(6);
	}

	@Test
	public void testGetMaxPairwiseProductOverflow() throws Exception {
		long maxProduct = MaxPairwiseProduct.getMaxPairwiseProduct(new long[] {100000, 90000 });
		assertThat(maxProduct).isEqualTo(9000000000L);

	}

	@Test
	public void testGetMaxPairwiseProductFasted() throws Exception {
		long maxProduct1 = MaxPairwiseProduct.getMaxPairwiseProduct(new long[] {100000, 90000 });
		long maxProduct2 = MaxPairwiseProduct.getMaxPairwiseProductFast(new long[] {100000, 90000 });
		assertThat(maxProduct2).isEqualTo(maxProduct1);

	}

	@Test
	public void testGetMaxPairwiseProductFast() throws Exception {
		long maxProduct = MaxPairwiseProduct.getMaxPairwiseProductFast(new long[] { 1, 3, 2, 5, 6, 6, 7, 8, 9, 100, 4, 400 });
		assertThat(maxProduct).isEqualTo(40000);
	}

	@Test
	public void testGetMaxPairwiseProductFast2() throws Exception {
		long maxProduct = MaxPairwiseProduct.getMaxPairwiseProductFast(new long[] { 1, 3, 2, 5, 6, 6, 7, 8, 9, 100, 4, 400, 6 });
		assertThat(maxProduct).isEqualTo(40000);
	}
}
