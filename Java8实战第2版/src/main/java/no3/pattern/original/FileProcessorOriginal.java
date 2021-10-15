package no3.pattern.original;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Leesin Dong
 * @since 2021/10/15
 */
@Data
@AllArgsConstructor
@Builder
public class FileProcessorOriginal {
    public void processFile1() {
        System.out.println("前置环绕");

        System.out.println(1 + 2);

        System.out.println("后置环绕");
    }

    public void processFile2() {
        System.out.println("前置环绕");

        System.out.println(1 == 2);

        System.out.println("后置环绕");
    }
}
