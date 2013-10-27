import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/***
 * N sorted array, find elements appears in all of them
 * e.g.,
 *  [1, 2, 3, 4]   [2, 4, 6, 8]   [0, 2, 3, 4, 10]
 *  
 *  output: [2, 4]
 * */
//Find intersection of two sorted array A, B
public class FindAllCommonElements {
	
	public static void main(String[] args) {
		int[] a = new int[]{1, 2, 3, 4};
		int[] b = new int[]{2, 4, 6, 8};
		int[] c = new int[]{0, 2, 3, 4, 10};
		System.out.println(findAllCommons(Arrays.asList(a, b, c)));
	}
	
	//see here http://stackoverflow.com/questions/15036821/find-common-elements-in-n-sorted-arrays-with-no-extra-space
	//or just use hash is a more easy way, seems
	
	public static List<Integer> findAllCommons(List<int[]> lists) {
		List<Integer> retList = new ArrayList<Integer>();
		//use the first array as a reference array
		
		int[] firstArray = lists.get(0);
		
		int[] indexArray = new int[lists.size()];
		
		for(int i = 0; i < firstArray.length; i++) {
			int val = firstArray[i];
			boolean find = true;
			for(int index = 1; index < lists.size(); index++) {
				int[] array = lists.get(index);
				while(indexArray[index] < array.length && array[indexArray[index]] < val) {
					indexArray[index]++;
				}
				if(array[indexArray[index]] != val) {
					//no found exit the program
					find = false;
					break;
				}
			}
			if(find) {
				retList.add(val);
			}
		}
		
		
		return retList;
	}
	
}
