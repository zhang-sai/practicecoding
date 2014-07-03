package basics;

//http://en.wikipedia.org/wiki/Ternary_search_tree
//http://en.wikipedia.org/wiki/Ternary_tree

//ternary tree
/**
 * a ternary search tree with the strings "as", "at", "cup", "cute", "he", "i"
 * and "us":
 * 
 * ternary search trees can become degenerate depending on the order of the keys
 * 
 * Tries and ternary search trees represent a time/space trade off. If your
 * alphabet has k symbols in it, then each node in a trie holds k pointers plus
 * one extra bit for whether or not the node encodes a word. Looking up a word
 * of length L always takes time O(L). A ternary search tree stores three
 * pointers per node, plus one character and one bit for whether or not the node
 * encodes a word. Looking up a word of length L takes time O(L log k).
 * 
 * For cases where each node in the Trie has most of its children used, the Trie
 * is substantially more space efficient and time efficient than th ternary
 * search tree. If each node stores comparatively few child nodes, the ternary
 * search tree is much more space efficient. Typically speaking, tries are much,
 * much faster than ternary search trees because fewer pointer indirections are
 * required. 
 
 
           c
        / | \
       a  u  h
       |  |  | \
       t  t  e  u
     /  / |   / |
    s  p  e  i  s
 
 **/

public class TrineryTree {

	TrineryTreeNode root = null;

	public void constructTree(String[] strs) {
		for (String str : strs) {
			root = insert(root, str, 0);
			// System.out.println("after inserting: " + str);
			// print(root);
		}
	}

	
	private TrineryTreeNode insert(TrineryTreeNode node, String str, int index) {
		char c = str.charAt(index);
		// create a node
		if (node == null) {
			node = new TrineryTreeNode(c);
		}
		//
		if (c < node.c) {
			node.less = insert(node.less, str, index);
		} else if (c > node.c) {
			node.more = insert(node.more, str, index);
		} else if (index < str.length() - 1) {
			node.mid = insert(node.mid, str, index + 1);
		} else {
			//the final one
			//index = str.length() - 1
			node.flag = true;
		}

		return node;
	}
	
	public boolean get(String key) {
		TrineryTreeNode node = get(root, key, 0);
		if (node == null) {
			return false;
		}
		return node.flag;
	}

	private TrineryTreeNode get(TrineryTreeNode x, String key, int index) {
		if (x == null) {
			return null;
		}
		char c = key.charAt(index);
		if (c < x.c) {
			return get(x.less, key, index);
		}
		else if (c > x.c) {
			return get(x.more, key, index);
		} else if (index < key.length() - 1) {
			return get(x.mid, key, index + 1);
		} else {
			return x;
		}
	}

	//a non recursive one
	public boolean query(String word) {
//		return get(word);
		
		char[] cs = word.toCharArray();
		TrineryTreeNode curr = root;
		int i = 0;
		while( i < cs.length) {
			char c = cs[i];
			if (curr == null) {
				return false;
			}
			if (curr.c == c) {
				if (i == cs.length - 1) {
					return curr.flag;
				}
				curr = curr.mid;
				i++;
			} else if (curr.c > c) {
				curr = curr.less;
			} else {
				curr = curr.more;
			}
		}

		return false;
	}

	public static void print(TrineryTreeNode node) {
		if (node == null) {
			return;
		}
		System.out.println(node.c + "  " + node.flag);
		print(node.less);
		print(node.mid);
		print(node.more);
	}

	public static void main(String[] args) {
		String[] str = new String[] { "cute", "at", "as", "cup", "he", "us", "i"};
		TrineryTree tree = new TrineryTree();
		tree.constructTree(str);

		print(tree.root);

		 for(String s : str) {
		     System.out.println("Query: " + s + "  exist? " + tree.query(s));
		 }
		 System.out.println("---------");
		 String s = "cutp";
		 System.out.println("Query: " + s + "  exist? " + tree.query(s));
		 s = "cut";
		 System.out.println("Query: " + s + "  exist? " + tree.query(s));
		 s = "ass";
		 System.out.println("Query: " + s + "  exist? " + tree.query(s));
	}
}

class TrineryTreeNode {
	char c;
	boolean flag = false;
	TrineryTreeNode less = null;
	TrineryTreeNode mid = null;
	TrineryTreeNode more = null;

	public TrineryTreeNode(char c) {
		this.c = c;
	}
}
