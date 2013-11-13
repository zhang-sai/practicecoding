package basics;

import util.Utils;

public class InsertionSort {

	public static void insertionSort(Integer[] a) {
		for(int i = 1; i < a.length; i++) {
			for(int j = 0; j < i; j++) {
				if(a[j] > a[i]) {
					int tmp = a[j];
					a[j] = a[i];
					a[i] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] a = new Integer[]{3, 4, 1, 5, 7, 9, 8, 2, 6};
		insertionSort(a);
		System.out.println(Utils.dumpArray(a));
	}
	
}