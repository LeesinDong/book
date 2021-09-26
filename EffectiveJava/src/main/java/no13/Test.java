package no13;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/25 4:06 下午
 */
public class Test implements Cloneable{
    public static void main(String[] args) {

    }

    @Override
    public Test clone() throws CloneNotSupportedException {
        return (Test) super.clone();
    }


}
