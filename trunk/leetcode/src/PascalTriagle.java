import java.util.ArrayList;


public class PascalTriagle {

	/**
	 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
	 * */
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < numRows; i++) {
			if(i == 0) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(1);
				retList.add(list);
			} else {
				ArrayList<Integer> prevList = retList.get(i - 1);
				ArrayList<Integer> currList = new ArrayList<Integer>();
				currList.add(1);
				for(int j = 1; j < prevList.size(); j++) {
					currList.add(prevList.get(j) + prevList.get(j - 1));
				}
				currList.add(1);
				retList.add(currList);
			}
		}
		
		return retList;
    }
	
	/**
	Given an index k, return the kth row of the Pascal's triangle.

	For example, given k = 3,
	Return [1,3,3,1].

	Note:
	Could you optimize your algorithm to use only O(k) extra space?
	*/
	//the rowIndex is 0-based
	public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> list = new ArrayList<Integer>(rowIndex + 1);
        for(int i = 0; i <= rowIndex; i++) { //XXX it is <=
        	list.add(0);
        }
        for(int i = 0; i <= rowIndex; i++) { //XXX it is <=
        	if(i == 0) {
        		list.set(0, 1);
        	} else {
        		int prevValue = 1;
        		for(int j = 1; j < rowIndex; j++) {
        			int value = prevValue + list.get(j);
        			prevValue = list.get(j);
        			list.set(j, value);
        		}
        	}
        }
        list.set(rowIndex, 1);
        return list;
    }
	
	public static void main(String[] args) {
		PascalTriagle pt = new PascalTriagle();
		System.out.println(pt.getRow(1));
	}
}
