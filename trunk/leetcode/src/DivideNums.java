
/**
 * Divide two integers without using multiplication, division and mod operator.
 * */
//XXX be aware of overflow, abs(min-int) = abs(max-int) + 1
//one way is to use log(a/b) = loga - logb
//xx
XXX
public class DivideNums {
	public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
		//some special cases
        if(divisor == 0 || dividend == 0) {
        	return 0;
        }
        if(divisor == 1) {
        	return dividend;
        } else if (divisor == -1) {
        	return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -1*dividend;
        }
        //need to pay attention to the sign
        //flag = true => positive
        //flag = false => negative
        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        
        int div1;
        if (dividend == Integer.MIN_VALUE) { //XXX this is critical
        	div1 = Integer.MAX_VALUE;
        } else {
        	div1 = Math.abs(dividend);
        }
        	 
        int div2;
        if (divisor == Integer.MIN_VALUE) {
        	div2 = Integer.MAX_VALUE;
        } else {
        	div2 = Math.abs(divisor);
        }
        //calculate the result of: div1/div2
        
        int retNum = 0;
        if(div1 < div2) {
        	retNum = 0;
        } else if (div1 == div2) {
        	retNum = 1;
        } else {
        	//search div1 > div2
        	
        	int td = Math.abs(divisor);
            int count = 1;
            while((dividend - td) >= 0){
                td = td *2;
                count = count*2;
            }
     
            int ret = 0;
            while (dividend > 0){
                if ((dividend - td) >= 0){
                    dividend -= td;
                    ret += count;
                }
                count >>= 1;
                td >>= 1;
            }
            
            return ret*(divisor > 0? 1 : -1);
        }
        
        return sign*retNum;
    }
	
	public static void main(String[] args) {
		DivideNums dn = new DivideNums();
		System.out.println(dn.divide(2147483647, 2));
	}
}