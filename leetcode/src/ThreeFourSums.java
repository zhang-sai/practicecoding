import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


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
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3) {
            return result;
        }
        Arrays.sort(num);
        
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i <= num.length-3; i++) {
            if(num[i] > 0) {
                break;
            }
            int j = i + 1;
            int k = num.length - 1;
            while(j < k) {
                if(num[i] + num[j] > 0) {
                    break;
                }
                if(num[i] + num[j] + num[k] == 0) {
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    l.add(num[i]);
                    l.add(num[j]);
                    l.add(num[k]);
                    set.add(l);
                    k--;
                    j++;
                } else if(num[i] + num[j] + num[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        
        result.addAll(set);
        
        return result;
        
    }
	
	
	
	/**
	 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 * */
	public int threeSumClosest(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Arrays.sort(num);
        if(num.length < 3) {
        	throw new Error(); 
        }
        int retNum = 0;
        int closest = Integer.MAX_VALUE;
        for(int i = 0; i < num.length; i++) {
        	int j = i + 1;
        	int k = num.length - 1;
        	while(j < k) {
        		int sum = num[i] + num[j] + num[k];
        		int delta = Math.abs(sum - target);
        		if(delta < closest) {
        			retNum = sum;
        			closest = delta;
        		}
        		//use some aggressive filtering
        		if(sum > target) {
        			k--;
        		} else if (sum < target) {
        			j++;
        		} else {
        			return target;
        		}
        	}
        }
        
        return retNum;
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
	//XXX the following pass the small tests, but exceed time limit of the large tests
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
		if(num.length < 4) {
			return retList;
		}
		
		Arrays.sort(num);
		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		
		
		for(int i = 0; i <= num.length - 4; i++) {
			//XXX  be aware of -5, -3, -1, -1  target is 11
			if(num[i] > 0 && num[i] > target) {
				break;
			}
			for(int j = i + 1; j <= num.length - 3; j++) {
				if(num[j] > 0 && num[i] + num[j] > target) {
					break;
				}
				
				int k = j + 1;
				if(num[k] > 0 && num[i] + num[j] + num[k] > target ) {
					break;
				}
				int l = num.length - 1;
				while(k < l) {
					int sum = num[i] + num[j] + num[k] + num[l];
					if(sum < target) {
						k ++;
					} else if (sum > target) {
						l --;
					} else {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(num[i]);
						list.add(num[j]);
						list.add(num[k]);
						list.add(num[l]);
						set.add(list);
						k++;
						l--;
					}
				}
			}
		}
		
		
		retList.addAll(set);
		
		return retList;
    }
	
	public static void main(String[] args) {
		ThreeFourSums tfsums = new ThreeFourSums();
		System.out.println(tfsums.fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));
	}
}
