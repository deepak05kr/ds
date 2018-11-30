package banking;

import java.util.List;

import banking.model.Person;

public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}
