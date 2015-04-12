package experiment3.exercise4;

import java.util.Date;

/**
 * This class is transaction record. It has 5 properties include transaction
 * date、transaction type、transaction money、balance after transaction and
 * description of this transaction.
 * 
 * @author HYL
 *
 */
public class Transaction {
	private Date date;
	private char type;
	private double amount;
	private double balance;
	private String description;

	/**
	 * Create a transaction record from some properties.
	 * 
	 * @param type
	 *            transaction type
	 * @param amount
	 *            transaction money
	 * @param balance
	 *            balance after transaction
	 * @param description
	 *            description of this transaction
	 */
	public Transaction(char type, double amount, double balance,
			String description) {
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
		this.date = new Date();
	}

	@Override
	public String toString() {
		return " Date: " + date + " Type: " + type + " Amount: " + amount
				+ " Balance: " + balance;
	}
}
