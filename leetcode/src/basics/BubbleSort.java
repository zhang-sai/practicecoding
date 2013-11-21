package basics;

import java.util.Random;

public class BubbleSort {

	public void bubbleSort(int[] a) {
		//in the first round, move the biggest one to the end
		//in the second round, move the second biggest one to the end
		//if there is no swap, just break out
		for(int round = 1; round < a.length; round ++) {
			boolean flag = false;
			for(int i = 0; i < a.length - round; i++) {
				if(a[i] > a[i+1]) {
					flag = true;
					int tmp = a[i];
					a[i] = a[i+1];
					a[i+1] = tmp;
				}
			}
			if(!flag) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		Random r = new Random(System.currentTimeMillis());
		for (int num = 0; num < 200; num++) {
			int[] a = new int[100 + r.nextInt(200)];
			for (int i = 0; i < a.length; i++) {
				a[i] = r.nextInt(500);
			}
			BubbleSort sort = new BubbleSort();
			sort.bubbleSort(a);
			if (!QuickSort.isSorted(a)) {
				System.out.println("failed");
			}
		}
	}
	
}
