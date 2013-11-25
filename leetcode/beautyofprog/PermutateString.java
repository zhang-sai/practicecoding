
public class PermutateString {

	public static void main(String[] args) {
		String str = "123";
		permute(str.toCharArray(), 0);
	}
	
	public static void permute(char[] chars, int curr) {
//		if(curr >= chars.length) {
//			return;
//		}
//		
		if(curr == chars.length - 1) {
		    System.out.println(new String(chars));
		    return;
		}
		
		permute(chars, curr + 1);
		
		for(int i = curr + 1; i < chars.length; i++) {
			
			char tmp = chars[i];
			chars[i] = chars[curr];
			chars[curr] = tmp;
			
			//XXX must make a copy here
			char[] newChars = new char[chars.length];
			for(int j = 0; j < chars.length; j++) {
				newChars[j] = chars[j];
			}
			
			permute(newChars, curr + 1);
		}
	}
	
}
