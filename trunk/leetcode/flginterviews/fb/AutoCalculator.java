package fb;

/**
 * Given a list of integer numbers, a list of symbols [+,-,*,/] and a target
 * number N, provide an expression which evaluates to N or return False
 * if that is not possible. 
e.g. let the list of numbers be [1,5,5] and the target number is 9,
one possible solution could be 5+5-1.
 * 
 * http://www.careercup.com/question?id=15466752
 * */

public class AutoCalculator {
	
	static class CalNode {
		int val;
		int pred = 0;
		String str = null;
		CalNode(int v) {
			val = v;
		}
		public int getValue() {
			return val;
		}
		public String toExpr() {
			if(str == null) {
				return val + "";
			}
			return str;
		}
	}

//	public static void printSolutions(int[] nums, int target) {
//		x
//	}
	
	public static boolean computeValue(int[] nums, int target) {
		CalNode[] nodes = new CalNode[nums.length];
		for(int i = 0; i < nodes.length; i++) {
			nodes[i] = new CalNode(nums[i]);
		}
		return computeValue(nodes, target);
	}
	
	public static boolean computeValue(CalNode[] nodes, int target) {
		if(nodes.length == 1) {
			if(nodes[0].getValue() == target) {
				System.out.println(nodes[0].toExpr());
				return true;
			}
			return false;
		}
		for(int i = 0; i < nodes.length; i++) {
			for(int j = i + 1; j < nodes.length; j++) {
				//the rest numbers
				CalNode[] rest = new CalNode[nodes.length - 1];
				int index = 0;
				for(int k = 0; k < nodes.length; k++) {
					if(k == i || k == j) {
						continue;
					}
					rest[index++] = nodes[k];
				}
				CalNode a = nodes[i];
				CalNode b = nodes[j];
				rest[index] = plus(a, b);
				if(computeValue(rest, target)) {
					return true;
				}
				rest[index] = minus(a, b);
				if(computeValue(rest, target)) {
					return true;
				}
				rest[index] = minus(b, a);
				if(computeValue(rest, target)) {
					return true;
				}
				rest[index] = multi(a, b);
				if(computeValue(rest, target)) {
					return true;
				}
				if(b.getValue() != 0) {
				    rest[index] = div(a, b);
				    if(computeValue(rest, target)) {
//					    System.out.println(a + " / " + b);
					    return true;
				    }
				}
				if(a.getValue() != 0) {
				    rest[index] = div(b, a);
				    if(computeValue(rest, target)) {
//					    System.out.println(b + " - " + a);
					    return true;
				    }
				}
			}
		}
		return false;
	}
	
	public static CalNode plus(CalNode a, CalNode b) {
		CalNode node = new CalNode(a.getValue() + b.getValue());
		node.str = a.toExpr()+ "+" + b.toExpr();
		node.pred = 1;
		return node;
	}
	
	public static CalNode minus(CalNode a, CalNode b) {
		CalNode node = new CalNode(a.getValue() - b.getValue());
		node.str = a.toExpr()+ "-" + b.toExpr();
		node.pred = 1;
		return node;
	}
	
	
	public static CalNode multi(CalNode a, CalNode b) {
		CalNode node = new CalNode(a.getValue() * b.getValue());
		String s = "";
		if(a.pred == 1) {
			s += "(" + a.toExpr()+ ")*";
		} else {
			s += a.toExpr() + "*";
		}
		if(b.pred == 1) {
			s += "(" + b.toExpr() + ")";
		} else {
			s += b.toExpr() ;
		}
		node.str = s;
		node.pred = 2;
		return node;
	}
	
	public static CalNode div(CalNode a, CalNode b) {
		CalNode node = new CalNode(a.getValue() / b.getValue());
//		node.str = "(" + a.toExpr()+ ")/(" + b.toExpr() + ")";
		
		String s = "";
		if(a.pred == 1) {
			s += "(" + a.toExpr()+ ")/";
		} else {
			s += a.toExpr() + "/";
		}
		if(b.pred == 1) {
			s += "(" + b.toExpr() + ")";
		} else {
			s += b.toExpr() ;
		}
		node.str = s;
		
		node.pred = 2;
		return node;
	}
	
	public static void main(String[] args) {
		//computeValue(new int[]{7, 9, 8, 9}, 24);
		int count = 0;
		int total = 0;
		for(int i = 1; i <=9; i++) {
			for(int j = i; j <=9; j++) {
				for(int k = j; k <=9; k++) {
					for(int l = k; l <=9; l++) {
						if(computeValue(new int[]{i, j, k, l}, 24)) {
							count++;
						}
						total++;
					}
				}
			}
		}
		System.out.println("Num: " + total + ", solvlable: " + count);
	}
}
