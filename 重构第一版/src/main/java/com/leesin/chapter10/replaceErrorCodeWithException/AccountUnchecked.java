package com.leesin.chapter10.replaceErrorCodeWithException;

/**
 * @description: unckecked异常
 * @author: dongxueyuan
 * @date: Created in 2020/11/26 1:43 下午
 */
public class AccountUnchecked {

    // 余额
    private int _balance;

    public static void main(String[] args) {
        int amount = 10;
        AccountUnchecked account = new AccountUnchecked();

        if (account.withdraw(amount) == -1) {
            handleOverdrawn();
        } else {
            doTheUsualThing();
        }

        // TODO: 【调用方】程序员自己在调用前需要做检查 余额是否充足
        if (!account.canWithdraw(amount)) {
            // 检查余额不足无法取款，就处理透支的情况，不进行取款
            handleOverdrawn();
        } else {
            // 余额充足的情况下再取款
            account.withdraw(amount);
            doTheUsualThing();
        }
    }

    private static void doTheUsualThing() {
    }

    private static void handleOverdrawn() {
    }

    int withdrawOriginal(int amount) {
        // 取的钱>余额，余额不足
        if (amount > _balance) {
            return -1;
        } else { // 余额充足
            _balance -= amount;
            return 0;
        }
    }

    private boolean canWithdraw(int amount) {
        // 前置检查，是否能够进行取款
        return false;
    }

    // TODO: 【被调用方】取款函数，移除错误码，抛出异常
    int withdraw(int amount) {
        // 异常是罕见的，用卫语句表示
        if (amount > _balance) {
            // 异常中提醒，取的钱太多了
            throw new IllegalArgumentException("Amount too large");
        }
        _balance -= amount;
        return _balance;
    }

    // （略）下面不重要，由于这是程序员所犯的错误，所以我应该使用assertion 更清楚地指出这一点：
    void withdraw2(int amount) {
        Assert.isTrue("amount too large", amount > _balance);
        _balance -= amount;
    }

    static class Assert {
        static void isTrue(String comment, boolean test) {
            if (!test) {
                throw new RuntimeException("Assertion failed: " + comment);
            }
        }
    }

}
