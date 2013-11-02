
public class TrailingZeroInFactorial {

	public static int numOfZeros(int n) {
		//simply counting the number of 5
		if(n < 0) {
			return -1;
		}
		//count the number of 5s
		int count = 0;
		//see how many divisions of 5
		//e.g., if n = 24,  so that 24/5 == 4 ==> 4 trailiing zeros
		//      if n = 25,  25/5 = 5, and 25/25 = 1 so that trailing zero = 6
		for (int i = 5; n/i > 0; i =i*5) {
			count = count + n/i;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(numOfZeros(1000));
	}
	
}