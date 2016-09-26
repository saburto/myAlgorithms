import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class MergingTablesTest {

    @Test
    public void testMergingTables() throws Exception {
        Stream<Integer> firstNumbers = Stream.of(5, 5);
        Stream<Integer> tableNumbers = Stream.of(1, 1, 1, 1, 1);
        Stream<String> mergeOperations = Stream.of("3 5", "2 4", "1 4", "5 4", "5 3");
        Stream<Integer> expectedStream = Stream.of(2, 2, 3, 5, 5);

        assertMergingTable(firstNumbers, tableNumbers, mergeOperations, expectedStream);

    }

    @Test
    public void testMergingTables2() throws Exception {
        Stream<Integer> firstNumbers = Stream.of(6, 4);
        Stream<Integer> tableNumbers = Stream.of(10, 0, 5, 0, 3, 3);
        Stream<String> mergeOperations = Stream.of("6 6", "6 5", "5 4", "4 3");
        Stream<Integer> expectedStream = Stream.of(10, 10, 10, 11);

        assertMergingTable(firstNumbers, tableNumbers, mergeOperations, expectedStream);

    }

    private void assertMergingTable(Stream<Integer> firstNumbers, Stream<Integer> tableNumbers,
            Stream<String> mergeOperations, Stream<Integer> expectedStream) {
        String firstLine = firstNumbers
                .map(String::valueOf)
                .collect(Collectors.joining(" ", "", "\n"));

        String table = tableNumbers
                .map(String::valueOf)
                .collect(Collectors.joining(" ", "", "\n"));

        String merges = mergeOperations
                .collect(Collectors.joining("\n", "", "\n"));

        String input = Stream.of(firstLine, table, merges)
                .collect(Collectors.joining());

        String expected = expectedStream
                .map(String::valueOf)
                .collect(Collectors.joining("\n", "", "\n"));

        MergingTables.InputReader reader = new MergingTables.InputReader(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        MergingTables.OutputWriter writer = new MergingTables.OutputWriter(output);
        new MergingTables(reader, writer).run();
        writer.writer.flush();

        assertThat(output.toString()).isEqualTo(expected);
    }

}
