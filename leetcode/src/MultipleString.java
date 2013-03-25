
/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.

» Solve this problem
 * */
public class MultipleString {

	 public String multiply(String num1, String num2) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int[] n1 = new int[num1.length()];
	        for(int i = 0; i < num1.length(); i++) {
	        	n1[i] = num1.charAt(i) - '0';
	        }
	        int[] n2 = new int[num2.length()];
	        for(int i = 0; i < num2.length(); i++) {
	        	n2[i] = num2.charAt(i) - '0';
	        }
	        //the result
	        int[] result = new int[num1.length() + num2.length()];
	        
	        //multiple two large numbers
	        for(int i = n2.length - 1; i >=0; i--) {
	        	//the starting point in the result array
	        	int v2 = n2[i];
	        	int startPoint = result.length - 1 - (n2.length - 1 - i);
	        	int carrier = 0;
	        	for(int j = n1.length - 1; j >= 0; j--) {
	        		int index = startPoint - (n1.length - 1 - j);
	        		int v1 = n1[j];
	        		
//	        		System.out.println("i: " + i + ": " + v2 + ", j: " + j + ": " + v1 + ", carrier: " + carrier);
	        		
	        		int finalValue = v1*v2 + carrier + result[index];
	        		carrier = finalValue/10;
	        		result[index] = finalValue % 10;
	        		//update the last
	        		if(j == 0) {
	        			if(carrier > 0) {
	        				result[index - 1] = carrier;
	        			}
	        		}
	        	}
//	        	this.printArray(result);
	        }
	        
	        //convert to the result
	        StringBuilder sb = new StringBuilder();
	        boolean zero = true;
	        for(int i : result) {
	        	if(i != 0 && zero) {
	        		zero = false;
	        	}
	        	if(!zero) {
	        	    sb.append(i);
	        	}
	        }
	        if(sb.length() == 0) {
	        	sb.append("0"); //all ZERO
	        }
	        return sb.toString();
	    }
	 
	 public static void main(String[] args) {
		 MultipleString ms = new MultipleString();
		 System.out.println(ms.multiply("98", "9")); //882
	 }
	 
	 private void printArray(int[] array) {
		 for(int i : array) {
			 System.out.print(i + "  ");
		 }
		 System.out.println();
	 }
}
