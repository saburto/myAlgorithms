import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TreeOrdersMainTest {

    @Test
    public void testRun() throws Exception {
        System.setIn(new ByteArrayInputStream(("5\n" +
                "4 1 2\n" +
                "2 3 4\n" +
                "5 -1 -1\n" +
                "1 -1 -1\n" +
                "3 -1 -1").getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        new TreeOrdersMain().run();

        assertThat(out.toString()).isEqualTo("1 2 3 4 5 \n" +
                "4 2 1 3 5 \n" +
                "1 3 2 5 4 \n");
    }

}
