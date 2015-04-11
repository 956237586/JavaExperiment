/**
 * Fun.java
 */
package experiment2.exercise3;

public class Fun {
	public static final int SLOW = 1;
	public static final int MEDIUM = 2;
	public static final int FAST = 3;
	private int speed;
	private boolean on;
	private double radius;
	private String color;

	public Fun() {
		speed = SLOW;
		on = false;
		radius = 5;
		color = "blue";
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		String ret = "";
		if (isOn()) {
			ret = "speed = " + speed;
		} else {
			ret = "fan is off";
		}
		ret += "\ncolor = " + color + 
				"\nradius = " + radius;
		return ret;
	}

}
