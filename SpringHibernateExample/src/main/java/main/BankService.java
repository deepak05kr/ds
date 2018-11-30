package main;

import java.util.Hashtable;

import banking.model.Person;

public class BankService {
	private Hashtable<Integer, IAccount> bankAccounts;

	public BankService() {
		this.bankAccounts = new Hashtable<Integer, IAccount>();
	}

	public int createNewAccount(Person user, String type, long initAmount) {
		IAccount newAccount = null;
		switch (type) {
		case "saving":
			newAccount = new Saving(user, initAmount);
			break;
		case "current":
			newAccount = new Current(user, initAmount);
			break;
		default:
			System.out.println("Invalid account type");
			break;
		}
		if (newAccount != null) {
			this.bankAccounts.put(newAccount.getAccountNumber(user.getId()), newAccount);
			return newAccount.getAccountNumber(user.getId());
		}
		return -1;
	}

	public void transferMoney(int to, int from, long amount) {
		IAccount toAccount = this.bankAccounts.get(to);
		IAccount fromAccount = this.bankAccounts.get(from);
		fromAccount.transfer(toAccount, amount);
	}

	public void depositMoney(int to, long amount) {

	}

	public void withdrawMoney(int from, long amount) {

	}
}
