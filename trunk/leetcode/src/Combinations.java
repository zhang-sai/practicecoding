
/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * */
xx
import java.util.ArrayList;
import java.util.Collections;

public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if(n <= 0) {
			return ret;
		}
		if(n < k) {
			return ret;
		}
		
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			l.add(i+1);
		}
		
        return this.combine(l, new ArrayList<ArrayList<Integer>>(), k);
    }
	
	private ArrayList<ArrayList<Integer>> combine(ArrayList<Integer> numList, ArrayList<ArrayList<Integer>> currList, int k) {
		System.out.println(numList);
		System.out.println("  " + currList);
		System.out.println("  " + k);
		if(k <= 0) {
			return currList;
		}
		if(numList.isEmpty()) {
			return currList;
		}
		
		
		ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
		
        if(k == 1) { //XXX never forget the recursion ends
		    for(int num : numList) {
		    	ArrayList<Integer> l = new ArrayList<Integer>();
		    	l.add(num);
		    	retList.add(l);
		    }
		    System.out.println("  xx" + retList);
		    return retList;
		}
		
		for(int i = 0; i < numList.size(); i++) {
			Integer n = numList.get(i);
			//make a deep copy
			ArrayList<Integer> remainingList = new ArrayList<Integer>();
			remainingList.addAll(numList);
			remainingList.remove(i);
			//update the currList
			ArrayList<ArrayList<Integer>> updatedLists = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> l : currList) {
				ArrayList<Integer> updateList = new ArrayList<Integer>();
				updateList.addAll(l);
				updateList.add(n);
				//
				updatedLists.add(updateList);
			}
			//do recursion
			System.out.println("  zz" + updatedLists);
			ArrayList<ArrayList<Integer>> list = this.combine(remainingList, updatedLists, k - 1);
			retList.addAll(list);
			System.out.println("  yy" + retList);
		}
		
		return retList;
	}
	
	public static void main(String[] args) {
		Combinations comb = new Combinations();
		System.out.println(comb.combine(4, 2));
	}
}
