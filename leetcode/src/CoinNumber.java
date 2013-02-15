import java.util.HashMap;
import java.util.Map;


/**
 * Given a number, use as few coins to 
 * */
public class CoinNumber {

	//1, 2, 5
	public Integer[] getMinCoinNumber(int num) {
		//use dynamic programming
		Map<Integer, Integer[]> coins = new HashMap<Integer, Integer[]>();
		
		coins.put(0, new Integer[]{});
		coins.put(1, new Integer[]{1});
		coins.put(2, new Integer[]{2});
		coins.put(3, new Integer[]{1, 2});
		coins.put(4, new Integer[]{2, 2});
		coins.put(5, new Integer[]{1});
		
		if(coins.containsKey(num)) {
			return coins.get(num);
		}
		
		for(int i = 6; i <=num; i++) {
			//three possibility
			int newCoin = -1;
			int size1 = coins.get(i - 1).length;
			int size2 = coins.get(i - 2).length;
			int size5 = coins.get(i - 5).length;
			
			int min = Math.min(Math.min(size1, size2), size5);
			
			if(min == size1) {
				Integer[] newInts = new Integer[coins.get(i-1).length + 1];
				for(int j = 1; j < coins.get(i-1).length; j++) {
					newInts[j] = coins.get(i-1)[j];
				}
			} else if (min == size2) {
				Integer[] newInts = new Integer[coins.get(i-2).length + 1];
				xx
			} else {
				Integer[] newInts = new Integer[coins.get(i-5).length + 1];
				xx
			}
		}
		
	}
	
}

