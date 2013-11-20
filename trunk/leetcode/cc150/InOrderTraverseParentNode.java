

public class InOrderTraverseParentNode {
xx
	//some basic ideas
	public TreeNode getNext(TreeNode node) {
		
		if(node.left != null) {
			TreeNode n = node;
			while(n.left != null) {
				n = n.left;
			}
			return n;
		} else if(node.right != null) {
			return getNext(node.right);
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
