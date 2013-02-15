
/**
 * Divide two integers without using multiplication, division and mod operator.
 * */
public class DivideNums {
	public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(divisor > dividend) {
        	return 0;
        }
        if(divisor == 0) {
        	return 0;
        }
        if(divisor == 1) {
        	return dividend;
        }
        if(dividend == 0) {
        	return 0;
        }
        boolean flag = dividend < 0 ? true : false;
        
        int total = divisor;
        int retNum = 1;
        while(total < dividend) {
        	int tmpTotal = total + total;
        	int retRetNum = retNum + retNum;
        	xx
        }
        
        
        return flag ? -1*retNum : retNum;
    }
}