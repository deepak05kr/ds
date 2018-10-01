package halodoc_Inverview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution implements SupportedOperations {
	public static final String LATITUDE = "Latitude";
	public static final String LONGITUDE = "Longitude";
	public static final String POLLUTION_LEVEL = "Pollution_level";
	public static final String FREE_FOOD = "free_food";
	public static final String CAPITAL = "capital";
	public static final String POPULATION = "Population";
	public static final String CATEGORY = "Category";
	public static final String MANUFACTURER = "Manufacturer";

	public static final String VERY_HIGH = "very high";
	public static final String HIGH = "high";
	public static final String MODERATE = "moderate";

	// static final HashMap<String, String> valueType = new HashMap<>();
	static Map<String, CustomMap> inputMap = new HashMap<>();

	// public static String getValueDatatypeForValue(String valueName, Object value)
	// {
	// if (valueType.containsKey(valueName)) {
	// return valueType.get(valueName).getClass().getName();
	// } else {
	// valueType.put(valueName, value.getClass().getName());
	// return value.getClass().getName();
	// }
	// }

	public static void main(String args[]) {
		Initialise();

		// Store value against a particular key k
		Solution obj = new Solution();
		obj.store("newkey", POLLUTION_LEVEL, VERY_HIGH);
		CustomMap customMap = obj.get("newkey");
		System.out.println(inputMap);
		obj.delete("newkey");
		System.out.println(inputMap);

		List<String> citiesWithHighPopulation = obj.getCitiesWithHighPopulation();
		for (String cityName : citiesWithHighPopulation) {
			System.out.println(cityName);
		}
	}

	@Override
	public void delete(String string) {
		if (inputMap.containsKey(string)) {
			inputMap.remove(string);
		}

	}

	@Override
	public CustomMap get(String key) {
		return inputMap.get(key);
	}

	private static void Initialise() {
		createDelhiMap(inputMap);
		createJakartaMap(inputMap);
		createBangalorMap(inputMap);
		createIndiaMap(inputMap);
		createCrocinMap(inputMap);
	}

	private static void createCrocinMap(Map<String, CustomMap> inputMap) {
		CustomMap crocinMap = new CustomMap();
		crocinMap.put(CATEGORY, String.class, "cold & flu");
		crocinMap.put(MANUFACTURER, String.class, "GSK");
		inputMap.put("crocin", crocinMap);
	}

	private static void createIndiaMap(Map<String, CustomMap> inputMap) {
		CustomMap indiaMap = new CustomMap();
		indiaMap.put(CAPITAL, String.class, "delhi");
		indiaMap.put(POPULATION, String.class, "1.2 Billion");
		inputMap.put("crocin", indiaMap);

	}

	private static void createBangalorMap(Map<String, CustomMap> inputMap) {
		CustomMap bangalogeMap = new CustomMap();
		bangalogeMap.put(LATITUDE, Double.class, 12.94);
		bangalogeMap.put(LONGITUDE, Double.class, 77.64);
		inputMap.put("bangalore", bangalogeMap);
	}

	private static void createJakartaMap(Map<String, CustomMap> inputMap) {
		CustomMap jakartaMap = new CustomMap();
		jakartaMap.put(LATITUDE, Double.class, -0.6);
		jakartaMap.put(LONGITUDE, Double.class, 106.0);
		inputMap.put("jakarta", jakartaMap);
	}

	private static void createDelhiMap(Map<String, CustomMap> inputMap) {
		CustomMap delhiMap = new CustomMap();
		delhiMap.put(POLLUTION_LEVEL, String.class, VERY_HIGH);
		delhiMap.put(POPULATION, String.class, "10 Million");
		inputMap.put("delhi", delhiMap);
	}

	@Override
	public void store(String key, String attribute, Double value) {
		CustomMap map = new CustomMap();
		map.put(attribute, Double.class, value);
		inputMap.put(key, map);
	}

	@Override
	public void store(String key, String attribute, String value) {
		CustomMap map = new CustomMap();
		map.put(attribute, String.class, value);
		inputMap.put(key, map);
	}

	@Override
	public void store(String key, String attribute, Boolean value) {
		CustomMap map = new CustomMap();
		map.put(attribute, Boolean.class, value);
		inputMap.put(key, map);
	}

	public List<String> getCitiesWithHighPopulation() {
		List<String> cities = new ArrayList<>();
		for (Map.Entry<String, CustomMap> map : inputMap.entrySet()) {
			String cityName = map.getKey();
			String string = map.getValue().get(POLLUTION_LEVEL, String.class);
			System.out.println();
			cities.add(cityName);
		}
		return cities;
	}

}
