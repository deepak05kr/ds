package comparator;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ObjectSortingTest {

	public static String NAME = "name";
	public static String ID = "id";
	public static String AGE = "age";
	public static String SALARY = "salary";

	@Test
	public void comparableTest_ListSorting() {
		List<Person> persons = getPersonList();

		List<Integer> sortedIds = new ArrayList();
		for (Person p : persons) {
			sortedIds.add(p.getId());
		}
		Collections.sort(sortedIds);

		Collections.sort(persons);

		int index = 0;

		for (Person p : persons) {
			assertTrue(sortedIds.get(index++) - p.getId() == 0);
		}
	}

	@Test
	public void comparableTest_ArraySorting() {
		Person[] persons = getPersonArray();

		List<Integer> sortedIds = new ArrayList();
		for (Person p : persons) {
			sortedIds.add(p.getId());
		}
		Collections.sort(sortedIds);

		Arrays.sort(persons);

		int index = 0;
		for (Person p : persons) {
			assertTrue(sortedIds.get(index++) - p.getId() == 0);
		}
	}

	@Test
	public void ageComparatorTest_ListSorting() {
		List<Person> persons = getPersonList();

		List<Integer> sortedAges = new ArrayList();
		for (Person p : persons) {
			sortedAges.add(p.getAge());
		}
		Collections.sort(sortedAges);

		Collections.sort(persons, Person.ageComparator);

		int index = 0;

		for (Person p : persons) {
			assertTrue(sortedAges.get(index++) - p.getAge() == 0);
		}
	}

	@Test
	public void salaryComparatorTest_ListSorting() {
		List<Person> persons = getPersonList();

		List<Integer> sortedSalaries = new ArrayList();
		for (Person p : persons) {
			sortedSalaries.add((int) p.getSalary());
		}
		Collections.sort(sortedSalaries);

		Collections.sort(persons, Person.salaryComparator);

		int index = 0;

		for (Person p : persons) {
			assertTrue(sortedSalaries.get(index++) - p.getSalary() == 0);
		}
	}

	@Test
	public void nameComparatorTest_ListSorting() {
		List<Person> persons = getPersonList();

		List<String> sortedNames = new ArrayList();
		for (Person p : persons) {
			sortedNames.add(p.getName());
		}
		Collections.sort(sortedNames);

		Collections.sort(persons, Person.nameComparator);

		int index = 0;

		for (Person p : persons) {
			assertTrue(sortedNames.get(index++).equals(p.getName()));
		}
	}

	@Test
	public void ageComparatorTest_ArraySorting() {
		Person[] persons = getPersonArray();

		List<Integer> sortedAges = new ArrayList();
		for (Person p : persons) {
			sortedAges.add(p.getAge());
		}
		Collections.sort(sortedAges);

		Arrays.sort(persons, Person.ageComparator);

		int index = 0;

		for (Person p : persons) {
			assertTrue(sortedAges.get(index++) - p.getAge() == 0);
		}
	}

	@Test
	public void salaryComparatorTest_ArraySorting() {
		Person[] persons = getPersonArray();

		List<Integer> sortedSalaries = new ArrayList();
		for (Person p : persons) {
			sortedSalaries.add((int) p.getSalary());
		}
		Collections.sort(sortedSalaries);

		Arrays.sort(persons, Person.salaryComparator);

		int index = 0;

		for (Person p : persons) {
			assertTrue(sortedSalaries.get(index++) - p.getSalary() == 0);
		}
	}

	@Test
	public void nameComparatorTest_ArraySorting() {
		Person[] persons = getPersonArray();

		List<String> sortedNames = new ArrayList();
		for (Person p : persons) {
			sortedNames.add(p.getName());
		}
		Collections.sort(sortedNames);

		Arrays.sort(persons, Person.nameComparator);

		int index = 0;

		for (Person p : persons) {
			assertTrue(sortedNames.get(index++).equals(p.getName()));
		}
	}
	@Test
	public void idAgeSalaryComparatorTest_ArraySorting() {
		Person[] persons = new Person[3];
		Person person1 = new Person(1, "Pankaj", 36, 50000);
		Person person2 = new Person(1, "Lisa", 36, 600000);
		Person person3 = new Person(1, "Mikey", 25, 9000);
		persons[0] = person1;
		persons[1] = person2;
		persons[2] = person3;

		List<Integer> sortedId = new ArrayList();
		for (Person p : persons) {
			sortedId.add((int) p.getId());
		}
		Collections.sort(sortedId);

		List<Integer> sortedAge = new ArrayList();
		for (Person p : persons) {
			sortedAge.add((int) p.getAge());
		}
		Collections.sort(sortedAge);

		List<Integer> sortedSalaries = new ArrayList();
		for (Person p : persons) {
			sortedSalaries.add((int) p.getSalary());
		}
		Collections.sort(sortedSalaries);

		Arrays.sort(persons, Person.idAgeSalarycomparator);

		int index = 0;

		for (Person p : persons) {
			assertTrue(sortedId.get(index) - p.getId() == 0);
			assertTrue(sortedAge.get(index) - p.getAge() == 0);
			assertTrue(sortedSalaries.get(index++) - p.getSalary() == 0);
		}
	}

	private List<Person> getPersonList() {
		Person person1 = new Person(1, "Pankaj", 32, 50000);
		Person person2 = new Person(5, "Lisa", 35, 5000);
		Person person3 = new Person(10, "Mikey", 25, 10000);
		Person person4 = new Person(20, "Arun", 29, 20000);

		List<Person> persons = new ArrayList<>();
		persons.add(person3);
		persons.add(person4);
		persons.add(person1);
		persons.add(person2);
		return persons;
	}

	private Person[] getPersonArray() {
		Person person1 = new Person(1, "Pankaj", 32, 50000);
		Person person2 = new Person(5, "Lisa", 35, 5000);
		Person person3 = new Person(10, "Mikey", 25, 10000);
		Person person4 = new Person(20, "Arun", 29, 20000);

		Person[] persons = new Person[4];
		persons[0] = person3;
		persons[1] = person4;
		persons[2] = person1;
		persons[3] = person2;
		return persons;
	}
}
