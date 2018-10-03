package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorDemo {

	public static void main(String args[]) {
		Person person1 = new Person(1, "Pankaj", 32, 50000);
		Person person2 = new Person(5, "Lisa", 35, 5000);
		Person person3 = new Person(10, "Mikey", 25, 10000);
		Person person4 = new Person(20, "Arun", 29, 20000);

		List<Person> persons = new ArrayList<>();
		persons.add(person3);
		persons.add(person4);
		persons.add(person1);
		persons.add(person2);

		Person.printPersonList(persons);
		System.out.println();

		Collections.sort(persons, Person.ageComparator);
		Person.printPersonList(persons);
		System.out.println();

		Collections.sort(persons, Person.salaryComparator);
		Person.printPersonList(persons);
		System.out.println();

		Collections.sort(persons, Person.nameComparator);
		Person.printPersonList(persons);
		System.out.println();

	}
}
