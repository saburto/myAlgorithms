import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SetRangeSumTest {

    @Test
    public void inserTwoElementFindThemTrue() throws Exception {
        SetRangeSum.SplayTree splayTree = new SetRangeSum.SplayTree();
        splayTree.insert(1);
        assertThat(splayTree.find(1)).isTrue();
        splayTree.insert(2);
        assertThat(splayTree.find(1)).isTrue();
        assertThat(splayTree.find(2)).isTrue();
    }

    @Test
    public void findNoElementFound() throws Exception {
        SetRangeSum.SplayTree splayTree = new SetRangeSum.SplayTree();
        assertThat(splayTree.find(1)).isFalse();
    }

    @Test
    public void addThenRemoveAll() throws Exception {
        SetRangeSum.SplayTree splayTree = new SetRangeSum.SplayTree();
        for (int i = 0; i < 100; i++) {
            splayTree.insert(i);
        }
        for (int i = 0; i < 100; i++) {
            splayTree.erase(i);
        }

        for (int i = 0; i < 100; i++) {
            assertThat(splayTree.find(i)).isFalse();
        }
    }

    @Test
    public void insertThenRemoveElementNotFound() throws Exception {
        SetRangeSum.SplayTree splayTree = new SetRangeSum.SplayTree();
        splayTree.insert(1);
        assertThat(splayTree.find(1)).isTrue();
        splayTree.erase(1);
        assertThat(splayTree.find(1)).isFalse();
    }

    @Test
    public void inserttwoElementThenRemoveOneElementNotFound() throws Exception {
        SetRangeSum.SplayTree splayTree = new SetRangeSum.SplayTree();
        splayTree.insert(1);
        splayTree.insert(9);
        assertThat(splayTree.find(1)).isTrue();
        assertThat(splayTree.find(9)).isTrue();
        splayTree.erase(1);
        assertThat(splayTree.find(1)).isFalse();
        assertThat(splayTree.find(9)).isTrue();
    }

    @Test
    public void insertTenElementThenRemoveFiveElementNotFound() throws Exception {
        SetRangeSum.SplayTree splayTree = new SetRangeSum.SplayTree();
        for (int i = 1; i <= 10; i++) {
            splayTree.insert(i);
            assertThat(splayTree.find(i)).isTrue();
        }

        for (int i = 1; i <= 5; i++) {
            splayTree.erase(i);
            assertThat(splayTree.find(i))
            .describedAs("i = " + i)
            .isFalse();
        }

        for (int i = 6; i <= 10; i++) {
            assertThat(splayTree.find(i))
            .describedAs("i = " + i)
            .isTrue();
        }
    }

    @Test
    public void sumOneAndTwoEqualsThree() throws Exception {
        SetRangeSum.SplayTree splayTree = new SetRangeSum.SplayTree();
        splayTree.insert(1);
        splayTree.insert(2);
        assertThat(splayTree.sum(1, 2)).isEqualTo(3);
    }

    @Test
    public void sumOneAndThreeEqualsSix() throws Exception {
        SetRangeSum.SplayTree splayTree = new SetRangeSum.SplayTree();
        splayTree.insert(1);
        splayTree.insert(2);
        splayTree.insert(3);
        assertThat(splayTree.sum(1, 3)).isEqualTo(6);
    }
}
