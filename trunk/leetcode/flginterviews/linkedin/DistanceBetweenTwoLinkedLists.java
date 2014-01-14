package linkedin;

import java.util.List;


/* This class will be given a list of words (such as might be tokenized
 * from a paragraph of text), and will provide a method that takes two
 * words and returns the shortest distance (in words) between those two
 * words in the provided text. 
 * Example:
 *   String[] words = {"the", "quick", "brown", "fox"};
 *   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList(words));
 *   System.out.println("dist between 'fox' and 'the' = " + finder.distance("fox","the"));            // 3
 *   System.out.println("dist between 'quick' and 'brown' = " + finder.distance("quick", "brown"));   // 1
 */
public class DistanceBetweenTwoLinkedLists {


    
    //predication: l1, l2 are sorted
    private int computeMinDistance_efficient(List<Integer> l1, List<Integer> l2) {
       int minDistance = Integer.MAX_VALUE;
       
       int index1 = 0;
       int index2 = 0;
       
       while(index1 <l1.size() - 1  && index2 < l2.size() - 1) {
           int v1 = l1.get(index1);
           int v2 = l2.get(index2);
           minDistance = Math.min(Math.abs(v1-v2), minDistance);
           //move the smaller index forward
           if(v1 < v2) {
               //move the v1 iterator 
               index1++;
           } else {
               //move the v2 iterator
               index2++;
           }
       }
       
       // 1,  6,  10
       // 7, 11, 12
       //10 and 11
       if(index1 < l1.size() - 1) {
    	   //keep traversing  and update min distance
    	   
       } else if(index2 < l2.size() - 1) {
    	   //keep traversing and update min distance
    	   
       }
       
       
       return minDistance;
    }
}
