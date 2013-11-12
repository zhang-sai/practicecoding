import java.util.Arrays;
import java.util.PriorityQueue;

import util.Utils;

//11.8

class TNode {
    int val;
    TNode left;
    TNode right;
    TNode(int x) { val = x; }
    public String toString() {return val + ""; }
    
    int elem = 1; //repetitive number
    int gnum = 0;
    
}

public class RankOfStreamValue {

	/**
	 * construct a tree, with a node stating the number of
	 * element less or equal than it
	 * */
	
	public static TNode processStream(Integer[] array) {
		//it build a tree, the number element = numbers <= it
		TNode root = new TNode(array[0]);
		for(int i = 1; i < array.length; i++) {
			int v = array[i];
			TNode curr = root;
			while(curr != null) {
				if(curr.val == v) {
					curr.elem++;
					break; //break the loop
				} else {
					if(curr.val > v) {
						//go to the left side
						curr.gnum++;
						if(curr.left == null) {
							curr.left = new TNode(v);
							break; //break the loop
						} else {
							curr = curr.left;
						}
					} else {
						//go to the right side
						//do not increase the gnum
						if(curr.right == null) {
							curr.right = new TNode(v);
							break; //break the loop
						} else {
							curr = curr.right;
						}
					}
				}
			}
		}
		
		return root;
	}
	
	public static int queryRank (TNode root, int v) {
		int rank = 0;
		TNode curr = root;
		while(curr != null) {
			if(curr.val == v) {
				rank += curr.gnum;
				return rank;
			} else if (curr.val > v) {
				curr = curr.left;
			} else {
				rank += curr.gnum;
				rank += curr.elem;
				curr = curr.right;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Integer[] array = new Integer[]{5, 4, 5, 1, 3, 4, 5, 6, 7, 8, 9, 10, 3, 2, 4, 5, 6, 11};
		
		TNode root = processStream(array);
		System.out.println("The rank of 5: " + queryRank(root, 5));
		System.out.println("The rank of 6: " + queryRank(root, 6));
		System.out.println("The rank of 3: " + queryRank(root, 3));
		System.out.println("The rank of 4: " + queryRank(root, 4));
		System.out.println("The rank of 1: " + queryRank(root, 1));
		System.out.println("The rank of 8: " + queryRank(root, 8));
		
		Arrays.sort(array);
		System.out.println(Utils.dumpArray(array));
		
		//print a tree
		printTree(root, 0);
	}
	
	public static void printTree(TNode t, int indent) {
		if(t == null) {
			return;
		}
		for(int i = 0; i < indent; i++) {
			System.out.print(" ");
		}
		System.out.println(t.val + ", gnum: " + t.gnum + ",  elem: " + t.elem);
		printTree(t.left, indent + 3);
		printTree(t.right, indent + 3);
	}
}