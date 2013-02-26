import java.util.ArrayList;
import java.util.Collections;


public class ThreeFourSums {

	/**
	 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
	 * */
	//XXX time limit exceeds
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<Integer> validIndices = new ArrayList<Integer>();
		for(Integer i = 0; i < num.length; i++) {
			validIndices.add(i);
		}
		ArrayList<ArrayList<Integer>> results = this.sum(3, num, validIndices, 0);
//		for(ArrayList<Integer> r : results) {
//			Collections.sort(r);
//		}
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> r : results) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			for(Integer i : r) {
				al.add(num[i]);
			}
			Collections.sort(al);
			if(!ret.contains(al)) {
				ret.add(al);
			}
		}
		return ret;
    }
	
	
	ArrayList<ArrayList<Integer>> sum(int num, int[] values, ArrayList<Integer> validIndices, int target) {
		ArrayList<ArrayList<Integer>> indices = new ArrayList<ArrayList<Integer>>();
		if(num > validIndices.size()) {
			return indices;
		}
		if(num == 1) {
			for(int index : validIndices) {
				if(values[index] == target) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(index);
					indices.add(list);
				}
			}
			return indices;
		}
		
		ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
		for(Integer index : validIndices) {
			int value = values[index];
			
			ArrayList<Integer> newValidIndices = (ArrayList<Integer>)validIndices.clone();
			newValidIndices.remove(index);
			
			ArrayList<ArrayList<Integer>> lst = this.sum(num - 1, values, newValidIndices, target - value);
			
			
			if(!lst.isEmpty()) {
				for(ArrayList<Integer> l : lst) {
				    ArrayList<Integer> aList = new ArrayList<Integer>();
				    aList.add(index);
				    aList.addAll(l);
				    retList.add(aList);
				}
				
			}
		}
		
		return retList;
	}
	
	/**
	 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 * */
	public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    }
	
	/**
	 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
	 * */
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    }
}
