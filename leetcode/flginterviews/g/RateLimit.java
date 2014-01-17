package g;

/**
 * brief example:
server instantiates your object, calls setQPS(1)
at at time t, user1 makes a request, allowThisRequest() returns true
at time t+0.01 sec, user2 makes a request, allowThisRequest() returns false
at at time t+1, user4 makes a request, allowThisRequest() returns true
at time t+5 sec, user3 makes a request, allowThisRequest() returns true

http://www.mitbbs.com/article_t/JobHunting/32608789.html
http://en.wikipedia.org/wiki/Leaky_bucket
 * */

/**
 * Be aware of multithreading
 * */

//google's implementation:
//http://code.google.com/p/guava-libraries/source/browse/guava/src/com/google/common/util/concurrent/RateLimiter.java

//suppose two successive requests should be < 1/qps

//may result in underutilization, or overutilization
//thread, synchronization, 
interface RateLimitInterface {
    /** Sets the rate, from 1 to 1000000 queries per second */
    void setQPS(int qps);

    /** accept or reject a request, called when request is received */
    boolean allowThisRequest();
}

public class RateLimit implements RateLimitInterface {

	long maxRate;
	
	float minTime;
	
	long lastActionTime = System.currentTimeMillis();
	
	@Override
	public void setQPS(int qps) {
		// TODO Auto-generated method stub
		maxRate = qps;
		minTime = 1.0f/maxRate;
	}

	@Override
	public boolean allowThisRequest() {
		// TODO Auto-generated method stub
		long currTime = System.currentTimeMillis();
		
		synchronized(this) {
			if(currTime - lastActionTime >= minTime) {
				lastActionTime = currTime;
				return true;
			} else {
				return false;
			}
		}
	}

}
