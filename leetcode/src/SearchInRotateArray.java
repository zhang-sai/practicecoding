
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

» Solve this problem
 * */
//XXX for binary search, use the recursive form
public class SearchInRotateArray {

	//compare the middle
	//suppose the array is sorted in increasing order
	public int search(int[] A, int target) {
        int l = 0;
        int r = A.length -1;  
        while(l<=r) {   
            int m = (l+r)/2;   
            if(A[m] == target) {
                return m;   
            }
            //the left part is sorted
            if(A[m]>= A[l]) {   
                if(A[l]<=target && target<= A[m]) {
                      r=m-1;   
                } else  {
                      l = m+1;       
                }
            } else {
                //the right part is sorted
                if(A[m] <= target && target <= A[r]) {
                      l = m+1;    
                } else {
                      r = m-1;   
                }
            }   
        }   
        //end of search, find nothing
        return -1;   
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
//	xx
	//adapt from: http://gongxuns.blogspot.com/2012/12/leetcode-search-in-rotated-sorted-array_9.html
	public boolean search_dup(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int l = 0;
        int r = A.length -1;  
        while(l<=r) {   
            int m = (l+r)/2;   
            if(A[m] == target) {
                return true;   
            }
            //the left part is sorted
            if(A[m]> A[l]) {   
                if(A[l]<=target && target<= A[m]) {
                      r=m-1;   
                } else  {
                      l = m+1;       
                }
            } else if(A[m] < A[l]) {
                //the right part is sorted
                if(A[m] <= target && target <= A[r]) {
                      l = m+1;    
                } else {
                      r = m-1;   
                }
            } else {
                l++; //THE ONLY DIFF PART, IN THIS CASE WE HAVE NO CHOICE
                //like  1, 3, 1, 1, 1, 1
            }
        }   
        //end of search, find nothing
        return false;  
    }
}
