package basics;

import java.util.Random;

public class MergeSort {

	public void mergeSort(int[] a) {
		if(a.length == 0) {
			return;
		}
		mergeSort(a, 0, a.length - 1);
	}
	
	public void mergeSort(int[] a, int low, int high) {
		if(low == high) {
			return;
		}
		int mid = (low + high)/2;
		mergeSort(a, low, mid);
		mergeSort(a, mid + 1, high);
		//then perform merging
		//[low, mid] and [mid + 1, high] have been sorted
		//copy array
		int[] array = new int[a.length];
		int index = array.length - 1;
		int i = mid;
		int j = high;
		while(i >= low && j > mid) {
			if(a[i] > a[j]) {
				array[index--] = a[i--];
			} else {
				array[index--] = a[j--];
			}
		}
		while(i>=low) {
			array[index--] = a[i--];
		}
		
		while(j>mid) {
			array[index--] = a[j--];
		}
		
		for(index = 0; index < array.length; index++) {
			a[index] = array[index];
		}
	}
	
	public static void main(String[] args) {
		Random r = new Random(System.currentTimeMillis());
		for (int num = 0; num < 200; num++) {
			int[] a = new int[100 + r.nextInt(200)];
			for (int i = 0; i < a.length; i++) {
				a[i] = r.nextInt(500);
			}
			MergeSort sort = new MergeSort();
			sort.mergeSort(a);
			if (!QuickSort.isSortedAsc(a)) {
				System.out.println("failed");
			}
		}
	}
}
