package g;

/**
 * 2. Given a list of words, find two strings S & T such that: a. S & T have no
 * common character b. S.length() * T.length() is maximized Follow up: how to
 * optimize and speed up your algorithm
 * */
public class FindTwoStrings {
	
	/**
	 * or build a reverse map
	 * a --> {string1, string2, string3, }
	 * 
	 * string -- > (which group it belongs to)
	 * */

	int biggest(String[] array) {
		if (array == null || array.length <= 1)
			return 0;
		
		class bitMap {
			int bit;
			String s;
		}
		bitMap[] bm = new bitMap[array.length];
		for (int i = 0; i < array.length; i++) {
			bm[i] = new bitMap();
			for (int j = 0; j < array[i].length(); j++)
				bm[i].bit = bm[i].bit | (1 << (array[i].charAt(j) - 'a'));
			bm[i].s = array[i];
		}
		int maximum = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++)
				if ((bm[i].bit & bm[j].bit) == 0)
					maximum = Math.max(maximum,
							bm[i].s.length() * bm[j].s.length());
		}
		return maximum;
	}

	public static void main(String[] args) {
		System.out.println(new FindTwoStrings().biggest(new String[] { "aa",
				"aabb", "bb", "cc" }));
	}
}
