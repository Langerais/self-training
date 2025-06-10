package remove_elements;

import java.util.Arrays;

public class RemoveElements {

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int num : nums) {
            if (num != val) {
                nums[k++] = num;
            }
        }
        return k;
    }

}
