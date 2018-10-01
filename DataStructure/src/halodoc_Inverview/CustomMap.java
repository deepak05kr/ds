package halodoc_Inverview;

import java.util.HashMap;
import java.util.Map;

public class CustomMap {

	 Map<String, Map<Class<?>, Object>> customMap;

	public CustomMap() {
		customMap = new HashMap<>();
	}

	public <T> void put(String textKey, Class<T> typeKey, T chachedValue) {
		Map<Class<?>, Object> mapForTextKey = getMapForTextKey(textKey);
		mapForTextKey.put(typeKey, chachedValue);
	}

	private Map<Class<?>, Object> getMapForTextKey(String textKey) {
		if (!customMap.containsKey(textKey))
			customMap.put(textKey, new HashMap<>());
		return customMap.get(textKey);
	}

	public <T> T get(String textKey, Class<T> typeKey) {
		Object untypedCachedValue = getUntyped(textKey, typeKey);
		return typeKey.cast(untypedCachedValue);
	}

	private Object getUntyped(String textKey, Class<?> typeKey) {
		if (customMap.containsKey(textKey))
			return customMap.get(textKey).get(typeKey);
		else
			return null;
	}

}
