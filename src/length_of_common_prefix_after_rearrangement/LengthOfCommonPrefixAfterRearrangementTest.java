package length_of_common_prefix_after_rearrangement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LengthOfCommonPrefixAfterRearrangementTest {

    @Test
    public void testAllEmptyStrings() {
        String[] input = {"", "", "", ""};
        assertEquals(0, LengthOfCommonPrefixAfterRearrangement.lengthOfCommonPrefixAfterRearrangement(input));
    }

    @Test
    public void testSingleCharStringsAllSame() {
        String[] input = {"a", "a", "a", "a"};
        assertEquals(1, LengthOfCommonPrefixAfterRearrangement.lengthOfCommonPrefixAfterRearrangement(input));
    }

    @Test
    public void testSingleCharStringsDifferent() {
        String[] input = {"a", "b", "c", "d"};
        assertEquals(0, LengthOfCommonPrefixAfterRearrangement.lengthOfCommonPrefixAfterRearrangement(input));
    }

    @Test
    public void testStringsWithCommonLetters() {
        String[] input = {"aabc", "abca", "bcaa", "caab"};
        // min frequencies: a=2, b=1, c=1 -> total 4
        assertEquals(4, LengthOfCommonPrefixAfterRearrangement.lengthOfCommonPrefixAfterRearrangement(input));
    }

    @Test
    public void testNoCommonLetters() {
        String[] input = {"abc", "def", "ghi", "jkl"};
        assertEquals(0, LengthOfCommonPrefixAfterRearrangement.lengthOfCommonPrefixAfterRearrangement(input));
    }

    @Test
    public void testPartialOverlap() {
        String[] input = {"aabbcc", "abbbc", "acc", "abc"};
        // letters frequencies min:
        // a: min(2,1,1,1) =1
        // b: min(2,3,0,1) =0
        // c: min(2,1,2,1) =1
        // total = 1+0+1=2
        assertEquals(2, LengthOfCommonPrefixAfterRearrangement.lengthOfCommonPrefixAfterRearrangement(input));
    }

    @Test
    public void testStringsWithRepeats() {
        String[] input = {"aaaabbbb", "aaabbb", "aabbb", "abbb"};
        // a: min(4,3,2,1)=1
        // b: min(4,3,3,3)=3
        // total = 4
        assertEquals(4, LengthOfCommonPrefixAfterRearrangement.lengthOfCommonPrefixAfterRearrangement(input));
    }

    @Test
    public void testStringsWithDifferentLengths() {
        String[] input = {"abcdefgh", "abcdef", "abcde", "abcd"};
        // Common letters are a,b,c,d
        // min counts: a=1, b=1, c=1, d=1
        // total=4
        assertEquals(4, LengthOfCommonPrefixAfterRearrangement.lengthOfCommonPrefixAfterRearrangement(input));
    }

    @Test
    public void testStringsWithUnicodeLetters() {
        String[] input = {"áéíóú", "úóíéá", "áúéóí", "éíóáú"};
        // all contain the same letters exactly once
        // total = 5
        assertEquals(5, LengthOfCommonPrefixAfterRearrangement.lengthOfCommonPrefixAfterRearrangement(input));
    }

    @Test
    public void testNullInput() {
        assertEquals(0, LengthOfCommonPrefixAfterRearrangement.lengthOfCommonPrefixAfterRearrangement(null));
    }

}
