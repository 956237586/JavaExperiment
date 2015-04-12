package experiment3.exercise3;

import experiment3.exercise1.Account;

/**
 * This class extends general Account, the difference is this class can over
 * drawn. It has an property "overDrawnLimit" definition the account over drawn
 * limit.
 * 
 * @author HYL
 *
 */
public class CheckingAccount extends Account {
	private double overDrawnLimit;

	public CheckingAccount() {

	}

	/**
	 * This constructor can create an Checking Account instance which have
	 * balance and over drawn limit.
	 * 
	 * @param id
	 *            account id
	 * @param balance
	 *            account balance
	 * @param overDrawnLimit
	 *            the limit can over drawn
	 */
	public CheckingAccount(int id, double balance, double overDrawnLimit) {
		super(id, balance);
		this.overDrawnLimit = overDrawnLimit;
	}

	/**
	 * Get over drawn limit of this instance.
	 * 
	 * @return over drawn limit
	 */
	public double getOverDrawnLimit() {
		return overDrawnLimit;
	}

	/**
	 * Set limit money this account can over drawn.
	 * 
	 * @param overDrawnLimit
	 *            over drawn limit
	 */
	public void setOverDrawnLimit(double overDrawnLimit) {
		this.overDrawnLimit = overDrawnLimit;
	}

	// The difference from superclass is withDraw function,
	// so, override it.
	@Override
	public Account withDraw(double drawMoney) {
		if (drawMoney <= getBalance() + overDrawnLimit) {
			super.withDraw(drawMoney);
		} else {
			System.out.println("Over the overdraft limit!");
		}
		return this;
	}

	@Override
	public String toString() {
		String ret = "This is a CheckingAccount\n" + "OverDrawnLimit is "
				+ overDrawnLimit + "\n";
		return ret + super.toString();
	}

}
