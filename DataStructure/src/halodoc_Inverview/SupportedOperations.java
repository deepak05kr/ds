package halodoc_Inverview;

public interface SupportedOperations {
	void store(String key, String attribute, Double value);

	void store(String key, String attribute, String value);

	void store(String key, String attribute, Boolean value);

	void delete(String key);

	CustomMap get(String key);
}
