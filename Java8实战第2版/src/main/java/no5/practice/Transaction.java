package no5.practice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Leesin Dong
 * @since 2021/10/16
 */
@Data
@AllArgsConstructor
@Builder
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
}
