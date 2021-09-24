package com.leesin.chapter10.encapsulateDowncast;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/11/26 1:32 下午
 */
public class Site {
    public static Site theSite = new Site();

    public static void main(String[] args) {

        Reading lastReadingOriginal = (Reading) theSite.readings().lastElement();
        // TODO: 在site中封装 转型操作【site中就已经得到了结果】
        Reading lastReading = theSite.lastReading();

    }

    private Readings readings() {
        return new Readings();
    }

    Reading lastReading() {
        return (Reading) readings().lastElement();
    }


    private <T> T getRequest(Object requestParam, T request) {
        return (T) requestParam;
    }
    // 调用的地方
    // getRequest(requestParam, new Request());
}
