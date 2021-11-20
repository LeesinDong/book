package no3;

/**
 * @author Leesin Dong
 * @since 2021/11/20
 */
public class TryCatch {
    public void test() {
        for (int i = 0; i < 100; i++) {
            try {
                int resutl = 1 * i;
            } catch (Exception exception) {
            }
        }

        try {
            for (int i = 0; i < 100; i++) {
                int result = 1 * i;
            }
        } catch (Exception e) {

        }
    }

}
