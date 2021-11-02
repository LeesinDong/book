package no3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Leesin Dong
 * @since 2021/11/2
 */
public class Test {
    private static final Apple apple = new Apple("");

    public static void main(String[] args) {
        apple.setS("aaa");
        System.out.println(apple);
    }

    @Builder
    @AllArgsConstructor
    @Data
    private static class Apple {
        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }

        private String s = "";
    }
}
