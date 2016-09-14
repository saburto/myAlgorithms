import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class EditDistanceTest {

    @Test
    public void testEditDistance() throws Exception {
        int distance = EditDistance.editDistance("short", "ports");
        assertThat(distance).isEqualTo(3);
    }

    @Test
    public void testEditDistance2() throws Exception {
        int distance = EditDistance.editDistance("editing", "distance");
        assertThat(distance).isEqualTo(5);
    }

    @Test
    public void testEditDistanceAB() throws Exception {
        int distance = EditDistance.editDistance("ab", "ab");
        assertThat(distance).isEqualTo(0);
    }

}
