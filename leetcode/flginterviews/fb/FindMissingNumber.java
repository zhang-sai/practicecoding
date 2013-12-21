package fb;

/**
 * Question was on Arithmetic progression 

Example : 
Given the AP :- 1 3 7 9 11 13 find the missing value "which would be 5 here". 

Conditions : 
Get an user for the length of AP sequence and make sure user provides length is above 3. 
Get the input in a single line ex:- "1 3 5 7 9 11" 
Provide the solution in O(n) or less if you can.
 * */
public class FindMissingNumber {
	
	public static int findMissingNum(int[] array) {
		if(array.length < 3 || array == null) {
			return -1;
		}
		int diff = Math.min(array[1] - array[0], array[2] - array[1]);
		int left = 0;
		int right = array.length - 1;
		while(left <= right) {
			int mid = (left + right)/2;
			
			int leftDiff = array[mid] - array[left];
			if(leftDiff > diff*(mid - left)) {
				//find it
				if(mid - left == 1) {
					return (array[mid] + array[left])/2;
				}
				right = mid;
				continue;
			}
			
			int rightDiff = array[right] - array[mid];
			if(rightDiff > diff * (right - mid)) {
				if(right - mid == 1) {
					return (array[mid] + array[right]) / 2;
				}
				left = mid;
				continue;
			}
		}
		
		
//		retur
		return -1;
	}
	
	public static void main(String[] args) {
		int num = findMissingNum(new int[]{1, 3,  7, 9, 11, 13});
		System.out.println(num);
//		num = findMissing_binary(new int[]{1, 3,  7, 9, 11, 13});
//		System.out.println(num);
	}
	
}
