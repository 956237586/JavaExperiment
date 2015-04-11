/**
 * StackOfIntegers.java
 */
package experiment2.exercise2;

public class StackOfIntegers {
	private int[] elements;
	private int pointerOfTop = -1;
	private int size;
	public static final int DEFAULTSIZE = 16;

	public StackOfIntegers() {
		this(DEFAULTSIZE);
	}

	public StackOfIntegers(int size) {
		if (size <= 0)size = DEFAULTSIZE;
		elements = new int[size];
		this.size = size;
	}

	public boolean isEmpty() {
		if (pointerOfTop == -1)return true;
		else return false;
		
	}

	public boolean isFull() {
		if (pointerOfTop == size - 1) {
			return true;
		} else {
			return false;
		}
	}

	public int getSize() {
		return this.size;
	}

	public void push(int a) {
		if (isFull()) {
			int[] newElements = new int[size *= 2];
			System.arraycopy(
					elements, 0, 
					newElements, 0, 
					elements.length);
			elements = newElements;
		}
		elements[++pointerOfTop] = a;
	}

	public int pop() {
		int ret = Integer.MIN_VALUE;
		if (isEmpty() != true)
			ret = elements[pointerOfTop--];
		return ret;
	}
}
