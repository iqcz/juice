package com.lee.util;

import java.util.Collection;
import java.util.Map;

public class CollectionUtil {

	public static boolean isValid(Collection<?> collection) {
		return null != collection && !collection.isEmpty();
	}

	public static boolean isValid(Map<?, ?> map) {
		return null != map && !map.isEmpty();
	}
}
