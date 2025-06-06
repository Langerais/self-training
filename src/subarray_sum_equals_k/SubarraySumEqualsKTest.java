package subarray_sum_equals_k;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SubarraySumEqualsKTest {

    private SubarraySumEqualsK solver;

    @BeforeEach
    public void setup() {
        solver = new SubarraySumEqualsK();
    }

    @Test
    public void testBasicExample() {
        int[] nums = {1, 1, 1};
        int k = 2;
        assertEquals(2, solver.subarraySum(nums, k));
    }

    @Test
    public void testWithNegativeNumbers() {
        int[] nums = {1, 2, 3, -2, 5};
        int k = 5;
        assertEquals(3, solver.subarraySum(nums, k));
    }

    @Test
    public void testNoSubarray() {
        int[] nums = {1, 2, 3};
        int k = 7;
        assertEquals(0, solver.subarraySum(nums, k));
    }

    @Test
    public void testAllZerosKZero() {
        int[] nums = {0, 0, 0, 0};
        int k = 0;
        // Number of subarrays whose sum is zero: 10 (all subarrays)
        assertEquals(10, solver.subarraySum(nums, k));
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        int k = 0;
        assertEquals(0, solver.subarraySum(nums, k));
    }

    @Test
    public void testSingleElementEqualsK() {
        int[] nums = {5};
        int k = 5;
        assertEquals(1, solver.subarraySum(nums, k));
    }

    @Test
    public void testSingleElementNotEqualsK() {
        int[] nums = {1};
        int k = 5;
        assertEquals(0, solver.subarraySum(nums, k));
    }
}
