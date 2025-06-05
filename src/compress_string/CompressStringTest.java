import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompressStringTest {

    @Test
    public void testBasicCompression() {
        assertEquals("a2b3c5", CompressString.compressString("aabbbccccc"));
    }

    @Test
    public void testSingleCharacters() {
        assertEquals("a1b1c1", CompressString.compressString("abc"));
    }

    @Test
    public void testAllSameCharacters() {
        assertEquals("z6", CompressString.compressString("zzzzzz"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", CompressString.compressString(""));
    }

    @Test
    public void testNoRepetition() {
        assertEquals("a1b1c1d1", CompressString.compressString("abcd"));
    }

    @Test
    public void testMixedCase() {
        assertEquals("A2a2", CompressString.compressString("AAaa"));
    }

    @Test
    public void testDigitsInString() {
        assertEquals("a2b2c1d2", CompressString.compressString("aabbcdd"));
    }
}
