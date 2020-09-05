package me.chenquan.javautils;

import junit.framework.TestCase;

import java.util.HashMap;

/**
 * </p>
 * Map工具类测试
 * <p>
 *
 * @author chenquan chenquan@osai.club 2020/09/05 23:30
 */
public class MapUtilsTest extends TestCase {

    public void testReplace() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("111", 111);
        map.put("222", 222);
        map.put("333", 222);
        System.out.println(map);

        MapUtils.replace(map, "222", it -> it.getClass().getTypeName());
        System.out.println(map);

    }
}
