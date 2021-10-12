package com.leesin.日志规约;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Leesin Dong
 * @since Created in 2021/10/10 7:58 上午
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        int testLog = 0;
        try {
            System.out.println();
        } catch (Exception e) {
        }
    }

    private void testLog(Integer testLog) {
        if (testLog == null) {
            log.warn("parameter: {} is null, message: {} , e: {} ", testLog);
        }
    }
}
