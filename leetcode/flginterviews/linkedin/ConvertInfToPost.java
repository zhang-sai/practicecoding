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



class InToPost {
	private Stack<Character> theStack;
	private String input;
	private String output = "";

	public InToPost(String in) {
		input = in;
		theStack = new Stack<Character>();
	}

	public String doTrans() {
		for (char ch : input.toCharArray()) {
			switch (ch) {
			case '+':
			case '-':
				gotOper(ch, 1);
				break;
			case '*':
			case '/':
				gotOper(ch, 2);
				break;
			case '(':
				theStack.push(ch);
				break;
			case ')':
				gotParen(ch);
				break;
			default:
				output = output + ch;
				break;
			}
			
			System.out.println(output + "    " + theStack);
		}
//		System.out.println(theStack);
		while (!theStack.isEmpty()) {
			output = output + theStack.pop();
		}
		System.out.println(output);
		return output;
	}

	public void gotOper(char opThis, int prec1) {
		while (!theStack.isEmpty()) {
			char opTop = theStack.pop();
			if (opTop == '(') {
				theStack.push(opTop);
				break;
			} else {
				int prec2;
				if (opTop == '+' || opTop == '-')
					prec2 = 1;
				else
					prec2 = 2;
				if (prec2 < prec1) {
					theStack.push(opTop);
					break;
				} else
					output = output + opTop;
			}
		}
		theStack.push(opThis);
	}

	public void gotParen(char ch) {
		while (!theStack.isEmpty()) {
			char chx = theStack.pop();
			if (chx == '(')
				break;
			else
				output = output + chx;
		}
	}

	public static void main(String[] args) throws IOException {
		String input = "1+2*4/5-7+3/6";
		String output;
		InToPost theTrans = new InToPost(input);
		output = theTrans.doTrans();
		System.out.println("Postfix is " + output + '\n');
	}

	
}
