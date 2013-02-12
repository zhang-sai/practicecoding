import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Word breaking 
// How many spaces can we add to a word such that: 
// All subwords can be found within a given dictionary 

// fireman 

// fire man -> 2 words 
// fir em an -> 3 words 

/* DICT
a 
an 
em 
fir 
fire 
ire 
ma
man 
*/
public class AddWordSpaces {

	
	public int getSpaceNum(Set<String> dict, String word) {
		if(word.length() == 0) {
			return 0;
		}
		int min = Integer.MIN_VALUE;
		for(int i = 1; i < word.length(); i++) { //XXX note the i
			String prefix = word.substring(0, i);
			if(dict.contains(prefix)) {
				int spaceNum = 1;
				if(i == word.length() -1) {
					spaceNum = 0;
				} else {
				    spaceNum += this.getSpaceNum(dict, word.substring(i));
				}
				System.out.println(spaceNum+ ", min: " + min);
				if(spaceNum > min) {
					min = spaceNum;
				}
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		AddWordSpaces ads = new AddWordSpaces();
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("an");
		dict.add("em");
		dict.add("fir");
		dict.add("fire");
		dict.add("ire");
		dict.add("ma"); 
		dict.add("ire");
		dict.add("man");
		System.out.println(ads.getSpaceNum(dict, "fireman"));
	}
	
}
