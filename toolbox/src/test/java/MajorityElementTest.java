import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MajorityElementTest {

    @Test
    public void testGetMajorityElement() throws Exception {
        boolean result = MajorityElement.getMajorityElement(new int[] { 2, 1, 2, 4, 3, 2, 3, 2, 2, 5, 2 });
        assertThat(result).isTrue();
    }

}
