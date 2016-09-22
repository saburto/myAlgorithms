import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TreeHeightProblemTest {



    @Parameters
    public static Collection<Object[]> data() throws Exception {

        Collection<Object[]> data = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            String file = String.format("/tree/tests/%02d",
                    i + 1);
            System.setIn(TreeHeightProblemTest.class.getResourceAsStream(file));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            TreeHeightProblem.main(null);

            String answer = Files.lines(Paths.get(TreeHeightProblemTest.class.getResource(file + ".a")
                    .getFile()))
                    .findFirst()
                    .get();
            data.add(new Object[] { out.toString(), answer });
        }
        return data;
    }

    String result;
    String answer;

    public TreeHeightProblemTest(String result, String answer) {
        this.result = result;
        this.answer = answer;
    }

    @Test
    public void testName() throws Exception {
        assertThat(result).isEqualToIgnoringWhitespace(answer);
    }

}
