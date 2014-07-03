import util.Utils;

/**
 * Given an array [a1, a2, ..., aN, b1, b2, ..., bN, c1, c2, ..., cN] 
 * convert it to [a1, b1, c1, a2, b2, c2, ..., aN, bN, cN] in-place
 * using constant extra space - See more at:
 * http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.dFMldWJu.dpuf
 * */
//xx

public class ConvertArray {

	/**
	 * def getIndex(currentIndex, N): return (currentIndex%3)*N + (currentIndex/3)
	 * 
	 * 
	 * def convertArray(arr): N=len(arr)/3 for currentIndex in range(len(arr)): swapIndex=getIndex(currentIndex, N) while swapIndex
	 * 
	 * */
	
	//total number of each
	//http://www.ardendertat.com/2011/10/18/programming-interview-questions-9-convert-array/
//	public static int getIndex(int currIndex, int totalNum) {
//		return currIndex
//	}
	
	public static void main(String[] args) {
		Integer[] array = new Integer[]{1, 4, 7, 2, 5, 8, 3, 6, 9};
		convertWithExtra(array, 3);
		convertWithoutExtra(array, 3);
	}
	
	public static int getIndex(int index, int n) {
		return n*(index%3) + index/3;
	}
	
	public static Integer[] convertWithExtra(Integer[] array, int n) {
		Integer[] as = new Integer[array.length];
		for(int i = 0; i < as.length; i++) {
			as[i] = array[getIndex(i, n)];
		}
		System.out.println(Utils.dumpArray(as));
		return as;
	}
	
	//its around O(n^1.3)
	public static Integer[] convertWithoutExtra(Integer[] array, int n) {
		
		
		/**
		 *  1, 4, 7, 2, 5, 8, 3, 6, 9
		 *  
		 *  currIndex = 0  => swapIndex = 0 ==> OK 
		 *  currIndex = 1  => swapIndex = 4 ==> OK
		 *  1, *2*, 7, 4, 5, 8, 3, 6, 9
		 *  
		 *  currIndex = 2 ==> swapIndex = 6 ==> OK
		 *  
		 *  1, 2, *3*, 4, 5, 8, *7*, 6, 9
		 *  currentIndex = 3 ==> swapIndex = 4 OK
		 *  
		 *  currentIndex = 4 ==> swapIndex = 4, OK
		 *  currIndex = 5  ==> 6
		 *  
		 *  1, 2, *3*, 4, 5, 6, *7*, 8, 9
		 * */
		
		for(int currIndex = 0; currIndex < array.length; currIndex++) {
			int swapIndex = getIndex(currIndex, n);
			while(swapIndex < currIndex) {
				swapIndex = getIndex(swapIndex, n);
			}
			//swap current and swap
			Integer tmp = array[swapIndex];
			array[swapIndex] = array[currIndex];
			array[currIndex] = tmp;
		}
		
		System.out.println(Utils.dumpArray(array));
		return array;
	}
	
}
