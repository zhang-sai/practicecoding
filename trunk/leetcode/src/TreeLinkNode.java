
public class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) {
		val = x;
	}
	
	public String toString() {
		return this.printNode(this, 0);
	}
	
	private String printNode(TreeLinkNode node, int indent) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < indent; i++) {
			sb.append(" ");
		}
		if(node == null) {
			sb.append("null");
			return sb.toString();
		}
		sb.append("val: " + node.val + ", left: " + (node.left == null ? "null" : node.left.val)
				+ ", right: " + (node.right == null ? "null" : node.right.val)
				+ ", next: " + (node.next == null ? "null" : node.next.val));
		sb.append("\n");
		String left = printNode(node.left, indent + 4);
		sb.append(left);
		sb.append("\n");
		String right = printNode(node.right, indent + 4);
		sb.append(right);
		sb.append("\n");
		
		return sb.toString();
	}
}
