package no2.Observer;

import java.util.Vector;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class Subject implements ISubject{
    private final Vector<IObserver> observers = new Vector<>();

    @Override
    public void add(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        observers.removeElement(observer);
    }

    @Override
    public void inform() {
        for (IObserver observer : observers) {
            observer.update("hello world");
        }
    }
}
