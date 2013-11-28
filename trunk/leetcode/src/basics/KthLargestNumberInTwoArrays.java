package basics;

//http://leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html

public class KthLargestNumberInTwoArrays {
	
	public static void main(String[] args) {
		int[] a = new int[]{1, 3, 5, 7, 9, 11, 13, 15};
		int[] b = new int[]{2, 4, 6, 8, 10, 12, 14};
		for(int i = 1; i < a.length + b.length + 1; i++) {
			System.out.println(getKLargest(a, 0, b, 0, i));
		}
//		System.out.println(getKLargest(a, 0, b, 0, 1));
	}

	public static int getKLargest(int[] a, int aStartIndex, int[] b, int bStartIndex, int k) {
//		System.out.println("astart: " + aStartIndex + ",  bStartIndex: " + bStartIndex + ", k: " + k);
		int m = a.length - aStartIndex;
		int n = b.length - bStartIndex;
		assert k <= m + n;
		
		int i = (int)((double)m/(m+n)*(k-1));
		int j = k - 1 - i;
		
		
		//invariant i + j = k - 1
		int ai_1 = i == 0 ? Integer.MIN_VALUE : a[aStartIndex + i-1];
		int bj_1 = j == 0 ? Integer.MIN_VALUE : b[bStartIndex + j-1];
		int ai = i == m ? Integer.MAX_VALUE : a[aStartIndex + i];
		int bj = j == n ? Integer.MAX_VALUE : b[bStartIndex + j];
		
		/**
		 *
		 * [a1, a2, ....   ai_1, ai, .......]
		 * 
		 * [b1, b2, ....   bj_1, bj, .......]
		 * 
		 * if ai is smaller than bj_1, so that we should discard ai's below, and bi's above 
		 * 
		 * otherwise, we discard ai's above and bj's below
		 * */
		
		if(bj_1 < ai && ai < bj) {
			return ai;
		} else if (ai_1 < bj && bj < ai) {
			return bj;
		}
		
		if (ai < bj) {
			return getKLargest(a, i+1, b, bStartIndex, k-i-1); //discard a's below part, and b's above part
		} else {
			return getKLargest(a, aStartIndex, b, j+1, k-j-1); //discard a's above part, and b's below part
		}
	}
	
}

