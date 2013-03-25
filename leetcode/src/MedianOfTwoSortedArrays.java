/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * */
XX
//http://leetcode.com/2011/03/median-of-two-sorted-arrays.html
public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
		System.out.println(m.findMedianSortedArrays(new int[]{1,2,3}, new int[]{1, 2}));
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
	private double findMedianSortedArrays(int a[], int aStart, int aEnd,
			int b[], int bStart, int bEnd) {
		System.out.println(aStart + ", " + aEnd + ": " + bStart + ", " + bEnd);
		c++;
		if(c > 10) {
			return -0d;
		}
		double aMedian = this.media(a, aStart, aEnd);
		double bMedian = this.media(b, bStart, bEnd);
		//no need for further recursion
		if(aStart == aEnd && bStart == bEnd) {
			return (aMedian + bMedian)/2;
		}
		if(aMedian == bMedian) {
			return aMedian;
		} else if (aMedian > bMedian) {
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