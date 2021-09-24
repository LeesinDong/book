package com.leesin.chapter1.polymorphismToReplaceSwitch.sswitch;

/**
 * @description:
 * @author: dongxueyuan
 * @date: Created in 2020/12/1 2:01 下午
 */
public class Movie {
    public static final int REGULAR = 1;
    public static final int NEW_RELEASE = 2;
    public static final int CHILDRENS = 3;

    String _name = "";
    private Price _price;

    // public Movie(String name, int priceCode) {
    //     _name = name;
    //     _priceCode = priceCode;
    // }
    //
    public Movie(String name, int priceCode) {
        _name = name;
        //译注：这就是一个set method
        /**
         * TODO: 1 创建子类
         **/
        setPriceCode(priceCode);
    }

    /**
     * TODO: 2 多态调用
     **/
    double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    /**
     * 多态
     * TODO: 这里可以换成直接反射工厂方法，主要就是上面的 多态调用_price.getCharge(daysRented);
     **/
    // public int getPriceCode() {    //取得价格代号
    //     return _price.getPriceCode();
    // }
    public void setPriceCode(int arg) {   //设定价格代号
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }
}
