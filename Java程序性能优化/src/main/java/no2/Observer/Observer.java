package no2.Observer;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class Observer implements IObserver{
    @Override
    public void update(String s) {
        System.out.println(s);
    }
}
