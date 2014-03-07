

//here: http://leetcode.com/2010/09/how-to-pretty-print-binary-tree.html


//import java.util.LinkedList;
//import java.util.Queue;
//
//
//public class PrettyPrintBST {
//
//	void printBranches(int branchLen, int nodeSpaceLen, int startLen,
//			int nodesInThisLevel, deque<BinaryTree*>& nodesQueue) {
//		  deque<BinaryTree*>::const_iterator iter = nodesQueue.begin();
//		  for (int i = 0; i < nodesInThisLevel / 2; i++) {  
//		    out << ((i == 0) ? setw(startLen-1) : setw(nodeSpaceLen-2)) << "" << ((*iter++) ? "/" : " ");
//		    out << setw(2*branchLen+2) << "" << ((*iter++) ? "\\" : " ");
//		  }
//		  out << endl;
//		}
//		 
//		// Print the branches and node (eg, ___10___ )
//		void printNodes(int branchLen, int nodeSpaceLen, int startLen,
//				int nodesInThisLevel, const deque<BinaryTree*>& nodesQueue, ostream& out) {
//		  deque<BinaryTree*>::const_iterator iter = nodesQueue.begin();
//		  for (int i = 0; i < nodesInThisLevel; i++, iter++) {
//		    out << ((i == 0) ? setw(startLen) : setw(nodeSpaceLen)) << "" << ((*iter && (*iter)->left) ? setfill('_') : setfill(' '));
//		    out << setw(branchLen+2) << ((*iter) ? intToString((*iter)->data) : "");
//		    out << ((*iter && (*iter)->right) ? setfill('_') : setfill(' ')) << setw(branchLen) << "" << setfill(' ');
//		  }
//		  out << endl;
//		}
//		 
//		// Print the leaves only (just for the bottom row)
//		void printLeaves(int indentSpace, int level, int nodesInThisLevel,
//				deque<BinaryTree*>& nodesQueue) {
//		  deque<BinaryTree*>::const_iterator iter = nodesQueue.begin();
//		  for (int i = 0; i < nodesInThisLevel; i++, iter++) {
//		    out << ((i == 0) ? setw(indentSpace+2) : setw(2*level+2)) << ((*iter) ? intToString((*iter)->data) : "");
//		  }
//		  out << endl;
//		}
//		 
//		// Pretty formatting of a binary tree to the output stream
//		// @ param
//		// level  Control how wide you want the tree to sparse (eg, level 1 has the minimum space between nodes, while level 2 has a larger space between nodes)
//		// indentSpace  Change this to add some indent space to the left (eg, indentSpace of 0 means the lowest level of the left node will stick to the left margin)
//		void printPretty(TreeNode root, int level, int indentSpace) {
//		  int h = maxHeight(root);
//		  int nodesInThisLevel = 1;
//		 
//		  int branchLen = 2*((int)Math.pow(2.0,h)-1) - (3-level)*(int)Math.pow(2.0,h-1);  // eq of the length of branch for each node of each level
//		  int nodeSpaceLen = 2 + (level+1)*(int)Math.pow(2.0,h);  // distance between left neighbor node's right arm and right neighbor node's left arm
//		  int startLen = branchLen + (3-level) + indentSpace;  // starting space to the first node to print of each level (for the left most node of each level only)
//		   
//		  Queue<TreeNode> nodesQueue = new LinkedList<TreeNode>();
//		  nodesQueue.offer(root);
//		  for (int r = 1; r < h; r++) {
//		    printBranches(branchLen, nodeSpaceLen, startLen, nodesInThisLevel, nodesQueue);
//		    branchLen = branchLen/2 - 1;
//		    nodeSpaceLen = nodeSpaceLen/2 + 1;
//		    startLen = branchLen + (3-level) + indentSpace;
//		    printNodes(branchLen, nodeSpaceLen, startLen, nodesInThisLevel, nodesQueue);
//		 
//		    for (int i = 0; i < nodesInThisLevel; i++) {
//		      TreeNode currNode = nodesQueue.peek();
//		      nodesQueue.poll();
//		      if (currNode != null) {
//		       nodesQueue.offer(currNode.left);
//		       nodesQueue.offer(currNode.right);
//		      } else {
//		        nodesQueue.offer(null);
//		        nodesQueue.offer(null);
//		      }
//		    }
//		    nodesInThisLevel *= 2;
//		  }
//		  printBranches(branchLen, nodeSpaceLen, startLen, nodesInThisLevel, nodesQueue);
//		  printLeaves(indentSpace, level, nodesInThisLevel, nodesQueue);
//		}
//	
//}