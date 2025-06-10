package majority_element;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0, candidate = nums[0], i = 0;
        while (i < nums.length) {
            if (count == 0) candidate = nums[i];
            if(candidate == nums[i]) count++;
            else count--;
            i++;
        }
        return candidate;
    }

}
