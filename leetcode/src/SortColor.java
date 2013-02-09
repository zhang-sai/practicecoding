
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
