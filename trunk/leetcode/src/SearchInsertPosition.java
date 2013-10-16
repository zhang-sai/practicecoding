
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
        int low = 0;
        int high = a.length - 1;
        int mid = low;
        while(low < high) {
            mid = (low+high)/2;
            if(a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        //need to compute the current mid
        mid = (low + high)/2;
        
        if(target > a[mid]) {
            return mid + 1;
        } else {
            return mid;
        }
        
    }
	
	public static void main(String[] args) {
		new SearchInsertPosition().searchInsert(new int[]{1, 3}, 0);
	}
}