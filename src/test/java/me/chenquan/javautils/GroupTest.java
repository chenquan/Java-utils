package me.chenquan.javautils;

import junit.framework.TestCase;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * </p>
 * 分组
 * <p>
 *
 * @author chenquan chenquan@osai.club 2020/05/29 9:39
 */
public class GroupTest extends TestCase {

    static class Example {
        private String name;
        private Integer classId;

        public Example(String name, Integer classId) {
            this.name = name;
            this.classId = classId;
        }

        @Override
        public String toString() {
            return "Example{" +
                    "name='" + name + '\'' +
                    ", classId=" + classId +
                    '}';
        }
    }

    private static final List<Example> exampleList = new ArrayList<>();

    static {
        for (int i = 0; i < 100; i++) {
            Example example = new Example("i", i % 11);

            exampleList.add(example);
        }
    }

    public void testGroupHelper() {

        Map<Object, Collection<Example>> stringCollectionMap = Group.groupHelper(exampleList, it -> it.classId);
        stringCollectionMap.forEach((k, v) -> {
            System.out.println(k + " - " + v);
        });
        assertTrue(true);
    }

    public void testGroupCountHelper() {
        Map<Integer, Long> booleanLongMap = Group.groupCountHelper(exampleList, it -> it.classId);

        booleanLongMap.forEach((k, v) -> {
            System.out.println(k + " - " + v);
        });
    }
}