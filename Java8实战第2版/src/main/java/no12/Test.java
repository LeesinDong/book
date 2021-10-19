package no12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author Leesin Dong
 * @since 2021/10/18
 */
public class Test {

    @org.junit.Test
    public void test() {
        LocalDate of = LocalDate.of(2017, 9, 21);
        int i = of.get(ChronoField.YEAR);
        System.out.println(i);

        DayOfWeek of1 = DayOfWeek.of(LocalDate.now().get(ChronoField.DAY_OF_WEEK));
        System.out.println(of1);

        System.out.println(DayOfWeek.FRIDAY.getValue());

        LocalDate plus = LocalDate.now().plus(1, ChronoUnit.DAYS);
        System.out.println(plus);
    }
}
