package no9.pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leesin Dong
 * @since 2021/10/18
 */
public class ObserverTest {
    @Test
    public void test() {
        Subject subject = Subject.builder().build();
        subject.register(s -> System.out.println(s + "1"));
        subject.register(s -> System.out.println(s + "2"));
        subject.notify("12345");
    }

    private interface Observer {
        void notify(String s);
    }

    @Builder
    @Data
    @AllArgsConstructor
    private static class Subject {
        private final List<Observer> observers = new ArrayList<>();

        public void register(Observer o) {
            observers.add(o);
        }

        public void notify(String s) {
            observers.forEach(i -> i.notify(s));
        }
    }
}
