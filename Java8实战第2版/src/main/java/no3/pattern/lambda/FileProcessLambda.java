package no3.pattern.lambda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Leesin Dong
 * @since 2021/10/15
 */
@Data
@Builder
@AllArgsConstructor
public class FileProcessLambda {
    public void processFile(FileProcess fileProcess) {
        System.out.println("前置环绕");

        fileProcess.process();

        System.out.println("后置环绕");
    }

    public void processFile1(FileProcess fileProcess) {
        System.out.println("前置环绕");

        fileProcess.process();

        System.out.println("后置环绕");
    }
}
