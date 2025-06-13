package leetcode_75.move_zeros;

public class MoveZeros {


    public void moveZeroes(int[] nums) {

        int zeros = 0;
        int write = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[write++] = nums[i];
            } else {
                zeros++;
            }
        }

        for(int i = nums.length - 1; i > nums.length - 1 - zeros; i--) nums[i] = 0;


    }




}
