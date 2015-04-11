package experiment3.exercise3;

import experiment3.exercise1.Account;

public class SavingAccount extends Account {

	public SavingAccount() {

	}

	public SavingAccount(int id, double balance) {
		super(id, balance);
	}

	@Override
	public Account withDraw(double drawMoney) {
		if (drawMoney <= getBalance()) {
			super.withDraw(drawMoney);
		} else {
			System.out.println("Over the balance!");
		}
		return this;
	}

	@Override
	public String toString() {
		String ret = "This is a SavingAccount\n";
		return ret + super.toString();
	}

}
