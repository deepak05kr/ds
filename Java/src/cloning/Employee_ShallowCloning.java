package cloning;

public class Employee_ShallowCloning extends Employee  {

	public Employee_ShallowCloning(Employee emp) {
		super(emp);
	}

	public Employee_ShallowCloning() {
		super();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
