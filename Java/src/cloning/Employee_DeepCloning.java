package cloning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Employee_DeepCloning extends Employee {

	public Employee_DeepCloning(Employee emp) {
		super(emp);
	}

	public Employee_DeepCloning() {
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();
		Employee_DeepCloning emp = (Employee_DeepCloning) obj;
		emp.setProps(null);
		Map<String, String> hm = new HashMap<>();
		String key;
		Iterator<String> it = this.props.keySet().iterator();
		while (it.hasNext()) {
			key = it.next();
			hm.put(key, this.props.get(key));
		}
		emp.setProps(hm);
		return emp;
	}
}
