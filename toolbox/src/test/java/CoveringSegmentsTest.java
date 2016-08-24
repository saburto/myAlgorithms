import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.Test;

public class CoveringSegmentsTest {

    @Test
    public void testOptimalPoints() throws Exception {

        Set<Integer> optimalPoints = CoveringSegments.optimalPoints(new CoveringSegments.Segment[] {
                new CoveringSegments.Segment(4, 7),
                new CoveringSegments.Segment(1, 3),
                new CoveringSegments.Segment(2, 5),
                new CoveringSegments.Segment(5, 6) });

        assertThat(optimalPoints).containsExactly(3, 6);
    }

    @Test
    public void testOptimalPoints3() throws Exception {
        // 1 32 53 6
        Set<Integer> optimalPoints = CoveringSegments.optimalPoints(new CoveringSegments.Segment[] {
                new CoveringSegments.Segment(1, 3),
                new CoveringSegments.Segment(2, 5),
                new CoveringSegments.Segment(3, 6) });

        assertThat(optimalPoints).containsExactly(3);
    }

}
