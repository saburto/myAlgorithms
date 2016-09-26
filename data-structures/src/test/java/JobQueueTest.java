import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;


public class JobQueueTest {

    @Test
    public void testAssignJobs() throws Exception {
        JobQueue jobQueue = new JobQueue();
        Queue<Integer> integers = new LinkedList<>();
        integers.addAll(Arrays.asList(1, 2, 3, 4, 5));
        List<JobQueue.Pair> result = jobQueue.assignJobs(integers, 2);
        assertThat(result).containsExactly(
                new JobQueue.Pair(0, 0l),
                new JobQueue.Pair(1, 0l),
                new JobQueue.Pair(0, 1l),
                new JobQueue.Pair(1, 2l),
                new JobQueue.Pair(0, 4l));
    }

}
