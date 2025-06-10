package remove_elements;

import java.util.Arrays;

public class RemoveDuplicatesFromSorted {


    public static int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;

        int k = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] != nums[i]){
                nums[k++] = nums[i];
            }
        }
        return k;
    }



}
