
//2.18
//the sum of each parts are as close as possible
public class DividAnArrayIntoTwoPart {

	
	//a better way
	public void divide(int[] a) {
		int sum = 10; //sum of array
		boolean[][] isOK = new boolean[a.length][sum];
		//is it possible to pick from 0 --- i number , and its sum is sum
		
		//isOK[i][sum] == isOK[j][sum] || isOK[j][sum - a[i]]
	}
}
