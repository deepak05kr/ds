package banking;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import banking.model.Account;
import banking.model.Person;

public class AccountDAOImpl implements AccountDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Account account) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(account);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Account> list() {
		Session session = this.sessionFactory.openSession();
		List<Account> accountList = session.createQuery("from Account").list();
		session.close();
		return accountList;
	}

	@Override
	public int getAccountNumber(int userId) {
		Session session = this.sessionFactory.openSession();
		List<Account> accountList = session.createQuery("from Account where user=" + userId).list();
		return accountList.get(0).getId();
	}

}
