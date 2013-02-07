
/**
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * */
public class StockProfit1 {
	public int maxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        int buyDay = 0;
        int saleDay = 1;
        int maxProfit = prices[1] - prices[0];
        for(int i = saleDay + 1; i < prices.length; i++) {
        	int salePrice = prices[i];
        	//do not forget updating the max profit as follows
        	if(salePrice - prices[buyDay] > maxProfit) {
        		maxProfit = salePrice - prices[buyDay];
        	}
            for(int j = buyDay; j < i /*the previous sale day*/; j++) {
              if(prices[j] < prices[buyDay]) {
            	   buyDay = j; //reset the index, so no redundant work here
            	   if(salePrice - prices[j] > maxProfit) {
            		   maxProfit = salePrice - prices[j];
            	   }
              }
            }
        }
        return Math.max(0, maxProfit);
    }
	
	public static void main(String[] args) {
		StockProfit1 p = new StockProfit1();
		System.out.println(p.maxProfit(new int[]{1,2,4}));
	}
}
