/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * */
xx
//http://leetcode.com/2011/03/median-of-two-sorted-arrays.html
public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
//		System.out.println(m.findMedianSortedArrays(new int[]{1,2,3}, new int[]{1, 2}));
		System.out.println(m.findMedianSortedArrays(new int[]{1,2,3}, new int[]{4, 5, 6}));
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
		System.out.println(aStart + ", " + aEnd + ": " + bStart + ", " + bEnd);
		c++;
//		if(c > 10) {
//			return -0d;
//		}
		if(bEnd - bStart == 1 && aEnd - aStart == 1) {
			if(a[aEnd] <= b[bStart]) {
				return (a[aEnd] + b[bStart]) / 2;
			} else if (b[bEnd] <= a[aStart]) {
				return (b[bEnd] + a[aStart]) /2;
			} 
			else {
				
			}
			return  a[aStart] >= b[bEnd] ? (a[aStart] + b[bEnd])/2 : (a[aEnd] + b[bStart])/2;
		}
		if(aStart == aEnd && bStart == bEnd) {
			return (a[aEnd] + b[bEnd])/2;
		}
		if(aStart == aEnd && bEnd - bStart == 1) {
			return b[bEnd] >= a[aStart] ? b[bStart] : b[bEnd];
		}
		if(aEnd - aStart == 1 && bStart == bEnd) {
			return a[aEnd] >= b[bStart] ? a[aStart] : a[aEnd];
		}
		
		double aMedian = this.media(a, aStart, aEnd);
		double bMedian = this.media(b, bStart, bEnd);
		//no need for further recursion
		
		if(aMedian == bMedian) {
			return aMedian;
		} else if (aMedian > bMedian) { //XXX Note the following equath
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
		return size%2 == 1 ? a[start + size/2] : (a[start + size/2] + a[start + size/2 - 1])/2;
	}
}