package immutable;

import java.util.HashMap;
import java.util.Map;

public class ImmutableClassDemo {

	public static void main(String args[]) {
		ImmutableClass immutableClass = new ImmutableClass.ImmutableClassBuilder(1, "deepak").build();
		HashMap<String, String> hm = new HashMap<>();
		hm.put("name", "Deepak");
		hm.put("City", "Bangalore");
		ImmutableClass immutableClass2 = new ImmutableClass.ImmutableClassBuilder(2, "Deepak Kumar")
				.setCompany("Google").setProperties(hm).build();
		Map<String, String> properties = immutableClass2.getProperties();
		properties.put("test", "test");
		properties.put("test", "test");
		System.out.println(immutableClass2.getProperties());
	}
}
