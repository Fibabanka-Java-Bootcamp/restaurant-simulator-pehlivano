package org.kodluyoruz;
import java.util.concurrent.Semaphore;

public class Client implements Runnable
{
	private Waiter waiter;
	private Semaphore semaphore;
	
	public Client(Waiter waiter, Semaphore semaphore) 
	{
		this.waiter = waiter;
		this.semaphore = semaphore;
	}
		
	@Override
	public void run() {
		try 
		{
			semaphore.acquire();
			System.out.println("Client sat to the table");
			System.out.println("Client Orders...");
			waiter.run();
			Thread.sleep(10000);
			System.out.println("Client leaves");
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}	
		semaphore.release();
	}
	
}
