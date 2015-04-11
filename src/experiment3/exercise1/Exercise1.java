package experiment3.exercise1;

public class Exercise1 {

	public static void main(String[] args) {
		Account account = new Account(1122, 20000);
		Account.setAnnualInterestRate(0.045);
		account.withDraw(2500);
		account.deposit(3000);
		System.out.println(account);
	}

}
