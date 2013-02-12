
/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 -> 2
[1,3,5,6], 2 -> 1
[1,3,5,6], 7 -> 4
[1,3,5,6], 0 -> 0
 * */
public class SearchInsertPosition {
	
	public int searchInsert(int[] a, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a.length == 0) {
        	return 0;
        }
		return this.findPosition(a, 0, a.length - 1, target);
    }
	
	private int findPosition(int[] a, int startIndex, int endIndex, int target) {
		if(startIndex == endIndex) {
			if(a[startIndex] == target) {
				return startIndex;
			} else if (a[startIndex] > target) {
				return startIndex;
			} else {
				return startIndex + 1;
			}
		}
		
		//XXX this is really critical
		//to avoid the case find 0 in [1,3]
		if(startIndex > endIndex) {
			return startIndex;
		}
		
		int mid = (startIndex + endIndex)/2;
		if(a[mid] == target) {
			return mid;
		} else if (a[mid] < target) {
			return this.findPosition(a, mid + 1, endIndex, target);
		} else {
			return this.findPosition(a, startIndex, mid - 1, target);
		}
		
	}
	
	public static void main(String[] args) {
		new SearchInsertPosition().searchInsert(new int[]{1, 3}, 0);
	}
}