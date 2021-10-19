package no9.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Comparator;

/**
 * @author Leesin Dong
 * @since 2021/10/18
 */
public class Test {

    @Builder
    @Data
    @AllArgsConstructor
    private static class Point {
        private final int x;
        private final int y;

        static Comparator<Point> compareByXAndThenY = Comparator.comparing(Point::getX).thenComparing(Point::getY);
    }

    @org.junit.Test
    public void test() {
        int compare = Point.compareByXAndThenY.compare(Point.builder().x(1).y(2).build(), Point.builder().x(2).y(2).build());
        System.out.println(compare);
    }
}
