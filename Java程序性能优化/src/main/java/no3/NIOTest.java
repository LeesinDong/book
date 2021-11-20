package no3;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Leesin Dong
 * @since 2021/11/19
 */
public class NIOTest {
    // FileInputStream fileInputStream = new FileInputStream("");
    // FileOutputStream fileOutputStream = new FileOutputStream("");
    // FileChannel readChannel = fileInputStream.getChannel();
    // FileChannel writeChannel = fileOutputStream.getChannel();
    // ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    //
    // public NIOTest() throws FileNotFoundException {
    // }
    //
    // public void test() throws IOException {
    //
    //     while (true) {
    //         byteBuffer.clear();
    //         int len = readChannel.read(byteBuffer);
    //         if (len == -1) {
    //             break;
    //         }
    //         byteBuffer.flip();
    //         writeChannel.write(byteBuffer);
    //     }
    //     readChannel.close();
    //     writeChannel.close();
    // }
    //
    // @Test
    // public void testClear() throws IOException {
    //     writeChannel.write(byteBuffer);
    //     byteBuffer.rewind();
    //     byte[] arr =new byte[1024];
    //     byteBuffer.get(arr);
    //
    //     byteBuffer.clear();
    //     readChannel.read(byteBuffer);
    //     byteBuffer.flip();
    //     writeChannel.write(byteBuffer);
    // }

    @Test
    public void testMark() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < 10; i++) {
            buffer.put((byte) i);
        }

        buffer.flip();
        for (int i = 0; i < buffer.limit(); i++) {
            byte b = buffer.get();
            System.out.println(b);
            if (i == 4) {
                buffer.mark();
                System.out.println("get 4");
            }
        }

        System.out.println("mark before");
        buffer.reset();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }

    @Test
    public void testDuplicate() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        ByteBuffer duplicate = buffer.duplicate();
        buffer.clear();
        buffer.put((byte) 1);
        buffer.flip();
        System.out.println(buffer.get());
        System.out.println(duplicate.get());
    }

    @Test
    public void testSlice() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.position(1);
        buffer.limit(2);
        ByteBuffer sub = buffer.slice();
        sub.put((byte) 1);
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get() + "");
        }
    }

    @Test
    public void readBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(19);
        ByteBuffer byteBuffer = buffer.asReadOnlyBuffer();
        buffer.putShort((short) 1);
        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }
    }

    @Test
    public void map() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("df", "rw");
        FileChannel channel = raf.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        while (map.hasRemaining()) {
            System.out.println(map.get());
        }
        map.put((byte) 1);
        channel.close();
    }

    @Test
    public void byteBufferArray() throws IOException {
        ByteBuffer wrap1 = ByteBuffer.wrap("哈哈哈".getBytes("UFT-8"));
        ByteBuffer wrap = ByteBuffer.wrap("嘿嘿嘿".getBytes("UFT-8"));
        ByteBuffer[] buf = new ByteBuffer[]{wrap1, wrap};
        FileOutputStream fileOutputStream = new FileOutputStream("");
        FileChannel writeChannel = fileOutputStream.getChannel();
        writeChannel.write(buf);
    }

    @Test
    public void DirectBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(19);
        byteBuffer.putInt(1);
        byteBuffer.flip();
        System.out.println(byteBuffer.getInt());
    }
}
