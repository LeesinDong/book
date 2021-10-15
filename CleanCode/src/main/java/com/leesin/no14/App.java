package com.leesin.no14;

import com.leesin.no14.逐步改进.Args;
import org.junit.Test;

/**
 * Hello world!
 */
public class App {

    @Test(timeout = 1000)
    public void test() {
        //正例：-l true -p 9999 -d D:\workspace\examples\clean-code-example\log
        //反例：-l t -p string -d D:\workspace\examples\clean-code-example\log
        String[] args = new String[]{"true", "9999", "D:\\workspace\\examples\\clean-code-example\\log"};

        try {
            Args arg = new Args("l,p#,d*", args);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            executeApplication(logging, port, directory);
        } catch (Exception e) { System.out.printf("Argument error: %s\n", e.getMessage());
        }
    }

    private static void executeApplication(boolean logging, int port, String directory) {
        System.out.printf("logging: %s;\tport: %d;\tdirectory: %s", logging, port, directory);
    }
}
