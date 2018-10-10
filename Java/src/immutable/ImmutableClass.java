package immutable;

import java.util.HashMap;
import java.util.Map;

public class ImmutableClass {
	private int id;
	private String name;
	private Map<String, String> properties;
	private String company;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public String getCompany() {
		return company;
	}

	public ImmutableClass(ImmutableClassBuilder builder) {
		super();
		this.id = builder.id;
		this.name = builder.name;
		this.properties = builder.properties;
		this.company = builder.company;
	}

	public static class ImmutableClassBuilder {
		private int id;
		private String name;
		private Map<String, String> properties;
		private String company;

		public ImmutableClassBuilder(int id, String nam) {
			this.id = id;
			this.name = nam;
		}

		public ImmutableClassBuilder setProperties(HashMap<String, String> properties) {
			this.properties = (Map<String, String>) properties.clone();
			return this;
		}

		public ImmutableClassBuilder setCompany(String company) {
			this.company = company;
			return this;
		}

		public ImmutableClass build() {
			return new ImmutableClass(this);
		}
	}
}
