package no16;

import org.junit.Test;

/**
 * @author Leesin Dong
 * @since 2021/11/14
 */
public class TestClinit {
    private static Resource resource = new Resource();
    static {
        int count = 1;
        resource = new Resource();
    }
    // 测试clinit方法

    // private static Resource resource;
    public synchronized static Resource getInstance() {
        if (resource == null) {
            resource = new Resource();
        }
        return resource;
    }

    private static class Resource {

    }

    @Test
    public void test() {
        getInstance();
    }
}
