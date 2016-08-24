import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DotProductTest {

    @Test
    public void testMaxDotProduct() throws Exception {
        long maxDotProduct = DotProduct.maxDotProduct(new long[] { 23 }, new long[] { 39 });
        assertThat(maxDotProduct).isEqualTo(897);
    }

    @Test
    public void testMaxDotProduct2() throws Exception {
        long maxDotProduct = DotProduct.maxDotProduct(
                new long[] { 1, 3, -5 },
                new long[] { -2, 4, 1 });
        assertThat(maxDotProduct).isEqualTo(23);
    }

}
