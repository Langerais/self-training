package best_time_to_bns_stock_II;

public class BestTimeToBNSStockII {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

        int[] prices2 = {1,2,3,4,5};
        System.out.println(maxProfit(prices2));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) maxProfit = Math.max(maxProfit, maxProfit + (prices[i] - prices[i-1]));
        return maxProfit;
    }




}
