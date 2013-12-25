package linkedin;

import java.util.Stack;


/**
 * Evaluating infix expression: 4 + 2 + 1 = 7
 * 4 + 2*4 = 12
 * */
public class EvaluateExper {

	public static int evaluateExpr(String expr) {
		Stack<Character> opStack = new Stack<Character>();
		Stack<Integer> numStack = new Stack<Integer>();
		
//		int result = 0;
		for(char c : expr.toCharArray()) {
			if(isDigit(c)) {
				numStack.push(c - '0');
			} else if (isSign(c)) {
				if(opStack.isEmpty()) {
					opStack.push(c);
				} else {
					//check the first character in the peek
					char prevSign = opStack.peek();
					if(getPred(prevSign) >= getPred(c)) {
						opStack.pop(); //pop the previous sign
						int v1 = numStack.pop();
						int v2 = numStack.pop();
						int v = compute(prevSign, v2, v1);
						numStack.push(v);
						opStack.push(c);
					} else {
						opStack.push(c);
					}
				}
			} else {
				throw new Error("");
			}
		}
		
		//compute the result
		int result = 0;
		if(opStack.isEmpty()) {
			result = numStack.pop(); //get the result
		} else {
			while(!opStack.isEmpty()) {
				int v1 = numStack.pop();
				int v2 = numStack.pop();
				char sign = opStack.pop();
				int v = compute(sign, v2, v1);
				result = v;
				numStack.push(v);
			}
		}
		
		
		return result;
	}

   static int compute(char sign, int v1, int v2) {
	   if(sign == '+') {
		   return v1+v2;
	   } else if (sign == '-') {
		   return v1 - v2;
	   } else if (sign == '*') {
		   return v1*v2;
	   } else {
		   return v1/v2;
	   }
   }

    static boolean isDigit(char c) {
    	return c >= '0' && c <= '9';
    }
    
    static boolean isSign(char c) {
    	return c == '+' || c == '-' || c == '*' || c== '/';
    }
    
    static int getPred(char c) {
    	if(!isSign(c)) {
    		throw new Error();
    	}
    	return c=='+' || c == '-' ? 1 : 2;
    }
	
	public static void main(String[] args) {
		String expr = "4+2-3";
		System.out.println(evaluateExpr(expr));
		
		expr = "4+2*3";
		System.out.println(evaluateExpr(expr));
		
		expr = "4*2-3";
		System.out.println(evaluateExpr(expr));
	}
	
}
