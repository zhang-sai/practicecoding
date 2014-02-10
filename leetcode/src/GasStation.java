
/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
 * */
public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(gas.length == 0) {
            return -1;
        }
        int sum = 0;
        int[] delta = new int[gas.length];
        for(int i = 0; i < gas.length; i++) {
            delta[i] = gas[i] - cost[i];
            sum += delta[i];
        }
        //the total amount < 0
        if(sum < 0) {
            return -1;
        }
        int index = 0;
        int currTotal = 0;
        //cannot be the starting point, since before coming
        //to i, there is at least SOME gas in the car
        for(int i = 0; i < delta.length; i++) {
            currTotal += delta[i];
            if(currTotal < 0) {
                currTotal = 0;
                index = i;
            }
        }
        
        return (index + 1)%delta.length;  //go to the next station
        
    }
}
