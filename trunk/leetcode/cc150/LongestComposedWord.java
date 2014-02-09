import java.util.HashMap;
import java.util.Map;



//find the longest composed word of other words
//["a", "dog", "cat", "pig", "walker"] ==> "dogwalker"
//first rank all words by length
public class LongestComposedWord {

	static class TrieNode {
		Character c;
		Map<Character, TrieNode> map = new HashMap<Character, TrieNode>();
		public TrieNode(Character  t) {
			c = t;
		}
	}
	
	public static String getLongestWord(String[] words) {
		String currLongest = "";
		
		TrieNode root = new TrieNode('#'); //a dummy node
		for(String w : words) {
			boolean isPrefix = true;
			TrieNode curr = root;
			for(Character c : w.toCharArray()) {
				if(curr.map.containsKey(c)) {
					continue;
				} else {
					TrieNode newNode = new TrieNode(c);
					curr.map.put(c, newNode);
					curr = newNode;
					isPrefix = false;
				}
			}
			if(isPrefix) {
				if(w.length() > currLongest.length()) {
					currLongest = w;
				}
			}
		}
		
		return currLongest;
	}
	
	public static void main(String[] args) {
		String[] words = new String[]{
				"cat", "cats", "catsdogcats", "catxdogcatsrat",
				"dog", "dogcatsdog", "hippopotamuses", 
				"rat", "ratcat", "ratcatdog", "ratcatdogcat"
		};
		System.out.println(getLongestWord(words));
	}
	
}
