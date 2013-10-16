import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 
 * Given two words (start and end), and a dictionary, find the length of shortest
 * transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.


Return 0 if there is no such transformation sequence.



 * */
//XXX note that constructing the graph may consume a significant amount of
//time, thus, a better way is to explore successive edge on demand,
//that tis, given a word, try to replace each in each place with
//'a' --- 'z' and then search its existence in the dictionary
public class WordWadder {

	public static void main(String[] args) {
		WordWadder w = new WordWadder();
//		"hot", "dog", ["hot","cog","dog","tot","hog","hop","pot","dot"]
		String start = "a";//"hot";
		String end = "a"; //"dog";
		HashSet<String> s = new HashSet<String>();
		s.add("a");
		s.add("b");
		s.add("c");
//		s.add("hot");
//		s.add("cog");
//		s.add("dog");
//		s.add("tot");
//		s.add("hog");
//		s.add("hop");
//		s.add("pot");
//		s.add("dot");
		w.ladderLength(start, end, s);
	}
	
	public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function      
        
        //like the visited set in BFS/DFS
        HashSet<String> dedupSet = new HashSet<String>();
        
        //like a fringe in BFS/DFS
        List<String> fromList = new ArrayList<String>();
        fromList.add(start);
        
        //the length
        int res = 1;
        while(fromList.size() != 0){
            List<String> toList = new ArrayList<String>();
            //find the next level
            for(String from : fromList){
                if(from.equals(end)) {
                    return res; //find it
                }
                char[] arr = from.toCharArray();
                //for each word in the from list
                for(int i = 0; i < arr.length; i++){
                    char base = arr[i];
                    for(char c = 'a'; c < 'z'; c++){
                        if(c == base) { 
                            continue;
                        }
                        arr[i] = c;
                        String s = new String(arr);
                        if(dict.contains(s) && !dedupSet.contains(s)){
                            toList.add(s);
                            dedupSet.add(s);
                        }
                    }
                    arr[i] = base;
                }
            } 
            fromList.clear();
            fromList = toList;
            res ++; //just record the levels
        }
        return 0;
    }
	
	/**
	 * find all wadders
	 * */
	
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		if(start.length() != end.length()) {
        	return new ArrayList<ArrayList<String>>();
        }
        
        //construct a graph
        HashSet<String> allWords = new HashSet<String>();
        allWords.addAll(dict);
        allWords.add(start);
        allWords.add(end);
        
//        System.out.println(allWords);
        
        Map<String, Set<String>> paths = new HashMap<String, Set<String>>();
        for(String w1 : allWords) {
        	for(String w2 : allWords) {
        		if(w1.equals(w2)) {
        			continue;
        		}
        		if(w1.length() == w2.length()) {
        			//if w1 and w2 only differ in 1 character?
        			int diff = 0;
        			for(int i = 0; i < w1.length(); i++) {
        				if(w1.charAt(i) != w2.charAt(i)) {
        					diff++;
        				}
        			}
        			if(diff == 1) {
        				if(!paths.containsKey(w1)) {
        					paths.put(w1, new HashSet<String>());
        				}
        				paths.get(w1).add(w2);
        				if(!paths.containsKey(w2)) {
        					paths.put(w2, new HashSet<String>());
        				}
        				paths.get(w2).add(w1);
        			}
        		}
        	}
        }
        //
        ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
        
        
        //my previous code:
        //https://code.google.com/p/guierrordetector/source/browse/trunk/GUIErrorDetector/tests/edu/washington/cs/detector/experiments/search/ExhaustiveSearcher.java
        
        return ladders;
    }
}
