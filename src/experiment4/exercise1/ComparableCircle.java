package experiment4.exercise1;

public class ComparableCircle extends Circle implements Comparable<Circle> {
	public ComparableCircle() {
		super();
	}

	public ComparableCircle(double radius) {
		super(radius);
	}

	@Override
	public int compareTo(Circle c) {
		return (int) Math.signum(this.getArea() - c.getArea());
	}

}
