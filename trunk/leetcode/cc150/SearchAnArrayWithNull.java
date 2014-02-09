
/**
 * search 5 in
 * [1, null, null, 3, null, 4, null, 5, null, null, 6]
 * 
 * */
public class SearchAnArrayWithNull {

	public static int searchArray(Integer[] array, Integer target) {
		int start = 0;
		int end = array.length - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(array[mid] == target) {
				return mid;
			}
			if(array[mid] != null) {
				if(array[mid] > target) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				//search both ways
				int high = mid + 1;
				while(array[high] == null) {
					high ++;
				}
				if(high <= array.length - 1 && high <= end && array[high] <= target) {
					start = high;
					continue;
				}
				int low = mid - 1;
				while(array[low] == null) {
					low --;
				}
				if(low >= 0 && low >= start && array[low] >= target) {
					end = low;
					continue;
				}
				//cannot find
				return -1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Integer[] array = new Integer[]{1, null, null, 3, null, 5, null, null, 7, 8, 9, null, null, 10};
		System.out.println(searchArray(array, 6));
		System.out.println(searchArray(array, 1));
		System.out.println(searchArray(array, 3));
		System.out.println(searchArray(array, 5));
		System.out.println(searchArray(array, 7));
		System.out.println(searchArray(array, 8));
		System.out.println(searchArray(array, 9));
		System.out.println(searchArray(array, 10));
		System.out.println(searchArray(array, 11));
		System.out.println(searchArray(array, 0));
	}
	
}
