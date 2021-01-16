package org.kodluyoruz;
import java.util.concurrent.Semaphore;

public class Chef implements Runnable {
	
	private Semaphore semaphore;
	
	public Chef(Semaphore semaphore) {
		this.semaphore = semaphore;
	}
	
	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		try {
			semaphore.acquire();
			makeFood();
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		semaphore.release();
	}
	
	public void makeFood() throws InterruptedException {
		System.out.println("Chef Started to make Food");
		Thread.sleep(5000);
		System.out.println("Chef finished making food");
	}
		
}
