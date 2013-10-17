
public class RomaToIntegerToRoma {
	/**
	 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
	 * */
	public int romanToInt(String s) {
        int result = 0;
    if (s.length() != 0) {
        int prev = getDigit(s.charAt(s.length() - 1));
        result += prev;
        for (int i = s.length() - 2; i >= 0; i--) {
            int d = getDigit(s.charAt(i));
            if (d < prev) {
                result -= d;
            } else if (d >= prev) {
                result += d;
            }
            prev = d;
        }
    }
    return result;
}

private int getDigit(char c) {
    switch(c) {
        case 'I': return 1;
        case 'V': return 5;
        case 'X': return 10;
        case 'L': return 50;
        case 'C': return 100;
        case 'D': return 500;
        case 'M': return 1000;
        default: return 0;
    }
}
	
	/**
	 * Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
	 * */
	public String intToRoman(int num) {
        String a[][] = {
        { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
        { "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
        { "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
        { "M", "MM", "MMM", "", "", "", "", "", "" }};
    String result = "";
    int key = 0; 
    while (num != 0) {
        int d = num - num / 10 * 10;
        if (d != 0) {
            result = a[key][d - 1] + result;
        }
        num /= 10;
        key++;
    }
    return result;
}
}
