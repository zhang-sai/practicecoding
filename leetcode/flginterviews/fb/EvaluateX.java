package fb;

/**
 * Given an expression (in single variable) like 4x+13(x-(4x+x/3)) = 9, evaluate x 
The expression is a string and the variable is always x.
 * */
xx
public class EvaluateX {

	
	
}

class Node {
	
}

class Symbol extends Node {
	
}

class XNode extends Node {
	int param;
	int xparam;
	
	public XNode(int param, int xparam) {
		this.param = param;
		this.xparam = xparam;
	}
}
