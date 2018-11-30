package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import banking.AccountDao;
import banking.model.Account;
import banking.model.Person;

public class Saving implements IAccount {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	AccountDao accountDao = context.getBean(AccountDao.class);

	public Saving(Person user, long initAmount) {
		Account account = new Account();
		account.setType(Constants.SAVING);
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
//		accountDao.transfet(this.getAccountNumber(userId))
	}

}
