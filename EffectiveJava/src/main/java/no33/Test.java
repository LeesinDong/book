package no33;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/28 7:09 下午
 */
public class Test {
    private static Map<Class<?>, Object> favorites = new HashMap<>();

    public static <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public static <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) throws ClassNotFoundException {
        putFavorite(String.class, "1234");
        putFavorite(Integer.class, 1);
        // warn
        // putFavorite(List<String>.class, 1);

        System.out.println(favorites);
        // getAnnotation(String.class);

        Class<?> annotationType = null;
        annotationType = Class.forName("");
        // getAnnotation(annotationType);
        getAnnotation(annotationType.asSubclass(Annotation.class));

        getList(Arrays.asList(1, 2));
    }

    public static <T extends Annotation> T getAnnotation(Class<? extends Annotation> annotationType){
        return null;
    }

    public static Object getList(List<? extends Object> list){
        return list;
    }


}
