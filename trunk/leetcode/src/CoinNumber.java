import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Given a number, use as few coins to 
 * */
public class CoinNumber {
	
	public static void main(String[] args) {
		CoinNumber cn = new CoinNumber();
		System.out.println((cn.getMinCoinNumber(10)));
		System.out.println((cn.getMinCoinNumber(11)));
		System.out.println((cn.getMinCoinNumber(12)));
		System.out.println((cn.getMinCoinNumber(13)));
		System.out.println((cn.getMinCoinNumber(14)));
		System.out.println((cn.getMinCoinNumber(15)));
		System.out.println((cn.getMinCoinNumber(20)));
	}

	//1, 2, 5
	public List<Integer> getMinCoinNumber(int num) {
		//use dynamic programming
		Map<Integer, List<Integer>> coins = new HashMap<Integer, List<Integer>>();
		
		coins.put(0, new ArrayList<Integer>());
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		coins.put(1, l1);
		
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(2);
		coins.put(2, l2);
		
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		l3.add(1); l3.add(2);
		coins.put(3, l3);
		
		ArrayList<Integer> l4 = new ArrayList<Integer>();
		l4.add(2); l4.add(2);
		coins.put(4, l4);
		
		ArrayList<Integer> l5 = new ArrayList<Integer>();
		l5.add(5);
		coins.put(5, l5);
		
		if(coins.containsKey(num)) {
			return coins.get(num);
		}
		
		for(int i = 6; i <=num; i++) {
			//three possibility
			int size1 = coins.get(i - 1).size();
			int size2 = coins.get(i - 2).size();
			int size5 = coins.get(i - 5).size();
			
			int min = Math.min(Math.min(size1, size2), size5);
			
			if(min == size1) {
				List<Integer> l = new ArrayList<Integer>();
				l.addAll(coins.get(i-1));
				l.add(1);
				coins.put(i, l);
			} else if (min == size2) {
				List<Integer> l = new ArrayList<Integer>();
				l.addAll(coins.get(i-2));
				l.add(2);
				coins.put(i, l);
			} else {
				List<Integer> l = new ArrayList<Integer>();
				l.addAll(coins.get(i-5));
				l.add(5);
				coins.put(i, l);
			}
		}
		return coins.get(num);
	}
	
}

