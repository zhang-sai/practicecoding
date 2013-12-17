package linkedin;



public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     TreeNode(int x) { val = x; }
     public String toString() {return val + ""; }
     
     int elem = 0;
     TreeNode parent;
     TreeNode succ;
}