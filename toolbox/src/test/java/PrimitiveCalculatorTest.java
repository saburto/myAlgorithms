import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class PrimitiveCalculatorTest {

    @Test
    public void testOptimal_sequence1() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(1);
        assertThat(optimal_sequence).containsExactly(1);
    }

    @Test
    public void testOptimal_sequence0() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(0);
        assertThat(optimal_sequence).containsExactly(0);
    }

    @Test
    public void testOptimal_sequence5() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(5);
        assertThat(optimal_sequence).containsExactly(1, 2, 4, 5);
    }

    @Test
    public void testOptimal_sequence96234() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(96234);
        assertThat(optimal_sequence).containsExactly(1, 3, 9, 10, 11, 22, 66, 198, 594, 1782, 5346, 16038, 16039, 32078,
                96234);
    }

    @Test
    public void testOptimal_sequence10() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(10);
        assertThat(optimal_sequence).containsExactly(1, 3, 9, 10);
    }

    @Test
    public void testOptimal_sequence11() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(11);
        assertThat(optimal_sequence).containsExactly(1, 3, 9, 10, 11);
    }

    @Test
    public void testOptimal_sequence12() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(12);
        assertThat(optimal_sequence).containsExactly(1, 2, 4, 12);
    }

    @Test
    public void testOptimal_sequence13() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(13);
        assertThat(optimal_sequence).containsExactly(1, 2, 4, 12, 13);
    }

    @Test
    public void testOptimal_sequence14() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(14);
        assertThat(optimal_sequence).containsExactly(1, 2, 6, 7, 14);
    }

    @Test
    public void testOptimal_sequence15() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(15);
        assertThat(optimal_sequence).containsExactly(1, 2, 4, 5, 15);
    }

    @Test
    public void testOptimal_sequence16() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(16);
        assertThat(optimal_sequence).containsExactly(1, 2, 4, 8, 16);
    }

    @Test
    public void testOptimal_sequence17() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(17);
        assertThat(optimal_sequence).containsExactly(1, 2, 4, 8, 16, 17);
    }

    @Test
    public void testOptimal_sequence18() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(18);
        assertThat(optimal_sequence).containsExactly(1, 2, 6, 18);
    }

    @Test
    public void testOptimal_sequence19() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(19);
        assertThat(optimal_sequence).containsExactly(1, 2, 6, 18, 19);
    }

    @Test
    public void testOptimal_sequence20() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(20);
        assertThat(optimal_sequence).containsExactly(1, 3, 9, 10, 20);
    }

    @Test
    public void testOptimal_sequence21() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(21);
        assertThat(optimal_sequence).containsExactly(1, 2, 6, 7, 21);
    }

    @Test
    public void testOptimal_sequence22() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(22);
        assertThat(optimal_sequence).containsExactly(1, 3, 9, 10, 11, 22);
    }

    @Test
    public void testOptimal_sequence23() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(23);
        assertThat(optimal_sequence).containsExactly(1, 3, 9, 10, 11, 22, 23);
    }

    @Test
    public void testOptimal_sequence24() throws Exception {
        List<Integer> optimal_sequence = PrimitiveCalculator.optimal_sequence(24);
        assertThat(optimal_sequence).containsExactly(1, 2, 4, 8, 24);
    }

}
