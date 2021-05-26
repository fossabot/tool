package org.yun.string.handler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yunkuangao a317526763@gmail.com
 * @apiNote String tools
 **/
public class StringHelper {
    /**
     * @param object default type String, check object is empty and length equals 0
     * @return boolean true: object is null or ""; false: object have any string
     * @author yunkuangao a317526763@gmail.com
     * @apiNote check param is null or length == 0
     **/
    public static boolean isEmptyString(Object object) {
        return object == null || ((String) object).length() == 0;
    }

    /**
     * @param object default type String, check object have any string
     * @return boolean true: object have any string; false: object is null or ""
     * @author yunkuangao a317526763@gmail.com
     * @apiNote check param have any string
     **/
    public static boolean isNotEmptyString(Object object) {
        return !isEmptyString(object);
    }

    /**
     * @param object default type Integer, check object is empty and value equals 0
     * @return boolean true: object is null or 0; false: object not equals 0
     * @author yunkuangao a317526763@gmail.com
     * @apiNote check param is null or 0
     **/
    public static boolean isEmptyInteger(Object object) {
        return object == null || ((Integer) object) == 0;
    }

    /**
     * @param object default type Integer, check object not equals 0
     * @return boolean true: object not equals 0; false: object is null or 0
     * @author yunkuangao a317526763@gmail.com
     * @apiNote check param have any value(not 0)
     **/
    public static boolean isNotEmptyInteger(Object object) {
        return !(isEmptyInteger(object));
    }

    /**
     * @param map  check map
     * @param keys key String array
     * @return boolean true: map have all keys of args; false: map have not any keys of args
     * @author yunkuangao a317526763@gmail.com
     * @apiNote if there is no value of args in the map,return no value's args
     **/
    public static boolean hasAnyNull(Map<String, Object> map, String... keys) {
        for (String str : keys) {
            if (!map.containsKey(str) && isEmptyString(map.get(str))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param map  check map
     * @param keys key String array
     * @return java.lang.String returns keys that are not in args in the map
     * @author yunkuangao a317526763@gmail.com
     * @apiNote if all args are contained in the map, an empty string will be returned; otherwise, no args will be returned
     **/
    public static String getAnyNull(Map<String, Object> map, String... keys) {
        StringBuilder sb = new StringBuilder();
        for (String str : keys) {
            if (!map.containsKey(str) && isEmptyString(map.get(str))) {
                sb.append(str + ",");
            }
        }
        return sb.toString();
    }

    /**
     * @param list check list
     * @param keys key String array
     * @return java.lang.String return the key value that checkStr does not have in the list
     * @author yunkuangao a317526763@gmail.com
     * @apiNote use a wrapper of getAnyNull for List<Map>
     **/
    public static String getAnyNull(List<Map> list, String... keys) {
        StringBuilder sb = new StringBuilder();
        list.forEach(lt -> {
            sb.append(getAnyNull(lt, keys));
        });
        return sb.toString();
    }

    /**
     * @param string string
     * @param t      any type
     * @return boolean true: equal; false: not equal
     * @author yunkuangao a317526763@gmail.com
     * @apiNote two-value comparison
     **/
    public static <T> boolean equalsStringAndT(String string, T t) {
        return string != null && t != null && string.equals(t.toString());
    }

    /**
     * @param changeMap origin map
     * @return java.util.Map return Map<K,V>
     * @author yunkuangao a317526763@gmail.com
     * @apiNote change the type of MAP<K,V>
     **/
    public static <K, V> Map changeMapToKT(Map<? extends Object, ? extends Object> changeMap, K t, V v) {
        return changeMap.entrySet().stream()
                .collect(Collectors.toMap(
                        entryKey -> (K) entryKey.getKey(),
                        entryValue -> (V) entryValue.getValue()));
    }
}
