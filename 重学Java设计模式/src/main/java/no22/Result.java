package no22;

/**
 * @author Leesin Dong
 * @since 2021/12/31
 */

public class Result {
    String code;
    String info;

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public Result(String code, String info) {
        this.code = code;
        this.info = info;
    }
}
