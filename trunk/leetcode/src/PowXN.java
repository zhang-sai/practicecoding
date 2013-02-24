
/**
 * Implement pow(x, n).
 * */
public class PowXN {

	public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		if(x == 1.0d) {
			return 1.0d;
		}
		if(n == 0) {
			return 1;
		}
		if(n == 1) {
			return x;
		}
		boolean flag = n < 0 ? true : false;
		n = Math.abs(n);
		
		if(n % 2 == 1) {
			double p = pow(x, n/2);
			double v = p*p*x;
			return flag ? 1/v : v;
		} else {
			double p = pow(x, n/2);
			double v = p*p;
			return flag ? 1/v : v;
		}
		
    }
}
