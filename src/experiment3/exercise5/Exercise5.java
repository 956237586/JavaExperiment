package experiment3.exercise5;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JFrame;

import experiment2.exercise4.Tax;
import experiment3.exercise1.Account;

public class Exercise5 {

	public static void main(String[] args) {
		// Due to the use of generic, so we can add different types of objects
		// to this list.
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(new GregorianCalendar());
		list.add("This is a String");
		list.add(new Account());
		list.add(new Tax());
		list.add(new JFrame());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
