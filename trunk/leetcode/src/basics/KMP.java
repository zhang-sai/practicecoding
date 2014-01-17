package basics;

public class KMP {

	//its application of search a small str in a large amount of text
	//http://algs4.cs.princeton.edu/53substring/KMP.java.html
	
	public static boolean kmp(char[] haystack, char[] needle) {
		return true;
	}

	public static void searchInALargeChunck(String chuck, String needle) {
		System.out.println("size of chuck: " + chuck.length());
		char[] buffer = new char[6];
		
		if(buffer.length <= needle.length()) {
			System.out.println("Buffer too small, find");
			//or you can read it multiple times
			return;
		}
		
		int start = 0;
		while(start < chuck.length()) {
			//read into the buffer
			for(int i = 0; i < buffer.length && start < chuck.length(); i++) {
				buffer[i] = chuck.charAt(start++);
			}
			//do the search in the buffer
			for(int i = 0; i < buffer.length - needle.length() + 1; i++) {
				boolean matched = true;
				for(int j = 0; j < needle.length(); j++) {
					if(buffer[i + j] != needle.charAt(j)) {
						matched = false;
						break;
					}
				}
				if(matched) {
					System.out.println("Found!");
					return;
				}
			}
			
			//XXX must check this condition, if the start index also
			//already arrive over the length, we should jump out
			if(start < chuck.length()) {
			    start = start - needle.length() + 1;
			}
		}
		System.out.println("Not found!");
	}
	
	public static void main(String[] args) {
		searchInALargeChunck("abcdefghijklmnopqst", "fgh");
		searchInALargeChunck("sfafbgjljlfslfjihsxljxflsfj", "fgh");
		searchInALargeChunck("sfafbgjljlfslfjihsxljxflsfj", "fslfjihs"); //larger than the buffer
		
		System.out.println(kmp("abcdefghijklmnopqst".toCharArray(), "fgh".toCharArray()));
		System.out.println(kmp("sfafbgjljlfslfjihsxljxflsfj".toCharArray(), "fgh".toCharArray()));
		System.out.println(kmp("sfafbgjljlfslfjihsxljxflsfj".toCharArray(), "fslfjihs".toCharArray()));
	}
	
}
