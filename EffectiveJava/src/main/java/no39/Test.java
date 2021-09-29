package no39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/29 1:43 下午
 */
public class Test {
    @MyTest
    public void m5() {
        System.out.println(1);
    }


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface MyTest {

    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = Class.forName("no39.Test");
        for (Method declaredMethod : aClass.getDeclaredMethods()) {
            if (declaredMethod.isAnnotationPresent(MyTest.class)) {
                try {
                    declaredMethod.invoke(new Test());
                } catch (Exception e) {
                    e.printStackTrace();

                }
                }
            }

    }
}
