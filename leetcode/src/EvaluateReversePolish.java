import java.util.Stack;


public class EvaluateReversePolish {

	public static int evalRPN(String[] tokens) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Stack<String> stack = new Stack<String>();
        // Integer value = null;
        for(int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                Integer v1 = Integer.parseInt(stack.pop());
                Integer v2 = Integer.parseInt(stack.pop());
                
                int value = -1;
                if(s.equals("+")) {
                    value = v1 + v2;
                } else if(s.equals("-")) {
                    value = v2 - v1;
                } else if(s.equals("*")) {
                    value = v1 * v2;
                } else {
                    value = v2 / v1;
                }
                if(i == tokens.length - 1) {
                    return value;
                } else {
                    stack.push(value + "");
                }
                //then return value
            } else {
            	//if it is the only value
                if(i == tokens.length - 1) {
                    return Integer.parseInt(s);
                }
                stack.push(s);
            }
        }
        
        return -1;
    }
	
}
