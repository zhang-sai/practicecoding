import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class CombinationsSum1And2 {

	/**
	 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
	 * */
	
	//pass both tests
	//other ppl's answer: https://gist.github.com/eclipse9614/4983552
	//this version is not good, it uses set, the second implementation is better!
	 public ArrayList<ArrayList<Integer>> combinationSum(int[] num, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        Arrays.sort(num);
	        
	        if(target < num[0]) {
	        	return new ArrayList<ArrayList<Integer>>();
	        }
	        
	        Set<ArrayList<Integer>> all = new HashSet<ArrayList<Integer>>();
	        
	        for(int n : num) {
//	        	System.out.println("n: " + n + ", target: " + target);
	        	if (n == target) {
	        		ArrayList<Integer> l = new ArrayList<Integer>();
	        		l.add(n);
	        		all.add(l);
	        	} else if(n < target) {
	        	    ArrayList<ArrayList<Integer>> remainList = combinationSum(num, target - n);
//	        	    if(remainList.isEmpty()) {
//	        	    	continue;
//	        	    }
	        	    for(ArrayList<Integer> l : remainList) {
	        	    	ArrayList<Integer> exl = new ArrayList<Integer>(l);
	        	    	exl.add(n);
	        	    	Collections.sort(exl);
	        	    	all.add(exl);
	        	    }
	        	} else {
//	        		System.out.println("set: " + all);
	        		return new ArrayList<ArrayList<Integer>>(all);
	        	}
	        }
//	        System.out.println("set: " + all);
	        return new ArrayList<ArrayList<Integer>>(all);
	    }
	 
	 //====================another version of combination sum of duplications=======
	 //this version seems better
	 public ArrayList<ArrayList<Integer>> combinationSum_(int[] num, int target) {
		 Arrays.sort(num);
		 ArrayList<Integer> currResult = new ArrayList<Integer>();
		 ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		 this.solve(num, target, results, 0, currResult);
		 return results;
	 }
	 
	 public void solve(int[] num, int target, ArrayList<ArrayList<Integer>> results, int curr, ArrayList<Integer> currResult) {
		 if(target < 0) {
			 return;
		 } else if (target == 0) {
			 ArrayList<Integer> result = new ArrayList<Integer>(currResult);
			 results.add(result);
			 return;
		 }
		 
		 for(int i = curr; i < num.length; i++) {
			 currResult.add(num[i]);
			 this.solve(num, target - num[i], results, i, /**XXX THe most important part, use i*/ currResult); //you can never track back
			 //such as 2, 3, 5, 7 ==> 7
			 //you would only produce: 2, 2, 3 once
			 currResult.remove(currResult.size() - 1);
		 }
	 }
	 //=============================================================================
	 
	 /**
	  * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
	  * */
	//a sample solution:
	//http://tianrunhe.wordpress.com/2012/07/12/finding-all-combinations-of-numbers-sum-up-to-a-number-combination-sum-ii/
	 public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 Arrays.sort(num);
	
		 ArrayList<Integer> numList = new ArrayList<Integer>();
		 for(int i : num) {
			 if(i > target) {
				 continue;
			 }
			 numList.add(i);
		 }
		 
		 return this.findCombinations(numList, 0, target);
	 }
	 
	 private ArrayList<ArrayList<Integer>> findCombinations(ArrayList<Integer> numList, int startIndex, int target) {
		 System.out.println(numList + ",  " + startIndex + ",  " + target);
		 ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		 if(numList.isEmpty()) {
			 return ret; //XXX do not forget this condition 
		 }
		 if(target < numList.get(startIndex)) {
			 return ret;
		 }
		 
		 
		 if(startIndex == numList.size() - 1) {
			 if(numList.get(startIndex) == target) {
				 ArrayList<Integer> l = new ArrayList<Integer>();
				 l.add(target);
				 ret.add(l); //XXX donot forget this
				 return ret;
			 } else {
				 return ret;//empty
			 }
		 }
		 
		 //two possibilititis
		 ArrayList<ArrayList<Integer>> remainList1 = this.findCombinations(numList, startIndex + 1, target - numList.get(startIndex));
		 for(ArrayList<Integer> l : remainList1) {
			 l.add(0, numList.get(startIndex));
			 ret.add(l);
		 }
		 
		 ArrayList<ArrayList<Integer>> remainList2 = this.findCombinations(numList, startIndex + 1, target);
		 ret.addAll(remainList2);
		 
		 return ret;
		 
	 }
	 
	 public static void main(String[] args) {
		 CombinationsSum1And2 c = new CombinationsSum1And2();
//		 System.out.println(c.combinationSum2(new int[]{1}, 1));
		 System.out.println(c.combinationSum(new int[]{2, 3, 6, 7}, 7));
	 }
	
}
