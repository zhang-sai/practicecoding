import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class BinaryTreePreOrderPostOrderTraversal {

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root != null) {
            stack.push(root);
        }
        
        while(!stack.isEmpty()) {
            TreeNode top = stack.pop();
            list.add(0, top.val);
            if(top.left != null) {
                stack.push(top.left);
            }
            if(top.right != null) {
                stack.push(top.right);
            }
        }
        
        return list;
    }
	
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null)
        queue.add(root);
        
        while(!queue.isEmpty()) {
            TreeNode top = queue.remove(0);
            list.add(top.val);
            if(top.right != null) {
                queue.add(0, top.right);
            }
            if(top.left != null) {
                queue.add(0, top.left);
            }
            
        }
        
        return list;
        
    }
}
