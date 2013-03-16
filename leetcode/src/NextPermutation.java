import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographical
 * next greater permutation of numbers. If such arrangement is not possible, it
 * must rearrange it as the lowest possible order (i.e., sorted in ascending
 * order). The replacement must be in-place, do not allocate extra memory.
 * Example: 1,2,3 -> 1,3,2 3,2,1 -> 1,2,3 1,1,5 -> 1,5,1
 * */
public class NextPermutation {

	// a good explaination is in:
	// http://www.tsechung.com/wordpress/tag/permutation/

//	public static void main(String[] args) {
//		NextPermutation np = new NextPermutation();
//		Integer[] num = new Integer[] {1, 1, 2};
//		int count = 0;
//		System.out.println(Arrays.asList(num));
//		count++;
//		Integer[] nextNum = np.nextPermutation(num);
//		while(nextNum != null) {
//			System.out.println(Arrays.asList(num));
//			nextNum = np.nextPermutation(num);
//			count++;
//		}
//		System.out.println("total : " + count);
//		np.nextPermutation(num);
//		System.out.println(Arrays.asList(num));
//		np.nextPermutation(num);
//		System.out.println(Arrays.asList(num));
//		np.nextPermutation(num);
//		System.out.println(Arrays.asList(num));
//		np.nextPermutation(num);
//		System.out.println(Arrays.asList(num));
//		np.nextPermutation(num);
//		System.out.println(Arrays.asList(num));
//		np.nextPermutation(num);
//		System.out.println(Arrays.asList(num));
//		np.nextPermutation(num);
//		System.out.println(Arrays.asList(num));
//		np.nextPermutation(num);
//		System.out.println(Arrays.asList(num));
//		np.nextPermutation(num);
//		System.out.println(Arrays.asList(num));
//		np.nextPermutation(num);
//		System.out.println(Arrays.asList(num));
//		np.nextPermutation(num);
//		System.out.println(Arrays.asList(num));
//		np.nextPermutation(num);
//		System.out.println(Arrays.asList(num));
//		np.nextPermutation(num);
//		System.out.println(Arrays.asList(num));
//		np.nextPermutation(num);
//		System.out.println(Arrays.asList(num));
//	}
	
	ArrayList<Integer> toList(int[] num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : num) {
			list.add(i);
		}
		return list;
	}
	
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		NextPermutation np = new NextPermutation();
		
		ret.add(toList(num));
		int[] nextNum = np.nextPermutation(num);
		while(nextNum != null) {
			ret.add(toList(nextNum));
			nextNum = np.nextPermutation(nextNum);
		}
		return ret;
	}
	
	public int[] nextPermutation(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num.length == 1)
			return null;
		
		int leastIndexToBeChanged = -1, swapIndex = -1;
		for (int i = num.length - 1; i > 0; i--) {
			if (num[i - 1] < num[i]) {
				leastIndexToBeChanged = i - 1;
				break;
			} else if (i == 1) {
				Arrays.sort(num);
				return null;
			}
		}

		for (int i = num.length - 1; i > 0; i--) {
			if (num[i] > num[leastIndexToBeChanged]) {
				swapIndex = i;
				break;
			}
		}

		int tmp = num[swapIndex];
		num[swapIndex] = num[leastIndexToBeChanged];
		num[leastIndexToBeChanged] = tmp;

		//XXX this step
		for (int i = 0; i < (num.length - 1 - leastIndexToBeChanged) / 2; i++) {
			tmp = num[leastIndexToBeChanged + 1 + i];
			num[leastIndexToBeChanged + 1 + i] = num[num.length - 1 - i];
			num[num.length - 1 - i] = tmp;
		}
		
		return num;
	}

}
