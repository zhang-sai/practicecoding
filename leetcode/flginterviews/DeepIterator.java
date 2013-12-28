import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * LinkedIn
 * Program an iterator for a List which may include nodes or List  i.e.  * {0,
{1,2}, 3 ,{4,{5, 6}}} Iterator returns 0 - 1 - 2 - 3 - 4 - 5 - 6"

what about empty list? such as {1, 2, {}, 3}
 * */

public class DeepIterator {
	
	
    static class DeepIter implements Iterator {
    	//the input
    	final List list;;
    	
    	//not empty iterator
    	Object currObj = null;
    	Iterator currIter = null;
    	Stack<Iterator> iterStack = null;
    	
    	public DeepIter(List list) {
			this.list = list;
			currIter = list.iterator();
			this.fetchNextValue(); //fetch next object
		}
    	
		@Override
		public boolean hasNext() {
			//check if the current object is not null
			return currObj != null;
		}

		@Override
		public Object next() {
			Object retObj = currObj;
			fetchNextValue();
			return retObj;
		}
		
		private void fetchNextValue() {
			//do initialization
			if(iterStack == null) {
				iterStack = new Stack<Iterator>();
				currIter = this.list.iterator();
			}
			while(!currIter.hasNext()) {
				//pop up the rest
				//no more iterator, just return
				if(iterStack.isEmpty()) {
					currObj = null;
					return;
				} else {
				    currIter = iterStack.pop();
				}
			}
			//find an iterator that has at least one element
			Object nextObj = currIter.next();
			while(nextObj instanceof List) {
				//push the current iterator to the stack
				iterStack.push(currIter);
				currIter = ((List)nextObj).iterator();
				while(!currIter.hasNext()) {
					if(iterStack.isEmpty()) {
						currObj = null;
						return;
					} else {
					    currIter = iterStack.pop();
					}
				}
				nextObj = currIter.next();
			}
			//the next obj is
			currObj = nextObj;
		}

		@Override
		public void remove() {
			throw new Error();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Object n0 = 0;
		Object n1 = 1;
		Object n2 = 3;
		Object n3 = 3;
		Object n4 = 4;
		Object n5 = 5;
		Object n6 = 6;
		
		List l1 = new LinkedList();
		l1.add(n1);
		l1.add(n2);
		
		List l2 = new LinkedList();
		l2.add(n5);
		l2.add(n6);
		
		List l3 = new LinkedList();
		l3.add(n4);
		l3.add(l2);
		
		List l4 = new LinkedList(); //this is an empty iterator
		
		List l5 = new LinkedList();
		l5.add(new LinkedList());
		l5.add(new LinkedList());
		
		List l6 = new LinkedList();
		l6.add(7);
		l6.add(8);
		
		List all = new LinkedList();
		all.add(n0);
		all.add(l1);
		all.add(n3);
		all.add(l3);
		all.add(l4);
		all.add(l6);
		all.add(9);
		all.add(10);
		
		//{0,  {1,2},  3 ,  {4,{5, 6}},  {}, {{},{}}, {7, 8}, 9, 10}
		
		DeepIter iter = new DeepIter(all);
		
		while(iter.hasNext()) {
			Object node = iter.next();
			System.out.println(node);
		}
		
		all = new LinkedList();
        iter = new DeepIter(all);
		
		while(iter.hasNext()) {
			Object node = iter.next();
			System.out.println(node);
		}
		
	}
	
}


