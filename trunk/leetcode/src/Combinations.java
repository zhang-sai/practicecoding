
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
		
        return this.combine(l, k);
    }
	
	private ArrayList<ArrayList<Integer>> combine(ArrayList<Integer> numList, int k) {
		//System.out.println(numList  + ",  k: " + k);
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if(k == 1) {
			for(Integer v : numList) {
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(v);
				list.add(l);
			}
			return list;
		}
		
		
		//recursive
		for(int index = 0; index < numList.size(); index++) { //XXX note only return the larger index!
			ArrayList<Integer> cloneList = new ArrayList<Integer>();
			for(int i = index + 1; i < numList.size(); i++) {
				cloneList.add(numList.get(i));
			}
			
			ArrayList<ArrayList<Integer>>  reList = this.combine(cloneList, k-1);
			for(ArrayList<Integer> l : reList) {
				ArrayList<Integer> nl = new ArrayList<Integer>();
				nl.add(numList.get(index));
				nl.addAll(l);
				Collections.sort(nl);
				list.add(nl);
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		Combinations comb = new Combinations();
		System.out.println(comb.combine(4, 2));
	}
}
