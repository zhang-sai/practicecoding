
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

» Solve this problem
 * */
//XXX for binary search, use the recursive form
public class SearchInRotateArray {

	//suppose the array is sorted in increasing order
	public int search(int[] a, int target) {
        return this.findTarget(a, target, 0, a.length - 1);
    }
	
	public int findTarget(int[] a, int target, int startIndex, int endIndex) {
		if(a.length == 0) {
        	return -1;
        }
		if(startIndex > endIndex) {
			return -1;
		}
		int midIndex = (startIndex + endIndex)/2;
		if(a[midIndex] == target) {
			return midIndex;
		} else {
    		//decide which part should search
    		//here is some possibilities
    		if(a[startIndex] < a[endIndex]) {
    			//the array is sorted, the normal binary search
    			if(a[midIndex] > target) {
    				return this.findTarget(a, target, startIndex, midIndex - 1);
    			} else {
    				return this.findTarget(a, target, midIndex + 1, endIndex);
    			}
    		} else {
    			//XXX in this case there are always 2 possibility
    			//3, 5, 1 ==> find 3
    			//3, 5, 1 ==> find 1
    			int index1 = this.findTarget(a, target, startIndex, midIndex - 1);
    			if(index1 == -1) {
				    int index2 = this.findTarget(a, target, midIndex + 1, endIndex);
				    return index2;
    			} else {
    				return index1;
    			}
    		}
    	}
	}
	
	public static void main(String[] args) {
		SearchInRotateArray s = new SearchInRotateArray();
		System.out.println(s.search(new int[]{3, 5, 1}, 3));
	}
	
	/**
	 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
	 * 
	 * */
	xx
	//adapt from: http://gongxuns.blogspot.com/2012/12/leetcode-search-in-rotated-sorted-array_9.html
	public boolean search_dup(int[] a, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int start = 0;
        int end = a.length - 1;
        while(start <= end) {
        	int mid = (start + end)/2;
        	if(a[mid] == target) {
        		return true;
        	} else if (a[mid] > target) {
        		
        	} else { //a[mid] < target
        		//three possibilities:
        		//1. the most normal way
        		if(a[mid] > a[end] || a[end] >= target) { //1.  [3,4,5,6,1,2] target = 6
        			start = mid + 1;                      //2.  [2,3,4,5,6] target = 4
        		} else if (a[end] > a[mid] && a[end] < target) {   // [1, 3, 5, 7, 2, 4] target = 7
        			
        		} else {
        			
        		}
        	}
        }
        return false;
    }
}
