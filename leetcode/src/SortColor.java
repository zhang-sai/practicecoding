
/**
 * 
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red,
white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
 * */
public class SortColor {
	
	public static void main(String[] args) {
		SortColor sc = new SortColor();
		int[] a = new int[]{1, 0};
		sc.sortColors_one_pass(a);
		for(int i : a) {
			System.out.println(i);
		}
	}
	
	public void sortColors_one_pass(int[] a) {
		if(a.length < 2) {
			return;
		}
		int pos0 = 0;
		int pos1 = a.length - 1;
		int pos2 = a.length - 1;
		while(pos0 < pos2) {
			if(a[pos0] == 0) {
				pos0++;
			} else if (a[pos0] == 1) {
				if(pos0 < pos1) {
					swap(a, pos0, pos1);
					pos1 --; //move back
				} else {
					pos0++;
				}
			} else {
				//a[pos0] == 2
				swap(a, pos0, pos2);
				pos2 --;
				if(pos1 > pos2) {
					pos1 = pos2; //1 must be before 2
				}
			}
		}
	}
	
	private void swap(int[] a, int index1, int index2) {
		int tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}
	
	public void sortColors(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // how to use in-place sort
		if(a.length == 0) {
			return;
		}
		int red = 0;
		int white = 0;
		int blue = 0;
		for(int i : a) {
			if(i == 0) red++;
			if(i == 1) white++;
			if(i == 2) blue++;
		}
		for(int i = 0; i < a.length; i++) {
			if(i < red) {
				a[i] = 0;
			} else if ( i < red + white) {
				a[i] = 1;
			} else {
				a[i] = 2;
			}
		}
		
    }
}
