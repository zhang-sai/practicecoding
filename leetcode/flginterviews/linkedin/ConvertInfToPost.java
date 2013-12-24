package linkedin;

import java.io.IOException;
import java.util.Stack;

/**
 * Convert and infix expression to postfix expression
 * 
 * 1+2*4/5-7+3/6
 * 
 * => 124*5/+7-36/+
 * */

/**
 * if it is a digit, put to the output
 * if it is (, push to the stack
 * if it is ), pop the stack until the (, and also pop out (
 * 
 * */
class InToPost {
	public static String infixToPostfix(String expr) {
		StringBuilder postfix = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();

		// read in tokens
		for (char c : expr.toCharArray()) {
			if (isDigit(c)) {
				postfix.append(c);
			} else if (isOp(c)) {
				while (isLeftAssociative(c) && !stack.isEmpty()
						&& getPreced(stack.peek()) >= getPreced(c)) {
					postfix.append(stack.pop());
				}
				stack.push(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					postfix.append(stack.pop());
				}
				if (stack.isEmpty()) {
					throw new IllegalArgumentException(
							"mismatched parentheses.");
				}
				stack.pop(); // pop '(' without adding to output
			} else if (c == ' ') {
				// do nothing
			} else {
				throw new IllegalArgumentException("Invalid input.");
			}
		}

		// empty stack
		while (!stack.isEmpty()) {
			char c = stack.pop();
			if (c == '(') {
				throw new IllegalArgumentException("mismatched parentheses.");
			}
			postfix.append(c);
		}

		return postfix.toString();
	}

	static boolean isLeftAssociative(char op) {
		if(op == '+' || op == '-' || op == '*' || op == '/') {
			return true;
		} else if (op == '^') {
			return false;
		}
		throw new IllegalArgumentException("Invalid input.");
	}

	static int getPreced(char op) {
		if(op == '+' || op == '-') {
			return 1;
		} else if (op == '*' || op == '/') {
			return 2;
		} else if (op == '^') {
			return 3;
		} else if (op == '(' || op == ')') {
			return -1;
		}
		throw new IllegalArgumentException("Invalid input.");
	}

	static boolean isDigit(char c) {
		return (c >= '0' && c <= '9');
	}

	static boolean isOp(char c) {
		if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		String input = "1+2*4/5-7+3/6";
		String output = InToPost.infixToPostfix(input);
		/**
		 * 
		 * "3 + 4 - 5" -> "34+5-"    // pop '+' before '-' since they have the same precedence
"3 + 4 * 5" -> "345*+"    // didn't pop '+' until '*' get popped since '*' has higher precedence than '+'
"3^2^2+4" -> "322^^4+"    // didn't pop '^' until '+' comes in since '^' is right-associative
		 * */
		System.out.println("Postfix is " + output + '\n');
	}

}
