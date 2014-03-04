import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Given a digit string, return all possible letter combinations that the number could represent.

http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * */
public class LetterCombination {
	public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("2", new String[]{"a", "b", "c"});
		map.put("3", new String[]{"d", "e", "f"});
		map.put("4", new String[]{"g", "h", "i"});
		map.put("5", new String[]{"j", "k", "l"});
		map.put("6", new String[]{"m", "n", "o"});
		map.put("7", new String[]{"p", "q", "r", "s"});
		map.put("8", new String[]{"t", "u", "v"});
		map.put("9", new String[]{"w", "x", "y", "z"});
		
		ArrayList<String> list = new ArrayList<String>();
		if(digits.isEmpty()) {
			list.add(digits);
			return list;
		}
		
//		return this.allCombinations(map, digits);
		ArrayList<String> results = new ArrayList<String>();
		findAllCombinations(results, map, new char[digits.length()], digits.toCharArray(), 0);
		return results;
		
    }
	
	private void findAllCombinations(ArrayList<String> results,
			Map<String, String[]> map, char[] resultArray,
			char[] chars, int currIndex) {
		if(currIndex == resultArray.length) {
			results.add(new String(resultArray));
			return;
		}
		//then do recursion
		String v = chars[currIndex] + "";
		String[] strs = map.get(v);
		for(String str : strs) {
			char c = str.charAt(0);
			resultArray[currIndex] = c;
			findAllCombinations(results, map, resultArray, chars, currIndex + 1);
		}
	}
	
	//XXX no current list here in the parameters
	private ArrayList<String> allCombinations(Map<String, String[]> map, String leftDigits) {
		if(leftDigits.length() == 1) {
			ArrayList<String> strs = new ArrayList<String>();
			for(String c : map.get(leftDigits.substring(0, 1))) {
				strs.add(c);
			}
			return strs;
		}
		ArrayList<String> strs = new ArrayList<String>();
		String firstDigit = leftDigits.substring(0, 1);
		ArrayList<String> others = this.allCombinations(map, leftDigits.substring(1));
		for(String c : map.get(firstDigit)) {
			for(String s : others) {
				strs.add(c  + s);
			}
		}
		
		return strs;
	}
}
