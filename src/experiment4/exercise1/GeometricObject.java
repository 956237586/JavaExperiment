package experiment4.exercise1;

import java.util.Date;

import experiment4.exercise3.CanGetArea;

public abstract class GeometricObject implements CanGetArea {
	private String color = "white";
	private boolean filled;
	private Date createDate;

	public GeometricObject() {
		createDate = new Date();
	}

	public GeometricObject(String color, boolean filled) {
		this();
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public Date getCreateDate() {
		return createDate;
	}

	@Override
	public String toString() {
		return "created on " + createDate + 
				"\ncolor: " + color	+ 
				" and filled:" + filled;
	}

}
