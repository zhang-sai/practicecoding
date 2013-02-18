
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
		if(k == 0) {
			return currList;
		}
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		//recursive
		for(Integer i : numList) {
			numList.remove(i);
			
			if(currList.isEmpty()) {
				xx
				
			} else {
				
			}
			
		
			numList.add(i);
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		Combinations comb = new Combinations();
		System.out.println(comb.combine(4, 2));
	}
}
