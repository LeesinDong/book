package no6;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Leesin Dong
 * @since 2021/11/18
 */
public class IoOptimize {
    private BufferedOutputStream writer;

    {
        try {
            writer = new BufferedOutputStream(new FileOutputStream(""));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
