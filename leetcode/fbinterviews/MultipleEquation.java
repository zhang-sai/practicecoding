import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * For some N, print all the solutions of A * B = C * D where A, B, C
, D are all 1-N.


eg. n=2
print:
1 * 1 = 1 * 1
1 * 2 = 1 * 2
1 * 2 = 2 * 1
2 * 1 = 1 * 2
2 * 1 = 2 * 1
2 * 2 = 2 * 2
 * */
x
public class MultipleEquation {
	
	public static void main(String[] args) {
		MultipleEquation me = new MultipleEquation();
//		me.printN(2);
	}

//	void printN(int n) {
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < n; j++) {
//                Set<Pair> pairSet = getPairSet(i * j);
//                for (Pair pair : pairSet) {
//                    System.out.println(i + "*" + j + "=" + pair.i + "*" + 
//pair.j);
//                }
//            }
//        }
//    }
//
//    Map<Integer, Set<Pair>> map = new HashMap<Integer, Set<Pair>>();
//
//    Set<Pair> getPairSet(int product) {
//        if (map.containsKey(new Integer(product)))
//            return map.get(new Integer(product));
//        Set<Pair> pairSet = new HashSet<Pair>();
//        for (int i = 1; i < product; i++) {
//            if (product % i == 0)
//                pairSet.add(new Pair(i, product / i));
//        }
//        map.put(new Integer(product), pairSet);
//        return map.get(new Integer(product));
//    }
//
//    class Pair {
//        int i;
//        int j;
//
//        public Pair(int i, int j) {
//            this.i = i;
//            this.j = j;
//        }
//    }
	
}
