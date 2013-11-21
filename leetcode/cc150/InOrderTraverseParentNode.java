

public class InOrderTraverseParentNode {
	//some basic ideas
	public TreeNode getNext(TreeNode node) {
		
		//note that the code has already traverse to that particular node
	//so no need to go left
		if(node.right != null) {
			TreeNode n = node.right;
			while(n.left != null) {
				n = n.left;
			}
			return n;
		} else {
			//go up until node.parent.left = node
			TreeNode parent = node.parent;
			while(parent != null) {
				if(parent.left == node) {
					break;
				}
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
		
	}
	
}
