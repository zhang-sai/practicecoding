import java.util.ArrayList;
import java.util.Arrays;


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
	XXX
	 public ArrayList<ArrayList<Integer>> combinationSum(int[] num, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        Arrays.sort(num);
	        
	        return null;
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
		 System.out.println(c.combinationSum2(new int[]{1}, 1));
	 }
	
}
