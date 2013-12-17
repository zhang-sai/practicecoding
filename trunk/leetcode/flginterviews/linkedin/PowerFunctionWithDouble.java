package linkedin;

/**
 * implement Java's pow function, then list test cases, 
 * examine performance, see if you can optimize performance. 

public double pow(double a, int b)

http://www.careercup.com/question?id=14959760
 * */
public class PowerFunctionWithDouble {

	public static double pow(double a, int b) {
		if(a == 0 && b == 0)
            return Integer.MIN_VALUE;
        
        if(a == 0) //if b < 0, then throw new exception
            return 0;

        if(b == 0)
            return 1;
        
        if(b == 1)
            return a;

        boolean aMinus = a < 0? true: false;
        boolean bMinus = b < 0? true : false;

        int bAbs = Math.abs(b);
        double aAbs = Math.abs(a);
        
        //check if b is odd
        
        
        double half = pow(aAbs, bAbs/2);
        double tempAnswer = bAbs % 2 == 0 ? half*half : half*half*aAbs;
        

        if(bMinus)
            tempAnswer = 1.0 / tempAnswer;
        if(aMinus && (b % 2 == 1))
            tempAnswer *= -1;

        return tempAnswer;
	}
	
	public static void main(String[] args) {
		System.out.println(pow(2.1, 2));
		System.out.println(pow(2.1, -2));
	}
	
}
