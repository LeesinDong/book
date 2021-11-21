package no4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leesin Dong
 * @since 2021/11/21
 */
public class scopeTest {
    private final List<Integer> list = new ArrayList<>();

    @Test
    public void test(){
        for (int i = 0; i < 10; i++) {
            int j = 0;
            list.add(j);
        }
        // 10 说明，每个{}都是一个作用域相当于{} {} {} {}
        System.out.println(list.size());
    }
}
