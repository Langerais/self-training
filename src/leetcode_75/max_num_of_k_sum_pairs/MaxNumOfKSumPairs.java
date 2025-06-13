package leetcode_75.max_num_of_k_sum_pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * 1679. Max Number of K-Sum Pairs
 * Medium

 * You are given an integer array nums and an integer k.
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * Return the maximum number of operations you can perform on the array.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 * Example 2:
 *
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 */

public class MaxNumOfKSumPairs {


    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int operations = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                operations++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return operations;
    }

    public int maxOperationsMap(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int operations = 0;

        for (int num : freq.keySet()) {
            int complement = k - num;

            if (!freq.containsKey(complement)) continue;

            if (num == complement) {
                // Special case: pair within itself
                operations += freq.get(num) / 2;
            } else if (num < complement) {
                // Avoid double-counting
                operations += Math.min(freq.get(num), freq.get(complement));
            }
        }

        return operations;
    }

}
