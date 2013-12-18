package basics;

public class FindAllPrimes {

	public static void printPrimes(int n) {
		boolean[] flags = new boolean[n + 1];
		for(int i = 0; i < flags.length; i++) {
			flags[i] = true;
		}
		flags[0] = false;
		flags[1] = false;
		//prune out the non-prime
		//only 2 --- sqrt(n)
		for(int i = 2; i <= Math.sqrt(n); i++) {
			//i is still a prime
			//if i is not a prime, all its multiplication has already been crossed
			if(flags[i]) {
				int j = i*i;
				while(j <= n) {
					flags[j] = false;
					j = j + i;
				}
			}
		}
		
		//print the primes
		for(int i = 0; i < flags.length; i++) {
			if(flags[i]) {
				System.out.print(i + "   ");
			}
		}
	}
	
	public static void main(String[] args) {
		printPrimes(1000);
	}
	
}
