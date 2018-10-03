package comparator;

import java.util.Comparator;
import java.util.List;

public class Person implements Comparable<Person> {

	private int id;
	private String name;
	private int age;
	private long salary;

	@Override
	public int compareTo(Person o) {
		return (int) (this.id - o.id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

	public Person(int id, String name, int age, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Person() {
	}

	public static void printPersonList(List<Person> persons) {
		for (Person p : persons) {
			System.out.println(p.id + " " + p.name + " " + p.age + " " + p.salary);
		}
	}

	public static Comparator<Person> salaryComparator = new Comparator<Person>() {

		@Override
		public int compare(Person o1, Person o2) {
			return (int) (o1.getSalary() - o2.getSalary());
		}

	};
	public static Comparator<Person> ageComparator = new Comparator<Person>() {
		@Override
		public int compare(Person o1, Person o2) {
			return (int) (o1.getAge() - o2.getAge());
		}
	};
	public static Comparator<Person> nameComparator = new Comparator<Person>() {
		@Override
		public int compare(Person o1, Person o2) {
			return o1.getName().compareTo(o2.getName());
		}
	};
	public static Comparator<Person> idAgeSalarycomparator = new Comparator<Person>() {
		@Override
		public int compare(Person o1, Person o2) {
			int flag = o1.id - o2.id;
			if (flag == 0) {
				flag = o1.age - o2.age;
				if (flag == 0) {
					flag = (int) (o1.salary - o2.salary);
				}
			}
			return flag;
		}
	};
}
