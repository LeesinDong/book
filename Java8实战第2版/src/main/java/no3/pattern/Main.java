package no3.pattern;

import no3.pattern.lambda.FileProcessLambda;
import no3.pattern.original.FileProcessorOriginal;

/**
 * @author Leesin Dong
 * @since 2021/10/15
 */
public class Main {
    public static void main(String[] args) {

        FileProcessorOriginal.builder().build().processFile1();
        FileProcessorOriginal.builder().build().processFile2();

        System.out.println("========");

        FileProcessLambda.builder().build().processFile(() -> System.out.println(1 + 2));
        FileProcessLambda.builder().build().processFile(() -> System.out.println(1 == 2));

    }
}
