import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testBinarySearchFindNumberExists() throws Exception {
        int[] array = new int[] { 3, 4, 5, 6, 7, 8 };
        assertBinarySearch(array, 4);
    }

    @Test
    public void testBinarySearchNotFound() throws Exception {
        int[] array = new int[] { 3, 4, 5, 6, 7, 8 };
        assertBinarySearch(array, 33);
    }

    @Test
    public void testBinarySearchRandomArrayStress() throws Exception {

        for (int j = 0; j < 10000; j++) {

            Random random = new Random();
            int[] array = new int[Math.abs(random.nextInt(100)) + 1];
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt();
            }
            Arrays.sort(array);
            assertBinarySearch(array, array[Math.abs(random.nextInt(array.length))]);
        }
    }

    private void assertBinarySearch(int[] array, int target) {
        int result = BinarySearch.binarySearch(array, target, 0, array.length);
        assertThat(result).isEqualTo(BinarySearch.linearSearch(array, target));
    }

}
