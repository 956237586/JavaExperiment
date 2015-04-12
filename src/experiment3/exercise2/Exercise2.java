package experiment3.exercise2;

import experiment3.exercise1.Account;

public class Exercise2 {
	public static void main(String[] args) {
		Account[] accounts = new Account[10];
		for (int i = 0; i < accounts.length; i++) {
			// create an Account Array include 10
			// account which have 100 balance.
			accounts[i] = new Account(100);
		}
		AtmMachine atm = new AtmMachine(accounts);
		atm.run();
	}
}
