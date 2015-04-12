package experiment3.exercise4;

public class Exercise4 {

	public static void main(String[] args) {
		Account.setAnnualInterestRate(0.015);
		Account account = new Account("George", 1122, 1000);
		// Because deposit and withDraw function define return current instance,
		// so we can call it sequential.
		account.deposit(30).deposit(40).deposit(50)
				.withDraw(5).withDraw(4).withDraw(2);
		System.out.println(account);
	}

}
