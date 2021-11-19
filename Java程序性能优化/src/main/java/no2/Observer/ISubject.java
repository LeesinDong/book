package no2.Observer;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public interface ISubject {
    void add(IObserver observer);
    void remove(IObserver observer);
    void inform();
}
