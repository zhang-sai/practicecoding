
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * */
public class StockProfit3 {

	public int maxProfit(int[] prices) {
		if(prices.length < 2) {
			return 0;
		}
		//it can use a single int[prices.length] vector too
		
        // Start typing your Java solution below
        // DO NOT write main() function
		int[][] maxOne = new int[prices.length][prices.length];
		int[][] maxTwo = new int[prices.length][prices.length];
		int[][] maxProfits = new int[prices.length][prices.length]; //not length - 1
		for(int i = 0; i < prices.length - 1; i++) {
			maxProfits[i][i+1] = Math.max(0, prices[i+1] - prices[i]);
			maxOne[i][i+1] = maxProfits[i][i+1];
			maxTwo[i][i+1] = maxProfits[i][i+1];
		}
		for(int stepsize = 2; stepsize < prices.length/*not length - 1*/; stepsize++) {
		    for(int i = 0; i < prices.length; i++) {
			    for(int j = i + stepsize; j < prices.length; j = j + stepsize) {
			    	System.out.println("updating: " + i + ",  " + j);
			    	//max: price[j] - price[i]
			    	//     price[i] ~ price[k] (k = i ~j)
			    	
			    	//first update maxone / maxtwo matrix
			    	int maxOneValue = Math.max(0, prices[j] - prices[i]);
			    	for(int k = i; k < j; k++) {
			    		int tmp = maxOne[i][k];
			    		if(tmp > maxOneValue) {
			    			maxOneValue = tmp;
			    		}
			    		if(k < j - 1) {
			    			tmp = maxOne[k+1][k+2];
			    			if(tmp > maxOneValue) {
			    				maxOneValue = tmp;
			    			}
			    		}
			    	}
			    	maxOne[i][j] = maxOneValue;
			    	
			    	int maxTwoValue = Math.max(0, prices[j] - prices[i]);
			    	for(int k = i; k < j; k++) {
			    		int tmp = maxTwo[i][k];
			    		if(tmp > maxTwoValue) {
			    			maxTwoValue = tmp;
			    		}
			    		if(k < j - 1) {
			    			tmp = maxOne[i][k] + maxOne[k+1][j];
			    			if(tmp > maxTwoValue) {
				    			maxTwoValue = tmp;
				    		}
			    			tmp = maxTwo[k+1][j];
			    			if(tmp > maxTwoValue) {
				    			maxTwoValue = tmp;
				    		}
			    		}
			    	}
			    	maxTwo[i][j] = maxTwoValue;
			    	
			    	//update the profit
			    	int maxProfit = Math.max(0, prices[j] - prices[i]);
			    	for(int k = i; k < j; k++) { //XXX
			    		int tmp = maxTwo[i][k];//XXXpossible just use one chance /**note*/
			    		if(tmp > maxProfit) {
			    			maxProfit = tmp;
			    		} 
			    		if(k < j - 1) {
			    		    tmp = maxOne[i][k] + maxOne[k+1][j];
			    		    if(tmp > maxProfit) {
			    			    maxProfit = tmp;
			    		    }
			    		    tmp = maxTwo[k+1][j];//XXXpossible just use one chance /**note*/
			    		    if(tmp > maxProfit) {
			    			    maxProfit = tmp;
			    		    }
			    		}
			    	}
			    	maxProfits[i][j] = maxProfit; //Math.max(0, maxProfit); //XXX comapre with 0
			    	System.out.println("    " + maxProfits[i][j]);
			    }
		    }
		}
        return maxProfits[0][prices.length - 1];
    }
	
	public static void main(String[] args) {
		StockProfit3 p = new StockProfit3();
		int profit = p.maxProfit(new int[]{3,3,5,0,0,3,1,4});
		System.out.println(profit);
	}
}
