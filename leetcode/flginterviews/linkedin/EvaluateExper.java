package linkedin;

import java.util.Stack;


/**
 * Evaluating infix expression: 4 + 2 + 1 = 7
 * 4 + 2*4 = 12
 * */
public class EvaluateExper {
x
	public static int evaluateExpr(String expr) {
		Stack<Character> stack = new Stack<Character>();
		int result = 0;
		for(char c : expr.toCharArray()) {
			
		}
		return result;
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
