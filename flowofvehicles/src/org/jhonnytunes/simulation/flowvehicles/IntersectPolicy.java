package org.jhonnytunes.simulation.flowvehicles;

public class IntersectPolicy {

	public static boolean policy(Vehicle vehicle, Vehicle otherVehicle) {

		return streetPriorityPolicy(vehicle, otherVehicle);

	}

	public static boolean streetPriorityPolicy(Vehicle one, Vehicle two){
		
		if(one.isStoppedByPolicy() && two.isStoppedByPolicy())
			return one.getPriority() > two.getPriority();
		
			
			return one.isStoppedByPolicy();
				
		
	}
}
