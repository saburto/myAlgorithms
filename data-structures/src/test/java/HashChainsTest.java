import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class HashChainsTest {

    @Test
    public void testProcessQuery() throws Exception {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        HashChains hashChains = new HashChains();
        hashChains.setNewBucket(5);

        hashChains.processQuery(new HashChains.Query("add", "world"));
        hashChains.processQuery(new HashChains.Query("add", "HellO"));
        hashChains.processQuery(new HashChains.Query("check", 4));
        hashChains.processQuery(new HashChains.Query("find", "World"));
        hashChains.processQuery(new HashChains.Query("find", "world"));
        hashChains.processQuery(new HashChains.Query("del", "world"));
        hashChains.processQuery(new HashChains.Query("check", 4));
        hashChains.processQuery(new HashChains.Query("del", "HellO"));
        hashChains.processQuery(new HashChains.Query("add", "luck"));
        hashChains.processQuery(new HashChains.Query("add", "GooD"));
        hashChains.processQuery(new HashChains.Query("check", 2));
        hashChains.processQuery(new HashChains.Query("del", "good"));

        assertThat(out.toString()).isEqualTo("HellO world\n" +
                "no\n" +
                "yes\n" +
                "HellO\n" +
                "GooD luck\n");
    }

    @Test
    public void testName() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        System.setIn(new ByteArrayInputStream(("5\n" +
                "12\n" +
                "add world\n" +
                "add HellO\n" +
                "check 4\n" +
                "find World\n" +
                "find world\n" +
                "del world\n" +
                "check 4\n" +
                "del HellO\n" +
                "add luck\n" +
                "add GooD\n" +
                "check 2\n" +
                "del good").getBytes()));
        HashChains.main(null);

        assertThat(out.toString()).isEqualTo("HellO world\n" +
                "no\n" +
                "yes\n" +
                "HellO\n" +
                "GooD luck\n");
    }

    @Test
    public void testName2() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.setIn(new ByteArrayInputStream(("4\n" +
                "8\n" +
                "add test\n" +
                "add test\n" +
                "find test\n" +
                "del test\n" +
                "find test\n" +
                "find Test\n" +
                "add Test\n" +
                "find Test").getBytes()));
        HashChains.main(null);
        assertThat(out.toString()).isEqualTo("yes\n" +
                "no\n" +
                "no\n" +
                "yes\n");
    }

}
