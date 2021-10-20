package no18;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Leesin Dong
 * @since 2021/10/20
 */
public class Test {
    public static void main(String[] args) {

    }

    public Optional<ArrayList<String>> insert(ArrayList<String> a, ArrayList<String> b) {
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(a);
        list.addAll(b);
        return Optional.ofNullable(list);

    }
}
