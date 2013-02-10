
/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 * */
public class SearchForRange {

	public int[] searchRange(int[] a, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index = this.findFirstPosition(a, 0, a.length - 1, target);
        if(index == -1) {
        	return new int[]{-1, -1};
        }
        
        int lastIndex = this.findLastPosition(a, 0, a.length - 1, target);
        
        return new int[] {index, lastIndex};
    }
	
	
	private int findFirstPosition(int[] a, int startIndex, int endIndex, int target) {
		if(startIndex > endIndex) {
			return -1;
		}
		if(a[startIndex] == target) {
			return startIndex;
		}
		int mid = (startIndex + endIndex)/2;
		if(a[mid] == target) {
			int beforeIndex = this.findFirstPosition(a, startIndex, mid - 1, target);
			if(beforeIndex != -1) {
				return beforeIndex;
			} else {
				return mid;
			}
		} else if (a[mid] > target) {
			return this.findFirstPosition(a, startIndex, mid - 1, target);
		} else {
			return this.findFirstPosition(a, mid + 1, endIndex, target);
		}
	}
	
	private int findLastPosition(int[] a, int startIndex, int endIndex, int target) {
		if(startIndex > endIndex) {
			return -1;
		}
		if(a[endIndex] == target) {
			return endIndex;
		}
		int mid = (startIndex + endIndex)/2;
		if(a[mid] == target) {
			int afterIndex = this.findLastPosition(a, mid + 1, endIndex, target);
			if(afterIndex != -1) {
				return afterIndex;
			} else {
				return mid;
			}
		} else if (a[mid] > target) {
			return this.findLastPosition(a, startIndex, mid - 1, target);
		} else {
			return this.findLastPosition(a, mid + 1, endIndex, target);
		}
	}
}
