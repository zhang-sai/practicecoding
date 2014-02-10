
/**
 * Implement pow(x, n).
 * */
//read the poster here: http://leetcode.com/groups/linkedin-interview-questions/forum/topic/implement-powx-y/
//be aware of the space cost
//see also: 
public class PowXN {
	
	//also see: PowerFunctionWithDouble

	public double pow(double x, int n) {
        if(n > 0) {
            return powPositive(x, n);
        } else if (n == 0) {
            return 1;
        } else {
            return 1 / powPositive(x, -1*n);
        }
    }
    public double powPositive(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0) {
            return 1;
        }
        if(n==1) {
            return x;
        }
        if(n%2 == 0) {
            double v = pow(x, n/2);
            return v*v;
        } else {
            double v = pow(x, n/2);
            return v*v*x;
        }
    }
}
