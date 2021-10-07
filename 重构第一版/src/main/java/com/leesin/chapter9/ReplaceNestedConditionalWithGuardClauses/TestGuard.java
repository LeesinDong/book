package com.leesin.chapter9.ReplaceNestedConditionalWithGuardClauses;

/**
 * @author Leesin Dong
 * @since Created in 2021/10/7 11:26 下午
 */
public class TestGuard {
    static double getPayAmount() {
        double result = 5;
        boolean isDead = false;
        boolean isSeparated = false;
        boolean isRetired = false;

        if (isDead) {
            result = 1;
        } else {
            if (isSeparated) {
                result = 2;
            } else {
                if (isRetired) {
                    result = 3;
                } else {
                    result = 4;
                }
            }
        }

        return result;
    }

    static double getPayAmountGuard() {
        double result = 5;
        boolean isDead = false;
        boolean isSeparated = false;
        boolean isRetired = false;

        if (isDead) {
            return 1;
        }

        if (isSeparated) {
            return 2;
        }

        if (isRetired) {
            return 3;
        }

        return 4;
    }

    static double getAdJustedCapital() {
        double result = 0.0;
        double intRate = 0.1;
        double duration = 0.1;
        double capitail = 0.1;
        if (capitail > 0.0) {
            if (intRate > 0.0 && duration > 0.0) {
                result = 1 + 2;
            }
        }
        return result;
    }

    static double getAdJustedCapitalGuard() {
        double result = 0.0;
        double intRate = 0.1;
        double duration = 0.1;
        double capitail = 0.1;
        if (capitail <= 0.0) {
            return result;
        }
        if (intRate <= 0.0 || duration <= 0.0) {
            return result;
        }
        return 1 + 2;
    }

    public static void main(String[] args) {
        System.out.println(getPayAmount());
        System.out.println(getAdJustedCapital());

        System.out.println(getPayAmountGuard());
        System.out.println(getAdJustedCapitalGuard());
    }
}
