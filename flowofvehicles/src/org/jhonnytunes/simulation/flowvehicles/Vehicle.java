/**
 * 
 */
package org.jhonnytunes.simulation.flowvehicles;

/**
 * @author jhonnytunes
 * 
 */
public class Vehicle {

	private int priority;
	private boolean running;
	private Street street;
	private int pos;
	private String name;
	private boolean stoppedByPolicy;

	public Street getStreet() {
		return street;
	}

	void setStreet(Street street) {
		this.street = street;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean outOfStreet() {
		return pos > street.getSize() - 1;
	}

	public void advance() {
		this.street.advance(this);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pos;
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pos != other.pos)
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	
	
	

	public boolean isStoppedByPolicy() {
		return stoppedByPolicy;
	}

	public void setStoppedByPolicy(boolean stoppedByPolicy) {
		this.stoppedByPolicy = stoppedByPolicy;
	}

	public Vehicle() {

		this.pos = 0;
	}

	
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + this.name + (isRunning()? " R":" S")+"]";
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
