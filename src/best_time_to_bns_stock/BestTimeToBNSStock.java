package best_time_to_bns_stock;

public class BestTimeToBNSStock {


    public int maxProfit(int[] prices) {

        int minSoFar = prices[0];
        int maxSoFar = 0;

        for(int i = 1; i < prices.length; i++){
            maxSoFar = Math.max(maxSoFar, prices[i] - minSoFar);
            minSoFar = Math.min(minSoFar, prices[i]);
        }
        return maxSoFar;
    }


}
