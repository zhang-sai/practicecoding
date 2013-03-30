/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * */

//http://leetcode.com/2011/03/median-of-two-sorted-arrays.html
xx
public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
//		System.out.println(m.findMedianSortedArrays(new int[]{1,2,3}, new int[]{1, 2}));
//		System.out.println(m.findMedianSortedArrays(new int[]{1,2,3}, new int[]{4, 5, 6}));
//		System.out.println(m.findMedianSortedArrays(new int[]{3,4}, new int[]{}));
		System.out.println(m.findMedianSortedArrays(new int[]{2, 3,4}, new int[]{1}));
	}
	public double findMedianSortedArrays(int a[], int b[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a.length == 0) {
        	return this.media(b, 0, b.length - 1);
        }
        if(b.length == 0) {
        	return this.media(a, 0, a.length - 1);
        }
        //a and b are not empty
        return this.findMedianSortedArrays(a, 0, a.length - 1, b, 0, b.length - 1);
    }
	
	int c = 0;
	//XXX be aware of the case: a= 0, 1   b= 1
	//a = 0,1  b = 1,1
	//
	private double findMedianSortedArrays(int a[], int aStart, int aEnd,
			int b[], int bStart, int bEnd) {
//		System.out.println(aStart + ", " + aEnd + ": " + bStart + ", " + bEnd);
//		c++;
//		if(c > 10) {
//			return -0d;
//		}
		if(bEnd - bStart == 1 && aEnd - aStart == 1) {
			int sum = a[aStart] + a[aEnd] + b[bStart] + b[bEnd];
			return (double)(sum - Math.min(a[aStart], b[bStart]) - Math.max(a[aEnd], b[bEnd]))/2;
		}
		if(aStart == aEnd && bStart == bEnd) {
			return (double)(a[aEnd] + b[bEnd])/2;
		}
		if(aStart == aEnd && bEnd - bStart == 1) {
			int sum = a[aStart] + b[bStart] + b[bEnd];
			return sum - Math.max(a[aStart], b[bEnd]) - Math.min(a[aStart], b[bStart]);
		}
		if(aEnd - aStart == 1 && bStart == bEnd) {
			int sum = a[aStart] + a[aEnd]+ b[bStart];
			return sum - Math.max(a[aEnd], b[bStart]) - Math.min(a[aStart], b[bStart]);
		}
		
		double aMedian = this.media(a, aStart, aEnd);
		double bMedian = this.media(b, bStart, bEnd);
		//no need for further recursion
		
		if(aMedian == bMedian) {
			return aMedian;
		} else if (aMedian > bMedian) { //XXX Note the following eqth is critical
			int newAEnd = aStart + (aEnd-aStart)/2;
			int newBStart = bEnd - (bEnd - bStart)/2;
			return this.findMedianSortedArrays(a, aStart, newAEnd, b, newBStart, bEnd);
		} else {
			int newAStart = aStart + (aEnd - aStart)/2;
			int newBEnd = bEnd - (bEnd - bStart)/2;
			return this.findMedianSortedArrays(a, newAStart, aEnd, b, bStart, newBEnd);
		}
	}
	
	private double media(int a[], int start, int end) {
		int size = end - start + 1;
//		System.out.println("size: " + size);
//		System.out.println(start);
//		System.out.println(end);
		return size%2 == 1 ? a[start + size/2] : ((double)(a[start + size/2] + a[start + size/2 - 1]))/2;
	}
}