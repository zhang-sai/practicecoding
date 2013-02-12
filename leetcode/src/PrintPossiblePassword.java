import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 
 * password -> PASSWoRd
 * give map for each character
 * */
public class PrintPossiblePassword {

	public Set<String> printAllPwds(Map<Character, Set<Character>> dict, String pwd) {
		Set<String> s = new HashSet<String>();
		if(pwd.length() == 0) {
			s.add(pwd);
			return s;
		}
		List<String> allPwds = this.createPassword(dict, pwd);
		s.addAll(allPwds);
		
		s.remove(pwd);
		
		return s;
	}
	
	private List<String> createPassword(Map<Character, Set<Character>> dict, String pwd) {
		if(pwd.length() == 1) {
			List<String> list = new LinkedList<String>();
			list.add(pwd);
			Character c = pwd.charAt(0);
			if(dict.containsKey(c)) {
				for(Character rc : dict.get(c)) {
					list.add(rc.toString());
				}
			}
			return list;
		} else {
			Character c = pwd.charAt(0);
			String remain = pwd.substring(1);
			List<String> newPwd = this.createPassword(dict, remain);
			
			List<String> list = new LinkedList<String>();
			for(String np : newPwd) {
				list.add(c.toString() + np);
			}
			
			if(dict.containsKey(c)) {
				Set<Character> cs = dict.get(c);
				for(String np : newPwd) {
					for(Character c1 : cs) {
						list.add(c1.toString() + np);
					}
				}
			}
			
			return list;
		}
	}
	
	public static void main(String[] args) {
		PrintPossiblePassword pp = new PrintPossiblePassword();
		Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
		Set<Character> s = new HashSet<Character>();
		s.add('q');
		s.add('P');
		map.put('p', s);
		Set<Character> s1 = new HashSet<Character>();
		s1.add('X');
		s1.add('A');
		map.put('a', s1);
		Set<Character> s2 = new HashSet<Character>();
		s2.add('$');
		map.put('s', s2);
		Set<Character> s3 = new HashSet<Character>();
		s3.add('D');
		s3.add('8');
		s3.add('0');
		map.put('d', s3);
		
		//3*3*2*2*4 = 9*4*4 = 9*16 = 144 - 1= 143
		Set<String> set = pp.printAllPwds(map, "password");
		
		System.out.println(set.size());
		System.out.println(set);
	}
	
}
