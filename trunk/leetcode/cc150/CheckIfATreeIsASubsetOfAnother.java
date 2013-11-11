x
/**
 * T1 is a huge tree, T2 is a small tree
 * check whether T2 is a subtree of T1
 * */
public class CheckIfATreeIsASubsetOfAnother {

	//do a rough processing to check the number of decscends
	//then do the exact match
	
	public static TreeNode isSubset(TreeNode lt, TreeNode st) {
		return null;
	}
	
	public static boolean isIdentical(TreeNode n1, TreeNode n2) {
		
	}
	
	public static int getNumberOfNodes(TreeNode n) {
		if(n == null) {
			return 0;
		}
		int count = 1;
		if(n.left != null) {
			count += getNumberOfNodes(n.left);
		}
		if(n.right != null) {
			count += getNumberOfNodes(n.right);
		}
		return count;
	}
	
	public static void main(String[] args) {
		
	}
}