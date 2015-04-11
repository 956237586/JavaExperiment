package experiment3.exercise3;

import experiment3.exercise1.Account;

public class CheckingAccount extends Account {
	private double overDrawnLimit;

	public CheckingAccount() {

	}

	public CheckingAccount(int id, double balance, double overDrawnLimit) {
		super(id, balance);
		this.overDrawnLimit = overDrawnLimit;
	}

	public double getOverDrawnLimit() {
		return overDrawnLimit;
	}

	public void setOverDrawnLimit(double overDrawnLimit) {
		this.overDrawnLimit = overDrawnLimit;
	}
	
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
		String ret = "This is a CheckingAccount\n" +
		"OverDrawnLimit is " + overDrawnLimit + "\n";
		return ret + super.toString();
	}

}
