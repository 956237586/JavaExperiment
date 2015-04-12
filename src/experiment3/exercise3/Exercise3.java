package experiment3.exercise3;

import experiment3.exercise1.Account;
import experiment3.exercise2.AtmMachine;

public class Exercise3 {

	public static void main(String[] args) {
		Account.setAnnualInterestRate(0.045);
		// According to the experiment requirement, create the following
		// instances.
		Account account0 = new Account(0, 100);
		Account account1 = new SavingAccount(1, 200);
		Account account2 = new CheckingAccount(2, 300, 100);
		Account[] accounts = { account0, account1, account2 };
		for (int i = 0; i < accounts.length; i++)
			System.out.println(accounts[i] + "\n");
		AtmMachine atm = new AtmMachine(accounts);
		atm.run();
	}

}
