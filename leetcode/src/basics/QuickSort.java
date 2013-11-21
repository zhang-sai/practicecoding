package basics;

import java.util.Random;

//http://www.vogella.com/articles/JavaAlgorithmsQuicksort/article.html#quicksort
public class QuickSort {

	public static void quickSort(int[] a, int low, int high) {
		if (low < high) {
			int q = partition(a, low, high);
			quickSort(a, low, q);
			quickSort(a, q + 1, high);
		}
	}

	public static int partition(int[] a, int low, int high) {
		// Print(A,p,r);

		int x = a[low];
		int i = low - 1;
		int j = high + 1;
		while (i < j) {
//			System.out.println("low: " + low + ", high: " + high  + ", i: " + i + ", j: "
//					+ j + ", a[i]: " + a[i] + ", a[j]: " + a[j]);
			do {
				j--;
			} while (a[j] > x);
			
			do {
				i++;
			} while (a[i] < x) ;
			
			if (i < j) {
				exchange(a, i, j);
			}
		}
		return j;
	}

	public static void exchange(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		Random r = new Random(System.currentTimeMillis());
		for (int num = 0; num < 200; num++) {
			int[] a = new int[100 + r.nextInt(200)];
			for (int i = 0; i < a.length; i++) {
				a[i] = r.nextInt(500);
			}
			
//			 a = new int[]{3, 2, 4, 1,  4, 5};
//			for(int k : a) {
//				System.out.print(k + "  ");
//			}
			
			System.out.println("working on: " + num);
			quickSort(a, 0, a.length - 1);
			if (!isSorted(a)) {
				System.out.println("failed");
			}
			
//			for(int k : a) {
//				System.out.print(k + "  ");
//			}
		}
	}
	
	public static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isSortedAsc(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] < a[i + 1]) {
				return false;
			}
		}
		return true;
	}

}