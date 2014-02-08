import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class CombinationsSum1And2 {
	
	//look at the similar problem: PossibleCoinCombinations

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
        	if (n == target) {
        		ArrayList<Integer> l = new ArrayList<Integer>();
        		l.add(n);
        		all.add(l);
        	} else if(n < target) {
        	    //when doing the recursion, keep the num set the same
        	    ArrayList<ArrayList<Integer>> remainList = combinationSum(num, target - n);
        	    for(ArrayList<Integer> l : remainList) {
        	    	ArrayList<Integer> exl = new ArrayList<Integer>(l);
        	    	exl.add(n);
        	    	Collections.sort(exl);
        	    	all.add(exl);
        	    }
        	} else {
                    break; //do nothing, stop traversing
        	}
        }
        return new ArrayList<ArrayList<Integer>>(all);
    }
	 
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
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // Start typing your Java solution below
	        // DO NOT write main() function
	        Arrays.sort(num);
	        
	        if(target < num[0]) {
	        	return new ArrayList<ArrayList<Integer>>();
	        }
	        
	        int sum = 0;
	        for(int v : num) {
	            sum = sum + v;
	        }
	        if(sum < target) {
	            return new ArrayList<ArrayList<Integer>>();
	        }
	        
	        Set<ArrayList<Integer>> all = new HashSet<ArrayList<Integer>>();
	        
	        for(int i = 0; i < num.length; i++) {
	            int n = num[i];
	        	if (n == target) {
	        		ArrayList<Integer> l = new ArrayList<Integer>();
	        		l.add(n);
	        		all.add(l);
	        	} else if(n < target) {
	        	    //when doing the recursion, keep the num set the same
	        	    int[] restNum = new int[num.length - 1];
	        	    int index = 0;
	        	    for(int j = 0; j < num.length; j++ ) {
	        	        if(j != i) {
	        	            restNum[index++] = num[j];
	        	        }
	        	    }
	        	    ArrayList<ArrayList<Integer>> remainList = combinationSum2(restNum, target - n);
	        	    for(ArrayList<Integer> l : remainList) {
	        	    	ArrayList<Integer> exl = new ArrayList<Integer>(l);
	        	    	exl.add(n);
	        	    	Collections.sort(exl);
	        	    	all.add(exl);
	        	    }
	        	} else {
	                    break; //do nothing, stop traversing
	        	}
	        }
	        return new ArrayList<ArrayList<Integer>>(all);
	    }
	 
	 public static void main(String[] args) {
		 CombinationsSum1And2 c = new CombinationsSum1And2();
//		 System.out.println(c.combinationSum2(new int[]{1}, 1));
		 System.out.println(c.combinationSum(new int[]{2, 3, 6, 7}, 7));
	 }
	
}
