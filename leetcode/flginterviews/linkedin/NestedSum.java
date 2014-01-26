package linkedin;

import java.util.LinkedList;
import java.util.List;

/**
 *  {1, 2, {3, 4}, {{5, 6, 7}, 8} }
 * */
public class NestedSum {

	public static int sum(List list) {
		int sum = 0;
		for(Object obj : list) {
			if(obj instanceof Integer) {
				sum += (Integer)obj;
			} else {
				sum += sum((List)obj);
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		List list = new LinkedList();
		list.add(1);
		list.add(2);
	
		List list1 = new LinkedList();
		list1.add(3);
		list1.add(4);
		list.add(list1);
		
		List list2 = new LinkedList();
		List list3 = new LinkedList();
		list3.add(5);
		list3.add(6);
		list3.add(7);
		list2.add(list3);
		list2.add(8);
		list.add(list2);
		
		System.out.println(sum(list));
	}
}

