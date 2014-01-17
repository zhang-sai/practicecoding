package g;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * http://www.mitbbs.com/article_t/JobHunting/32608789.html
 * 
 * implement:
 * String encode(List<String> input);
 * List<String> decode(String input);
 * 
 * */


//there is an ambiguity:
//a###b#  ==> should be a#, b  or a, b#
//escape //n?
public class StringEncodeDecode {

	static String sep = "#";
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("1#ab", "#2##cd%$#", "", "1##d", "");
		String encoded = encode(list);
		System.out.println("Encoded: " + encoded);
		List<String> decodeList = decode(encoded);
		if(!list.equals(decodeList)) {
			System.out.println("Original one: " + list);
			System.out.println("Decoded one: " + decodeList);
		}
	}
	
	//use an annotation to indicate the length of each string
	public static String encode(List<String> input) {
		StringBuilder sb = new StringBuilder();
		for(String s : input) {
			sb.append(s.length());
			sb.append("#");
			sb.append(s);
		}
		return sb.toString();
	}
	
	public static List<String> decode(String input) {
		//decode the string
		List<String> list = new LinkedList<String>();
		
		char[] cs = input.toCharArray();
		int index = 0;
		while(index < cs.length) {
			if(!isDigit(cs[index]) || index == cs.length - 1 || cs[index+1] != '#') {
				throw new Error("Wrong format: " + index + ", " + cs[index]);
			}
			int num = cs[index] - '0';
			index = index + 2;
			StringBuilder sb = new StringBuilder();
			while(num > 0) {
				sb.append(cs[index]);
				num--;
				index++;
			}
			list.add(sb.toString());
		}
		
		return list;
	}
	
	private static boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}
	
}
