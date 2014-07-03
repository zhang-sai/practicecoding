
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * */
public class StockProfit3 {
 
	
	public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(prices.length < 2) {
			return 0;
		}
		
        //stores the max profit in [0, ... , i] subarray in prices
        int[] maxEndWith = new int[prices.length];
        int lowest = prices[0];
        int maxprofit = 0;
        maxEndWith[0] = maxprofit;
        for(int i = 1; i < prices.length; ++i) {
            int profit = prices[i] - lowest;
            if(profit > maxprofit) {
                maxprofit = profit;
            }
            maxEndWith[i] = maxprofit;
            if(prices[i] < lowest) {
                lowest = prices[i];
            }
        }
        
        int ret = maxEndWith[prices.length - 1];
        //reverse to see what is the maxprofit_end of [i, ... , n-1] subarray in prices
         //and meanwhile calculate the final result
        int highest = prices[prices.length - 1];
        int maxprofit_end = 0;
        for(int i = prices.length - 2; i >= 0; --i) {
            int profit = highest - prices[i];
            if(profit > maxprofit_end) {
                maxprofit_end = profit;
            }
            int finalprofit = maxprofit_end + maxEndWith[i];
            if(finalprofit > ret) {
                ret = finalprofit;
            }
            if(prices[i] > highest) {
                highest = prices[i];
            }
        }

        return ret;
		
    }
	
	public static void main(String[] args) {
		StockProfit3 p = new StockProfit3();
		int profit = p.maxProfit(new int[]{3,3,5,0,0,3,1,4});
		System.out.println(profit);
	}
}
