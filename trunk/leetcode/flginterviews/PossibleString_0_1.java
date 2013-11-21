import java.util.LinkedList;
import java.util.List;

//http://www.mitbbs.com/article_t/JobHunting/32582249.html

public class PossibleString_0_1 {

/**
 * The following solution works, but is low efficient
 * */
//	public static List<String> getAllPossibleStrings(String s) {
//		return getAllPossibleStrings(s.toCharArray(), 0);
//	}
//	
//	public static List<String> getAllPossibleStrings(char[] cs, int index) {
//		if(index == cs.length - 1) {
//			List<String> l = new LinkedList<String>();
//			if(cs[index] != '?') {
//				l.add(cs[index] + "");
//			} else {
//				l.add("1");
//				l.add("0");
//			}
//			return l;
//		}
//		List<String> rest = getAllPossibleStrings(cs, index + 1);
//		List<String> currList = new LinkedList<String>();
//		if(cs[index] != '?') {
//			for(String s : rest) {
//				currList.add(cs[index] + s);
//			}
//		} else {
//			for(String s : rest) {
//				currList.add("0" + s);
//				currList.add("1" + s);
//			}
//		}
//
//		return currList;
//	}
	
	//============ back tracking
	
	public static void mutate(char[] cs, int index, List<String> l) {
		if(index == cs.length) {
			String s = new String(cs);
			System.out.println(s);
			l.add(s);
			return;
		}
		if(cs[index] != '?') {
			mutate(cs, index+1, l);
		} else {
			char tmp = cs[index];
			cs[index] = '1';
			mutate(cs, index+1, l);
			cs[index] = '0';
			mutate(cs, index+1, l);
			cs[index] = tmp;
		}
	}
	
	//
	
	public static void main(String[] args) {
//		System.out.println(getAllPossibleStrings("ab?cd??e?").size());
		List<String> l = new LinkedList<String>();
		mutate("ab?cd??e?".toCharArray(), 0, l);
		System.out.println(l);
	}
	
}