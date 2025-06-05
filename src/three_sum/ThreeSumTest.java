import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ThreeSumTest {

    @Test
    public void testMultipleTriplets() {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)
        );
        List<List<Integer>> actual = ThreeSum.threeSum(input);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
    }

    @Test
    public void testNoTriplets() {
        int[] input = {1, 2, 3, 4};
        List<List<Integer>> expected = Collections.emptyList();
        List<List<Integer>> actual = ThreeSum.threeSum(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllZeros() {
        int[] input = {0, 0, 0, 0};
        List<List<Integer>> expected = Collections.singletonList(
                Arrays.asList(0, 0, 0)
        );
        List<List<Integer>> actual = ThreeSum.threeSum(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyArray() {
        int[] input = {};
        List<List<Integer>> expected = Collections.emptyList();
        List<List<Integer>> actual = ThreeSum.threeSum(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testTwoElementsOnly() {
        int[] input = {0, 1};
        List<List<Integer>> expected = Collections.emptyList();
        List<List<Integer>> actual = ThreeSum.threeSum(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testDuplicates() {
        int[] input = {-2, 0, 0, 2, 2};
        List<List<Integer>> expected = Collections.singletonList(
                Arrays.asList(-2, 0, 2)
        );
        List<List<Integer>> actual = ThreeSum.threeSum(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllNegative() {
        int[] input = {-3, -2, -1};
        List<List<Integer>> expected = Collections.emptyList();
        List<List<Integer>> actual = ThreeSum.threeSum(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllPositive() {
        int[] input = {1, 2, 3};
        List<List<Integer>> expected = Collections.emptyList();
        List<List<Integer>> actual = ThreeSum.threeSum(input);
        assertEquals(expected, actual);
    }
}
