package no12;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.zone.ZoneRules;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

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


        String format = LocalDate.of(2014, 3, 2)
                .format(DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN));
        LocalDate parse = LocalDate.parse(format, DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN));
        System.out.println(format);
        System.out.println(parse);

        ZoneId of2 = ZoneId.of("Europe/Rome");
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        System.out.println(of2);
        System.out.println(zoneId);

        LocalDate of3 = LocalDate.of(2014, 2, 4);
        ZonedDateTime zonedDateTime = of3.atStartOfDay(zoneId);
        System.out.println(zonedDateTime);
        ZonedDateTime zonedDateTime1 = Instant.now().atZone(zoneId);

        // LocalDateTime of4 = LocalDateTime.of(1213, 3, 3, 12, 3, 4);
        // Instant instant = of4.toInstant((ZoneOffset) zoneId);

        Date date = new Date();

        JapaneseDate from = JapaneseDate.from(of3);

        ZoneRules rules = of2.getRules();
        System.out.println(rules);

        LocalDateTime.now();


    }
}
