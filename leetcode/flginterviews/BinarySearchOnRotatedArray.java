/**
 * binary search on a shifted array, find the offset (2) in log n
find the beginning of the array, if (right - left  <= 1) then return min(
left,right)
 * */

/**
 * e.g., 1 2 3 4 5 ==> 4 5 1 2 3 output 2
 * 
 * 1 2 3 4 5 ===> 2 3 4 5 1 output 1
 * */

public class BinarySearchOnRotatedArray {

	public static void main(String[] args) {
		System.out.println(findOffset(new int[] { 1, 2, 3, 4, 5 })); // 0
		System.out.println(findOffset(new int[] { 5, 1, 2, 3, 4 })); // 1
		System.out.println(findOffset(new int[] { 5, 4, 1, 2, 3 })); // 2
		System.out.println(findOffset(new int[] { 5, 4, 3, 1, 2 })); // 3
		System.out.println(findOffset(new int[] { 5, 4, 3, 2, 1 })); // 4
	}

	public static int findOffset(int[] a) {
		int start = 0;
		int end = a.length - 1;

		while (start <= end) {
			if (a[end] > a[start]) {
				return start;
			}
			// only two elements, must check this special case
			if (start == end || start + 1 == end) {
				return end;
			}
			// int mid = (start + end)%2 == 0 ? (start + end)/2 : (start +
			// end)/2 + 1;
			int mid = (start + end) / 2;
			if (a[mid] < a[mid + 1] && a[mid] < a[mid - 1]) {
				return mid;
			} else if (a[end] > a[mid] && a[mid] > a[start]) {
				return 0;
			} else if (a[end] > a[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return 0;
	}
}
