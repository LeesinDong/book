package no3;

/**
 * @author Leesin Dong
 * @since 2021/11/20
 */
public class ExtractExpression {
    public void test() {
        // for (int i = 0; i < 1000; i++) {
        //     int resultA = a * b / c;
        //     int resultB = b * b / c;
        //     int resultC = c * b / c;
        // }
        //
        //
        // for (int i = 0; i < 1000; i++) {
        //     // for 内提取
        //     int TempResult = b / c;
        //     int resultA = a * TempResult;
        //     int resultB = b * TempResult;
        //     int resultC = c * TempResult;
        // }
        //
        // for (int i = 0; i < 100; i++) {
        //     int result = 1 * 2 * i;
        // }
        //
        // int temp = 1 * 2;
        // for (int i = 0; i < 100; i++) {
        //     int result = temp * i;
        // }
    }
}
