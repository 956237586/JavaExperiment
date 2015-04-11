/**
 * Exercise1.java
 */
package experiment2.exercise1;

import java.util.Random;

public class Exercise1 {
	public static void main(String[] args) {
		Random r = new Random(1000);
		for (int i = 1; i <= 50; i++) {
			System.out.print(r.nextInt(100) + "\t");
			if(i % 5 ==0)System.out.println();
		}
	}
}
