package me.chenquan.javautils;

import java.util.*;
import java.util.function.Function;

/**
 * </p>
 * 分组
 * <p>
 *
 * @author chenquan chenquan@osai.club 2020/05/29 9:39
 */
public class GroupUtils {

    private GroupUtils() {
    }


    /**
     * 分组函数
     *
     * @param object        待分组的对象
     * @param groupFunction 分组条件
     * @return 分组后的Map对象
     */
    public static <E, T> Map<E, Collection<T>> groupHelper(Collection<T> object, Function<T, E> groupFunction) {
        // 分组条件不能为空
        Objects.requireNonNull(groupFunction);

        if (object.isEmpty()) {
            // 返回空的map对象
            return new HashMap<>(0);
        }

        Map<E, Collection<T>> map = new HashMap<>(16);
        for (T obj : object) {
            E group = groupFunction.apply(obj);
            // 如果Key[group]对应的Value为空,则创建一个新的ArrayList并把其和Key一起放入map中
            Collection<T> groupObj = map.computeIfAbsent(group, k -> new ArrayList<>());
            groupObj.add(obj);

        }
        return map;
    }


    /**
     * 分组统计函数
     *
     * @param object        待分组的对象
     * @param groupFunction 分组条件
     * @return 分组后的Map对象, 存储每组的个数
     */
    public static <E, T> Map<E, Long> groupCountHelper(Collection<T> object, Function<T, E> groupFunction) {
        Map<E, Collection<T>> eCollectionMap = groupHelper(object, groupFunction);
        HashMap<E, Long> mapCount = new HashMap<>(eCollectionMap.size());
        eCollectionMap.forEach((k, v) -> {
            mapCount.put(k, (long) v.size());
        });
        return mapCount;
    }

}
