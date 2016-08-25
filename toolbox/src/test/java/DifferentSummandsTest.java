import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class DifferentSummandsTest {

    @Test
    public void testOptimalSummands2() throws Exception {
        List<Integer> optimalSummands = DifferentSummands.optimalSummands(2);
        assertThat(optimalSummands).containsExactly(2);
    }

    @Test
    public void testOptimalSummands6() throws Exception {
        List<Integer> optimalSummands = DifferentSummands.optimalSummands(6);
        assertThat(optimalSummands).containsExactly(1, 2, 3);
    }

    @Test
    public void testOptimalSummands7() throws Exception {
        List<Integer> optimalSummands = DifferentSummands.optimalSummands(7);
        assertThat(optimalSummands).containsExactly(1, 2, 4);
    }

    @Test
    public void testOptimalSummands8() throws Exception {
        List<Integer> optimalSummands = DifferentSummands.optimalSummands(8);
        assertThat(optimalSummands).containsExactly(1, 2, 5);
    }

    @Test
    public void testOptimalSummands3() throws Exception {
        List<Integer> optimalSummands = DifferentSummands.optimalSummands(3);
        assertThat(optimalSummands).containsExactly(1, 2);
    }

    @Test
    public void testOptimalSummands1() throws Exception {
        List<Integer> optimalSummands = DifferentSummands.optimalSummands(1);
        assertThat(optimalSummands).containsExactly(1);
    }

    @Test
    public void testOptimalSummands5() throws Exception {
        List<Integer> optimalSummands = DifferentSummands.optimalSummands(5);
        assertThat(optimalSummands).containsExactly(1, 4);
    }

    @Test
    public void testOptimalSummandsStrees() throws Exception {
        for (int i = 0; i < 10000; i++) {
            List<Integer> optimalSummands = DifferentSummands.optimalSummands(i);
            assertThat(optimalSummands.stream()
                    .reduce((a, b) -> a + b)
                    .get()).isEqualTo(i);
        }
    }

}
