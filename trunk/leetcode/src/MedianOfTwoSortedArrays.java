/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * */

//http://leetcode.com/2011/03/median-of-two-sorted-arrays.html

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
//		System.out.println(m.findMedianSortedArrays(new int[]{1,2,3}, new int[]{1, 2}));
//		System.out.println(m.findMedianSortedArrays(new int[]{1,2,3}, new int[]{4, 5, 6}));
//		System.out.println(m.findMedianSortedArrays(new int[]{3,4}, new int[]{}));
		System.out.println(m.findMedianSortedArrays(new int[]{3}, new int[]{1,2,4}));
	}
	public double findMedianSortedArrays(int A[], int B[]) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return findMedianSortedArrays(A, A.length, B, B.length);
    }
    
    private double findMedianSortedArrays(int A[], int m, int B[], int n) {  
        if((n+m)%2 ==0) {  
          System.out.println("==>");
          int i1 = getMedian(A, 0, m,B, 0, n, (m+n)/2);
          System.out.println("==>");
          int i2 = getMedian(A,0, m,B, 0, n, (m+n)/2+1);
          return (i1+i2)/2.0;
        }  
        else {
          return getMedian(A,0, m,B, 0, n, (m+n)/2+1);        
        }
    }
    
    private int getMedian(int a[], int astart, int n, int b[], int bstart, int m, int k) {  
    	System.out.println("astart: " + astart + ", n: " + n + ",  bstart: " + bstart + ",  m: " + m + ", k: " + k);
        if (n <= 0) {
        	System.out.println("return : " + b[bstart + k-1]);
            return b[bstart + k-1];   //do not forget bstart
        }
        if (m <= 0) {
        	System.out.println("return : " + a[astart + k-1]);
            return a[astart + k-1];   //do not forget astart
        }
        if (k <= 1) {
        	System.out.println("return min: " + Math.min(a[0], b[0]));
            return Math.min(a[astart], b[bstart]);   
        }
        if (b[bstart + (m/2)] >= a[astart + (n/2)])  {  
            if ((n/2 + 1 + m/2) >= k)  {
            	System.out.println("1");
                return getMedian(a, astart, n, b, bstart, m/2, k);  
            } else {
            	System.out.println("2");
                return getMedian(a, astart + n/2 + 1, n - (n/2 + 1), b, bstart, m, k - (n/2 + 1));  
            }
        } else {  
            if ((m/2 + 1 + n/2) >= k) {
            	System.out.println("3");
                return getMedian( a, astart, n/2, b, bstart, m, k);  
            } else {
            	System.out.println("4");
                return getMedian( a, astart, n, b, bstart + m/2 + 1, m - (m/2 + 1),k - (m/2 + 1));  
            }
       }  
   }  
}