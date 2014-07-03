import util.Utils;

//find a min sequence that m - n is min,
//that if n ~ m is sorted, the whole array is sorted
//xxx
public class MinSortSequence {
	
	//example: 1, 2, 4, 7, 10, 9, 11
	//sort: 10, 9
	//eg, 1 2 4 7 10 11 7 12 6 7 16 18 19
	//                  s  e
	//                     curr min= 6
	//   curr max = 11
	//   starting from 0, find the first 7 as the start index
	//   starting from end, find the second 7
	//divide it into 3 parts, and then shrink the left and right parts
	public static void findMinSeq(Integer[] array) {
		if(array.length < 2) {
			return;
		}
		int startIndex = 1;
		//get to the first place where the array is not sorted
		while(startIndex < array.length) {
			if(array[startIndex] < array[startIndex - 1]) {
				break;
			}
			startIndex++;
		}
		
		if(startIndex == array.length) {
			System.out.println("Already sorted!");
			return;
		}
		
		int endIndex = array.length - 2;
		while(endIndex >= 0) {
			if(array[endIndex] > array[endIndex+1]) {
				break;
			}
			endIndex--;
		}
		
		System.out.println("Initial startIndex: " + startIndex + ",  endIndex: " + endIndex);
		
		//then start to shrink on both sides
		int currMin = Integer.MAX_VALUE;
		int currMax = Integer.MIN_VALUE;
		
		//MUST go to the rest of the array XXXX
		for(int i = startIndex; i < array.length; i++) {
			if(array[i] < currMin) {
				currMin = array[i];
			}
		}
		//MUST go to the beginning of the array XXX
		for(int i = 0; i <= endIndex; i++) {
			if(array[i] > currMax) {
				currMax = array[i];
			}
		}
		
		//start to expand
		int start = -1;
		if(startIndex > 0 ) {
		    for(int i = startIndex - 1; i >=0; i--) {
			    int v = array[i];
			    if(v <= currMin) {
				    System.out.println("start index: " + (i+1));
				    start = i+1;
				    break;
			    } else {
			    	if(v > currMax) {
			    		currMax = v;
			    	}
			    }
		    }
		}
		
		int end = -1;
		if(endIndex < array.length) {
			for(int i = endIndex + 1; i < array.length; i++) {
				int v = array[i];
				if(v >= currMax) {
					System.out.println("end index: " + (i-1));
					end = i - 1;
				    break;
				} else {
			    	if(v < currMin) {
			    		currMin = v;
			    	}
			    }
			} 
		}
		
		for(int i = start; i <= end; i++) {
			System.out.print(array[i] + "  ");
		}
	}
	
	public static void main(String[] ags) {
		Integer[] array = new Integer[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		System.out.println(Utils.dumpArray(array));
		findMinSeq(array);
	}

}
