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
		// �û��������
		int i = 2;
		while (!isPrime(number)) {
			if (isPrime(i) && number % i == 0) {
				stack.push(i);
				number /= i;
			} else { // i��������number���Ա�i����
				i++; // ������һ��������
			}
		}
		stack.push(number); // ���ʣ�µ�����ջ
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
