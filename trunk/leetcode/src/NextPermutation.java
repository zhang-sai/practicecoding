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

	public void nextPermutation(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (num.length == 1)
			return;
		
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
		    return;
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
		
		return;
    }

	public static void main(String[] args) {
		NextPermutation np = new NextPermutation();
		int[] num = new int[]{1, 2, 3, 4};
		for(int i = 0; i < 20; i++) {
			for(int n : num) {
				System.out.print(n + "  ");
			}
			System.out.println();
		   // num =np.nextPermutation(num);
		}
	}
}
