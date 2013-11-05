//find a min sequence that m - n is min,
//that if n ~ m is sorted, the whole array is sorted
xx
public class MinSortSequence {
	
	//example: 1, 2, 4, 7, 10, 9, 11
	//sort: 10, 9
	//eg, 1 2 4 7 10 11 7 12 6 7 16 18 19
	//divide it into 3 parts, and then shrink the left and right parts
	public static void findMinSeq(int[] array) {
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
		int currMax = Integer.MIN_VALUE;
		int currMin = Integer.MAX_VALUE;
		
		for(int i = startIndex; i <= endIndex; i++) {
			if(array[i] > currMax) {
				currMax = array[i];
			}
			if(array[i] < currMin) {
				currMin = array[i];
			}
		}
		
		//start to expand
		if(startIndex > 0 ) {
		    for(int i = startIndex - 1; i >=0; i--) {
			    int v = array[i];
			    if(v <= currMin) {
				    System.out.println("start index: " + (i+1));
				    break;
			    } else {
			    	if(v > currMax) {
			    		currMax = v;
			    	}
			    }
		    }
		}
		
		if(endIndex < array.length) {
			for(int i = endIndex + 1; i < array.length; i++) {
				int v = array[i];
				if(v >= currMax) {
					System.out.println("end index: " + (i-1));
				    break;
				} else {
			    	if(v < currMin) {
			    		currMin = v;
			    	}
			    }
			} 
		}
	}
	
	public static void main(String[] ags) {
		int[] array = new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		findMinSeq(array);
	}

}
