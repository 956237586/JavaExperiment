package experiment4.exercise3;

import experiment4.exercise1.Circle;
import experiment4.exercise1.GeometricObject;

public class Exercise3 {
	public static double sumArea(GeometricObject[] a) {
		double ret = 0;
		for (int i = 0; i < a.length; i++) {
			ret += a[i].getArea();
		}
		return ret;
	}

	public static void main(String[] args) {
		GeometricObject[] geometrics = {
				new Circle(50),
				new Circle(30),
				new Rectangle(20, 40),
				new Rectangle(10, 10)
		};
		System.out.printf("Sum area is %.2f", sumArea(geometrics));
	}
}
