package com.leesin.chapter10.replaceErrorCodeWithException;

/**
 * @description: 受检异常
 * @author: dongxueyuan
 * @date: Created in 2020/11/30 9:41 上午
 */
public class AccountChecked {
    public static int amount = 10;
    static AccountUnchecked account = new AccountUnchecked();
    // 余额
    private static int _balance;

    /**
     * TODO 【被调用方】通过异常表示错误
     **/
    static void withdraw(int amount) throws BalanceException {
        if (amount > _balance) {
            throw new BalanceException();
        }
        _balance -= amount;
    }

    public static void main(String[] args) {
        // TODO: 【调用方】调用的地方捕获异常
        try {
            withdraw(amount);
            doTheUsualThing();
        } catch (BalanceException e) {
            handleOverdrawn();
        }
    }

    private static void doTheUsualThing() {
    }

    // 后面的代码例子，略，说的就是通过中间函数，避免这里抛出 checked Exception，导致编译器所有调用的地方报错
    // 没有实际的意义

    private static void handleOverdrawn() {
    }

    /**
     * TODO: 【被调用方】建立一个异常
     **/
    static class BalanceException extends Exception {
    }
}
