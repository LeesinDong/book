package no3;

import lombok.Builder;
import lombok.Getter;
import org.junit.Test;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class TreeMapTest {
    private final TreeMap<Integer, Integer> map =
            new TreeMap<>(Integer::compare);
    @Test
    public void test() {
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        SortedMap<Integer, Integer> integerIntegerSortedMap = map.headMap(1);
        // System.out.println(integerIntegerSortedMap);

        String s = "";
        System.out.println(s.length());
        if (((s = "a").indexOf("a") != -1) || s.length() == 1) {
            System.out.println(true);
        }
    }

    @Builder
    @Getter
    private static class Student implements Comparable<Student> {
        private int age;

        @Override
        public int compareTo(Student o) {
            if (o.age < this.age) {
                return 1;
            } else if (o.age> this.age) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    @Test
    public void test1() {
        Map<Student, Integer> map = new TreeMap<>();
        Student build1 = Student.builder().age(1).build();
        map.put(build1, 1);
        Student build2 = Student.builder().age(2).build();
        map.put(build2, 2);
        Student build3 = Student.builder().age(3).build();
        map.put(build3, 3);

        map = ((TreeMap<Student, Integer>) map).headMap(build3);
        map.entrySet().forEach(i -> System.out.println(new StringBuilder(i.getKey().toString()).append(" ").append(i.getValue())));

    }
}
