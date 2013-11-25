
public class ReverseWords {

	public static void main(String[] args) {
		String str = "Hello   World ";
		char[] cs = str.toCharArray();
		reverse(cs);
		System.out.println(new String(cs) + "|");
	}
	
	public static void reverse(char[] chars) {
		System.out.println(new String(chars));
		reverse(chars, 0, chars.length - 1);
		System.out.println(new String(chars));
		int start = 0;
		//move to the first non-space char
		while(chars[start] == ' ') {
			start++;
		}
		//move to the next
		int end = start + 1;
		
		while(end < chars.length) {
			//System.out.println(end + "  "  + chars[end]);
			if(chars[end] == ' ')  {
				//start reversing
				reverse(chars, start, end - 1);
				//then looking for the next start
				start = end;
				while(chars[start] == ' ') {
					start++;
				}
				end = start + 1;
			} else if(end == chars.length - 1) {
				//still reverse
				reverse(chars, start, end);
			}
			end++;
		}
	}
	
	public static void reverse(char[] chars, int start, int end) {
		if(start >= end) {
			return;
		}
		while(start < end) {
			char tmp = chars[start];
			chars[start] = chars[end];
			chars[end] = tmp;
			start++;
			end --;
		}
		
		
	}
	
}
