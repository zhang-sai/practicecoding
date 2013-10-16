/**
 * 
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

 * */
public class ReverseInteger {

	public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x == 0) {
			return x;
		}
		boolean flag = x > 0 ? true : false;
		if(!flag) { //XXX do not forget it
            x = -x;
        }
		int returnNum = 0;
		
		while(x/10 != 0) {
			int lastNum = x%10;
			returnNum = returnNum*10 + lastNum;
			x = x/10;
		}
		
		returnNum = returnNum*10 + x;
		
        return flag ? returnNum : -1*returnNum;
    }
	
}
