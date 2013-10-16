
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
        if(a.length <= 1) {
            return;
        }
        int red = 0;
        int blue = a.length - 1;
        while(red < a.length && a[red] == 0) { //do not miss check
            red++;
        }
        while(blue >= 0 && a[blue] == 2) {
            blue--;
        }
        //check condition
        if(red == a.length || blue == -1) {
            return;
        }
        //now red and blue are in the first place of non-read, non-blue, respectively
        int j = red;
        while(j < blue) {
            if(a[j] == 1) {
                j++;
            }
            if(a[j] == 2) {
                swap(a, j, blue);
                blue--;
            }
            if(a[j] == 0) {
                swap(a, j, red);
                if(j == red) {
                    j++;
                }
                red++;
            }
        }
    }
    
    //a helper method for swapping
    void swap(int[] a, int i, int j) {
        if(i!=j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
