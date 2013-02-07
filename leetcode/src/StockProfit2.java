
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete
as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * */
public class StockProfit2 {
	//use array a[i][j] to denote the max profit of
	//buying stock at day i, and selling it at day j, where i < j
	//
	// a[i][j+1] = max{
	//                 a[i][j]
	//                 a[i][j] + (prices[j+1] - prices[j]),
	//                 (prices[i+1] - prices[i]) + a[i+1]a[j+1]
	//                 a[i+1]a[j+1]
	//                 }
	//
	//a[i][i+1]  = max(0, a[i+1] - a[i])
	//
	//return a[0]a[prices.length - 1]
	public int maxProfit(int[] prices) {
		if(prices.length < 2) {
			return 0;
		}
		//it can use a single int[prices.length] vector too
		
        // Start typing your Java solution below
        // DO NOT write main() function
		int[][] maxProfits = new int[prices.length][prices.length]; //not length - 1
		for(int i = 0; i < prices.length - 1; i++) {
			maxProfits[i][i+1] = Math.max(0, prices[i+1] - prices[i]);
		}
		for(int stepsize = 2; stepsize < prices.length/*not length - 1*/; stepsize++) {
		    for(int i = 0; i < prices.length; i++) {
			    for(int j = i + stepsize; j < prices.length; j = j + stepsize) {
//			    	System.out.println("updating: " + i + ",  " + j);
			    	maxProfits[i][j] = 
			    		Math.max(Math.max(maxProfits[i][j-1], maxProfits[i+1][j]),
			    				Math.max(maxProfits[i][j-1] + (prices[j] - prices[j-1]),
			    						maxProfits[i+1][j] + (prices[i+1] - prices[i])));
//			    	System.out.println("    " + maxProfits[i][j]);
			    }
		    }
		}
        return maxProfits[0][prices.length - 1];
    }
	
	public static void main(String[] args) {
		StockProfit2 p = new StockProfit2();
		int profit = p.maxProfit(new int[]{1, 2, 4});
		System.out.println(profit);
	}
}
