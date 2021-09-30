package no45;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// import static java.math.BigInteger.TWO;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/29 9:34 下午
 */
public class Test {
    static Stream<BigInteger> primes() {
        // return Stream.iterate(TWO, BigInteger::nextProbablePrime);
        return null;
    }

    private static class Card {
        private int left;
        private int right;

        public Card(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private static List<Integer> lefts = Arrays.asList(1, 2);
    private static List<Integer> rights = Arrays.asList(3, 4);

    /**
     * 笛卡尔积
     */
    public static List<Card> newDeck() {
        List<Card> result = new ArrayList<Card>();
        for (Integer left : lefts) {
            for (Integer right : rights) {
                result.add(new Card(left, right));
            }
        }
        return result;
    }

    /**
     * 笛卡尔积
     */
    public static List<Card> newDeckRepeat() {
        return Stream.of(1, 2)
                .flatMap(left -> Stream.of(3, 4).map(right -> new Card(left, right))).collect(Collectors.toList());
        // return lefts.stream().map(left -> left)
        //         .flatMap(left -> rights.stream().map(right -> new Card(left, right)))
        //         .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(newDeck());
        System.out.println(newDeckRepeat());
    }
}
