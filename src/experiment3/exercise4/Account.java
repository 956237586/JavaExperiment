package experiment3.exercise4;

import java.util.ArrayList;

public class Account extends experiment3.exercise1.Account {
	private String name;
	private ArrayList<Transaction> transactions;

	public Account(String name, int id, double balance) {
		super(id, balance);
		this.name = name;
		transactions = new ArrayList<Transaction>();
	}

	@Override
	public experiment3.exercise1.Account withDraw(double drawMoney) {
		super.withDraw(drawMoney);
		transactions.add(
				new Transaction('W', drawMoney, 
						getBalance(), "DrawMoney")
				);
		return this;
	}

	@Override
	public experiment3.exercise1.Account deposit(double depositMoney) {
		super.deposit(depositMoney);
		transactions.add(
				new Transaction('D', depositMoney, 
						getBalance(), "DepositMoney"));
		return this;
	}

	@Override
	public String toString() {
		String ret = "Account information:\n" 
				+ "Name: " + name + "\n"
				+ "Monthly InteRest Rate: "
				+ getMonthlyInterestRate() * 100 + "%\n"
				+ "Balance: " + getBalance() + "\n";
		for (int i = 0; i < transactions.size(); i++) {
			ret += "Transaction " + i + ":\n " 
					+ transactions.get(i) + "\n";
		}
		return ret;
	}

}
