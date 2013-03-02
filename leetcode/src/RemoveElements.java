/**
 * Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * */
public class RemoveElements {
	public int removeElement(int[] a, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = a.length;
        if(size == 0) { //whatever
        	return size;
        }
        //remove in place
        int i = 0;
        int j = -1;
        while(i < size) {
        	if(a[i] == elem) {
        		j = Math.max(i, j); //XXX start from the current i
        		j = j + 1;
        		while(j < size && a[j] == elem) {
        			j++;
        		}
        		if(j == size) {
        			break;
        		} else {
        			//j is the first 
        			a[i] = a[j];
        			a[j] = elem;
        		}
        	}
        	i++;
        }
        
        return i;
    }
	
	public static void main(String[] args) {
		RemoveElements re = new RemoveElements();
		int[] a = new int[]{3};
		System.out.println(re.removeElement(a, 3));
		for(int v : a) {
			System.out.print(v + "  ");
		}
	}
}
