package basics;

//swap the i-th and j-th bit of an integer number
public class SwapTwoBits {

	/**
	 * If two bits are same, x ^ y is 0 and (0,1) XOR 0 is the bit itself. Otherwise, x ^ y is 1 and (0,1) XOR 1 is (1,0)

     x' = x ^ ( x ^ y ) 
     y' = y ^ ( x ^ y )
	 * */
	int swap(int num, int i, int j)	{
	 int xor = ((num>>i) ^ (num>>j)) & 1;
	 return num ^ (xor<<i) ^ (xor<<j);
	}
}
