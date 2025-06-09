package reverse_words_with_delimiters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ReverseWordsWithDelimitersTest {

    @Test
    void testHelloWorldHere() {
        assertEquals("here/world:hello", ReverseWordsWithDelimiters.reverseWords("hello/world:here", new char[]{'/', ':'}));
    }

    @Test
    void testHelloWorldHereWithTrailingDelimiter() {
        assertEquals("here/world:hello/", ReverseWordsWithDelimiters.reverseWords("hello/world:here/", new char[]{'/', ':'}));
    }

    @Test
    void testHelloDoubleDelimiterWorldHere() {
        assertEquals("here//world:hello", ReverseWordsWithDelimiters.reverseWords("hello//world:here", new char[]{'/', ':'}));
    }

    @Test
    void testSingleDelimiterColon() {
        assertEquals("c:b:a", ReverseWordsWithDelimiters.reverseWords("a:b:c", new char[]{':'}));
    }

    @Test
    void testStartingWithDelimiter() {
        assertEquals("/c:b:a", ReverseWordsWithDelimiters.reverseWords("/a:b:c", new char[]{':', '/'}));
    }

    @Test
    void testCommaAndPeriodDelimiters() {
        assertEquals("word3,word2.word1", ReverseWordsWithDelimiters.reverseWords("word1,word2.word3", new char[]{',', '.'}));
    }

    @Test
    void testOnlyDelimiters() {
        assertEquals("///", ReverseWordsWithDelimiters.reverseWords("///", new char[]{'/'}));
    }

    @Test
    void testEmptyString() {
        assertEquals("", ReverseWordsWithDelimiters.reverseWords("", new char[]{':'}));
    }

    @Test
    void testNoDelimitersInString() {
        assertEquals("abc", ReverseWordsWithDelimiters.reverseWords("abc", new char[]{':'}));
    }
}
