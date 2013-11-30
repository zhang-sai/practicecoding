import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Given a number, say which index it is
 * for example:
 * 1, 2, 3 is the first permutation of [1,2,3]
 * */
public class ReversePermutationIndex {
	
	public static void main(String[] args) {
		char[] chars = new char[]{'1', '2', '3'};
		for(int i = 0; i < 6; i++) {
			printPerm(chars, i);
		}
	}
	
	public static void printPerm(char[] chars, int k) {
		Map<Integer, Integer> choiceBelow = new HashMap<Integer, Integer>();
		int choice = 1;
		choiceBelow.put(chars.length - 1, 0); //only 1 choice if we need to fix the last digit
		for(int i = 1; i < chars.length; i++) {
			choice = choice * i;
			choiceBelow.put(chars.length - 1 - i, choice);
		}
//		System.out.println(choiceBelow);
		
		ArrayList<Character> list = new ArrayList<Character>();
		for(char c : chars) {
			list.add(c);
		}
		
		//first figure out the first digit
		char[] newChars = new char[chars.length];
		for(int i = 0; i < chars.length; i++) {
			if(i == chars.length - 1) {
				newChars[i] = list.get(k); //chars[i];
			} else  {
			    int num = choiceBelow.get(i);
			    int index = k / num;
			    k = k - index*num;
			    newChars[i] = list.get(index);
			    list.remove(index);
			}
		}
		
		//1, 2, 3
		//1, 3, 2
		//2, 1, 3
		//2, 3, 1
		//3, 1, 2
		//3, 2, 1
		
		System.out.println("Index: " + k + ": " + new String(newChars));
	}
	
}