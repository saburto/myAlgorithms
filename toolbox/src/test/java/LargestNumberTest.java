import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LargestNumberTest {

    @Test
    public void testLargestNumber() throws Exception {
        String result = LargestNumber.largestNumber(new String[] { "21", "2" });
        assertThat(result).isEqualTo("221");
    }

    @Test
    public void testLargestNumberOnlyOneDigit() throws Exception {
        String result = LargestNumber.largestNumber(new String[] { "9", "4", "6", "1", "9" });
        assertThat(result).isEqualTo("99641");
    }

    @Test
    public void testLargestNumberOnlyTwoDigit() throws Exception {
        String result = LargestNumber.largestNumber(new String[] { "23", "39", "92" });
        assertThat(result).isEqualTo("923923");
    }

    @Test
    public void testLargestNumbera() throws Exception {
        String result = LargestNumber.largestNumber(new String[] { "3", "39", "333" });
        assertThat(result).isEqualTo("393333");
    }

    @Test
    public void testLargestNumberb() throws Exception {
        String result = LargestNumber.largestNumber(new String[] { "3919", "3", "3982", "333" });
        assertThat(result).isEqualTo("398239193333");
    }
}
