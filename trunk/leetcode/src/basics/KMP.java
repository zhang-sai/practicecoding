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

	   /**
     * Pre processes the pattern array based on proper prefixes and proper
     * suffixes at every position of the array
     * 
     * @param pattern
     *            word that is to be searched in the search string
     * @return partial match table which indicates
     */
	
	//credit goes to: http://tekmarathon.wordpress.com/2013/05/14/algorithm-to-find-substring-in-a-string-kmp-algorithm/
    public static int[] overlap(char[] pattern) {
        int i = 0, j = -1;
        int length = pattern.length;
        int[] overlap = new int[length + 1];
 
        overlap[i] = j;
        while (i < length) {
            while (j >= 0 && pattern[i] != pattern[j]) {
                // if there is mismatch consider next widest border
                j = overlap[j];
            }
            i++;
            j++;
            overlap[i] = j;
        }
        // print pettern, partial match table and index
//        System.out
//                .println("printing pattern, partial match table, and its index");
//        System.out.print(" ");
//        for (char c : ptrn) {
//            System.out.print(c + "   ");
//        }
//        System.out.println(" ");
//        for (int tmp : b) {
//            System.out.print(tmp + "   ");
//        }
//        System.out.print("\n ");
//        for (int l = 0; l < ptrn.length; l++) {
//            System.out.print(l + "   ");
//        }
//        System.out.println();
        return overlap;
    }
 
    /**
     * Based on the pre processed array, search for the pattern in the text
     * 
     * @param haystack
     *            text over which search happens
     * @param needle
     *            pattern that is to be searched
     */
    public static void  kmp(char[] haystack, char[] needle) {
        int i = 0, j = 0;
        // pattern and text lengths
        int needleLength = needle.length;
        int haystackSize = haystack.length;
 
        // initialize new array and preprocess the pattern
        int[] overlap = overlap(needle);
 
        while (i < haystackSize) {
            while (j >= 0 && haystack[i] != needle[j]) {
//                System.out.println("Mismatch happened, between text char "
//                        + text[i] + " and pattern char " + ptrn[j]
//                        + ", \nhence jumping the value of " + "j from " + j
//                        + " to " + b[j] + " at text index i at " + i
//                        + " based on partial match table");
                j = overlap[j];
            }
            i++;
            j++;
 
            // a match is found
            if (j == needleLength) {
                System.out.println("FOUND SUBSTRING AT i " + i + " and index:"
                        + (i - needleLength) + ",  target: " + new String(needle));
                j = overlap[j];
            }
        }
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
		searchInALargeChunck("abcdefghijklmnopqst", "fghi");
		searchInALargeChunck("sfafbgjljlfslfjihsxljxflsfj", "fgxh");
		searchInALargeChunck("sfafbgjljlfslfjihsxljxflsfj", "fslfjihs"); // larger
																			// than
																			// the
																			// buffer

		System.out.println("----- compute overlap ------");

		System.out.println("\n----- test kmp ------");

		 
		kmp("abcdefghijklmnopqst".toCharArray(), "fgh".toCharArray());
		kmp("sfffffgggggghhhhh".toCharArray(), "fgh".toCharArray());
		kmp("sfafbgjljlfslfjihsxljxflsfj".toCharArray(), "fslfjihs".toCharArray());
	}

}
