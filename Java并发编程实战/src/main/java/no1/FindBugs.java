package no1;

/**
 * @author Leesin Dong
 * @since 2021/11/15
 */
public class FindBugs {
    private int change = 0;

    private synchronized void updateChange() {
        change++;
    }

    private int getChange() {
        return change;
    }
}


