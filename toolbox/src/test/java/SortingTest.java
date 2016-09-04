import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SortingTest {

    @Test
    public void testRandomizedQuickSort() throws Exception {
        int[] array = getArrayBase();
        Sorting.randomizedQuickSort(array, 0, array.length - 1);
        assertThat(array).isSorted();
    }

    @Test
    public void testRandomizedQuickSort3() throws Exception {
        int[] array = getArrayBase();
        Sorting.randomizedQuickSort3(array, 0, array.length - 1);
        assertThat(array).isSorted();
    }

    @Test
    public void testRandomizedQuickSortSameElement3() throws Exception {
        int[] arraySomeValue1 = getArraySomeSameValue();
        Sorting.randomizedQuickSort3(arraySomeValue1, 0, arraySomeValue1.length - 1);

        int[] arraySomeValue2 = getArraySomeSameValue();
        Sorting.randomizedQuickSort(arraySomeValue2, 0, arraySomeValue2.length - 1);

        assertThat(arraySomeValue1).isSorted();
        assertThat(arraySomeValue2).isSorted();

        assertThat(arraySomeValue1).isEqualTo(arraySomeValue2);
    }

    @Test
    public void testRandomizedQuickSortManySameElement() throws Exception {
        int[] arraySomeValue1 = new int[100000];
        for (int i = 0; i < arraySomeValue1.length; i++) {
            arraySomeValue1[i] = (i % 4) + 900000000;
        }

        Sorting.randomizedQuickSort(arraySomeValue1, 0, arraySomeValue1.length - 1);

        assertThat(arraySomeValue1).isSorted();
    }

    private int[] getArraySomeSameValue() {
        return new int[] { 1, 3, 8, 8, 8, 8, 8, 8, 8, 9 };
    }

    private int[] getArrayBase() {
        return new int[] { 1, 3, 5, 6, 7, 8, 9 };
    }

}
