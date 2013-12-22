//http://www.mitbbs.com/article_t/JobHunting/32586021.html

xx
public class MissingNumberVariants {

	//123456891011  ==> 7
	//9991000100110021004  ==> 1003
	
	public static int findMissingNumber(String str) {
		int length = str.length();
		if(length < 1) {
			return -1;
		}
		for(int i = 1; i <= str.length(); i++) {
			String value = str.substring(0, i);
			Integer v = Integer.parseInt(value);
			int found = findMissingNumber(0, i, str, v);
			if(found != -1) {
				return found;
			}
		}
		return -1;
	}
	
	public static int findMissingNumber(int start, int end, String str, int expected) {
		if(start >= str.length() || end > str.length()) {
			return expected;
		}
		String value = str.substring(start, end);
		Integer v = Integer.parseInt(value);
		if(v == expected) {
			//get the next
			int nextNum = v + 1;
			String nextNumStr = nextNum + "";
			int found = findMissingNumber(end, end + nextNumStr.length(), str, nextNum);
			if(found != -1) {
				return found;
			}
		} else {
			//double check
			//check the next one
			if(end == str.length()) {
				return expected; //the last one
			}
			String nextNextNumStr = (v+ 2) + "";
			
			int found = findMissingNumber(start, start + nextNextNumStr.length(), str, v + 2 );
			if(found != -1) {
			    return expected; //missing this
			} else {
				return -1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(findMissingNumber("123456891011"));
		System.out.println(findMissingNumber("9991000100110021004"));
	}
	
}
