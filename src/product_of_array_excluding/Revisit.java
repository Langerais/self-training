package product_of_array_excluding;

import java.util.ArrayList;
import java.util.Arrays;

public class Revisit {


    public static void main(String[] args) {



        int[] arr1 = {1,2,3,4};

        System.out.println(Arrays.toString(productExceptSelf(arr1)));
    }


    public static int[] productExceptSelf(int[] nums) {

        int prefProd = 1;
        int postProd = 1;

        int second = nums[1];
        int secondLast = nums[nums.length-2];

        int left = 0;
        int right = nums.length - 1;

        int pred = nums[0], next = nums[nums.length - 1];


        while (left < nums.length - 2){

            prefProd *= pred;
            postProd *= next;

            int temp = left;



            right--;
            left++;
        }

       // nums[0] = nums[1] * second;
        //nums[nums.length-1] = nums[nums.length-2] * secondLast;

        return nums;

    }





}
