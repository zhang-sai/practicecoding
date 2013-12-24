package linkedin;

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
public class ParsingTreeDepth {

	public static int parseTreeDepth(String str) {
		//illegal case
		if(str == null || str.length() < 2) {
			return -1;
		}
		//check the boundary
		if(!str.startsWith("(") || !str.endsWith(")")) {
			return -1;
		}
		String rest = str.substring(1, str.length() - 1);
		x
		return -1;
	}
	
	public static void main(String[] args) {
		String str = "(00)";
		System.out.println(parseTreeDepth(str));
		
		str = "((00)0)";
		System.out.println(parseTreeDepth(str));
		
		str = "((00)(00))";
		System.out.println(parseTreeDepth(str));
		
		str = "((00)(0(00)))";
		System.out.println(parseTreeDepth(str));
		
		str = "((00)(0(0(00))))";
		System.out.println(parseTreeDepth(str));
		
		str = "x";
		System.out.println(parseTreeDepth(str));
		
		str = "0";
		System.out.println(parseTreeDepth(str));
		
		str = "()";
		System.out.println(parseTreeDepth(str));
		
		str = "(0)";
		System.out.println(parseTreeDepth(str));
		
		str = "(0p)";
		System.out.println(parseTreeDepth(str));
		
		str = "(00)x";
		System.out.println(parseTreeDepth(str));
	}
}
