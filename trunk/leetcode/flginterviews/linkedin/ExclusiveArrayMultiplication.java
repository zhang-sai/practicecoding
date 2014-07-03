package linkedin;

import util.Utils;

/**
 * 
 * 1.exclusive array, give an arr1, return a new arr2, arr2[i] is the
 * multiplication of all elements in arr1 except arr1[i]
 * */

// see here: http://leetcode.com/2010/04/multiplication-of-numbers.html
public class ExclusiveArrayMultiplication {

	// cacluate all mult
	static void array_multiplication(int A[], int OUTPUT[], int n) {
		
		for (int i = 0; i < n; i++)
			OUTPUT[i] = 1;
		
		//it will be multiple a number of times
		//4, 3, 2, 1, 1
		//at the beginning
		//output[0] == output[1] == output[2] == output[3] == 1
		//
		//left = right = 1
		
		//output[0] = 1, option[4] = 1
		//left = 4, right 1
		
		//output[1] = 4 output[3] = 1
		//left = 12, right = 2
		
		//output[2] = 12, output[2] = 
		//left = 16, right = 9
		//output[3] = 16, output[2] = 27
		
		int left = 1;
		int right = 1;
		for (int i = 0; i < n; i++) {
			OUTPUT[i] *= left;
			OUTPUT[n - 1 - i] *= right;
			left *= A[i];
			right *= A[n - 1 - i];
		}
	}
	
	
	public static void main(String[] args) {
		int[] o = new int[]{1, 1, 1, 1, 1};
		array_multiplication(new int[]{4, 3, 2, 1, 2}, o, 5);
		for(int i : o) {
			System.out.println(i);
		}
		
	}

}
