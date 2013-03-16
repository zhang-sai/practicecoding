import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 * */
//explanation: http://smartlhc.blogspot.com/2012/08/find-kth-permutation-sequence.html
public class PermutationSequence {
	public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		Map<Integer, Integer> permValues = new HashMap<Integer, Integer>();
		permValues.put(0, 1);
		int value = 1;
		for(int i = 1; i <=n; i++) {
			value = value*i;
			permValues.put(i, value);
		}
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for(int i = 1; i <=n; i++) {
			ints.add(i);
		}
		//judge the k
		StringBuilder sb = new StringBuilder();
		k --; //XXX must deduct k since use 0 as the first index
		for(int iter = n; iter >=1; iter--) {
			int index = k / permValues.get(iter - 1);
			k = k % permValues.get(iter - 1); //XXX do not forget this
			sb.append(ints.get(index));
			
			ints.remove(index);
			//System.out.println(ints);
		}
		
        return sb.toString();
        
    }
	
	public static void main(String[] args) {
		PermutationSequence ps = new PermutationSequence();
		System.out.println(ps.getPermutation(3, 3));
	}
}
