import java.util.ArrayList;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * */
public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> retList = new ArrayList<Integer>();
        if(n == 0) {
        	retList.add(0); //XXX the case for zero
        	return retList;
        }
        if(n == 1) {
        	retList.add(0);
        	retList.add(1);
        	return retList;
        }
        //
        ArrayList<Integer> prevList = this.grayCode(n - 1);
        retList.addAll(prevList);
        for(int index = prevList.size() - 1; index >= 0; index--) {
        	int v = prevList.get(index);
        	retList.add(v + (int)Math.pow(2, n - 1));
        }
        
        return retList;
    }
}
