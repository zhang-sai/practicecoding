import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Permutations1and2 {

	/**
	 * Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 * */
//	XXX
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
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
			//
			ArrayList<ArrayList<Integer>> lists = this.permuteInternal(array);
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
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> head = new ArrayList<Integer>();
		Arrays.sort(num);
		
		//after sorting the array, the sorted one is the first permutated item
		for (int i = 0; i < num.length; i++)
			head.add(num[i]);
		al.add(head);

		//the total number of possible permutation number
		int factorial = 1;
		for (int i = 0; i < num.length; i++)
			factorial *= (i + 1);

		
		for (int t = 1; t < factorial; t++) {
			int first_non_decreasing_index = -1, swap_point = -1;

			// from the end, find first index that num[index]<num[index+1]
			for (int i = num.length - 1; i > 0; i--) {
				if (num[i - 1] < num[i]) {
					first_non_decreasing_index = i - 1;
					break;
				} else if (i == 1) {
					//at this point: num is sorted in a descreasing order
					return al;
				}
			}

			// finding the first numthat num[swap_point]>num[index]
			for (int i = num.length - 1; i > first_non_decreasing_index; i--) {
				if (num[first_non_decreasing_index] < num[i]) {
					swap_point = i;
					break;
				}
			}
			//swap num[index], num[swap_point]
			int tmp = num[first_non_decreasing_index];
			num[first_non_decreasing_index] = num[swap_point];
			num[swap_point] = tmp;

			// swap the index+1...end sequences
			for (int i = 0; i < (num.length - 1 - first_non_decreasing_index) / 2; i++) {
				tmp = num[first_non_decreasing_index + 1 + i];
				num[first_non_decreasing_index + 1 + i] = num[num.length - 1 - i];
				num[num.length - 1 - i] = tmp;
			}

			//create the next permutated list
			ArrayList<Integer> next = new ArrayList<Integer>();
			for (int i = 0; i < num.length; i++)
				next.add(num[i]);
			al.add(next);
		}
		return al;
	}

	
	public static void main(String[] args) {
		Permutations1and2 p = new Permutations1and2();
		System.out.println(p.permute(new int[]{1, 2, 3}));
	}
}
