import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Permutations1and2 {

	/**
	 * 
	 * http://zhedahht.blog.163.com/blog/static/254111742007499363479/
	 * 
	 * Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 * */
//	XXX
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>>  ret = new ArrayList<ArrayList<Integer>> ();
		if(num.length == 0) {
			return ret;
		}
		return this.permuteInternal(num);
    }
	
	private ArrayList<ArrayList<Integer>> permuteInternal(int[] num) {
		ArrayList<ArrayList<Integer>>  ret = new ArrayList<ArrayList<Integer>> ();
		if(num.length == 1) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(num[0]);
			ret.add(list);
			return ret;
		}
		for(int i = 0; i < num.length; i++) {
			int[] array = new int[num.length - 1];
			int index = 0;
			for(int j = 0; j < num.length; j++) {
				if(j == i) {
					continue;
				}
				array[index++] = num[j];
			}
			//recursive call the
			ArrayList<ArrayList<Integer>> lists = this.permuteInternal(array);
			//add the current result
			for(ArrayList<Integer> list : lists) {
				list.add(0, num[i]);
				ret.add(list);
			}
		}
		
		return ret;
	}
	
	/**
	 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
	 * */
	//credit goes to: http://www.tsechung.com/wordpress/tag/permutation/
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
// 		ArrayList<Integer> head = new ArrayList<Integer>();
		Arrays.sort(num);
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		for(int i : num) {
		    list1.add(i);
		}
		al.add(list1);
		
		int[] prevNum = new int[num.length];
	    System.arraycopy(num, 0, prevNum, 0, num.length);
		
		while(true) {
		    num = nextPermutation(num);
		    if(equals(prevNum, num)) {
		        break;
		    } else {
		       ArrayList<Integer> list = new ArrayList<Integer>();
		       for(int i : num) {
		           list.add(i);
		       }
		       al.add(list);
		    }
		}
		
		return al;
		
    }
    
    public boolean equals(int[] a, int[] b) {
        for(int i = 0; i < a.length; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    
    public int[] nextPermutation(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (num.length == 1)
			return num;
		
		int leastIndexToBeChanged = -1, swapIndex = -1;
		for (int i = num.length - 1; i > 0; i--) {
		    //find the first index i, that num[i] < num[i+1]
			if (num[i - 1] < num[i]) {
				leastIndexToBeChanged = i - 1;
				break;
			}
		}
		
		if(leastIndexToBeChanged == -1) {
		    Arrays.sort(num);
		    return num;
		}

        //find the last index that is great than the leastIndexToBeChanged
		for (int i = num.length - 1; i > 0; i--) {
			if (num[i] > num[leastIndexToBeChanged]) {
				swapIndex = i;
				break;
			}
		}

		int tmp = num[swapIndex];
		num[swapIndex] = num[leastIndexToBeChanged];
		num[leastIndexToBeChanged] = tmp;

		//this step is critical
		//swap the location of the remaining array
		//e.g.,   1, 2, 3, 4
		// =>   1, 2, 4, 3
		// =>   1, 3, 4, 2    ==>  1, 3, 2, 4 (this step)
		// => 1, 3, 4, 2
		// => 1, 4, 3, 2   ==>  1, 4, 2, 3 (this step)
		// => 1, 4, 3, 2
		for (int i = 0; i < (num.length - 1 - leastIndexToBeChanged) / 2; i++) {
			tmp = num[leastIndexToBeChanged + 1 + i];
			num[leastIndexToBeChanged + 1 + i] = num[num.length - 1 - i];
			num[num.length - 1 - i] = tmp;
		}
		
		return num;
    }

	
	public static void main(String[] args) {
		Permutations1and2 p = new Permutations1and2();
//		System.out.println(p.permute(new int[]{1, 2, 3}));
		System.out.println(p.permuteUnique(new int[]{1, 1, 2, 3}));
	}
}
