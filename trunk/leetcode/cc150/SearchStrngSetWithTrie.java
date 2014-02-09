import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//xxx
//given a string s, and an  array of smaller string t, searc
//s for each small string in t
public class SearchStrngSetWithTrie {

	//construct a trie, and then perform quick search
	
	/**
	 *  the trie of the word  bibs looks like
	 *  
	 *               root
	 *              /  |  \
	 *             b   i   s
	 *            / \  \
	 *           i   s  b
	 *          /       \
	 *         b         s
	 *        /
	 *        s
	 * **/
	
	//then it permits search the tree fast
	
	static class TrieNode {
		Object v;
		Map<Object, TrieNode> map = new HashMap<Object, TrieNode>();
		public TrieNode(Object  t) {
			v = t;
		}
	}
	
	static TrieNode constructTrie(String t) {
		TrieNode root = new TrieNode(null);
		
		List<TrieNode> fringe = new LinkedList<TrieNode>();
		fringe.add(root);
		
		for(Character c : t.toCharArray()) {
		
			List<TrieNode> newFringe = new LinkedList<TrieNode>();
			newFringe.add(root);
			
			for(TrieNode n : fringe) {
				if(n.map.containsKey(c)) {
					TrieNode newNode = (TrieNode)n.map.get(c);
					newFringe.add(newNode);
				} else {
					TrieNode newNode = new TrieNode(c);
					n.map.put(c, newNode);
					newFringe.add(newNode);
				}
			}
			
			//clear existing fringe
			fringe.clear();
			fringe.addAll(newFringe);
		}
		
		return root;
		
	}
	
	static boolean lookupString(TrieNode t, String s) {
		TrieNode curr = t;
		for(Character c : s.toCharArray()) {
			if(curr.map.containsKey(c)) {
				curr = (TrieNode) curr.map.get(c);
				
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String lstr = "helloworldiamjava";
		String[] set = new String[]{"c++", "java", "iamj", "heo", "helloworld"};
		TrieNode node = constructTrie(lstr);
		for(String str : set) {
			boolean in = lookupString(node, str);
			System.out.println("existing? " + str + ": " + in);
		}
	}
	
}
