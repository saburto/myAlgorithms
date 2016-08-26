package org.saburto.greedy.luck.balance;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void testMaxMountOfLuck() throws Exception {
        int result = Solution.maxMountOfLuck(3, 4, Arrays.asList(
                new Solution.EventLuck(5, true),
                new Solution.EventLuck(2, true),
                new Solution.EventLuck(1, true),
                new Solution.EventLuck(8, true),
                new Solution.EventLuck(10, false),
                new Solution.EventLuck(5, false)));
        assertThat(result).isEqualTo(29);
    }

}
