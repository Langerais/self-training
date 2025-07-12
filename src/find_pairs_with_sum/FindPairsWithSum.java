package find_pairs_with_sum;

import java.util.HashMap;
import java.util.Map;

public class FindPairsWithSum {


    public static void main(String[] args) {
        FindSumPairs a = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});


        System.out.println(FindSumPairs.count(7));
    }

    static class FindSumPairs {

        public static HashMap<Integer, Integer> num1;
        public static HashMap<Integer, Integer> num2;
        public static HashMap<Integer, Integer> indexes;


        public FindSumPairs(int[] nums1, int[] nums2) {

            this.num1 = new HashMap<>();
            for (int j : nums1) num1.put(j, num1.getOrDefault(j, 0) + 1);

            indexes = new HashMap<>();
            this.num2 = new HashMap<>();
            for (int i = 0; i < nums2.length; i ++) {
                num2.put(nums2[i], num2.getOrDefault(nums2[i], 0) + 1);
                indexes.put(i, nums2[i]);
            }

        }

        public void add(int index, int val) {

            int numOld = indexes.get(index);
            int numNew = numOld + val;
            indexes.put(index, numNew);

            if(num2.getOrDefault(numOld, 0) <= 1) num2.remove(numOld);
            else num2.put(numOld, num2.getOrDefault(numOld, 0) - 1);

            num2.put(numNew, num2.getOrDefault(numNew, 0) + 1);

        }

        public static int count(int tot) {
            int count = 0;
            for(Map.Entry <Integer, Integer> entry : num1.entrySet()) count += entry.getValue() * num2.getOrDefault(tot - entry.getKey(), 0);
            return count;
        }
    }




}
