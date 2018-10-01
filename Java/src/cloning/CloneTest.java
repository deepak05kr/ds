package cloning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CloneTest {
	@Test
	public void ShallowCloning_Test() throws CloneNotSupportedException {
		Employee_ShallowCloning emp = new Employee_ShallowCloning();
		emp.setEmpId(1l);
		emp.setName("name");
		Map<String, String> properties = new HashMap<>();
		properties.put("salary", "20001");
		emp.setProps(properties);

		Employee_ShallowCloning clonedEmp = (Employee_ShallowCloning) emp.clone();

		assertEquals(emp.getEmpId(), clonedEmp.getEmpId());
		assertTrue(emp.getName().equals(clonedEmp.getName()));

		// emp and clonedEmp are two different object, not referring to same object.
		assertNotEquals(emp, clonedEmp);

		// both emp and clonedEmp object variables refer to same object. default cloning
		// in java doesn’t create totally detached objects.
		// we are good with java clone object default method as long as we have only
		// primitive and immutable variables in the object.

		assertEquals(emp.getProps(), clonedEmp.getProps());
		assertTrue(emp.getProps() == clonedEmp.getProps());

	}

	@Test
	public void DeepCloning_Test() throws CloneNotSupportedException {
		Employee_DeepCloning emp = new Employee_DeepCloning();
		emp.setEmpId(1l);
		emp.setName("name");
		Map<String, String> properties = new HashMap<>();
		properties.put("salary", "20001");
		emp.setProps(properties);

		Employee_DeepCloning clonedEmp = (Employee_DeepCloning) emp.clone();

		assertEquals(emp.getEmpId(), clonedEmp.getEmpId());
		assertTrue(emp.getName().equals(clonedEmp.getName()));

		// emp and clonedEmp are two different object, not referring to same object.
		assertNotEquals(emp, clonedEmp);
		assertFalse(emp == clonedEmp);

		assertFalse(emp.getProps() == clonedEmp.getProps());

	}

	@Test
	public void CopyConstructor_Cloning_Test() throws CloneNotSupportedException {
		Employee emp = new Employee();
		emp.setEmpId(1l);
		emp.setName("name");
		Map<String, String> properties = new HashMap<>();
		properties.put("salary", "20001");
		emp.setProps(properties);

		Employee clonedEmp = new Employee(emp);

		assertEquals(emp.getEmpId(), clonedEmp.getEmpId());
		assertTrue(emp.getName().equals(clonedEmp.getName()));

		// emp and clonedEmp are two different object, not referring to same object.
		assertNotEquals(emp, clonedEmp);
		assertFalse(emp == clonedEmp);

		assertFalse(emp.getProps() == clonedEmp.getProps());

	}

}
