import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class KnapsackTest {

    private static final int VAL = 3;
    private static final int CAP = 4;

    @Test
    public void testName() throws Exception {

        int[] capcities = new int[] { 1, 4, 3 };
        int[] values = new int[] { 1500, 3000, 2000 };

        int[][] matrix = new int[VAL][CAP];
        for (int i = 0; i < VAL; i++) {

            int cap = capcities[i];
            for (int j = 0; j < CAP; j++) {

                if (cap == (j + 1)) {
                    matrix[i][j] = values[i];
                } else if (cap < (j + 1)) {
                    if (i > 0) {
                        matrix[i][j] = values[i] + matrix[i - 1][j - cap];
                    } else {
                        matrix[i][j] = values[i];
                    }
                }

                if (i > 0) {
                    matrix[i][j] = Math.max(matrix[i][j], matrix[i - 1][j]);
                }

            }
            System.out.println(Arrays.toString(matrix[i]));
        }
        assertThat(matrix[VAL - 1][CAP - 1]).isEqualTo(3500);
    }

    @Test
    public void testOptimalWeight() throws Exception {
        int optimalWeight = Knapsack.optimalWeight(10, new int[] { 1, 4, 8 });
        assertThat(optimalWeight).isEqualTo(9);
    }
}
