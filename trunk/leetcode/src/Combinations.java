
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

//more solution: http://tianrunhe.wordpress.com/2012/07/12/all-posssible-k-combinations-of-numbers-out-of-1-to-n-combinations/

/**
 * * combine_recursive is more elegant
 **/
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
	
	public void combine_iter(int n, int k) {
		//keep a list of index
		int[] num = new int[n];
		for(int i = 0; i < n; i++) {
			num[i] = i+1;
		}
		//establish index array
		int[] indices = new int[k];
		for(int i = 0; i < k; i++) {
			indices[i] = i; //point to the index of the num array
		}
		//return the next
		boolean hasNext = true;
		while(hasNext) {
			StringBuilder sb = new StringBuilder();
			for(int index : indices) {
				sb.append(num[index]);
				sb.append("  ");
			}
			System.out.println(sb);
			
			//start to move the index
			if(indices[0] == n - k ) {
				hasNext = false;
			} else {
				//move the each index to the new place
				int movableIndex = -1;
				for(int i = k - 1; i>= 0; i--) {
					if(indices[i] != (n-1) -(k-1 - i)) {
						movableIndex = i;
						break;
					}
				}
//				System.out.println("movable index: " + movableIndex);
				//move the index to the next
				indices[movableIndex] = indices[movableIndex] + 1;
				for(int i = movableIndex + 1; i <= k-1; i++) {
					indices[i] = indices[movableIndex] + (i - movableIndex);
				}
			}
		}
	}
	
	public ArrayList<ArrayList<Integer>> combine_recursive(int n, int k) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		int[] nums = new int[n];
		for(int i = 1; i <= n; i++) {
			nums[i-1] = i;
		}
		combine_internal(ret, nums, new boolean[nums.length], 0, 0, k);
		return ret;
	}
	
	public void combine_internal(ArrayList<ArrayList<Integer>> ret,
			int[] nums, boolean[] flags, int currIndex, int totalSelected, int k) {
		if(totalSelected == k) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < flags.length; i++) {
				if(flags[i]) {
					list.add(nums[i]);
				}
			}
			ret.add(list);
			return;
		}
		//a few ways
		//suppose we have 1, 2, 3, 4  current index = 1, length = 4
		int restNum = nums.length - currIndex;
		int neededNum = k - totalSelected;
		if(restNum > neededNum) {
			combine_internal(ret, nums, flags, currIndex + 1, totalSelected, k);
		}
		//select the current one
		flags[currIndex] = true;
		combine_internal(ret, nums, flags, currIndex + 1, totalSelected + 1, k);
		flags[currIndex] = false;
	}
	
	public static void main(String[] args) {
		Combinations comb = new Combinations();
		System.out.println(comb.combine(5, 3));
//		comb.combine_iter(5, 3);
		System.out.println(comb.combine_recursive(5, 3));
	}
}
