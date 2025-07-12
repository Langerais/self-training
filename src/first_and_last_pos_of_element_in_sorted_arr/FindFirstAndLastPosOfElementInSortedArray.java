package first_and_last_pos_of_element_in_sorted_arr;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Medium
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * Constraints:
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */

public class FindFirstAndLastPosOfElementInSortedArray {


    public int[] searchRange(int[] nums, int target) {


        if(nums.length == 1) {
            if(nums[0] != target) return new int[]{-1,-1};
            return new int[]{0, 0};
        }

        int left = 0, right = nums.length-1, mid = left + (right - left) / 2;
        int[] out = {-1,-1};

        while (left < right){

            mid = left + (right - left) / 2;
            if(nums[mid] < target) left = mid + 1;
            else right = mid;


            if(nums[left] == target){

                right = left;

                while (left >= 0 && nums[left] == target){
                    out[0] = left;
                    left--;
                }

                while (right < nums.length && nums[right] == target){
                    out[1] = right;
                    right++;
                }

                return out;
            }

        }

        return out;
    }





}
