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
        if(start.length() != end.length()) {
        	return 0;
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
        
        //XXX special case for the same word
        System.out.println(paths);
        if(start.equals(end)) {
        	if(paths.get(start) != null) {
        		return 3;
        	} else {
        		return 0;
        	}
        }
        
//        System.out.println(paths);
        
        //start to perform a BFS
        Set<String> visited = new HashSet<String>();
//        visited.add(start);
        List<String> queue = new LinkedList<String>();
        queue.add(start);
        
        
        Map<String, String> backTracking = new HashMap<String, String>();
        
        while(!queue.isEmpty()) {
        	String top = queue.remove(0);
        	if(top.equals(end)) {
//        		System.out.println(backTracking);
        		//do back tracking
        		int count = 1;
        		String s = backTracking.get(top);
        		while(!s.equals(start)) {
        			s = backTracking.get(s);
        			count++;
        		}
        		return count + 1;
        	} else {
        		if(visited.contains(top)) {
        			continue;
        		} else {
        			//
        			visited.add(top);
        			Set<String> nexts = paths.get(top);
//        			System.out.println(visited + " -- " + nexts);
        			if(nexts != null) {
        				for(String next : nexts) {
        					if(visited.contains(next)) {
        						continue;
        					}
        				     queue.add(next);
        				     if(!backTracking.containsKey(next)) { //XXX This is critical to avoid overlap
        				         backTracking.put(next, top);
        				     }
//        				     System.out.println("put: " + next + "  " + top);
        				}
        			}
        			
        		}
        	}
        }
        
        return 0;
    }
	
	
	/**
	 * find all wadders
	 * */
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    }
}
