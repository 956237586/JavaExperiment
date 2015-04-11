/**
 * Exercise2.java
 */
package experiment2.exercise2;

import java.util.Scanner;

public class Exercise2 {
	public static void main(String[] args) {
		StackOfIntegers stack = new StackOfIntegers();
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		in.close();
		// 用户输入结束
		int i = 2;
		while (!isPrime(number)) {
			if (isPrime(i) && number % i == 0) {
				stack.push(i);
				number /= i;
			} else { // i是素数、number可以被i整除
				i++; // 至少有一条不满足
			}
		}
		stack.push(number); // 最后剩下的数入栈
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public static boolean isPrime(int a) {
		boolean ret = true;
		int i = 2;
		for (i = 2; i <= Math.sqrt((double) a); i++) {
			if (a % i == 0) {
				ret = false;
				break;
			}
		}
		return ret;
	}
}
