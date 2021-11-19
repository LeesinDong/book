package no3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class NIOTest {
    public void test() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("");
        FileOutputStream fileOutputStream = new FileOutputStream("");
        FileChannel readChannel = fileInputStream.getChannel();
        FileChannel writeChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            int read = readChannel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
        }
    }
}
