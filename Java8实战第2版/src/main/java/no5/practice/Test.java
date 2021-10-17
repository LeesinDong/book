package no5.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Leesin Dong
 * @since 2021/10/16
 */
public class Test {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 10000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        transactions.stream()
                .filter(i -> i.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());

        transactions.stream()
                .map(Transaction::getTrader)
                .filter(i -> Objects.equals(i.getCity(), "Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName));

        String collect1 = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .map(Trader::getName)
                .reduce( (n1, n2) -> n1 + "-" + n2).get();

        String collect2 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining("-"));

        System.out.println(collect1);
        System.out.println(collect2);

        boolean b = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(i -> "Milan".equals(i.getCity()));

        transactions.stream()
                .filter(i -> "Cmbrige".equals(i.getTrader().getCity()))
                .map(Transaction::getValue)
                .reduce(Integer::sum);

        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        transactions.stream()
                .reduce((i, j) -> i.getValue() < j.getValue() ? i : j);

    }
}
