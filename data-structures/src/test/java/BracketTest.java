import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class BracketTest {

    @Test
    public void testCheckBrackets() throws Exception {
        String result = Bracket.checkBrackets("[]");
        assertThat(result).isEqualTo("Success");
    }

    @Test
    public void testCheckBrackets2() throws Exception {
        String result = Bracket.checkBrackets("{}[]");
        assertThat(result).isEqualTo("Success");
    }

    @Test
    public void testCheckBracketsError1() throws Exception {
        String result = Bracket.checkBrackets("{");
        assertThat(result).isEqualTo("1");
    }

    @Test
    public void testCheckBracketsError3() throws Exception {
        String result = Bracket.checkBrackets("{[}");
        assertThat(result).isEqualTo("3");
    }

    @Test
    public void testCheckBracketsError10() throws Exception {
        String result = Bracket.checkBrackets("foo(bar[i);");
        assertThat(result).isEqualTo("10");
    }

    @Test
    public void testCheckBracketsAllTest() throws Exception {

        Path path = Paths.get(getClass().getResource("/bracket/tests/01")
                .getPath());
        Files.list(path.getParent())
        .forEach(f -> {

            try {
                if (!f.getFileName()
                        .toString()
                        .endsWith("a")) {
                    String line = Files.lines(f)
                            .findFirst()
                            .get();

                    String answer = Files.lines(Paths.get(f.getParent()
                            .toString(), f.getFileName() + ".a"))
                            .findFirst()
                            .get();

                            String result = Bracket.checkBrackets(line);
                    assertThat(result).isEqualTo(answer);
                    System.out.println(f.getFileName());

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

}
