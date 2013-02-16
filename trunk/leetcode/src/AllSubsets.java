import java.util.ArrayList;
import java.util.Collections;


/**
 * Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
» Solve this problem
 * */
public class AllSubsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		list.add(new ArrayList<Integer>());
        int size = s.length;
        if(size == 0) {
        	return list;
        }
        //number of possible non-empty subsets
        int num = (int)Math.pow(2.0d, (double)size) - 1;
        
        for(int k = 1; k <= num; k++) {
        	//convert it into an arraylist
        	ArrayList<Integer> set  = new ArrayList<Integer>();
        	int value = k;
        	int index = 0;
        	int mod = value%2;
        	if(mod == 1) {
        		set.add(s[index]);
        	}
        	while(value/2 != 0) {
        		index++;
        		value = value/2;
        		mod = value%2;
        		if(mod == 1) {
            		set.add(s[index]);
            	}
        	}
        	
        	Collections.sort(set);
        	list.add(set);
        }
        
        return list;
    }
	
	public static void main(String[] args) {
		AllSubsets as = new AllSubsets();
		int[] set = new int[]{4, 1, 0};
		System.out.println(as.subsets(set));
	}
}
