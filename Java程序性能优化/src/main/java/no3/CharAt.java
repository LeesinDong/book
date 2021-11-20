package no3;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Leesin Dong
 * @since 2021/11/20
 */
public class CharAt {
    private final String s = "1234";
    @Test
    public void test(){
        Assert.assertEquals(s.charAt(0) == '1' && s.charAt(1) == '2', true);
    }
}
