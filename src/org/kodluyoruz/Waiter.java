package org.kodluyoruz;
import java.util.concurrent.Semaphore;

public class Waiter implements Runnable
{
	private Chef chef;
	private Semaphore semaphore;
	
	public Waiter(Chef chef, Semaphore semaphore) {
		this.chef = chef;
		this.semaphore = semaphore;
	}
	
	@Override
	public void run() {
		
		try 
		{
			semaphore.acquire();
			System.out.println("Waiter takes order");
			Thread.sleep(5000);
			chef.run();
			System.out.println("Waiter deliver the order");
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		semaphore.release();
	}
}

