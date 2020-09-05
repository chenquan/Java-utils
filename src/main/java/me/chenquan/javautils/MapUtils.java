package me.chenquan.javautils;

import java.util.Map;
import java.util.function.Function;

/**
 * </p>
 * Map工具类
 * <p>
 *
 * @author chenquan chenquan@osai.club 2020/09/04 17:05
 */
public class MapUtils {
    /**
     * @param map      map对象
     * @param key      key
     * @param function 处理函数
     */
    public static <K, V> void replace(Map<K, V> map, K key, Function<V, V> function) {
        V value = map.get(key);
        V newValue = function.apply(value);
        map.replace(key, newValue);
    }
}
