package cloning;

import java.util.HashMap;
import java.util.Map;

import cloning.Employee_ShallowCloning;

public class CloneDemo {
	public static void main(String args[]) throws CloneNotSupportedException {
		Employee_ShallowCloning emp = new Employee_ShallowCloning();
		emp.setEmpId(1l);
		emp.setName("name");
		Map<String, String> properties = new HashMap<>();
		properties.put("salary", "20001");
		emp.setProps(properties);

		Employee_ShallowCloning clonedEmp = (Employee_ShallowCloning) emp.clone();

		System.out.println(clonedEmp.getEmpId());
		System.out.println(clonedEmp.getName());
		System.out.println(emp == clonedEmp);
	}
}
