
/**
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * */
//see: http://zhedahht.blog.163.com/blog/static/2541117420116135376632/
public class StockProfit1 {
	public int maxProfit(int[] a) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(a.length < 2) {
            return 0;
        }
        
        int max = 0;
        int lowest = a[0];
        for(int i = 0; i < a.length; i++) {
            if(a[i] - lowest > max) {
                max = a[i] - lowest;
            }
            if(a[i] < lowest) {
                lowest = a[i];
            }
        }
        return max;
	}
	
	public static void main(String[] args) {
		StockProfit1 p = new StockProfit1();
		System.out.println(p.maxProfit(new int[]{1,2,4}));
	}
}
