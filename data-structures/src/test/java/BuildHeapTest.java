import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class BuildHeapTest {

    @Test
    public void testGenerateSwapsEfective() throws Exception {
        BuildHeap buildHeap = new BuildHeap();
        List<BuildHeap.Swap> swaps = buildHeap.generateSwapsEfective(new int[] { 5, 4, 3, 2, 1 });

        assertThat(swaps).containsExactly(new BuildHeap.Swap(1, 4),
                new BuildHeap.Swap(0, 1),
                new BuildHeap.Swap(1, 3));

    }

    @Test
    public void testGenerateSwapsEfectiveSorted() throws Exception {
        BuildHeap buildHeap = new BuildHeap();
        List<BuildHeap.Swap> swaps = buildHeap.generateSwapsEfective(new int[] { 1, 2, 3, 4, 5 });

        assertThat(swaps).isEmpty();

    }

}
