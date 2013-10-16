
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete
as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * */
public class StockProfit2 {
	//key insights: given an increasing order, 6, 1, 2, 3, 4, 2
    //buy 1, sell at 4
    //is equals to: buy 1, sell 2 buy, sell 3 and buy, and sell (though this is not permitted)
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(prices.length < 2) {
			return 0;
		}
		int max = 0;
		for(int i = 0; i < prices.length - 1; i++) {
		    int delta = prices[i+1] - prices[i];
		    if(delta > 0) {
		        max += delta;
		    }
		}
		
		return max;
		
    }
	
	public static void main(String[] args) {
		StockProfit2 p = new StockProfit2();
		int profit = p.maxProfit(new int[]{1, 2, 4});
		System.out.println(profit);
	}
}
