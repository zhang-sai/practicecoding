package linkedin;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class H2O {

	
	Semaphore hs = new Semaphore(2);
	Semaphore os = new Semaphore(1);
	
	
	public void generateH() throws InterruptedException {
		System.out.println("calling: generate h");
		hs.acquire();
		System.out.println("H");
	}
	
	public void generateO() throws InterruptedException {
		System.out.println("calling: generate o");
		os.acquire();
		System.out.println("O");
	}
	
	static int hnum = 0;
	
	public void generateH2O() throws InterruptedException {
		System.out.println("calling: generate h2o");
		hs.release(2);
		os.release();
		
		System.out.println("H2O");
		hnum++;
	}
	
	public static void main(String[] args) throws InterruptedException {
		final H2O h = new H2O();
//		for(int i = 0; i < 10; i++) {
			Thread th = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j = 0; j < 400; j++) {
					    try {
							h.generateH();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
//					System.exit(1);
				}
			});
			th.start();
			Thread to = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j = 0; j < 200; j++) {
					    try {
							h.generateO();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
//					System.exit(1);
				}
			});
			to.start();
			Thread h2o = new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j = 0; j < 200; j++) {
					    try {
							h.generateH2O();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
//					System.exit(1);
				}
			});
			h2o.start();
			
			//kill all thread
			th.join();
			to.join();
			h2o.join();
			
			System.out.println("Number of waters: " + hnum);
//		}
		
	}
}
