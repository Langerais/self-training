package remove_elements;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedII {


    public static void main(String[] args) {

        int[] arr = {1,1,1,2,2,3};

        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }



    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }




}
