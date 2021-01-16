package org.kodluyoruz;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Semaphore chefSemaphore = new Semaphore(2,true);
		Semaphore waiterSemaphore = new Semaphore(3,true);
		Semaphore clientSemaphore = new Semaphore(5,true);
		
		Chef chef = new Chef(chefSemaphore);
		Waiter waiter = new Waiter(chef, waiterSemaphore);
		Client client = new Client(waiter,clientSemaphore);
		
		//Thread threadClient = new Thread(client);
		//Thread threadWaiter = new Thread(waiter);
		//Thread threadChef = new Thread(chef);
		
		Thread[] threadPool = new Thread[15];
		for(int i=0; i<15; i++) {
			threadPool[i] = new Thread(client);
			threadPool[i].start();
			//Thread.sleep(1000);
		}	
	}
}
