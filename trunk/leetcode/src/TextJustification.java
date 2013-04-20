import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
 * */

public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int l) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> list = new ArrayList<String>();
        
        int length = 0;
        List<String> currLine = new LinkedList<String>();
        for(int i = 0; i < words.length; ) {
        	String word = words[i];
        	if(length + word.length() + currLine.size() <= l) {
        		currLine.add(word);
        		length = length + word.length();
        		i++;
        	} else {
        		String text = this.justifyText(currLine, length, l);
    			list.add(text);
        		//clear the length
        		length = 0;
        		currLine.clear();
        	}
        }
        
        //XXX do not forget the remaining part
        if(!currLine.isEmpty()) {
        	String text = "";
        	for(String w : currLine) {
        		text = text + w + " ";
        	}
        	text = text.trim();
        	while(text.length() < l) { //XXX must padding the space
				text = text + " ";
			}
        	list.add(text);
        }
        
        return list;
    }
	
	//XXX padding the space
	private String justifyText(List<String> currLine, int length, int l) {
		String text = "";
		if(currLine.size() == 1) {
			text = text + currLine.get(0);
			while(text.length() < l) { //XXX must padding the space
				text = text + " ";
			}
			return text;
		}
		int numOfWord = currLine.size();
		int spaces = l - length;
		//spaces must > numOfWord - 1
		int avgSpace = spaces / (numOfWord - 1);
		String spaceText = "";
		for(int j = 0; j < avgSpace; j++) {
			spaceText = spaceText + " ";
		}
		int remaingSpace = spaces - avgSpace*(numOfWord - 1);
		text = currLine.get(0);
		for(int j = 1; j < currLine.size(); j++) {
			text = text + spaceText + (j-1 < remaingSpace ? " " : "") + currLine.get(j);
		}
		return text;
	}
	
	public static void main(String[] args) {
		TextJustification tj = new TextJustification();
//		String[] words = new String[]{"Listen","to","many,","speak","to","a","few."};
//		ArrayList<String> strList = tj.fullJustify(words, 6);
		String[] words = new String[]{""};
		ArrayList<String> strList = tj.fullJustify(words, 0);
		for(String str : strList) {
			System.out.println("\"" + str + "\"");
		}
	}
}
