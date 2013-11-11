//a[i] = i
//in a sorted array, which may contain duplications
//9.3
xx
public class SearchMagicNumber {

	//start, end, is inclusive
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
		searchForMagicNumber(a, start, mid - 1);
		searchForMagicNumber(a, mid + 1, end);
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1, 1, 1, 3, 5, 6, 6};
		searchForMagicNumber(array, 0, array.length - 1);
	}
}
