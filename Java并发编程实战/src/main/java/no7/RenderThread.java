package no7;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author Leesin Dong
 * @since 2021/11/8
 */
public class RenderThread extends Thread{
    private final Socket socket;
    private final InputStream inputStream;

    public RenderThread(Socket socket, InputStream inputStream) {
        this.socket = socket;
        this.inputStream = inputStream;
    }

    private void test() {
        byte[] bytes = new byte[1024];
        try {
            int read = inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void interrupt() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            super.interrupt();
        }
    }
}
