
//Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
//
//For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
//
//Follow-up: what if you can't use division?

import java.util.Arrays;

public class ProductOfArrayExcludingSelf {
    public static void main(String[] args) {

        int[] result1 = productOfArrayExcl(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(result1)); // [24, 12, 8, 6]

        int[] result2 = productOfArrayExcl(new int[]{1, 2, 0, 4});
        System.out.println(Arrays.toString(result2)); // [0, 0, 8, 0]

        int[] result3 = productOfArrayExcl(new int[]{0, 2, 0, 4});
        System.out.println(Arrays.toString(result3)); // [0, 0, 0, 0]

        int[] result4 = productOfArrayExcl(new int[]{1, 1, 1, 1});
        System.out.println(Arrays.toString(result4)); // [1, 1, 1, 1]

        int[] result5 = productOfArrayExcl(new int[]{5});
        System.out.println(Arrays.toString(result5)); // [1] For a single-element array, the product of all other elements is defined as 1 (empty product).

        int[] result6 = productOfArrayExcl(new int[]{3, 7});
        System.out.println(Arrays.toString(result6)); // [7, 3]

    }


    public static int[] productOfArrayExcl(int[] input) {
        int n = input.length;

        // prefix[i] will hold the product of all elements before index i
        int[] prefix = new int[n];
        // suffix[i] will hold the product of all elements after index i
        int[] suffix = new int[n];
        // output array to hold the final results
        int[] result = new int[n];

        // Initialize prefix for the first element as 1 because no elements before it
        prefix[0] = 1;
        // Calculate prefix products from left to right
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * input[i - 1];
        }

        // Initialize suffix for the last element as 1 because no elements after it
        suffix[n - 1] = 1;
        // Calculate suffix products from right to left
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * input[i + 1];
        }

        // Multiply prefix and suffix products for each element to get the result
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }



}