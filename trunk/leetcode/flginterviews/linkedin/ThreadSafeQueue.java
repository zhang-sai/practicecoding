package linkedin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implement a thread-safe Blocking queue in C/C++(POSIX) or Java
 * http://www.careercup.com/question?id=14622668
 * 
 * similar: http://www.careercup.com/question?id=14004678
 * 
 * a good tutorial:
 * http://tutorials.jenkov.com/java-util-concurrent/blockingqueue.html#blockingqueue-implementations
 * 
 * a standard answer:
 * http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/Condition.html
 * */

class BlockingQueue<T> {

	private Queue<T> queue = new LinkedList<T>();
	private int limit = 10;
	
	/** Main lock guarding all access */
    private final ReentrantLock lock;
    /** Condition for waiting takes */
    private final Condition notEmpty;
    /** Condition for waiting puts */
    private final Condition notFull;

	public BlockingQueue(int limit) {
		this.limit = limit;
		lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull =  lock.newCondition();
	}

	public void enqueue(T item) throws InterruptedException  {
		lock.lockInterruptibly();
		try {
			while(queue.size() == this.limit) {
				notFull.await(); //wait until receiving a not full signal
			}
			queue.add(item);
			//now signal the not empty condition
			notEmpty.signalAll(); //or signal();
			
			/**
			 * or you can add:
			 * 
			 * catch (InterruptedException ie) {
                notFull.signal(); // propagate to non-interrupted thread
                throw ie;
                
                if the current thread is interrupted, then signal the
                notFull signal
			 * */
		} finally {
		    System.out.println("add: " + item);
		    lock.unlock();
		}
	}

	public T dequeue() throws InterruptedException {
		this.lock.lockInterruptibly();
		try {
			while(this.queue.size() == 0) {
				this.notEmpty.await();
			}
			T t = this.queue.remove();
			System.out.println("remove: " + t);
			notFull.signalAll();
		
			return t;
		} finally {
			lock.unlock();
		}
	}
	
	static int count = 0;
	
	
	public static void main(String[] args) {
		final BlockingQueue<Object> q = new BlockingQueue<Object>(4); 
		
		
		
		Thread p1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for(int i = 0; i < 10; i++) {
						String s = "Item" + count++;
					    q.enqueue(s);;
					    
					    s = "Item" + count++;
					    q.enqueue(s);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread p2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for(int i = 0; i < 10; i++) {
						String s = "Item" + count++;
					    q.enqueue(s);;
					    
					    s = "Item" + count++;
					    q.enqueue(s);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread c1 = new Thread (new Runnable() {
			@Override
			public void run() {
				try {
					for(int i = 0; i < 40; i++) {
					    Object o = q.dequeue();
//					    System.out.println("get: " + o + " " + System.currentTimeMillis());
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		p1.start();
		p2.start();
		c1.start();
	}
}
