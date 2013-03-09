/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 * */
public class MergeSortedArrays {
	public void merge(int a[], int m, int b[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		//XXX the key idea is to put element from the end of array a
		int index = m + n - 1;
		
		int aIndex = m -1;
		int bIndex = n -1;
		while(aIndex != -1 || bIndex != -1) { //XXX it is || not &&
			if(aIndex >= 0 && bIndex >=0 ) {
				if(a[aIndex] > b[bIndex]) {
					a[index--] = a[aIndex--];
				} else {
					a[index--] = b[bIndex--];
				}
			} else if (aIndex != -1) {
//				while(aIndex != -1) {
//					a[index--] = a[aIndex--];
//				}
				break;
			} else if (bIndex != -1) {
				while(bIndex != -1) {
					a[index--] = b[bIndex--];
				}
				break;
			} else {
				break;
			}
		}
    }
	
	public static void main(String[] args) {
		MergeSortedArrays msa = new MergeSortedArrays();
		int[] a = new int[1];
		int[] b = new int[]{1};
		msa.merge(a, 0, b, 1);
		for(int i : a) {
			System.out.println(i);
		}
	}
}
