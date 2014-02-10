
/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 * */
public class DecodeWays {

	public int numDecodings(String s) {  
        int n = s.length();  
        if (n==0) {
            return 0;  
        }
        int[] dp = new int[n+1];  
        //empty string has 1 way to iterpret
        dp[0] = 1;  
        if (isValid(s.substring(0,1))) {
            dp[1] = 1;  
        } else {
            dp[1] = 0;  
        }
        //use dp
        for(int i=2; i<=n;i++){  
            if (isValid(s.substring(i-1,i)))  {
                dp[i] = dp[i-1];  //use the i- 1 number
            }
            if (isValid(s.substring(i-2,i)))  {
                dp[i] += dp[i-2];  
            }
        }  
        return dp[n];  
    }  
      
    public boolean isValid(String s){  
        if (s.charAt(0)=='0') {
            return false;  
        }
        int code = Integer.parseInt(s);  
        return code>=1 && code<=26;  
    }  


     
     //the recursive way fails in time
    // public int numDecodings(String s) {
    //     // Start typing your Java solution below
    //     // DO NOT write main() function
    //     if(s == null || s.length() == 0) {
    //         return 0;
    //     }
    //     if(s.startsWith("0")) {
    //         return -1;
    //     }
    //     int num = 0;
    //     if(s.length() > 1) {
    //         int restNum = numDecodings(s.substring(1));
    //         if(restNum != -1) {
    //             num = num + restNum;
    //         }
    //     }
    //     if(s.length() > 2) {
    //         String str = s.substring(0, 2);
    //         Integer i = Integer.parseInt(str);
    //         if(isChar(i)) {
    //             int restNum = numDecodings(s.substring(2));
    //             if(restNum != -1) {
    //                 num = num + restNum;
    //             }
    //         }
    //     }
    //     return num;
    // }
    
    // private boolean isChar(int num) {
    //     if(num < 1 || num > 26) {
    //         return false;
    //     }
    //     return true;
    // }
    
    private char numToChar(int num) {
        if(num < 1 || num > 26) {
            return 0; //a special num
        }
        return ((char)('A' + (num - 'A')));
    }
    
}
