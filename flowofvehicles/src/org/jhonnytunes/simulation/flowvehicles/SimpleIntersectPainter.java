package org.jhonnytunes.simulation.flowvehicles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleIntersectPainter implements Runnable {

	private volatile boolean running = true;

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void run() {
		while (running) {
			paint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private int horizontalStreetPosition;
	private int verticalStreetPosition;

	private Street horizontal;
	private Street vertical;
	private int horizontalSize;
	private int verticalSize;
	private boolean locked;

	public SimpleIntersectPainter(Street horizontal, Street vertical) {

		horizontalSize = horizontal.getSize();
		verticalSize = vertical.getSize();
		this.horizontal = horizontal;
		this.vertical = vertical;

		verticalStreetPosition = vertical.findOtherStreetIntersect(horizontal);
		horizontalStreetPosition = horizontal
				.findOtherStreetIntersect(vertical);

	}

	public Street getHorizontal() {
		return horizontal;
	}

	public Street getVertical() {
		return vertical;
	}

	public void print(String string) {

		System.out.print(string);
	}

	public void paint() {

		if (vertical.getVehicles() == null || vertical.getVehicles().isEmpty()
				|| horizontal.getVehicles() == null
				|| horizontal.getVehicles().isEmpty())
			return;

		if (locked)
			return;

		print("\n#################Escena##################\n");
		for (int i = 0; i < horizontalSize; i++) {

			for (int j = 0; j < verticalSize; j++) {

				if (i == horizontalStreetPosition
						&& j == verticalStreetPosition) {
					print(checkIfVehicleHorizontal(j).compareTo("[     ]")==0? checkIfVehicleVertical(i) : checkIfVehicleHorizontal(j));
				}else
				if (i == horizontalStreetPosition)
					print(checkIfVehicleHorizontal(j));
				else if (j == verticalStreetPosition)
					print(checkIfVehicleVertical(i));
				else
					print("XXXXXXX");

			}
			print("\n");
		}

		print("####################Fin de Escena###############\n");
		// print("\nver: "+vertical.getVehicles());
		// print("\nhori: "+horizontal.getVehicles());
		// print("\nverpos: "+vertical.getVehicles().get(0).getPos());
		// print("\nhorpos: "+horizontal.getVehicles().get(0).getPos());
		//

	}

	private String checkIfVehicleVertical(int pos) {

		return checkIfVehicle(pos, vertical);
	}

	private String checkIfVehicleHorizontal(int pos) {

		return checkIfVehicle(pos, horizontal);
	}

	private String checkIfVehicle(int pos, Street street) {

		if (street == null || street.getVehicles() == null
				|| street.getVehicles().isEmpty())
			return "@EMPTY@";

		street.setLocked(true);

		List<Vehicle> vehicles = street.getVehicles();
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getPos() == pos) {
				street.setLocked(false);
				return vehicle.toString();
			}
			// System.out.print(pos+"=="+vehicle.getPos());

		}

		street.setLocked(false);
		return "[     ]";
	}

	public void lock() {

		this.locked = true;
	}

	public void unlock() {
		this.locked = false;
	}
}
