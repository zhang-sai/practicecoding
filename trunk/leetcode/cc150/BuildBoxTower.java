import java.util.Iterator;
import java.util.LinkedList;


//a stack of box, each has w, h, d
//can only be put on top of one another if 3 dims are strictly larger
public class BuildBoxTower {

	//use the longest substring
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(5);
		list.add(4);
		list.add(2);
		
		System.out.println(list);
		
		Iterator<Integer> it = list.iterator();
		it.next();
		it.next();
		it.remove();
		System.out.println(list);
	}
}

