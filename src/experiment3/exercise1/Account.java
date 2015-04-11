package experiment3.exercise1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
	private static int num;
	private static double annualInterestRate;
	private int id;
	private double balance;
	private Date dateCreated;

	public Account() {
		id = num++;
		dateCreated = new Date();
	}

	public Account(double balance) {
		this();
		this.balance = balance;
	}
	
	public Account(int id, double balance) {
		this(balance);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Account setId(int id) {
		this.id = id;
		return this;
	}

	public double getBalance() {
		return balance;
	}

	public Account setBalance(double balance) {
		this.balance = balance;
		return this;
	}

	public static double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public static void setAnnualInterestRate(double annualInterestRate) {
		Account.annualInterestRate = annualInterestRate;
	}

	public String getDateCreated() {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss");
		return sd.format(dateCreated);
	}

	public double getMonthlyInterestRate() {
		return annualInterestRate / 12.0;
	}

	public Account withDraw(double drawMoney) {
		balance -= drawMoney;
		return this;
	}

	public Account deposit(double depositMoney) {
		balance += depositMoney;
		return this;
	}

	@Override
	public String toString() {
		String ret = "balance: " + balance + "\n" + "MonthlyInterest: "
				+ getMonthlyInterestRate() * balance + "\n"
				+ "AccountCreatedDate:" + getDateCreated();
		return ret;
	}

}
