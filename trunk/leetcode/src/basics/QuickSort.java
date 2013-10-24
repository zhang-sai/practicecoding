package basics;
import java.util.Random;

//http://www.vogella.com/articles/JavaAlgorithmsQuicksort/article.html#quicksort
public class QuickSort {
	
	public void quicksort(int[] values) {
		if(values == null || values.length == 0) {
			return;
		}
		this.quicksort(0, values.length -1, values);
	}
	
	public void quicksort(int low, int high, int[] values) {
		int pivot = values[low + (high - low)/2];
		int i = low;
		int j = high;
		while(i < j) {
			while(values[i] < pivot) {
				i++;
			}
			while(values[j] > pivot) {
				j--;
			}
			
			if(i < j) {
				//exchange
				int tmp = values[i];
				values[i] = values[j];
				values[j] = tmp;
				i++;
				j--;
			}
		}
		if(j < high) {
			this.quicksort(j, high, values);
		}
		if( i > low) {
			this.quicksort(low, i, values);
		}
	}
	
	XXX
	
	what about exchange two nodes in a linked list?
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private int[] numbers;
	private int number;

	public void sort(int[] values) {
		// Check for empty or null array
		if (values == null || values.length == 0) {
			return;
		}
		this.numbers = values;
		number = values.length;
		quicksort(0, number - 1);
	}

	private void quicksort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = numbers[low + (high - low) / 2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (numbers[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (numbers[j] > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Random r = new Random(System.currentTimeMillis());
		for (int num = 0; num < 200; num++) {
			int[] a = new int[100 + r.nextInt(200)];
			for (int i = 0; i < a.length; i++) {
				a[i] = r.nextInt(500);
			}
			QuickSort sort = new QuickSort();
			sort.quicksort(a);
			if (!isSorted(a)) {
				System.out.println("failed");
			}
		}
	}

}