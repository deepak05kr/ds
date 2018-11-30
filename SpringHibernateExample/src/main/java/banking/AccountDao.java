package banking;

import java.util.List;

import banking.model.Account;
import banking.model.Person;

public interface AccountDao {

	public void save(Account account);
	
	public List<Account> list();

	public int getAccountNumber(int userId);

	
}
