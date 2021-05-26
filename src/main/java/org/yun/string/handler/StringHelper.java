package org.yun.string.handler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringHelper {
    /**
     * @param str
     * @return boolean
     * @author yunkuangao a317526763@gmail.com
     * @apiNote 判断当前对象是否为空或者空字符串
     * @date 2021/5/26 11:22
     **/
    public static boolean isEmpty(Object str) {
        return str == null || ((String) str).length() == 0;
    }

    /**
     * @param str
     * @return boolean
     * @author yunkuangao a317526763@gmail.com
     * @apiNote 判断当前对象是否不为空并且不为空字符串
     * @date 11:23
     **/
    public static boolean isNotEmpty(Object str) {
        return !isEmpty(str);
    }

    /**
     * @param str
     * @return boolean
     * @author yunkuangao a317526763@gmail.com
     * @apiNote 判断当前对象是否为空或者空整形
     * @date 2021/5/26 11:23
     **/
    public static boolean isEmptyInteger(Object str) {
        return str == null || ((Integer) str) == 0;
    }

    /**
     * @param str
     * @return boolean
     * @author yunkuangao a317526763@gmail.com
     * @apiNote 判断当前对象是否不为空并且不为空整形
     * @date 2021/5/26 11:23
     **/
    public static boolean isNotEmptyInteger(Object str) {
        return !(isEmptyInteger(str));
    }


    /**
     * @param
     * @return boolean
     * @author yunkuangao a317526763@gmail.com
     * @description 判断map中是否有args内的键值
     * @date 2021/4/10 16:21
     **/
    public static boolean hasAnyNull(Map<String, Object> map, String... args) {
        for (String str : args) {
            if (!map.containsKey(str) && isEmpty(map.get(str))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param map
     * @return boolean
     * @author yunkuangao a317526763@gmail.com
     * 返回map中args没有的键值
     * @date 2021/4/10 16:23
     **/
    public static String getAnyNull(Map<String, Object> map, String... checkStr) {
        StringBuilder sb = new StringBuilder();
        for (String str : checkStr) {
            if (!map.containsKey(str) && isEmpty(map.get(str))) {
                sb.append(str + ",");
            }
        }
        return sb.toString();
    }

    /**
     * @param list
     * @param checkStr
     * @return java.lang.String
     * @author yunkuangao a317526763@gmail.com
     * 返回list中checkStr没有的键值
     * @date 2021/4/23 10:40
     **/
    public static String getAnyNull(List<Map> list, String... checkStr) {
        StringBuilder sb = new StringBuilder();
        list.forEach(lt -> {
            sb.append(getAnyNull(lt, checkStr));
        });
        return sb.toString();
    }

    /**
     * @param str 字符串
     * @param t   任意类型
     * @return boolean
     * @author yunkuangao a317526763@gmail.com
     * 返回是否相等
     * @date 2021年5月7日 15点24分
     **/
    public static <T> boolean equalsObj(String str, T t) {
        return str != null && t != null && str.equals(t.toString());
    }

    /**
     * @param
     * @return java.util.Map
     * @author yunkuangao a317526763@gmail.com
     * @apiNote 将map的value变为string
     * @date 2021/5/19 15:09
     **/
    public static Map changeMapValueToString(Map<? extends Object, ? extends Object> changeMap) {
        return changeMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> String.valueOf(entry.getValue())));
    }
}
