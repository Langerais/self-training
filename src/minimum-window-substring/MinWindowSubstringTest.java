import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MinWindowSubstringTest {

    @Test
    public void testExample1() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String expected = "BANC";
        assertEquals(expected, MinWindowSubstring.minWindow(s, t));
    }

    @Test
    public void testExample2() {
        String s = "a";
        String t = "a";
        String expected = "a";
        assertEquals(expected, MinWindowSubstring.minWindow(s, t));
    }

    @Test
    public void testExample3() {
        String s = "a";
        String t = "aa";
        String expected = "";
        assertEquals(expected, MinWindowSubstring.minWindow(s, t));
    }

    @Test
    public void testNoMatch() {
        String s = "abc";
        String t = "d";
        String expected = "";
        assertEquals(expected, MinWindowSubstring.minWindow(s, t));
    }

    @Test
    public void testWholeStringMatch() {
        String s = "xyz";
        String t = "xyz";
        String expected = "xyz";
        assertEquals(expected, MinWindowSubstring.minWindow(s, t));
    }

    @Test
    public void testRepeatedCharsInT() {
        String s = "aaabbcc";
        String t = "abc";
        String expected = "abbc";
        assertEquals(expected, MinWindowSubstring.minWindow(s, t));
    }

    @Test
    public void testMultiplePossibleWindows() {
        String s = "abdabca";   // Does not satisfy the unique answer. Returns first
        String t = "abc";
        String expected = "abc"; // shortest window containing a,b,c
        assertEquals(expected, MinWindowSubstring.minWindow(s, t));
    }


}
