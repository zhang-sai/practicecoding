import java.util.ArrayList;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
XXX
 * */

//one sample solution: https://gist.github.com/xiaonanz/4013895
//XX
public class RecoverBinaryTree {
	
	//a const space solution
	//http://fisherlei.blogspot.com/2012/12/leetcode-recover-binary-search-tree.html
//	XXX
	public void recoverTree(TreeNode root) {
        if(root == null) {
			return;
		}
		List<TreeNode> list = this.inorder(root);
// 		System.out.println(list);
		TreeNode n1 = null;
		TreeNode n2 = null;
		for(int i = 0; i < list.size() - 1; i++) {
			if(list.get(i).val > list.get(i + 1).val) {
				n1 = list.get(i);
				break; //XXX do not forget break; other wise will be in
				//trouble, e.g., 3, 2, 1  ==> 3, and 1 are swapped
			}
		}
		for(int i = list.size() - 1; i >0; i --) {
			if(list.get(i).val < list.get(i - 1).val) {
				n2 = list.get(i);
				break;
			}
		}
		
// 		System.out.println(n1);
// 		System.out.println(n2);
		
		int tmp = n1.val;
		n1.val = n2.val;
		n2.val = tmp;
        
    }
	
	List<TreeNode> inorder(TreeNode node) {
		List<TreeNode> arrayList = new ArrayList<TreeNode>();
		if(node.left != null) {
			arrayList.addAll(this.inorder(node.left));
		}
		arrayList.add(node);
		if(node.right != null) {
			arrayList.addAll(this.inorder(node.right));
		}
		return arrayList;
	}
	
	public static void main(String[] args) {
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n1 = new TreeNode(1);
		n2.left = n3;
		n2.right = n1;
		RecoverBinaryTree rbt = new RecoverBinaryTree();
		rbt.recoverTree(n2);
		
		System.out.println(n2.val);
	}
}
