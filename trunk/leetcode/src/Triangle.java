import java.util.ArrayList;
import java.util.Collections;


/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * */
public class Triangle {
	
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(triangle.size() == 1) {
			return triangle.get(0).get(0);
		}
		ArrayList<ArrayList<Integer>> minValues = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < triangle.size(); i++) {
			ArrayList<Integer> oneLevel = triangle.get(i);
			ArrayList<Integer> minValueList = new ArrayList<Integer>();
			for(int j = 0; j < oneLevel.size(); j++) {
				if(i == 0) {
					minValueList.add(oneLevel.get(0));
				} else {
					int minValue = Integer.MAX_VALUE;
					if(j == 0) {
						minValue = minValues.get(i - 1).get(0) + oneLevel.get(j);
					} else if (j == i) {
						minValue = minValues.get(i - 1).get(j - 1) + oneLevel.get(j);
					} else {
					    minValue = Math.min(minValues.get(i - 1).get(j - 1), minValues.get(i - 1).get(j)) + oneLevel.get(j);
					}
					minValueList.add(minValue);
				}
			}
			minValues.add(minValueList);
		}
        return Collections.min(minValues.get(minValues.size() -1));
    }
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(1);
		l2.add(2);
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		l3.add(1);
		l3.add(2);
		l3.add(3);
		list.add(l1);
		list.add(l2);
		list.add(l3);
		Triangle t = new Triangle();
		int value = t.minimumTotal(list);
		System.out.println(value);
	}
}