package fb;

import util.Utils;

/**
 * Push all the zero's of a given array to the end of the array.
 * In place only. Ex 1,2,0,4,0,0,8 becomes 1,2,4,8,0,0,0
 * 
 * http://www.careercup.com/question?id=12986664
 * */
public class PushZeroToEnd {

	public static void main(String[] args) {
		
		Integer[] array = new Integer[]{1, 2, 0, 4, 0, 0, 0, 8};
		
		int pos = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] != 0 ) {
				if(pos != i) { // a small optimization
					array[pos] = array[i];
				}
				pos++;
			}
		}
		//assign zero
		for(int i = pos; i < array.length; i++) {
			array[i] = 0;
		}
		
		System.out.println(Utils.dumpArray(array));
	}
	
}
