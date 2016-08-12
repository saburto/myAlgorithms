import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class APlusBTest {

	@Test
	public void testName() throws Exception {
		System.setIn(new ByteArrayInputStream("2 3".getBytes()));
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteArrayOutputStream));
		APlusB.main(null);
		assertThat(byteArrayOutputStream.toString()).isEqualToIgnoringWhitespace("5");
	}
}
