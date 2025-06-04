import java.util.Arrays;

public class MinimumNumberOfCoins {

    public static int getMinimumNumberOfCoins(int[] coins, int target){

        //Assuming that coins are sorted

        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) dp[i] = target+1;


        for(int coin : coins){
            for (int j = coin; j <= target; j++){
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        return dp[dp.length-1] <= target ? dp[dp.length-1] : -1;

    }

}
