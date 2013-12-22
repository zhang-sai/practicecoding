package basics;

public class CheckPrime {

	public boolean isPrime(int n) {
		if (n < 2)
			return false; // prime must >=2
		if (n == 2)
			return true;
		if ((n & 1) == 0)
			return false; // prime must not be even

		int rootN = (int) Math.sqrt(n);
		for (int i = 2; i <= rootN; ++i) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
