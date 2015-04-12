package experiment3.exercise3;

import experiment3.exercise1.Account;

/**
 * This class extends general Account, the difference is this class can't over
 * drawn.
 * 
 * @author HYL
 *
 */
public class SavingAccount extends Account {

	public SavingAccount() {

	}

	/**
	 * This constructor can create an SavingAccount instance which have balance.
	 * 
	 * @param id
	 *            account id
	 * @param balance
	 *            account balance
	 */
	public SavingAccount(int id, double balance) {
		super(id, balance);
	}

	// The difference from superclass is withDraw function,
	// so, override it.
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
