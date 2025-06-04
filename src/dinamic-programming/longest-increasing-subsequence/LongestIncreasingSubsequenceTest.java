import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void testExample1() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        assertEquals(4, LongestIncreasingSubsequence.getLIS(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = {0, 1, 0, 3, 2, 3};
        assertEquals(4, LongestIncreasingSubsequence.getLIS(nums));
    }

    @Test
    public void testExample3() {
        int[] nums = {7, 7, 7, 7, 7, 7, 7};
        assertEquals(1, LongestIncreasingSubsequence.getLIS(nums));
    }

    @Test
    public void testSingleElement() {
        int[] nums = {42};
        assertEquals(1, LongestIncreasingSubsequence.getLIS(nums));
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        assertEquals(0, LongestIncreasingSubsequence.getLIS(nums));
    }

    @Test
    public void testStrictlyIncreasing() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(5, LongestIncreasingSubsequence.getLIS(nums));
    }

    @Test
    public void testStrictlyDecreasing() {
        int[] nums = {5, 4, 3, 2, 1};
        assertEquals(1, LongestIncreasingSubsequence.getLIS(nums));
    }
}
