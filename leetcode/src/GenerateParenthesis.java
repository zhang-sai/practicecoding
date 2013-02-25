import java.util.ArrayList;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 * */
public class GenerateParenthesis {
	public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		ArrayList<String> retList = new ArrayList<String>();
		if(n == 0) {
			return retList;
		}
		
		retList.add("(");
		retList = this.generateParathesis(1, 0, retList, n);
		return retList;
    }
	
	ArrayList<String> generateParathesis(int leftNum, int rightNum, ArrayList<String> currStrs, int upbound) {
		if(leftNum == rightNum && leftNum == upbound) {
			return currStrs;
		}
		//invariant: leftNum >= rightNum
		ArrayList<String> retList = new ArrayList<String>();
		if(leftNum == rightNum) {
			//only append a ( here
			for(String currStr : currStrs) {
				retList.add(currStr + "(");
			}
			return this.generateParathesis(leftNum + 1, rightNum, retList, upbound);
		} else if(leftNum > rightNum) {
			if(leftNum == upbound) {
				for(String currStr : currStrs) {
					retList.add(currStr + ")");
				}
				return this.generateParathesis(leftNum, rightNum + 1, retList, upbound);
			} else {
				
				for(String currStr : currStrs) {
					retList.add(currStr + "(");
				}
				ArrayList<String> list1 = this.generateParathesis(leftNum + 1, rightNum, retList, upbound);
				
				retList.clear();
				for(String currStr : currStrs) {
					retList.add(currStr + ")");
				}
				ArrayList<String> list2 = this.generateParathesis(leftNum, rightNum + 1, retList, upbound);
				
				retList.clear();
				retList.addAll(list1);
				retList.addAll(list2);
				
				return retList;
				
			}
		} else {
			throw new Error();
		}
		
	}
	
	public static void main(String[] args) {
		GenerateParenthesis g = new GenerateParenthesis();
		System.out.println(g.generateParenthesis(3));
	}
	
}
