package no78;

/**
 * @author Leesin Dong
 * @since Created in 2021/10/3 9:52 上午
 */
public class StopThreadTest {
    private static boolean interrupted = false;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            int i = 0;
            while (!interrupted) {
                i++;
            }
        });
        thread.start();
        Thread.sleep(1000);
        interrupted = true;
    }

    /**
     * sync实现可见性
     */
    private static class UpgradeStop1 {
        private static boolean interrupted = false;

        public static void main(String[] args) throws InterruptedException {
                Thread thread = new Thread(() -> {
                    int i = 0;
                    while (!getInterrupted()) {
                        i++;
                    }
                });
                thread.start();
                Thread.sleep(1000);
                setInterrupted();
        }

        private  static synchronized void setInterrupted() {
            interrupted = true;
        }

        private static synchronized boolean getInterrupted() {
            return interrupted;
        }
    }

    /**
     * volatile实现可见性
     */
    private static class UpgradeStop2 {
        private static volatile boolean interrupted = false;

        public static void main(String[] args) throws InterruptedException {
            Thread thread = new Thread(() -> {
                int i = 0;
                while (!interrupted) {
                    i++;
                }
            });
            thread.start();
            Thread.sleep(1000);
            interrupted = true;
        }
    }
}
