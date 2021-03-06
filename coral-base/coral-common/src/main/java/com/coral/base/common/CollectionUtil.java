package com.coral.base.common;

import java.util.*;

/**
 * @author huss
 */
public class CollectionUtil {

    public static <T> List<T> convert(List<T> list) {
        return list == null || list.isEmpty() ? Collections.emptyList() : list;
    }

    public static boolean isBlank(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotBlank(Collection collection) {
        return !isBlank(collection);
    }

    public static <T> Set<T> newHashSet(T... args) {
        return new HashSet<>(Arrays.asList(args));
    }

    public static <T> Set<T> newHashSet(Collection<T> collection) {
        return new HashSet<>(collection);
    }

    public static <T> List<T> of(List<T> collection) {
        return Objects.isNull(collection) ? Collections.emptyList() : collection;
    }

    public static <T> Set<T> of(Set<T> collection) {
        return Objects.isNull(collection) ? Collections.emptySet() : collection;
    }

    public static <T, V> Map<T, V> of(Map<T, V> map) {
        return Objects.isNull(map) ? Collections.emptyMap() : map;
    }
}
