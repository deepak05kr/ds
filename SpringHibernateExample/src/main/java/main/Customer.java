package main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import banking.PersonDAO;
import banking.model.Person;

public class Customer {

	public static void main(String[] args) {
		Customer c = new Customer();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		PersonDAO personDAO = context.getBean(PersonDAO.class);

		String username = "rd";
		String country = "india";
		String password = "rd";
		Person person = c.registerCustomer(personDAO, username, country, password);

		BankService bank = new BankService();
		int saving = bank.createNewAccount(person, Constants.SAVING, 10000);
		int current = bank.createNewAccount(person, Constants.CURRENT, 5000);

		bank.depositMoney(person.getId(), 200);
		bank.withdrawMoney(person.getId(), 200);
		bank.transferMoney(saving, current, 200);

		System.out.println("Person::" + person);

		List<Person> list = personDAO.list();

		for (Person p : list) {
			System.out.println("Person List::" + p);
		}

		context.close();

	}

	private Person registerCustomer(PersonDAO personDAO, String username, String country, String password) {
		Person person = new Person();
		person.setName(username);
		person.setCountry(country);
		person.setPassword(password);

		personDAO.save(person);
		return person;
	}

}
