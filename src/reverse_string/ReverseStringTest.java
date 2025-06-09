package reverse_string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ReverseStringTest {

    // Tests for reverseWordsInPlace method

    @Test
    public void testReverseWordsInPlace_basic() {
        char[] arr = "hello world here".toCharArray();
        ReverseString.reverseWordsInPlace(arr);
        assertEquals("here world hello", new String(arr));
    }

    @Test
    public void testReverseWordsInPlace_multipleWords() {
        char[] arr = "one two three four".toCharArray();
        ReverseString.reverseWordsInPlace(arr);
        assertEquals("four three two one", new String(arr));
    }

    @Test
    public void testReverseWordsInPlace_singleWord() {
        char[] arr = "singleword".toCharArray();
        ReverseString.reverseWordsInPlace(arr);
        assertEquals("singleword", new String(arr));
    }

    @Test
    public void testReverseWordsInPlace_emptyString() {
        char[] arr = "".toCharArray();
        ReverseString.reverseWordsInPlace(arr);
        assertEquals("", new String(arr));
    }
}
