package linkedin;

import java.util.Stack;

/**
 * Consider this string representation for binary trees. Each node
 * is of the form (lr), where l represents the left child and r represents
 * the right child. If l is the character 0, then there is no left child.
 * Similarly, if r is the character 0, then there is no right child.
 * Otherwise, the child can be a node of the form (lr), and the
 * representation continues recursively. 
For example: (00) is a tree that consists of one node. ((00)0) is
a two-node tree in which the root has a left child, and the left
child is a leaf. And ((00)(00)) is a three-node tree, with a root,
a left and a right child. 

Write a function that takes as input such a string, and returns -1
if the string is malformed, and the depth of the tree if the string
is well-formed. 

For instance: 

find_depth('(00)') -> 0 
find_depth('((00)0)') -> 1 
find_depth('((00)(00))') -> 1 
find_depth('((00)(0(00)))') -> 2 
find_depth('((00)(0(0(00))))') -> 3 
find_depth('x') -> -1 
find_depth('0') -> -1 
find_depth('()') -> -1 
find_depth('(0)') -> -1 
find_depth('(00)x') -> -1 
find_depth('(0p)') -> -1

http://www.careercup.com/question?id=13262681
 * */

/**
 *    t -> (00)
 *    N -> t | (N0) | (NN)
 *    
 *    check whether a string is a valid representation
 * 
 * */
public class ParsingTreeDepth {

	public static boolean isValidTree(String str) {
		//illegal case
		if(str == null || str.length() < 2) {
			return false;
		}
		//check the boundary
		if(!str.startsWith("(") || !str.endsWith(")")) {
			return false;
		}
		String rest = str.substring(1, str.length() - 1);
		if(rest.startsWith("0")) {
			rest = rest.substring(1);
			if(rest.equals("0")) {
				return true;  //the 00 case
			} else {
				return isValidTree(rest);
			}
		} else if (rest.startsWith("(")) {
			//use a stack to find the matching )
			Stack<Character> stack = new Stack<Character>();
			StringBuilder left = new StringBuilder();
			for(char c : rest.toCharArray()) {
				left.append(c);
				if(c == '(') {
					stack.push(c);
				}
				if(c == ')') {
					if(stack.isEmpty()) {
						return false;
					} else {
						stack.pop();
						if(stack.isEmpty()) {
							break;
						}
					}
				}
			}
			String leftPart = left.toString();
			String right = rest.substring(leftPart.length());
			boolean isLeftValid = isValidTree(leftPart);
			boolean isRightValid = right.equals("0") || isValidTree(right);
			return isLeftValid && isRightValid;
		} else {
			return false;
		}
	}
	
	public static int parseTreeDepth(String str) {
		return parseTreeDepthInternal(str);
	}
	
	public static int parseTreeDepthInternal(String str) {
		//illegal case
		if(str == null || str.length() < 2) {
			return -1;
		}
		//check the boundary
		if(!str.startsWith("(") || !str.endsWith(")")) {
			return -1;
		}
		String rest = str.substring(1, str.length() - 1);
		if(rest.startsWith("0")) {
			rest = rest.substring(1);
			if(rest.equals("0")) {
				return 1;
			} else {
				int treeDepth = parseTreeDepthInternal(rest);
				return treeDepth == - 1? -1 : 1 + treeDepth;
			}
		} else if (rest.startsWith("(")) {
			//use a stack to find the matching )
			Stack<Character> stack = new Stack<Character>();
			StringBuilder left = new StringBuilder();
			for(char c : rest.toCharArray()) {
				left.append(c);
				if(c == '(') {
					stack.push(c);
				}
				if(c == ')') {
					if(stack.isEmpty()) {
						return -1;
					} else {
						stack.pop();
						if(stack.isEmpty()) {
							break;
						}
					}
				}
			}
			String leftPart = left.toString();
			String right = rest.substring(leftPart.length());
			int leftDepth = parseTreeDepthInternal(leftPart);
			int rightDepth = right.equals("0") ? 0 : parseTreeDepthInternal(right);
			return 1 + Math.max(leftDepth, rightDepth);
		} else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		String str = "(00)";
		System.out.println(str + " valid? " + isValidTree(str) + ", depth: " + parseTreeDepth(str));
		
		
		str = "((00)0)";
		System.out.println(str + " valid? " + isValidTree(str) + ", depth: " + parseTreeDepth(str));
		
		str = "((00)(00))";
		System.out.println(str + " valid? " + isValidTree(str) + ", depth: " + parseTreeDepth(str));
		
		str = "((00)(0(00)))";
		System.out.println(str + " valid? " + isValidTree(str) + ", depth: " + parseTreeDepth(str));
		
		str = "((00)(0(0(00))))";
		System.out.println(str + " valid? " + isValidTree(str) + ", depth: " + parseTreeDepth(str));
		
		str = "x";
		System.out.println(str + " valid? " + isValidTree(str) + ", depth: " + parseTreeDepth(str));
		
		str = "0";
		System.out.println(str + " valid? " + isValidTree(str) + ", depth: " + parseTreeDepth(str));
		
		str = "()";
		System.out.println(str + " valid? " + isValidTree(str) + ", depth: " + parseTreeDepth(str));
		
		str = "(0)";
		System.out.println(str + " valid? " + isValidTree(str) + ", depth: " + parseTreeDepth(str));
		
		str = "(0p)";
		System.out.println(str + " valid? " + isValidTree(str) + ", depth: " + parseTreeDepth(str));
		
		str = "(00)x";
		System.out.println(str + " valid? " + isValidTree(str) + ", depth: " + parseTreeDepth(str));
		
		str = "(00)(00)(00)";
		System.out.println(str + " valid? " + isValidTree(str) + ", depth: " + parseTreeDepth(str));
		
		str = "(00)(00)";
		System.out.println(str + " valid? " + isValidTree(str) + ", depth: " + parseTreeDepth(str));
	}
}
