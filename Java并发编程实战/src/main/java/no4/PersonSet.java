package no4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Leesin Dong
 * @since 2021/11/3
 */
public class PersonSet {
    private Set<Person> set = new HashSet<>();

    public synchronized Set<Person> getSet() {
        return set;
    }

    public synchronized void setSet(Set<Person> set) {
        this.set = set;
    }

    private static class Person {

    }
}
