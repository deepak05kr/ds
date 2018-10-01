package cloning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Employee implements Cloneable {
	private String name;
	private Long empId;
	Map<String, String> props = new HashMap<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Map<String, String> getProps() {
		return props;
	}

	public void setProps(Map<String, String> props) {
		this.props = props;
	}

//	copy constructor and get a copy of object and don’t depend on the cloning at all. 	
	public Employee(Employee emp) {
		this.setEmpId(emp.getEmpId());
		this.setName(emp.getName());
		Map<String, String> hm = new HashMap<>();
		String key;
		Iterator<String> it = emp.getProps().keySet().iterator();
		while (it.hasNext()) {
			key = it.next();
			hm.put(key, emp.getProps().get(key));
		}
		this.setProps(hm);
	}

	public Employee() {
	}
}
