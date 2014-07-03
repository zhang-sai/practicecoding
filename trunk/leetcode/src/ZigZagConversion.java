/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * */
public class ZigZagConversion {

	String convert(String s, int nRows) {  
	      if(nRows <= 1) {
	          return s;  
	      }
	      StringBuilder result = new StringBuilder();  
	      if(s.length() ==0) {
	          return result.toString();  
	      }
	      for(int i =0; i< nRows; i++) {  
	        for(int j =0, index =i;
	            index < s.length();
	            j++, index = (2*nRows-2)*j +i) { 
	          result.append(s.charAt(index));  //red element
	          if(i ==0 || i == nRows-1) {      //green     
	            continue;  
	          }  
	          if(index+(nRows- i-1)*2 < s.length()) {  
	            result.append(s.charAt(index+(nRows- i-1)*2));  
	          }  
	        }  
	      }  
	      return result.toString();  
	    }  
}
