import java.util.ArrayList;

public class Permutations1and2 {

	/**
	 * Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 * */
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
	
	public static void main(String[] args) {
		Permutations1and2 p = new Permutations1and2();
		System.out.println(p.permute(new int[]{1, 2, 3}));
	}
	
	/**
	 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
	 * */
	
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return null;
    }
}
