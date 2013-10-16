
/**
 * Divide two integers without using multiplication, division and mod operator.
 * */
//XXX be aware of overflow, abs(min-int) = abs(max-int) + 1
//one way is to use log(a/b) = loga - logb
//xx
//XXX
public class DivideNums {
	public int divide(int dividend, int divisor) {      
        if(dividend==divisor) {
            return 1;
        }
        if(divisor==1) {
            return dividend;
        }
        //since we have already check dividend = MIN_VALUE case
        if(divisor==Integer.MIN_VALUE) {
            return 0;
        }

        boolean sign = false;
        int count=1, res=0;        
        if(divisor<0 && dividend<0){
            //avoid overflow here
            if(dividend==Integer.MIN_VALUE){
                dividend -= divisor;
                res++;
            }
        } else if(divisor<0 || dividend<0){
            if(dividend==Integer.MIN_VALUE){
                dividend += divisor;
                res++;
            }
            sign=true;            
        }

        dividend=Math.abs(dividend);
        divisor=Math.abs(divisor);

        int savedDivisor=divisor;
        int rem=dividend; //the remaining value
        while(rem >= savedDivisor){
            rem = dividend - divisor;
            if(rem<0){
                divisor = savedDivisor;
                rem = dividend - divisor;
                count = 1;
            }
            res += count;
            divisor +=divisor;
            count += count;
            dividend = rem;
        }
        //no multiplication here
        if(sign) {
            return 0-res;
        }
        return res;
    }
	
	public static void main(String[] args) {
		DivideNums dn = new DivideNums();
		System.out.println(dn.divide(2147483647, 2));
	}
}