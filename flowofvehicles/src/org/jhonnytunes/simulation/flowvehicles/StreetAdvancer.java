package org.jhonnytunes.simulation.flowvehicles;

import java.util.Random;

public class StreetAdvancer implements Runnable {

	@Override
	public void run() {

		while (running) {
			painter.lock();
			moveVehicles();
			painter.unlock();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private boolean lock=false;
	
	
	
	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	private volatile boolean running = true;

	private Street street;

	private SimpleIntersectPainter painter;

	private Street street2;

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void moveVehicles() {
		this.street.advanceAll();
		this.street2.advanceAll();
	}

	
	public Street getStreet2() {
		return street2;
	}

	public void setStreet2(Street street2) {
		this.street2 = street2;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public StreetAdvancer(Street street, Street street2, SimpleIntersectPainter painter) {
		this.street = street;
		this.street2 = street2;
		this.painter = painter;

	}

}