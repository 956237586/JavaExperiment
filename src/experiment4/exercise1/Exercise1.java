package experiment4.exercise1;

public class Exercise1 {
	public static void main(String[] args) {
		ComparableCircle c1 = new ComparableCircle(30);
		ComparableCircle c2 = new ComparableCircle(20);
		if (c1.compareTo(c2) > 0) {
			System.out.println(c1);
		} else if (c1.compareTo(c2) < 0) {
			System.out.println(c2);
		} else {
			System.out.println("equal!");
		}
		
	}
}
