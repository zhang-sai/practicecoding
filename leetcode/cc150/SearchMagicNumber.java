//a[i] = i
//in a sorted array, which may contain duplications
//9.3
//xx
public class SearchMagicNumber {

	//start, end, is inclusive
	/*** note that two ways are possible! */
	public static void searchForMagicNumber(int[] a, int start, int end) {
		if(start > end) {
			return;
		}
		if(a[start] > end || a[end] < start) {
			return;
		}
		
		int mid = (start + end)/2;
		if(a[mid] == mid) {
			System.out.println("mid index: " + mid + ", value: " + a[mid]);
		}
		
		//a little bit optimizations here
		/**
		 *  value: -10 -5 2  2  2  *3*  4  7  9  12
		 *  index:  0  1  2  3  4  *5*  6  7  8  9
		 *  
		 *  Suppose the current mid index is: 5
		 *  so that any index which is bigger than 3 is NOT possible!
		 * */
		int leftIndex = Math.min(mid - 1, a[mid]);
		searchForMagicNumber(a, start, /*mid - 1*/ leftIndex);
		
		int rightIndex = Math.max(mid + 1, a[mid]);
		searchForMagicNumber(a, /*mid + 1*/ rightIndex, end);
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1, 1, 1, 3, 5, 6, 6};
		searchForMagicNumber(array, 0, array.length - 1);
	}
}
