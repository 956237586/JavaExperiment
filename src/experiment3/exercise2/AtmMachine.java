package experiment3.exercise2;

import java.util.Scanner;

import experiment3.exercise1.Account;

public class AtmMachine {
	private static Account[] accounts;
	private Scanner in = new Scanner(System.in);
	private Account currentAccount;

	public AtmMachine() {
	}

	public AtmMachine(Account[] accounts) {
		AtmMachine.setAccounts(accounts);
	}

	public static void setAccounts(Account[] accounts) {
		AtmMachine.accounts = accounts;
	}

	private void showErrorMessage() {
		System.out.println("Input error! Please try again!");
	}

	private void showResult(int userChoice) {
		switch (userChoice) {
		case 1:
			System.out.printf("The balance is %.6f.\n",
					currentAccount.getBalance());
			break;

		case 2:
			System.out.print("Enter an amount to withdraw: ");
			double drawMoney = in.nextDouble();
			if (drawMoney > 0) {
				currentAccount.withDraw(drawMoney);
				System.out.printf(
						"The balance after withdrawing %.6f is %.6f.\n",
						drawMoney, currentAccount.getBalance());
			} else {
				showErrorMessage();
			}
			break;

		case 3:
			System.out.print("Enter an amount to deposit: ");
			double depositMoney = in.nextDouble();
			if (depositMoney > 0) {
				currentAccount.deposit(depositMoney);
				System.out.printf("The balance after deposit %.6f is %.6f.\n",
						depositMoney, currentAccount.getBalance());
			} else {
				showErrorMessage();
			}
			break;
		default:
			showErrorMessage();
			break;
		}
	}

	private void showMainMenu() {
		String[] s = new String[] { "Main menu", "1: check balance",
				"2: withdraw", "3: deposit", "4: exit", };
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
		System.out.print("Enter a choice:");
	}

	private boolean isExistAccount(Account[] accounts, int id) {
		boolean ret;
		if (0 <= id && id < accounts.length) {
			ret = true;
		} else {
			ret = false;
		}
		return ret;
	}

	public void run() {
		for (;;) {
			System.out.printf("Please input a account id(0-%d):",
					accounts.length - 1);
			int id = in.nextInt();
			if (isExistAccount(accounts, id)) {
				currentAccount = accounts[id];
				for (;;) {
					showMainMenu();
					int userChoice = in.nextInt();
					if (userChoice != 4) {
						showResult(userChoice);
					} else {
						break;
					}
					System.out.println();
				}
			} else {
				showErrorMessage();
			}
		}
	}

}
