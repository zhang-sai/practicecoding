package linkedin;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a thread-safe Blocking queue in C/C++(POSIX) or Java
 * http://www.careercup.com/question?id=14622668
 * 
 * similar: http://www.careercup.com/question?id=14004678
 * */
class BlockingQueue {
xx
	private Queue<Object> queue = new LinkedList<Object>();
	private int limit = 10;

	public BlockingQueue(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		// Notify all the threads that are waiting
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}

		return this.queue.remove(0);
	}
}
