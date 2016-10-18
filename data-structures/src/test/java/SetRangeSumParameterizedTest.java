import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SetRangeSumParameterizedTest {

    @Parameters(name = "{index}: File {2}")
    public static Collection<Object[]> data() throws Exception {

        Collection<Object[]> data = new ArrayList<>();

        int[] filesNumber = new int[] { 1, 4, 5, 20, 36, 83 };

        for (int i : filesNumber) {
            String file = String.format("/sum_range/%02d",
                    i);
            System.setIn(SetRangeSumParameterizedTest.class.getResourceAsStream(file));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            SetRangeSum.main(null);

            String answer = Files.lines(Paths.get(SetRangeSumParameterizedTest.class.getResource(file + ".a")
                    .getFile()))
                    .collect(Collectors.joining("\n"));
            data.add(new Object[] { out.toString(), answer, i });
        }
        return data;
    }

    String result;
    String answer;
    private int fileNumber;

    public SetRangeSumParameterizedTest(String result, String answer, int i) {
        this.result = result;
        this.answer = answer;
        this.fileNumber = i;
    }

    @Test
    public void testName() throws Exception {
        assertThat(result.trim()).isEqualTo(answer);
    }

}
