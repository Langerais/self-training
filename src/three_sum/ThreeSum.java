import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        // Test case 1: example with multiple triplets
        int[] test1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test 1: " + threeSum(test1));
        // Expected: [[-1, -1, 2], [-1, 0, 1]]

        // Test case 2: no triplets sum to zero
        int[] test2 = {1, 2, 3, 4};
        System.out.println("Test 2: " + threeSum(test2));
        // Expected: []

        // Test case 3: array with zeros only
        int[] test3 = {0, 0, 0, 0};
        System.out.println("Test 3: " + threeSum(test3));
        // Expected: [[0, 0, 0]]

        // Test case 4: empty array
        int[] test4 = {};
        System.out.println("Test 4: " + threeSum(test4));
        // Expected: []

        // Test case 5: array with two elements only
        int[] test5 = {0, 1};
        System.out.println("Test 5: " + threeSum(test5));
        // Expected: []

        // Test case 6: large negative and positive values with duplicates
        int[] test6 = {-2, 0, 0, 2, 2};
        System.out.println("Test 6: " + threeSum(test6));
        // Expected: [[-2, 0, 2]]

        // Test case 7: all negative numbers
        int[] test7 = {-3, -2, -1};
        System.out.println("Test 7: " + threeSum(test7));
        // Expected: []

        // Test case 8: all positive numbers
        int[] test8 = {1, 2, 3};
        System.out.println("Test 8: " + threeSum(test8));
        // Expected: []


    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }



}
