package main;

import banking.AccountDao;
import banking.model.Account;
import banking.model.Person;

public class Current implements IAccount {
	AccountDao accountDao;

	public Current(Person user, long initAmount) {
		Account account = new Account();
		account.setType(Constants.CURRENT);
		account.setUser(user);
		account.setAmount(initAmount);

		accountDao.save(account);
	}

	public void deposit(long amount) {

	}

	public void withdraw(long amount) {

	}

	public void transfer(long amount) {

	}

	public int getAccountNumber(int userId) {
		return accountDao.getAccountNumber(userId);
	}

	@Override
	public void transfer(IAccount toAccount, long amount) {
		
	}

}
