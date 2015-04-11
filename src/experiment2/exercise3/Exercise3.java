/**
 * Exercise3.java
 */
package experiment2.exercise3;

public class Exercise3 {
	public static void main(String[] args) {
		Fun fun1 = new Fun();
		Fun fun2 = new Fun();
		
		fun1.setSpeed(Fun.FAST);
		fun1.setRadius(10);
		fun1.setColor("yellow");
		fun1.setOn(true);
		
		fun2.setSpeed(Fun.MEDIUM);
		fun2.setRadius(5);
		fun2.setColor("blue");
		fun2.setOn(false);
		
		System.out.println("fun1 status:\n" + fun1);
		System.out.println("\nfun2 status:\n" + fun2);
		//此处由于重写了toString()方法
		//所以会自动调用Fun类自己的toString()
	}
}
