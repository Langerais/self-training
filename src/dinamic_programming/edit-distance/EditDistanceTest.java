import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EditDistanceTest {

    @Test
    public void testSameStrings() {
        assertEquals(0, EditDistance.editDistance("test", "test"));
    }

    @Test
    public void testEmptyToNonEmpty() {
        assertEquals(4, EditDistance.editDistance("", "test"));
    }

    @Test
    public void testNonEmptyToEmpty() {
        assertEquals(3, EditDistance.editDistance("cat", ""));
    }

    @Test
    public void testSimpleReplace() {
        assertEquals(1, EditDistance.editDistance("cat", "bat"));
    }

    @Test
    public void testInsertAndDelete() {
        assertEquals(3, EditDistance.editDistance("horse", "ros"));
    }

    @Test
    public void testComplexExample() {
        assertEquals(5, EditDistance.editDistance("intention", "execution"));
    }

    @Test
    public void testCompletelyDifferent() {
        assertEquals(3, EditDistance.editDistance("abc", "def"));
    }

    @Test
    public void testOneEmptyOneSingleChar() {
        assertEquals(1, EditDistance.editDistance("", "a"));
        assertEquals(1, EditDistance.editDistance("a", ""));
    }
}
