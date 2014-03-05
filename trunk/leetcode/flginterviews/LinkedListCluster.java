import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * http://www.mitbbs.com/article_t/JobHunting/32573325.html
 * 
class Node{
   public Node next();
}

a list,which is: a b c d e f g...  z

given a, b c, e g

==>  abc
=> e
=>g
 * */
public class LinkedListCluster {
	
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(5);
		set.add(7);
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		
		int count = 0;
		boolean isPrevIn = false;
		for(int v : list) {
			if(set.contains(v)) {
				if(!isPrevIn) {
					count++;
					isPrevIn = true;
				}
			} else {
				isPrevIn = false;
			}
		}
		
		System.out.println(count);
	}

}