/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * */
//http://leetcode.com/2011/03/median-of-two-sorted-arrays.html
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int a[], int b[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a.length == 0) {
        	return this.media(b);
        }
        if(b.length == 0) {
        	return this.media(a);
        }
        //a and b are not empty
        
    }
	
	private double media(int a[]) {
		int size = a.length;
		return size%2 == 1 ? a[size/2] : (a[size/2] + a[size/2 - 1])/2;
	}
}