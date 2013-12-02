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

xx
public class DeepIterator {
	
	
	static class DeepListNode {
		int val;
		DeepListNode(int v) {val = v;}
		
	}
	
	static class DeepList {
		List content = new LinkedList();
		public void add(DeepListNode o) {
			content.add(o);
		}
		public void add(DeepList list) {
			content.add(list);
		}
		
		//recursive printing
		public void printAll() {
			for(Object o : content) {
				if(o instanceof DeepListNode) {
					System.out.println(((DeepListNode)o).val);
				} else if (o instanceof DeepList) {
					((DeepList)o).printAll();
				}
			}
		}
	}

	
    static class DeepIter implements Iterator<DeepListNode> {

    	final List list;
    	DeepListNode nextElem = null;
    	
    	Iterator currIter = null;
    	Stack<Iterator> iterStack = new Stack<Iterator>();
    	
    	public DeepIter(List list) {
			this.list = list;
			currIter = list.iterator();
		}
    	
		@Override
		public boolean hasNext() {
//			currElem != null;
			
			//need to jump to a valid element
			if(currIter.hasNext()) {
				return true; //
			}
			
			if(iterStack.isEmpty()) {
				return false;
			}
			
//			currIter = iterStack.pop();
			while(!currIter.hasNext() && !iterStack.isEmpty()) {
				currIter = iterStack.pop();
			}
			
			return currIter.hasNext();
		}

		@Override
		public DeepListNode next() {
			// TODO Auto-generated method stub
			Object currObj = currIter.next();
			
			if(currObj instanceof DeepListNode) {
				return (DeepListNode)currObj;
			} else if (currObj instanceof List) {
				iterStack.push(currIter);
				currIter = new DeepIter((List)currObj);
//				while(currIter.)
				return (DeepListNode)currIter.next();
			}
				
			return null;
		}

		@Override
		public void remove() {
			throw new Error();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		DeepListNode n0 = new DeepListNode(0);
		DeepListNode n1 = new DeepListNode(1);
		DeepListNode n2 = new DeepListNode(2);
		DeepListNode n3 = new DeepListNode(3);
		DeepListNode n4 = new DeepListNode(4);
		DeepListNode n5 = new DeepListNode(5);
		DeepListNode n6 = new DeepListNode(6);
		
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
		
		List all = new LinkedList();
		all.add(n0);
		all.add(l1);
		all.add(n3);
		all.add(l3);
		all.add(l4);
		
		DeepIter iter = new DeepIter(all);
		
		while(iter.hasNext()) {
			DeepListNode node = iter.next();
			System.out.println(node.val);
		}
		
	}
	
}


