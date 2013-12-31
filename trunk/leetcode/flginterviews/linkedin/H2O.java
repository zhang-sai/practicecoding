package linkedin;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
x
public class H2O {

	List<Object> hlist = new LinkedList<Object>();
	List<Object> olist = new LinkedList<Object>();
	
	
	private final ReentrantLock hlock = new ReentrantLock();
	private final ReentrantLock olock = new ReentrantLock();
	
	private final ReentrantLock h2olock = new ReentrantLock();
	
	private final Condition hc = hlock.newCondition();
	private final Condition oc = olock.newCondition();
	
	private final Condition c = h2olock.newCondition();
	
	static int hnumber = 0;
	
	public void generateH() throws InterruptedException {
		hlock.lockInterruptibly();
		try {
			hlist.add("H");
			System.out.println("H");
			if(hlist.size() >= 2) {
				
//				h2olock.lockInterruptibly();
				hc.signal();
//				h2olock.unlock();
			}
			
		} finally {
			hnumber++;
			System.out.println("H: " + hnumber);
			hlock.unlock();
		}
	}
	
	static int onumber = 0;
	
	public void generateO() throws InterruptedException {
		olock.lockInterruptibly();
		try {
			olist.add("O");
			System.out.println("O");
//			h2olock.lockInterruptibly();
			oc.signal();
//			h2olock.unlock();
		} finally {
			onumber++;
			System.out.println("O: " + onumber);
			olock.unlock();
		}
	}
	
	static int h2onumber = 0;
	
	public void generateH2O() throws InterruptedException {
//		h2olock.lockInterruptibly();
		hlock.lockInterruptibly();
		olock.lockInterruptibly();
		try {
			while(hlist.size() < 2 || olist.isEmpty()) {
//				c.await();
				hc.await();
				oc.await();
			}
//			hlock.lockInterruptibly();
//			olock.lockInterruptibly();
			
			hlist.remove(0);
			hlist.remove(0);
			olist.remove(0);
			System.out.println("Generate H2O");
			
//			hlock.unlock();
//			olock.unlock();
		} finally {
//			h2olock.unlock();
			h2onumber++;
			System.out.println("H2O number: " + h2onumber);
			hlock.unlock();
			olock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final H2O h = new H2O();
		for(int i = 0; i < 10; i++) {
			Thread th = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j = 0; j < 100; j++) {
					    try {
							h.generateH();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			th.start();
			Thread to = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j = 0; j < 100; j++) {
					    try {
							h.generateO();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			to.start();
			Thread h2o = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j = 0; j < 100; j++) {
					    try {
							h.generateH2O();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			h2o.start();
		}
		
	}
}
