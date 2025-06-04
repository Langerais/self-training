import java.util.HashMap;

public class EditDistance {

    public static int editDistance(String s1, String s2){

        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i <= s1.length(); i++) dp[i][0] = i;
        for(int i = 0; i <= s2.length(); i++) dp[0][i] = i;

        for (int i = 1; i < dp.length; i++){

            char c1 = s1.charAt(i-1);

            for(int j = 1; j < dp[0].length; j++){
                char c2 = s2.charAt(j-1);
                if(c1==c2) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],  // replace
                            Math.min(dp[i - 1][j],    // delete
                                    dp[i][j - 1]));  // insert
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }






}
