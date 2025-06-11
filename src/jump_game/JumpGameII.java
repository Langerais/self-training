package jump_game;

import java.util.Arrays;

public class JumpGameII {


    public static void main(String[] args) {
        int[] n1 = {1,2,1,1,1};
        System.out.println(jump(n1));
    }

    public static int jump(int[] nums) {

        int n = nums.length-1;

        if (n < 2) return n;

        int[] dp = new int[n];

        for(int i = 1; i < n; i++){
            dp[i] = i;
        }

        for(int i = 0; i < dp.length; i++){

            for(int j = 1; j <= nums[i]; j++){

                if(i+j >= n) return dp[i] + 1;

                if(dp[i + j] > dp[i] + 1){
                    dp[i+j] = dp[i] + 1;
                }
            }

        }
        return dp[nums.length-1];
    }


}
