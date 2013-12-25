package fb;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Given an expression (in single variable) like 4x+13(x-(4x+x/3)) = 9,
 * evaluate x The expression is a string and the variable is always x.
 * */

public class EvaluateX {

	public static void evaluate(String s) {
		System.out.println("Evaluating: " + s);
		Queue<Node> q = parseExpr(s);
		System.out.println(q);
		//start evaluation
		Stack<Symbol> opStack = new Stack<Symbol>();
		Stack<XNode> numStack = new Stack<XNode>();
		
		for(Node n : q) {
			if(n instanceof Symbol) {
				Symbol sym = (Symbol)n;
				if(sym.sign == '(') {
					opStack.push(sym);
				} else if (sym.sign == ')') {
					//XXX pop out
					while(opStack.peek().sign != '(') {
						Symbol sign = opStack.pop();
						XNode n1 = numStack.pop();
						XNode n2 = numStack.pop();
						XNode newNode = compute(n2, n1, sign);
						numStack.push(newNode);
					}
					opStack.pop(); //pop out '('
				} else {
					//other sign
					if(opStack.isEmpty()) {
						opStack.push(sym);
					} else {
						Symbol prevSign = opStack.peek();
						if(prevSign.getPred() >= sym.getPred()) {
							//do calculation now
							opStack.pop();
							XNode n1 = numStack.pop();
							XNode n2 = numStack.pop();
							XNode newNode = compute(n2, n1, prevSign);
							numStack.push(newNode);
							opStack.push(sym);
						} else {
							opStack.push(sym);
						}
					}
				}
			} else if (n instanceof XNode) {
				numStack.push((XNode)n);
			} else {
				throw new Error();
			}
		}
		
		if(opStack.isEmpty()) {
			XNode x = numStack.peek();
			System.out.println(x);
			return;
		} else {
			while(!opStack.isEmpty()) {
				Symbol op = opStack.pop();
				XNode n1 = numStack.pop();
				XNode n2 = numStack.pop();
				XNode newNode = compute(n2, n1, op);
				numStack.push(newNode);
			}
			XNode r = numStack.peek();
			System.out.println(r);
			return;
		}
	}
	
	private static Queue<Node> parseExpr(String s) {
		Queue<Node> q = new LinkedList<Node>();
		char[] cs = s.toCharArray();
		int index = 0;
		while(index < cs.length) {
			char c = cs[index];
			if(isX(c)) {
				XNode node = new XNode(0, 1);
				q.add(node);
				index++;
			} else if (isSign(c)) {
				Symbol node = new Symbol(c);
				q.add(node);
				index++;
			} else if (isDigit(c)) {
				if(index < cs.length - 1 && isX(cs[index+1])) {
					XNode node = new XNode(0, cs[index] - '0');
					q.add(node);
					index ++;
					index ++;
				} else {
					XNode node = new XNode(c - '0', 0);
					q.add(node);
					index ++;
				}
			} else {
				throw new Error();
			}
		}
		return q;
	}
	
	private static boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
	
	private static boolean isX(char c) {
		return c == 'x';
	}
	
	private static boolean isSign(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/'
			|| c == '(' || c == ')';
	}
	
	private static XNode compute(XNode a, XNode b, Symbol c) {
		if(c.sign == '+') {
			return plus(a, b);
		} else if (c.sign == '-') {
			return minus(a, b);
		} else if (c.sign == '*') {
			return multi(a, b);
		} else if (c.sign == '/') {
			return div(a, b);
		} else {
			throw new Error(c.toString());
		}
	}
	
	private static XNode plus(XNode a, XNode b) {
		XNode newNode = new XNode(a.param + b.param, a.xparam + b.xparam);
		return newNode;
	}
	
    private static XNode minus(XNode a, XNode b) {
    	XNode newNode = new XNode(a.param - b.param, a.xparam - b.xparam);
		return newNode;
	}
    
    private static XNode multi(XNode a, XNode b) {
		if(a.xparam != 0 && b.xparam != 0) {
			throw new Error("Unsupported: " + a + " * " + b);
		}
		if(a.xparam == 0) {
			return new XNode(a.param*b.param, a.param*b.xparam);
		} else {
			return new XNode(b.param*a.param, b.param*a.xparam);
		}
	}
    
    private static XNode div(XNode a, XNode b) {
		if(b.xparam != 0 || b.param == 0) {
			throw new Error("Unsupported: " + b);
		}
		return new XNode(a.param/b.param, a.xparam/b.param);
	}

	public static void main(String[] args) {
		String str = "4x+3*(x-(4x+2x)/3)";
		
		evaluate(str);
	}
	
}



class Node {
	
}

class Symbol extends Node {
	final char sign;
	//+ -> 1   - -> 2 * -> 3 / -> 4 ( -> 5  ) ->6
	public Symbol(char sign) {
		this.sign = sign;
	}
	public String toString() {
		return sign + "";
	}
	
	public int getPred() {
		if(sign == '+' || sign == '-') {
			return 1;
		} else if (sign == '*' || sign == '/') {
			return 2;
		} else {
			return -1; //( and )
		}
	}
}

class XNode extends Node {
	final int param;
	final int xparam;
	
	public XNode(int param, int xparam) {
		this.param = param;
		this.xparam = xparam;
	}
	
	public String toString() {
		return (param != 0 ? param + "" : "")
		    + (xparam != 0 ? xparam + "x" : "");
	}
	
}
