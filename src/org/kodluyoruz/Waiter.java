package org.kodluyoruz;

public class Waiter implements Runnable
{
	private Chef chef;
	
	public Waiter(Chef chef) {
		this.chef = chef;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		takeOrder();
	}
	
	public void takeOrder() {
		chef.makeFood();
	}
}
