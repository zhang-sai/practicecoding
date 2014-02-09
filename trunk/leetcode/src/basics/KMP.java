package basics;

import util.Utils;

class KMPAndSearchInALargeChunck {

	// its application of search a small str in a large amount of text
	// http://algs4.cs.princeton.edu/53substring/KMP.java.html

	/**
	 * Implement the kmp algorithm
	 * 
	 * The idea: skipping both out and inner loop, by computing the overlap
	 * function
	 * 
	 * */

	// credit goes to: http://www.ics.uci.edu/~eppstein/161/960227.html
	public static boolean kmp(char[] haystack, char[] needle) {
		int[] overlap = computeOverlap(needle);
		int n = haystack.length;
		int m = needle.length;

		int i = 0;
		int o = 0;
		while (i < n) {
//			System.out.println("int: " + i);
			int j = o;
			while( i + j < n && j < m) {
				if(haystack[i + j] == needle[j]) {
					j++;
				} else {
					break;
				}
			}
			if (j == m) {
				return true;
			}
			o = j == 0 ?  0 : overlap[j - 1]; // overlap(P[0..j-1],P[0..m]);
			i = i + Math.max(1, j - o);
		}
		return false;
	}

	// the overlap between pattern[0,, i] with the whole pattern
	// the overlapped part, if nano is the whole pattern
	// nan
	// nano

	// the overlap of two strings x and y to be the longest word that's a suffix
	// of x and a prefix of y
	private static int[] computeOverlap(char[] pattern) {
		if (pattern.length == 1) {
			return new int[] { 0 };
		}
		int[] overlap = new int[pattern.length];
		for (int i = 0; i < pattern.length - 1; i++) {
			overlap[i + 1] = overlap[i] + 1;
			while (overlap[i + 1] > 0 && pattern[i] != pattern[overlap[i + 1] - 1])
				overlap[i + 1] = overlap[overlap[i + 1] - 1] + 1;
		}
		return overlap;
	}

	/**
	 * Search a needle in a haystack by using a buffer. The buffer can be
	 * smaller than the needle
	 * */
	public static void searchInALargeChunck(String chuck, String needle) {
		System.out.println("size of chuck: " + chuck.length());
		char[] buffer = new char[6];

		if (buffer.length <= needle.length()) {
			System.out.println("Buffer too small, cannot find");
			// or you can read it multiple times
			return;
		}

		int start = 0;
		while (start < chuck.length()) {
			// read into the buffer
			for (int i = 0; i < buffer.length && start < chuck.length(); i++) {
				buffer[i] = chuck.charAt(start++);
			}
			// do the search in the buffer
			for (int i = 0; i < buffer.length - needle.length() + 1; i++) {
				boolean matched = true;
				for (int j = 0; j < needle.length(); j++) {
					if (buffer[i + j] != needle.charAt(j)) {
						matched = false;
						break;
					}
				}
				if (matched) {
					System.out.println("Found!");
					return;
				}
			}

			// XXX must check this condition, if the start index also
			// already arrive over the length, we should jump out
			if (start < chuck.length()) {
				start = start - needle.length() + 1;
			}
		}
		System.out.println("Not found!");
	}

	public static void main(String[] args) {
		searchInALargeChunck("abcdefghijklmnopqst", "fgh");
		searchInALargeChunck("sfafbgjljlfslfjihsxljxflsfj", "fgh");
		searchInALargeChunck("sfafbgjljlfslfjihsxljxflsfj", "fslfjihs"); // larger
																			// than
																			// the
																			// buffer

		System.out.println("----- compute overlap ------");

		int[] overlap = computeOverlap("fgh".toCharArray());
		for (int o : overlap) {
			System.out.print(o + " ");
		}

		System.out.println("\n----- test kmp ------");

		 System.out.println(kmp("abcdefghijklmnopqst".toCharArray(),
		 "fgh".toCharArray()));
		 System.out.println(kmp("sfffffgggggghhhhh".toCharArray(),
		 "fgh".toCharArray()));
		 System.out.println(kmp("sfafbgjljlfslfjihsxljxflsfj".toCharArray(),
		 "fslfjihs".toCharArray()));
	}

}
