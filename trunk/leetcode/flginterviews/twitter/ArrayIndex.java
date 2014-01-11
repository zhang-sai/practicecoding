package twitter;

public class ArrayIndex {

	public int solution(int[] a) {
        // write your code in Java SE 6
        if(a == null || a.length == 0) {
            throw new Error("a cannot be null or empty.");
        }
        //compute the sum of the array
        //this may overflow
        int sum = 0;
        for(int num : a) {
            sum += num;
        }
        //keep track the sum so far to the current index
        int sumSoFar = 0;
        for(int i = 0; i < a.length; i++) {
        	//check whether i is the desired index
        	if(sumSoFar == sum - a[i] - sumSoFar) {
        		return i;
        	}
            sumSoFar += a[i];
        }
        //cannot find one
        return -1;
    }
	
	public static void main(String[] args) {
		ArrayIndex a = new ArrayIndex();
		System.out.println(a.solution(new int[]{-1, 1}));
	}
	
}
