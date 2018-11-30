package main;

public interface IAccount {
	public void deposit(long amount);

	public void withdraw(long amount);

	public void transfer(long amount);

	public int getAccountNumber(int userId);

	public void transfer(IAccount toAccount, long amount);
}
