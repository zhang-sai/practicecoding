package g;

/**
 * 
 * void minMSwap(int[] num, int m), return the min array after m swaps, each 
swap happens only between two adjacent elements([4,2,1,3], 2 return [1,4,2,3
])

4,2,1,3
4,1,2,3
1,4,2,3
 * */
public class MinSwap {

	//min swap
	
	//use recursion
	//fromt the most significant bit, find the smallest element it can exchange
	//and then do recursion
	//first move the smallest to the head, then for the rest one, do recursion
	
	public void minMSwap(int[] num, int m) {
		swapInternal(num, 0, m);
	}
	
	private void swapInternal(int[] array, int startIndex, int steps) {
		if(startIndex == array.length - 1 || steps == 0) {
			printNums(array);
			return;
		}
		int swapIndex = getTheSmallestNumIndex(array, startIndex, steps);
		if(swapIndex == -1) {
			swapInternal(array, startIndex + 1, steps);
		} else {
			swap(array, startIndex, swapIndex);
			swapInternal(array, startIndex + 1, steps - (swapIndex - startIndex));
		}
	}
	
	private void printNums(int[] num) {
		for(int n : num) {
			System.out.print(n +  " ");
		}
		System.out.println();
	}
	
	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	private int getTheSmallestNumIndex(int[] array, int currIndex, int step) {
		int currNum = array[currIndex];
		int currMin = currNum;
		int numIndex = -1;
		for(int i = 1; i <= step; i++) {
			if(currIndex + i >= array.length) {
				break;
			} else {
				if(array[currIndex+i] < currMin) {
					currMin = array[currIndex + i];
					numIndex = currIndex+ i;
				}
			}
		}
		return numIndex;
	}
	
	public static void main(String[] args) {
		MinSwap ms = new MinSwap();
		ms.minMSwap(new int[]{2, 2, 2, 2, 1}, 3);
	}
}
