package twitter;

/**
 Hardy-Ramanujan Number

1729 = 1 ^ 3 + 12^3 = 9^3 +10^3

An integer that can be expressed as the sum of two cubes for at least two ways.

K = a ^ 3 + b ^ 3 = c ^ 3 + d ^ 3

Given positive int N, find out (print) all the HRN numbers that are between 1 and N (all k, where 1<=k<=N)

//n^(1 + 4/3) == n^(2.333333)
public void printALLHRNNumbers(int bound) {
    //check the input, the bound can be more tight
    if(bound < 3) {
        throw new IllegalArgumentException("The bound is illegal.");
    }
    //then we check each value between 1 and the cubic_sqrt(N);
    for(int v = 3; v < cubic_sqrt(N); v++) {
        if(isHRNumber(v)) {
            System.out.println("Number: " + v);
        }
    }
}

//n^(4/3)
private boolean isHRNumber(int N) {
   //for each a, b, c, and d, check whether there exists a formula
   int upbound = cubic_sqrt(N);
   for(int a = 1; a <= upbound; a++) {
       int a3 = a*a*a;
       //start at a to look for b
       for(int b = a; b <= upbound; b++) {
           int b3 = b*b*b;
           
           //we find a combination of a and b
           if(a3 + b3 == N) {
               //we start from a + 1
               for(int c = a + 1; c <= upbound; c++) {
                   int c3 = c*c*c;
                   
                   //start at c to look for d
                   for(int d = c; d <= upbound; d++) {
                           int d3 = d*d*d;
                       if(c3 + d3 == N) {
                           //we find one
                           //here, a, b, c, d must not the same
                           return true;
                       }
                   }
               }
           }
           
       }
       
       return false;
   }
}


public void findAllRHNumber() {
  //this map keeps track of the number of possible ways 
  //that a key can be divided into cubic + cubic
  //for given example: 
  //1729, it corresponds to an entry in the map
  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
  
  // < O(n^(2/3))
  
  for(int i = 1; i <= pow(N, 1/3); i++) {
     for(int j = i + 1; j <= pow(N, 1/3); j++) {
          int value = i*i*i + j*j*j;  //no overflow here
          if(value <= N) {
              if(!map.containsKey(value)) {
                 map.put(value, 1);
              } else {
                 map.put(value, map.get(value) + 1);
                 if(map.get(value) == 2) {
                 //we have already got one way to form the number N
                    System.out.println("We find a HR number: " + value);
                 }
              }
          }
     }
  }
  }
 
 
 * */
public class FindHRNumber {

}
