
/**
 * Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
 * */
public class PalindromeNumber {

	public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x < 0) {
            return false;
        }
        if(x < 10) {
            return true;
        }
        int v = 10;
        while(x/v >= 10) { //did not handle overflow well: 1000000001, this is for handling overflow, not x/v > 0
            v = v*10;
        }
        //iteratively compare the first number and the last number
        while(x != 0) {
            int last = x%10;
            int first = x/v;
            if(last != first) {
                return false;
            }
            x = (x % v) / 10;
            v = v / 100;
        }
        return true;
    }
}
