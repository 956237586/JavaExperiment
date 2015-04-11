package experiment3.exercise4;

import java.util.Date;

public class Transaction {
	private Date date;
	private char type;
	private double amount;
	private double balance;
	private String description;

	public Transaction(char type, double amount, 
			double balance,	String description) {
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
		this.date = new Date();
	}

	@Override
	public String toString() {
		return " Date: " + date + 
				" Type: " + type + 
				" Amount: " + amount + 
				" Balance: " + balance;
	}
}
