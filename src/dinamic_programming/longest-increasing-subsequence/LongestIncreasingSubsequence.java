import java.util.ArrayList;

public class LongestIncreasingSubsequence {


    public static int getLIS(int[] nums) {
        if (nums.length == 0) return 0;

        ArrayList<Integer> tails = new ArrayList<>();

        for (int num : nums) {
            int left = 0, right = tails.size();


            // Binary search for the position to insert num
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // If left == tails.size(), append num; else replace
            if (left == tails.size()) {
                tails.add(num);
            } else {
                tails.set(left, num);
            }
        }

        return tails.size();
    }

}
