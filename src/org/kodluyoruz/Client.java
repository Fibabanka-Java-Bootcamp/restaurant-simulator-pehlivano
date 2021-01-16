package org.kodluyoruz;

public class Client implements Runnable
{
	private Waiter waiter;
	
	private Client(Waiter waiter) {
		this.waiter = waiter;
	}
	
	public void makeOrder() {
		waiter.takeOrder();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		makeOrder();
	}
	
	

}
